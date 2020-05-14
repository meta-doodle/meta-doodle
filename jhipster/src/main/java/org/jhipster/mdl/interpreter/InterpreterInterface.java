package org.jhipster.mdl.interpreter;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jhipster.mdl.domain.CurrentStep;
import org.jhipster.mdl.domain.MdlUser;
import org.jhipster.mdl.domain.WorkflowInstanceState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xtext.metadoodle.interpreter.Interface.Interpreter;
import org.xtext.metadoodle.interpreter.Interface.MailReminder;
import org.xtext.metadoodle.interpreter.Interface.StepDTO;
import org.xtext.metadoodle.interpreter.Interface.StepDTOFactory;
import org.xtext.metadoodle.interpreteur.implementation.InterpreterImpl;

import com.sun.mail.smtp.SMTPTransport;

public class InterpreterInterface {
	private static final Logger log = LoggerFactory.getLogger(InterpreterInterface.class);

	private static final Interpreter INTERPRETER = new InterpreterImpl();
	
	private static final String smtpHost = "smtp.gmail.com";
	private static final String auth = "false";
	private static final int port = 587;
	private static final String sender = "metadoodle2020@gmail.com";
	

	public static Optional<StepDTO> getWorkflowStepData(WorkflowExecutionStateImpl workflowExecutionStateImpl) {
		log.debug("Resquest WorkflowStepData");

		String wfModel = workflowExecutionStateImpl.getWorkflowInstance().getWfModel().getBody();
		WorkflowInstanceState workflowInstanceState = workflowExecutionStateImpl.getWorkflowInstance().getState();
		MdlUser mdlUser = workflowExecutionStateImpl.getMdlUser();

		StepDTOFactory wfStepFactory = INTERPRETER.getStep(wfModel, workflowExecutionStateImpl);
		
		Optional<CurrentStep> optCurrentStep = workflowExecutionStateImpl.findCurrentStep();
		if (!optCurrentStep.isPresent()) {
			log.debug("Current Step not found for MdlUser {}", mdlUser);
			return Optional.empty();
		}
		CurrentStep currentStep = optCurrentStep.get();
		
		String nextStepID = wfStepFactory.getCurrentStepID();

		if (workflowExecutionStateImpl.isEndOfStep() && !currentStep.getStepIdent().equals(nextStepID)) {
			currentStep.removeUsers(mdlUser);
			CurrentStep newCurrentStep = workflowInstanceState.putMdlUserInRightCurrentStep(mdlUser, nextStepID);

			if (!currentStep.equals(newCurrentStep)) {
				workflowExecutionStateImpl.getCurrentStepRepository().saveAndFlush(newCurrentStep);
			}
			
		}
		
		if(wfStepFactory.getMailReminder().isPresent()) {
			MailReminder mailReminder = wfStepFactory.getMailReminder().get();
			mailReminder.getDateToSend().forEach(date -> newMailSender(date, mailReminder, mdlUser));
		}
		
		return Optional.of(wfStepFactory.getStepDTO());
	}
	
	private static void newMailSender(String date, MailReminder mailReminder, MdlUser mdlUser) {
		log.info("Prepare to send mail at {}" , date);
		
		try {
			Date d = new SimpleDateFormat("dd/MM/yy").parse(date);
			Timer timer = new Timer(true);
			Date now = Date.from(Instant.now());
			if(now.before(d) || now.equals(d)) {
				log.debug("deamon launch");
				timer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						log.info("send mail");
						try {
							sendMail(mailReminder.getObject(), mailReminder.getBody(), mdlUser.getUser().getEmail());
						} catch (MessagingException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}, d);
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	private static void sendMail(String object, String body, String mailAddress) throws AddressException, MessagingException, UnknownHostException, IOException {
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.auth", auth);
		Session session = Session.getInstance(props, null);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(sender));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailAddress, false));
		msg.setSubject(object);
		msg.setText(body);
		msg.setSentDate(new Date());
		Socket socket = new Socket(smtpHost, port);
		SMTPTransport t = (SMTPTransport)session.getTransport("smtp");
		t.connect(socket);
		t.sendMessage(msg, msg.getAllRecipients());
		t.close();
	}

	public static String getStepIdent(String wfModel) {
		return INTERPRETER.getWorkflowData(wfModel).getIDFirstStep();
	}
}
