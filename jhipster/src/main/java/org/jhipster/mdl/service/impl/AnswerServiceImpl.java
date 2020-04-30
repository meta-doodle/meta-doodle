package org.jhipster.mdl.service.impl;

import org.jhipster.mdl.service.AnswerService;
import org.jhipster.mdl.domain.Answer;
import org.jhipster.mdl.domain.WorkflowInstance;
import org.jhipster.mdl.interpreter.InterpreterInterface;
import org.jhipster.mdl.repository.AnswerRepository;
import org.jhipster.mdl.repository.CurrentStepRepository;
import org.jhipster.mdl.repository.WorkflowInstanceRepository;
import org.jhipster.mdl.service.dto.AnswerDTO;
import org.jhipster.mdl.service.mapper.AnswerMapper;
import org.jhipster.mdl.workflow.to_transfert_data.StepDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Answer}.
 */
@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

	private final Logger log = LoggerFactory.getLogger(AnswerServiceImpl.class);

	private final AnswerRepository answerRepository;

	private final AnswerMapper answerMapper;

	private WorkflowInstanceRepository workflowInstanceRepository;

	private CurrentStepRepository currentStepRepository;

	public AnswerServiceImpl(AnswerRepository answerRepository, AnswerMapper answerMapper,
			WorkflowInstanceRepository workflowInstanceRepository, CurrentStepRepository currentStepRepository) {
		this.answerRepository = answerRepository;
		this.answerMapper = answerMapper;
		this.workflowInstanceRepository = workflowInstanceRepository;
		this.currentStepRepository = currentStepRepository;
	}

	/**
	 * Save a answer.
	 *
	 * @param answerDTO the entity to save.
	 * @return the persisted entity.
	 */
	@Override
	public AnswerDTO save(AnswerDTO answerDTO) {
		log.debug("Request to save Answer : {}", answerDTO);
		Answer answer = answerMapper.toEntity(answerDTO);
		answer = answerRepository.save(answer);
		return answerMapper.toDto(answer);
	}

	/**
	 * Get all the answers.
	 *
	 * @return the list of entities.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<AnswerDTO> findAll() {
		log.debug("Request to get all Answers");
		return answerRepository.findAll().stream().map(answerMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Get one answer by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<AnswerDTO> findOne(Long id) {
		log.debug("Request to get Answer : {}", id);
		return answerRepository.findById(id).map(answerMapper::toDto);
	}

	/**
	 * Delete the answer by id.
	 *
	 * @param id the id of the entity.
	 */
	@Override
	public void delete(Long id) {
		log.debug("Request to delete Answer : {}", id);
		answerRepository.deleteById(id);
	}

	@Override
	public Optional<StepDTO> sendNewAnswer(AnswerDTO answerDTO) {
		log.debug("Request to send new Answer : {}", answerDTO);
		Answer answer = answerMapper.toEntity(answerDTO);
		answer = answerRepository.save(answer);

		Optional<WorkflowInstance> optWFI = workflowInstanceRepository.findById(answerDTO.getWorkflowInstanceId());
		if (optWFI.isPresent()) {
			log.debug("WorkflowInstance found !");
			WorkflowInstance wfi = optWFI.get();

			// Optional<CurrentStep> optStep =
			// wfi.getState().findCurrentStepContainingMdlUser(answer.getUser());

			/*
			 * if (optStep.isPresent()) { log.debug("CurrentStep found !"); CurrentStep
			 * currentStep = optStep.get();
			 */

			Optional<StepDTO> workflowStepData = InterpreterInterface.getWorkflowStepData(wfi,
					answer.getUser(), currentStepRepository, true);
			// WorkflowStepData workflowStepData = doExec(wfi.getState(), currentStep,
			// answer.getUser());

			return workflowStepData;
			/*
			 * } else { log.debug("CurrentStep not found : {}", wfi, answer.getUser()); }
			 */
		} else {
			log.debug("WorkflowInstance doesn't exist with id : {}", answerDTO.getWorkflowInstanceId());
		}

		return Optional.empty();
	}

	/*private WorkflowStepData doExec(WorkflowInstanceState workflowInstanceState, CurrentStep currentStep,
			MdlUser mdlUser) {

		try {
			int ident = Integer.parseInt(currentStep.getStepIdent());
			FakeReturnExec ret = FakeInterpreter.INTERPRETER.exec("", new FakeState(ident, 0, 0));

			if (!currentStep.getStepIdent().equals(ret.nextStep + "")) {
				currentStep.removeUsers(mdlUser);
				CurrentStep newCurrentStep = workflowInstanceState.putMdlUserInRightCurrentStep(mdlUser,
						ret.nextStep + "");
				if (!currentStep.equals(newCurrentStep)) {
					currentStepRepository.saveAndFlush(newCurrentStep);
				}
			}

			// TODO : clean up
			ret = FakeInterpreter.INTERPRETER.exec("", new FakeState(ret.nextStep, 0, 0));
			return ret.stepData;

		} catch (NumberFormatException e) {
			return new WorkflowStepData();
		}
	}*/
}
