package org.xtext.mdl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.mdl.services.MdlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMdlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_DATE", "RULE_LA", "RULE_INT", "RULE_STRING", "RULE_LP", "RULE_RP", "RULE_RA", "RULE_ADDRESSEMAIL", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'StartDate:'", "'StepNumber:'", "'StepName:'", "'Questions'", "'Mail'", "'Calendar'", "'FileDepository'", "'TimeLaps'", "'ParticipantsRequired:'", "'StartingDate:'", "'EndingDate:'", "'Accuracy:'", "'TitleSubmission:'", "'SizeLimite:'", "'QuestionType:'", "'TitleQuestion:'", "'PossibleResponse:'", "'OpenQuestion'", "'CheckBox'", "'RadioButton'", "'Reminder'", "'From:'", "'To:'", "'Attachment:'", "'Body:'"
    };
    public static final int RULE_LA=5;
    public static final int RULE_RA=10;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=14;
    public static final int T__19=19;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int RULE_ADDRESSEMAIL=11;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=12;
    public static final int RULE_WS=15;
    public static final int RULE_ANY_OTHER=16;
    public static final int RULE_DATE=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=13;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int RULE_RP=9;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int RULE_LP=8;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalMdlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMdlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMdlParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMdl.g"; }



     	private MdlGrammarAccess grammarAccess;

        public InternalMdlParser(TokenStream input, MdlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Workflow";
       	}

       	@Override
       	protected MdlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleWorkflow"
    // InternalMdl.g:64:1: entryRuleWorkflow returns [EObject current=null] : iv_ruleWorkflow= ruleWorkflow EOF ;
    public final EObject entryRuleWorkflow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkflow = null;


        try {
            // InternalMdl.g:64:49: (iv_ruleWorkflow= ruleWorkflow EOF )
            // InternalMdl.g:65:2: iv_ruleWorkflow= ruleWorkflow EOF
            {
             newCompositeNode(grammarAccess.getWorkflowRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWorkflow=ruleWorkflow();

            state._fsp--;

             current =iv_ruleWorkflow; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWorkflow"


    // $ANTLR start "ruleWorkflow"
    // InternalMdl.g:71:1: ruleWorkflow returns [EObject current=null] : ( (otherlv_0= 'StartDate:' ( (lv_dateDebut_1_0= RULE_DATE ) ) )? ( (lv_steps_2_0= ruleStep ) )* ) ;
    public final EObject ruleWorkflow() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_dateDebut_1_0=null;
        EObject lv_steps_2_0 = null;



        	enterRule();

        try {
            // InternalMdl.g:77:2: ( ( (otherlv_0= 'StartDate:' ( (lv_dateDebut_1_0= RULE_DATE ) ) )? ( (lv_steps_2_0= ruleStep ) )* ) )
            // InternalMdl.g:78:2: ( (otherlv_0= 'StartDate:' ( (lv_dateDebut_1_0= RULE_DATE ) ) )? ( (lv_steps_2_0= ruleStep ) )* )
            {
            // InternalMdl.g:78:2: ( (otherlv_0= 'StartDate:' ( (lv_dateDebut_1_0= RULE_DATE ) ) )? ( (lv_steps_2_0= ruleStep ) )* )
            // InternalMdl.g:79:3: (otherlv_0= 'StartDate:' ( (lv_dateDebut_1_0= RULE_DATE ) ) )? ( (lv_steps_2_0= ruleStep ) )*
            {
            // InternalMdl.g:79:3: (otherlv_0= 'StartDate:' ( (lv_dateDebut_1_0= RULE_DATE ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==17) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalMdl.g:80:4: otherlv_0= 'StartDate:' ( (lv_dateDebut_1_0= RULE_DATE ) )
                    {
                    otherlv_0=(Token)match(input,17,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getWorkflowAccess().getStartDateKeyword_0_0());
                    			
                    // InternalMdl.g:84:4: ( (lv_dateDebut_1_0= RULE_DATE ) )
                    // InternalMdl.g:85:5: (lv_dateDebut_1_0= RULE_DATE )
                    {
                    // InternalMdl.g:85:5: (lv_dateDebut_1_0= RULE_DATE )
                    // InternalMdl.g:86:6: lv_dateDebut_1_0= RULE_DATE
                    {
                    lv_dateDebut_1_0=(Token)match(input,RULE_DATE,FOLLOW_4); 

                    						newLeafNode(lv_dateDebut_1_0, grammarAccess.getWorkflowAccess().getDateDebutDATETerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getWorkflowRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"dateDebut",
                    							lv_dateDebut_1_0,
                    							"org.xtext.mdl.Mdl.DATE");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMdl.g:103:3: ( (lv_steps_2_0= ruleStep ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_LA) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMdl.g:104:4: (lv_steps_2_0= ruleStep )
            	    {
            	    // InternalMdl.g:104:4: (lv_steps_2_0= ruleStep )
            	    // InternalMdl.g:105:5: lv_steps_2_0= ruleStep
            	    {

            	    					newCompositeNode(grammarAccess.getWorkflowAccess().getStepsStepParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_steps_2_0=ruleStep();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getWorkflowRule());
            	    					}
            	    					add(
            	    						current,
            	    						"steps",
            	    						lv_steps_2_0,
            	    						"org.xtext.mdl.Mdl.Step");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWorkflow"


    // $ANTLR start "entryRuleStep"
    // InternalMdl.g:126:1: entryRuleStep returns [EObject current=null] : iv_ruleStep= ruleStep EOF ;
    public final EObject entryRuleStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStep = null;


        try {
            // InternalMdl.g:126:45: (iv_ruleStep= ruleStep EOF )
            // InternalMdl.g:127:2: iv_ruleStep= ruleStep EOF
            {
             newCompositeNode(grammarAccess.getStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStep=ruleStep();

            state._fsp--;

             current =iv_ruleStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStep"


    // $ANTLR start "ruleStep"
    // InternalMdl.g:133:1: ruleStep returns [EObject current=null] : (this_LA_0= RULE_LA otherlv_1= 'StepNumber:' ( (lv_id_2_0= RULE_INT ) ) otherlv_3= 'StepName:' ( (lv_name_4_0= RULE_STRING ) ) (this_LP_5= RULE_LP ( (lv_reminders_6_0= ruleReminder ) )+ this_RP_7= RULE_RP )? ( (lv_obj_8_0= ruleObject ) ) this_RA_9= RULE_RA ) ;
    public final EObject ruleStep() throws RecognitionException {
        EObject current = null;

        Token this_LA_0=null;
        Token otherlv_1=null;
        Token lv_id_2_0=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token this_LP_5=null;
        Token this_RP_7=null;
        Token this_RA_9=null;
        EObject lv_reminders_6_0 = null;

        EObject lv_obj_8_0 = null;



        	enterRule();

        try {
            // InternalMdl.g:139:2: ( (this_LA_0= RULE_LA otherlv_1= 'StepNumber:' ( (lv_id_2_0= RULE_INT ) ) otherlv_3= 'StepName:' ( (lv_name_4_0= RULE_STRING ) ) (this_LP_5= RULE_LP ( (lv_reminders_6_0= ruleReminder ) )+ this_RP_7= RULE_RP )? ( (lv_obj_8_0= ruleObject ) ) this_RA_9= RULE_RA ) )
            // InternalMdl.g:140:2: (this_LA_0= RULE_LA otherlv_1= 'StepNumber:' ( (lv_id_2_0= RULE_INT ) ) otherlv_3= 'StepName:' ( (lv_name_4_0= RULE_STRING ) ) (this_LP_5= RULE_LP ( (lv_reminders_6_0= ruleReminder ) )+ this_RP_7= RULE_RP )? ( (lv_obj_8_0= ruleObject ) ) this_RA_9= RULE_RA )
            {
            // InternalMdl.g:140:2: (this_LA_0= RULE_LA otherlv_1= 'StepNumber:' ( (lv_id_2_0= RULE_INT ) ) otherlv_3= 'StepName:' ( (lv_name_4_0= RULE_STRING ) ) (this_LP_5= RULE_LP ( (lv_reminders_6_0= ruleReminder ) )+ this_RP_7= RULE_RP )? ( (lv_obj_8_0= ruleObject ) ) this_RA_9= RULE_RA )
            // InternalMdl.g:141:3: this_LA_0= RULE_LA otherlv_1= 'StepNumber:' ( (lv_id_2_0= RULE_INT ) ) otherlv_3= 'StepName:' ( (lv_name_4_0= RULE_STRING ) ) (this_LP_5= RULE_LP ( (lv_reminders_6_0= ruleReminder ) )+ this_RP_7= RULE_RP )? ( (lv_obj_8_0= ruleObject ) ) this_RA_9= RULE_RA
            {
            this_LA_0=(Token)match(input,RULE_LA,FOLLOW_5); 

            			newLeafNode(this_LA_0, grammarAccess.getStepAccess().getLATerminalRuleCall_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getStepAccess().getStepNumberKeyword_1());
            		
            // InternalMdl.g:149:3: ( (lv_id_2_0= RULE_INT ) )
            // InternalMdl.g:150:4: (lv_id_2_0= RULE_INT )
            {
            // InternalMdl.g:150:4: (lv_id_2_0= RULE_INT )
            // InternalMdl.g:151:5: lv_id_2_0= RULE_INT
            {
            lv_id_2_0=(Token)match(input,RULE_INT,FOLLOW_7); 

            					newLeafNode(lv_id_2_0, grammarAccess.getStepAccess().getIdINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStepRule());
            					}
            					setWithLastConsumed(
            						current,
            						"id",
            						lv_id_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_8); 

            			newLeafNode(otherlv_3, grammarAccess.getStepAccess().getStepNameKeyword_3());
            		
            // InternalMdl.g:171:3: ( (lv_name_4_0= RULE_STRING ) )
            // InternalMdl.g:172:4: (lv_name_4_0= RULE_STRING )
            {
            // InternalMdl.g:172:4: (lv_name_4_0= RULE_STRING )
            // InternalMdl.g:173:5: lv_name_4_0= RULE_STRING
            {
            lv_name_4_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

            					newLeafNode(lv_name_4_0, grammarAccess.getStepAccess().getNameSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStepRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalMdl.g:189:3: (this_LP_5= RULE_LP ( (lv_reminders_6_0= ruleReminder ) )+ this_RP_7= RULE_RP )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_LP) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalMdl.g:190:4: this_LP_5= RULE_LP ( (lv_reminders_6_0= ruleReminder ) )+ this_RP_7= RULE_RP
                    {
                    this_LP_5=(Token)match(input,RULE_LP,FOLLOW_10); 

                    				newLeafNode(this_LP_5, grammarAccess.getStepAccess().getLPTerminalRuleCall_5_0());
                    			
                    // InternalMdl.g:194:4: ( (lv_reminders_6_0= ruleReminder ) )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==37) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalMdl.g:195:5: (lv_reminders_6_0= ruleReminder )
                    	    {
                    	    // InternalMdl.g:195:5: (lv_reminders_6_0= ruleReminder )
                    	    // InternalMdl.g:196:6: lv_reminders_6_0= ruleReminder
                    	    {

                    	    						newCompositeNode(grammarAccess.getStepAccess().getRemindersReminderParserRuleCall_5_1_0());
                    	    					
                    	    pushFollow(FOLLOW_11);
                    	    lv_reminders_6_0=ruleReminder();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"reminders",
                    	    							lv_reminders_6_0,
                    	    							"org.xtext.mdl.Mdl.Reminder");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);

                    this_RP_7=(Token)match(input,RULE_RP,FOLLOW_9); 

                    				newLeafNode(this_RP_7, grammarAccess.getStepAccess().getRPTerminalRuleCall_5_2());
                    			

                    }
                    break;

            }

            // InternalMdl.g:218:3: ( (lv_obj_8_0= ruleObject ) )
            // InternalMdl.g:219:4: (lv_obj_8_0= ruleObject )
            {
            // InternalMdl.g:219:4: (lv_obj_8_0= ruleObject )
            // InternalMdl.g:220:5: lv_obj_8_0= ruleObject
            {

            					newCompositeNode(grammarAccess.getStepAccess().getObjObjectParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_12);
            lv_obj_8_0=ruleObject();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStepRule());
            					}
            					set(
            						current,
            						"obj",
            						lv_obj_8_0,
            						"org.xtext.mdl.Mdl.Object");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RA_9=(Token)match(input,RULE_RA,FOLLOW_2); 

            			newLeafNode(this_RA_9, grammarAccess.getStepAccess().getRATerminalRuleCall_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStep"


    // $ANTLR start "entryRuleObject"
    // InternalMdl.g:245:1: entryRuleObject returns [EObject current=null] : iv_ruleObject= ruleObject EOF ;
    public final EObject entryRuleObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject = null;


        try {
            // InternalMdl.g:245:47: (iv_ruleObject= ruleObject EOF )
            // InternalMdl.g:246:2: iv_ruleObject= ruleObject EOF
            {
             newCompositeNode(grammarAccess.getObjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObject=ruleObject();

            state._fsp--;

             current =iv_ruleObject; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObject"


    // $ANTLR start "ruleObject"
    // InternalMdl.g:252:1: ruleObject returns [EObject current=null] : ( (otherlv_0= 'Questions' ( (lv_obj_1_0= ruleQCM ) ) ( (lv_cond_2_0= ruleCondFin ) ) ) | (otherlv_3= 'Mail' ( (lv_mail_4_0= ruleMail ) ) ( (lv_dateEnvoi_5_0= RULE_DATE ) ) ) | (otherlv_6= 'Calendar' ( (lv_synchDate_7_0= ruleSynchDate ) ) ( (lv_cond_8_0= ruleCondFin ) ) ) | (otherlv_9= 'FileDepository' ( (lv_depot_10_0= ruleDepot ) ) ) | (otherlv_11= 'TimeLaps' ( (lv_dateFin_12_0= RULE_DATE ) ) ) ) ;
    public final EObject ruleObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token lv_dateEnvoi_5_0=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_dateFin_12_0=null;
        EObject lv_obj_1_0 = null;

        EObject lv_cond_2_0 = null;

        EObject lv_mail_4_0 = null;

        EObject lv_synchDate_7_0 = null;

        EObject lv_cond_8_0 = null;

        EObject lv_depot_10_0 = null;



        	enterRule();

        try {
            // InternalMdl.g:258:2: ( ( (otherlv_0= 'Questions' ( (lv_obj_1_0= ruleQCM ) ) ( (lv_cond_2_0= ruleCondFin ) ) ) | (otherlv_3= 'Mail' ( (lv_mail_4_0= ruleMail ) ) ( (lv_dateEnvoi_5_0= RULE_DATE ) ) ) | (otherlv_6= 'Calendar' ( (lv_synchDate_7_0= ruleSynchDate ) ) ( (lv_cond_8_0= ruleCondFin ) ) ) | (otherlv_9= 'FileDepository' ( (lv_depot_10_0= ruleDepot ) ) ) | (otherlv_11= 'TimeLaps' ( (lv_dateFin_12_0= RULE_DATE ) ) ) ) )
            // InternalMdl.g:259:2: ( (otherlv_0= 'Questions' ( (lv_obj_1_0= ruleQCM ) ) ( (lv_cond_2_0= ruleCondFin ) ) ) | (otherlv_3= 'Mail' ( (lv_mail_4_0= ruleMail ) ) ( (lv_dateEnvoi_5_0= RULE_DATE ) ) ) | (otherlv_6= 'Calendar' ( (lv_synchDate_7_0= ruleSynchDate ) ) ( (lv_cond_8_0= ruleCondFin ) ) ) | (otherlv_9= 'FileDepository' ( (lv_depot_10_0= ruleDepot ) ) ) | (otherlv_11= 'TimeLaps' ( (lv_dateFin_12_0= RULE_DATE ) ) ) )
            {
            // InternalMdl.g:259:2: ( (otherlv_0= 'Questions' ( (lv_obj_1_0= ruleQCM ) ) ( (lv_cond_2_0= ruleCondFin ) ) ) | (otherlv_3= 'Mail' ( (lv_mail_4_0= ruleMail ) ) ( (lv_dateEnvoi_5_0= RULE_DATE ) ) ) | (otherlv_6= 'Calendar' ( (lv_synchDate_7_0= ruleSynchDate ) ) ( (lv_cond_8_0= ruleCondFin ) ) ) | (otherlv_9= 'FileDepository' ( (lv_depot_10_0= ruleDepot ) ) ) | (otherlv_11= 'TimeLaps' ( (lv_dateFin_12_0= RULE_DATE ) ) ) )
            int alt5=5;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt5=1;
                }
                break;
            case 21:
                {
                alt5=2;
                }
                break;
            case 22:
                {
                alt5=3;
                }
                break;
            case 23:
                {
                alt5=4;
                }
                break;
            case 24:
                {
                alt5=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalMdl.g:260:3: (otherlv_0= 'Questions' ( (lv_obj_1_0= ruleQCM ) ) ( (lv_cond_2_0= ruleCondFin ) ) )
                    {
                    // InternalMdl.g:260:3: (otherlv_0= 'Questions' ( (lv_obj_1_0= ruleQCM ) ) ( (lv_cond_2_0= ruleCondFin ) ) )
                    // InternalMdl.g:261:4: otherlv_0= 'Questions' ( (lv_obj_1_0= ruleQCM ) ) ( (lv_cond_2_0= ruleCondFin ) )
                    {
                    otherlv_0=(Token)match(input,20,FOLLOW_13); 

                    				newLeafNode(otherlv_0, grammarAccess.getObjectAccess().getQuestionsKeyword_0_0());
                    			
                    // InternalMdl.g:265:4: ( (lv_obj_1_0= ruleQCM ) )
                    // InternalMdl.g:266:5: (lv_obj_1_0= ruleQCM )
                    {
                    // InternalMdl.g:266:5: (lv_obj_1_0= ruleQCM )
                    // InternalMdl.g:267:6: lv_obj_1_0= ruleQCM
                    {

                    						newCompositeNode(grammarAccess.getObjectAccess().getObjQCMParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_obj_1_0=ruleQCM();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObjectRule());
                    						}
                    						set(
                    							current,
                    							"obj",
                    							lv_obj_1_0,
                    							"org.xtext.mdl.Mdl.QCM");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMdl.g:284:4: ( (lv_cond_2_0= ruleCondFin ) )
                    // InternalMdl.g:285:5: (lv_cond_2_0= ruleCondFin )
                    {
                    // InternalMdl.g:285:5: (lv_cond_2_0= ruleCondFin )
                    // InternalMdl.g:286:6: lv_cond_2_0= ruleCondFin
                    {

                    						newCompositeNode(grammarAccess.getObjectAccess().getCondCondFinParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_cond_2_0=ruleCondFin();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObjectRule());
                    						}
                    						set(
                    							current,
                    							"cond",
                    							lv_cond_2_0,
                    							"org.xtext.mdl.Mdl.CondFin");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMdl.g:305:3: (otherlv_3= 'Mail' ( (lv_mail_4_0= ruleMail ) ) ( (lv_dateEnvoi_5_0= RULE_DATE ) ) )
                    {
                    // InternalMdl.g:305:3: (otherlv_3= 'Mail' ( (lv_mail_4_0= ruleMail ) ) ( (lv_dateEnvoi_5_0= RULE_DATE ) ) )
                    // InternalMdl.g:306:4: otherlv_3= 'Mail' ( (lv_mail_4_0= ruleMail ) ) ( (lv_dateEnvoi_5_0= RULE_DATE ) )
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_13); 

                    				newLeafNode(otherlv_3, grammarAccess.getObjectAccess().getMailKeyword_1_0());
                    			
                    // InternalMdl.g:310:4: ( (lv_mail_4_0= ruleMail ) )
                    // InternalMdl.g:311:5: (lv_mail_4_0= ruleMail )
                    {
                    // InternalMdl.g:311:5: (lv_mail_4_0= ruleMail )
                    // InternalMdl.g:312:6: lv_mail_4_0= ruleMail
                    {

                    						newCompositeNode(grammarAccess.getObjectAccess().getMailMailParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_mail_4_0=ruleMail();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObjectRule());
                    						}
                    						set(
                    							current,
                    							"mail",
                    							lv_mail_4_0,
                    							"org.xtext.mdl.Mdl.Mail");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMdl.g:329:4: ( (lv_dateEnvoi_5_0= RULE_DATE ) )
                    // InternalMdl.g:330:5: (lv_dateEnvoi_5_0= RULE_DATE )
                    {
                    // InternalMdl.g:330:5: (lv_dateEnvoi_5_0= RULE_DATE )
                    // InternalMdl.g:331:6: lv_dateEnvoi_5_0= RULE_DATE
                    {
                    lv_dateEnvoi_5_0=(Token)match(input,RULE_DATE,FOLLOW_2); 

                    						newLeafNode(lv_dateEnvoi_5_0, grammarAccess.getObjectAccess().getDateEnvoiDATETerminalRuleCall_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getObjectRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"dateEnvoi",
                    							lv_dateEnvoi_5_0,
                    							"org.xtext.mdl.Mdl.DATE");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMdl.g:349:3: (otherlv_6= 'Calendar' ( (lv_synchDate_7_0= ruleSynchDate ) ) ( (lv_cond_8_0= ruleCondFin ) ) )
                    {
                    // InternalMdl.g:349:3: (otherlv_6= 'Calendar' ( (lv_synchDate_7_0= ruleSynchDate ) ) ( (lv_cond_8_0= ruleCondFin ) ) )
                    // InternalMdl.g:350:4: otherlv_6= 'Calendar' ( (lv_synchDate_7_0= ruleSynchDate ) ) ( (lv_cond_8_0= ruleCondFin ) )
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_13); 

                    				newLeafNode(otherlv_6, grammarAccess.getObjectAccess().getCalendarKeyword_2_0());
                    			
                    // InternalMdl.g:354:4: ( (lv_synchDate_7_0= ruleSynchDate ) )
                    // InternalMdl.g:355:5: (lv_synchDate_7_0= ruleSynchDate )
                    {
                    // InternalMdl.g:355:5: (lv_synchDate_7_0= ruleSynchDate )
                    // InternalMdl.g:356:6: lv_synchDate_7_0= ruleSynchDate
                    {

                    						newCompositeNode(grammarAccess.getObjectAccess().getSynchDateSynchDateParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_synchDate_7_0=ruleSynchDate();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObjectRule());
                    						}
                    						set(
                    							current,
                    							"synchDate",
                    							lv_synchDate_7_0,
                    							"org.xtext.mdl.Mdl.SynchDate");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMdl.g:373:4: ( (lv_cond_8_0= ruleCondFin ) )
                    // InternalMdl.g:374:5: (lv_cond_8_0= ruleCondFin )
                    {
                    // InternalMdl.g:374:5: (lv_cond_8_0= ruleCondFin )
                    // InternalMdl.g:375:6: lv_cond_8_0= ruleCondFin
                    {

                    						newCompositeNode(grammarAccess.getObjectAccess().getCondCondFinParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_cond_8_0=ruleCondFin();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObjectRule());
                    						}
                    						set(
                    							current,
                    							"cond",
                    							lv_cond_8_0,
                    							"org.xtext.mdl.Mdl.CondFin");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMdl.g:394:3: (otherlv_9= 'FileDepository' ( (lv_depot_10_0= ruleDepot ) ) )
                    {
                    // InternalMdl.g:394:3: (otherlv_9= 'FileDepository' ( (lv_depot_10_0= ruleDepot ) ) )
                    // InternalMdl.g:395:4: otherlv_9= 'FileDepository' ( (lv_depot_10_0= ruleDepot ) )
                    {
                    otherlv_9=(Token)match(input,23,FOLLOW_13); 

                    				newLeafNode(otherlv_9, grammarAccess.getObjectAccess().getFileDepositoryKeyword_3_0());
                    			
                    // InternalMdl.g:399:4: ( (lv_depot_10_0= ruleDepot ) )
                    // InternalMdl.g:400:5: (lv_depot_10_0= ruleDepot )
                    {
                    // InternalMdl.g:400:5: (lv_depot_10_0= ruleDepot )
                    // InternalMdl.g:401:6: lv_depot_10_0= ruleDepot
                    {

                    						newCompositeNode(grammarAccess.getObjectAccess().getDepotDepotParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_depot_10_0=ruleDepot();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObjectRule());
                    						}
                    						set(
                    							current,
                    							"depot",
                    							lv_depot_10_0,
                    							"org.xtext.mdl.Mdl.Depot");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalMdl.g:420:3: (otherlv_11= 'TimeLaps' ( (lv_dateFin_12_0= RULE_DATE ) ) )
                    {
                    // InternalMdl.g:420:3: (otherlv_11= 'TimeLaps' ( (lv_dateFin_12_0= RULE_DATE ) ) )
                    // InternalMdl.g:421:4: otherlv_11= 'TimeLaps' ( (lv_dateFin_12_0= RULE_DATE ) )
                    {
                    otherlv_11=(Token)match(input,24,FOLLOW_3); 

                    				newLeafNode(otherlv_11, grammarAccess.getObjectAccess().getTimeLapsKeyword_4_0());
                    			
                    // InternalMdl.g:425:4: ( (lv_dateFin_12_0= RULE_DATE ) )
                    // InternalMdl.g:426:5: (lv_dateFin_12_0= RULE_DATE )
                    {
                    // InternalMdl.g:426:5: (lv_dateFin_12_0= RULE_DATE )
                    // InternalMdl.g:427:6: lv_dateFin_12_0= RULE_DATE
                    {
                    lv_dateFin_12_0=(Token)match(input,RULE_DATE,FOLLOW_2); 

                    						newLeafNode(lv_dateFin_12_0, grammarAccess.getObjectAccess().getDateFinDATETerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getObjectRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"dateFin",
                    							lv_dateFin_12_0,
                    							"org.xtext.mdl.Mdl.DATE");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObject"


    // $ANTLR start "entryRuleCondFin"
    // InternalMdl.g:448:1: entryRuleCondFin returns [EObject current=null] : iv_ruleCondFin= ruleCondFin EOF ;
    public final EObject entryRuleCondFin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondFin = null;


        try {
            // InternalMdl.g:448:48: (iv_ruleCondFin= ruleCondFin EOF )
            // InternalMdl.g:449:2: iv_ruleCondFin= ruleCondFin EOF
            {
             newCompositeNode(grammarAccess.getCondFinRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondFin=ruleCondFin();

            state._fsp--;

             current =iv_ruleCondFin; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondFin"


    // $ANTLR start "ruleCondFin"
    // InternalMdl.g:455:1: ruleCondFin returns [EObject current=null] : ( ( (lv_date_0_0= RULE_DATE ) ) (otherlv_1= 'ParticipantsRequired:' ( (lv_ParticipantsRequired_2_0= RULE_INT ) ) )? ) ;
    public final EObject ruleCondFin() throws RecognitionException {
        EObject current = null;

        Token lv_date_0_0=null;
        Token otherlv_1=null;
        Token lv_ParticipantsRequired_2_0=null;


        	enterRule();

        try {
            // InternalMdl.g:461:2: ( ( ( (lv_date_0_0= RULE_DATE ) ) (otherlv_1= 'ParticipantsRequired:' ( (lv_ParticipantsRequired_2_0= RULE_INT ) ) )? ) )
            // InternalMdl.g:462:2: ( ( (lv_date_0_0= RULE_DATE ) ) (otherlv_1= 'ParticipantsRequired:' ( (lv_ParticipantsRequired_2_0= RULE_INT ) ) )? )
            {
            // InternalMdl.g:462:2: ( ( (lv_date_0_0= RULE_DATE ) ) (otherlv_1= 'ParticipantsRequired:' ( (lv_ParticipantsRequired_2_0= RULE_INT ) ) )? )
            // InternalMdl.g:463:3: ( (lv_date_0_0= RULE_DATE ) ) (otherlv_1= 'ParticipantsRequired:' ( (lv_ParticipantsRequired_2_0= RULE_INT ) ) )?
            {
            // InternalMdl.g:463:3: ( (lv_date_0_0= RULE_DATE ) )
            // InternalMdl.g:464:4: (lv_date_0_0= RULE_DATE )
            {
            // InternalMdl.g:464:4: (lv_date_0_0= RULE_DATE )
            // InternalMdl.g:465:5: lv_date_0_0= RULE_DATE
            {
            lv_date_0_0=(Token)match(input,RULE_DATE,FOLLOW_14); 

            					newLeafNode(lv_date_0_0, grammarAccess.getCondFinAccess().getDateDATETerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCondFinRule());
            					}
            					setWithLastConsumed(
            						current,
            						"date",
            						lv_date_0_0,
            						"org.xtext.mdl.Mdl.DATE");
            				

            }


            }

            // InternalMdl.g:481:3: (otherlv_1= 'ParticipantsRequired:' ( (lv_ParticipantsRequired_2_0= RULE_INT ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==25) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMdl.g:482:4: otherlv_1= 'ParticipantsRequired:' ( (lv_ParticipantsRequired_2_0= RULE_INT ) )
                    {
                    otherlv_1=(Token)match(input,25,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getCondFinAccess().getParticipantsRequiredKeyword_1_0());
                    			
                    // InternalMdl.g:486:4: ( (lv_ParticipantsRequired_2_0= RULE_INT ) )
                    // InternalMdl.g:487:5: (lv_ParticipantsRequired_2_0= RULE_INT )
                    {
                    // InternalMdl.g:487:5: (lv_ParticipantsRequired_2_0= RULE_INT )
                    // InternalMdl.g:488:6: lv_ParticipantsRequired_2_0= RULE_INT
                    {
                    lv_ParticipantsRequired_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_ParticipantsRequired_2_0, grammarAccess.getCondFinAccess().getParticipantsRequiredINTTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCondFinRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"ParticipantsRequired",
                    							lv_ParticipantsRequired_2_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondFin"


    // $ANTLR start "entryRuleSynchDate"
    // InternalMdl.g:509:1: entryRuleSynchDate returns [EObject current=null] : iv_ruleSynchDate= ruleSynchDate EOF ;
    public final EObject entryRuleSynchDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynchDate = null;


        try {
            // InternalMdl.g:509:50: (iv_ruleSynchDate= ruleSynchDate EOF )
            // InternalMdl.g:510:2: iv_ruleSynchDate= ruleSynchDate EOF
            {
             newCompositeNode(grammarAccess.getSynchDateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSynchDate=ruleSynchDate();

            state._fsp--;

             current =iv_ruleSynchDate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSynchDate"


    // $ANTLR start "ruleSynchDate"
    // InternalMdl.g:516:1: ruleSynchDate returns [EObject current=null] : (this_LA_0= RULE_LA otherlv_1= 'StartingDate:' ( (lv_start_2_0= RULE_DATE ) ) otherlv_3= 'EndingDate:' ( (lv_end_4_0= RULE_DATE ) ) otherlv_5= 'Accuracy:' ( (lv_precision_6_0= RULE_STRING ) )? this_RA_7= RULE_RA ) ;
    public final EObject ruleSynchDate() throws RecognitionException {
        EObject current = null;

        Token this_LA_0=null;
        Token otherlv_1=null;
        Token lv_start_2_0=null;
        Token otherlv_3=null;
        Token lv_end_4_0=null;
        Token otherlv_5=null;
        Token lv_precision_6_0=null;
        Token this_RA_7=null;


        	enterRule();

        try {
            // InternalMdl.g:522:2: ( (this_LA_0= RULE_LA otherlv_1= 'StartingDate:' ( (lv_start_2_0= RULE_DATE ) ) otherlv_3= 'EndingDate:' ( (lv_end_4_0= RULE_DATE ) ) otherlv_5= 'Accuracy:' ( (lv_precision_6_0= RULE_STRING ) )? this_RA_7= RULE_RA ) )
            // InternalMdl.g:523:2: (this_LA_0= RULE_LA otherlv_1= 'StartingDate:' ( (lv_start_2_0= RULE_DATE ) ) otherlv_3= 'EndingDate:' ( (lv_end_4_0= RULE_DATE ) ) otherlv_5= 'Accuracy:' ( (lv_precision_6_0= RULE_STRING ) )? this_RA_7= RULE_RA )
            {
            // InternalMdl.g:523:2: (this_LA_0= RULE_LA otherlv_1= 'StartingDate:' ( (lv_start_2_0= RULE_DATE ) ) otherlv_3= 'EndingDate:' ( (lv_end_4_0= RULE_DATE ) ) otherlv_5= 'Accuracy:' ( (lv_precision_6_0= RULE_STRING ) )? this_RA_7= RULE_RA )
            // InternalMdl.g:524:3: this_LA_0= RULE_LA otherlv_1= 'StartingDate:' ( (lv_start_2_0= RULE_DATE ) ) otherlv_3= 'EndingDate:' ( (lv_end_4_0= RULE_DATE ) ) otherlv_5= 'Accuracy:' ( (lv_precision_6_0= RULE_STRING ) )? this_RA_7= RULE_RA
            {
            this_LA_0=(Token)match(input,RULE_LA,FOLLOW_15); 

            			newLeafNode(this_LA_0, grammarAccess.getSynchDateAccess().getLATerminalRuleCall_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getSynchDateAccess().getStartingDateKeyword_1());
            		
            // InternalMdl.g:532:3: ( (lv_start_2_0= RULE_DATE ) )
            // InternalMdl.g:533:4: (lv_start_2_0= RULE_DATE )
            {
            // InternalMdl.g:533:4: (lv_start_2_0= RULE_DATE )
            // InternalMdl.g:534:5: lv_start_2_0= RULE_DATE
            {
            lv_start_2_0=(Token)match(input,RULE_DATE,FOLLOW_16); 

            					newLeafNode(lv_start_2_0, grammarAccess.getSynchDateAccess().getStartDATETerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSynchDateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"start",
            						lv_start_2_0,
            						"org.xtext.mdl.Mdl.DATE");
            				

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getSynchDateAccess().getEndingDateKeyword_3());
            		
            // InternalMdl.g:554:3: ( (lv_end_4_0= RULE_DATE ) )
            // InternalMdl.g:555:4: (lv_end_4_0= RULE_DATE )
            {
            // InternalMdl.g:555:4: (lv_end_4_0= RULE_DATE )
            // InternalMdl.g:556:5: lv_end_4_0= RULE_DATE
            {
            lv_end_4_0=(Token)match(input,RULE_DATE,FOLLOW_17); 

            					newLeafNode(lv_end_4_0, grammarAccess.getSynchDateAccess().getEndDATETerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSynchDateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"end",
            						lv_end_4_0,
            						"org.xtext.mdl.Mdl.DATE");
            				

            }


            }

            otherlv_5=(Token)match(input,28,FOLLOW_18); 

            			newLeafNode(otherlv_5, grammarAccess.getSynchDateAccess().getAccuracyKeyword_5());
            		
            // InternalMdl.g:576:3: ( (lv_precision_6_0= RULE_STRING ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalMdl.g:577:4: (lv_precision_6_0= RULE_STRING )
                    {
                    // InternalMdl.g:577:4: (lv_precision_6_0= RULE_STRING )
                    // InternalMdl.g:578:5: lv_precision_6_0= RULE_STRING
                    {
                    lv_precision_6_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

                    					newLeafNode(lv_precision_6_0, grammarAccess.getSynchDateAccess().getPrecisionSTRINGTerminalRuleCall_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSynchDateRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"precision",
                    						lv_precision_6_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }
                    break;

            }

            this_RA_7=(Token)match(input,RULE_RA,FOLLOW_2); 

            			newLeafNode(this_RA_7, grammarAccess.getSynchDateAccess().getRATerminalRuleCall_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSynchDate"


    // $ANTLR start "entryRuleDepot"
    // InternalMdl.g:602:1: entryRuleDepot returns [EObject current=null] : iv_ruleDepot= ruleDepot EOF ;
    public final EObject entryRuleDepot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDepot = null;


        try {
            // InternalMdl.g:602:46: (iv_ruleDepot= ruleDepot EOF )
            // InternalMdl.g:603:2: iv_ruleDepot= ruleDepot EOF
            {
             newCompositeNode(grammarAccess.getDepotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDepot=ruleDepot();

            state._fsp--;

             current =iv_ruleDepot; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDepot"


    // $ANTLR start "ruleDepot"
    // InternalMdl.g:609:1: ruleDepot returns [EObject current=null] : (this_LA_0= RULE_LA otherlv_1= 'TitleSubmission:' ( (lv_intitule_2_0= RULE_STRING ) ) otherlv_3= 'SizeLimite:' ( (lv_limiteSize_4_0= RULE_INT ) ) ( (lv_format_5_0= RULE_STRING ) )* this_RA_6= RULE_RA ) ;
    public final EObject ruleDepot() throws RecognitionException {
        EObject current = null;

        Token this_LA_0=null;
        Token otherlv_1=null;
        Token lv_intitule_2_0=null;
        Token otherlv_3=null;
        Token lv_limiteSize_4_0=null;
        Token lv_format_5_0=null;
        Token this_RA_6=null;


        	enterRule();

        try {
            // InternalMdl.g:615:2: ( (this_LA_0= RULE_LA otherlv_1= 'TitleSubmission:' ( (lv_intitule_2_0= RULE_STRING ) ) otherlv_3= 'SizeLimite:' ( (lv_limiteSize_4_0= RULE_INT ) ) ( (lv_format_5_0= RULE_STRING ) )* this_RA_6= RULE_RA ) )
            // InternalMdl.g:616:2: (this_LA_0= RULE_LA otherlv_1= 'TitleSubmission:' ( (lv_intitule_2_0= RULE_STRING ) ) otherlv_3= 'SizeLimite:' ( (lv_limiteSize_4_0= RULE_INT ) ) ( (lv_format_5_0= RULE_STRING ) )* this_RA_6= RULE_RA )
            {
            // InternalMdl.g:616:2: (this_LA_0= RULE_LA otherlv_1= 'TitleSubmission:' ( (lv_intitule_2_0= RULE_STRING ) ) otherlv_3= 'SizeLimite:' ( (lv_limiteSize_4_0= RULE_INT ) ) ( (lv_format_5_0= RULE_STRING ) )* this_RA_6= RULE_RA )
            // InternalMdl.g:617:3: this_LA_0= RULE_LA otherlv_1= 'TitleSubmission:' ( (lv_intitule_2_0= RULE_STRING ) ) otherlv_3= 'SizeLimite:' ( (lv_limiteSize_4_0= RULE_INT ) ) ( (lv_format_5_0= RULE_STRING ) )* this_RA_6= RULE_RA
            {
            this_LA_0=(Token)match(input,RULE_LA,FOLLOW_19); 

            			newLeafNode(this_LA_0, grammarAccess.getDepotAccess().getLATerminalRuleCall_0());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getDepotAccess().getTitleSubmissionKeyword_1());
            		
            // InternalMdl.g:625:3: ( (lv_intitule_2_0= RULE_STRING ) )
            // InternalMdl.g:626:4: (lv_intitule_2_0= RULE_STRING )
            {
            // InternalMdl.g:626:4: (lv_intitule_2_0= RULE_STRING )
            // InternalMdl.g:627:5: lv_intitule_2_0= RULE_STRING
            {
            lv_intitule_2_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            					newLeafNode(lv_intitule_2_0, grammarAccess.getDepotAccess().getIntituleSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDepotRule());
            					}
            					setWithLastConsumed(
            						current,
            						"intitule",
            						lv_intitule_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,30,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getDepotAccess().getSizeLimiteKeyword_3());
            		
            // InternalMdl.g:647:3: ( (lv_limiteSize_4_0= RULE_INT ) )
            // InternalMdl.g:648:4: (lv_limiteSize_4_0= RULE_INT )
            {
            // InternalMdl.g:648:4: (lv_limiteSize_4_0= RULE_INT )
            // InternalMdl.g:649:5: lv_limiteSize_4_0= RULE_INT
            {
            lv_limiteSize_4_0=(Token)match(input,RULE_INT,FOLLOW_18); 

            					newLeafNode(lv_limiteSize_4_0, grammarAccess.getDepotAccess().getLimiteSizeINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDepotRule());
            					}
            					setWithLastConsumed(
            						current,
            						"limiteSize",
            						lv_limiteSize_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalMdl.g:665:3: ( (lv_format_5_0= RULE_STRING ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_STRING) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMdl.g:666:4: (lv_format_5_0= RULE_STRING )
            	    {
            	    // InternalMdl.g:666:4: (lv_format_5_0= RULE_STRING )
            	    // InternalMdl.g:667:5: lv_format_5_0= RULE_STRING
            	    {
            	    lv_format_5_0=(Token)match(input,RULE_STRING,FOLLOW_18); 

            	    					newLeafNode(lv_format_5_0, grammarAccess.getDepotAccess().getFormatSTRINGTerminalRuleCall_5_0());
            	    				

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getDepotRule());
            	    					}
            	    					addWithLastConsumed(
            	    						current,
            	    						"format",
            	    						lv_format_5_0,
            	    						"org.eclipse.xtext.common.Terminals.STRING");
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            this_RA_6=(Token)match(input,RULE_RA,FOLLOW_2); 

            			newLeafNode(this_RA_6, grammarAccess.getDepotAccess().getRATerminalRuleCall_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDepot"


    // $ANTLR start "entryRuleQCM"
    // InternalMdl.g:691:1: entryRuleQCM returns [EObject current=null] : iv_ruleQCM= ruleQCM EOF ;
    public final EObject entryRuleQCM() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQCM = null;


        try {
            // InternalMdl.g:691:44: (iv_ruleQCM= ruleQCM EOF )
            // InternalMdl.g:692:2: iv_ruleQCM= ruleQCM EOF
            {
             newCompositeNode(grammarAccess.getQCMRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQCM=ruleQCM();

            state._fsp--;

             current =iv_ruleQCM; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQCM"


    // $ANTLR start "ruleQCM"
    // InternalMdl.g:698:1: ruleQCM returns [EObject current=null] : (this_LA_0= RULE_LA otherlv_1= 'QuestionType:' ( (lv_type_2_0= ruleTypeQCM ) ) otherlv_3= 'TitleQuestion:' ( (lv_intitule_4_0= RULE_STRING ) ) (otherlv_5= 'PossibleResponse:' ( (lv_responses_6_0= RULE_STRING ) ) )* this_RA_7= RULE_RA ( (lv_suite_8_0= ruleQCM ) )? ) ;
    public final EObject ruleQCM() throws RecognitionException {
        EObject current = null;

        Token this_LA_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_intitule_4_0=null;
        Token otherlv_5=null;
        Token lv_responses_6_0=null;
        Token this_RA_7=null;
        EObject lv_type_2_0 = null;

        EObject lv_suite_8_0 = null;



        	enterRule();

        try {
            // InternalMdl.g:704:2: ( (this_LA_0= RULE_LA otherlv_1= 'QuestionType:' ( (lv_type_2_0= ruleTypeQCM ) ) otherlv_3= 'TitleQuestion:' ( (lv_intitule_4_0= RULE_STRING ) ) (otherlv_5= 'PossibleResponse:' ( (lv_responses_6_0= RULE_STRING ) ) )* this_RA_7= RULE_RA ( (lv_suite_8_0= ruleQCM ) )? ) )
            // InternalMdl.g:705:2: (this_LA_0= RULE_LA otherlv_1= 'QuestionType:' ( (lv_type_2_0= ruleTypeQCM ) ) otherlv_3= 'TitleQuestion:' ( (lv_intitule_4_0= RULE_STRING ) ) (otherlv_5= 'PossibleResponse:' ( (lv_responses_6_0= RULE_STRING ) ) )* this_RA_7= RULE_RA ( (lv_suite_8_0= ruleQCM ) )? )
            {
            // InternalMdl.g:705:2: (this_LA_0= RULE_LA otherlv_1= 'QuestionType:' ( (lv_type_2_0= ruleTypeQCM ) ) otherlv_3= 'TitleQuestion:' ( (lv_intitule_4_0= RULE_STRING ) ) (otherlv_5= 'PossibleResponse:' ( (lv_responses_6_0= RULE_STRING ) ) )* this_RA_7= RULE_RA ( (lv_suite_8_0= ruleQCM ) )? )
            // InternalMdl.g:706:3: this_LA_0= RULE_LA otherlv_1= 'QuestionType:' ( (lv_type_2_0= ruleTypeQCM ) ) otherlv_3= 'TitleQuestion:' ( (lv_intitule_4_0= RULE_STRING ) ) (otherlv_5= 'PossibleResponse:' ( (lv_responses_6_0= RULE_STRING ) ) )* this_RA_7= RULE_RA ( (lv_suite_8_0= ruleQCM ) )?
            {
            this_LA_0=(Token)match(input,RULE_LA,FOLLOW_21); 

            			newLeafNode(this_LA_0, grammarAccess.getQCMAccess().getLATerminalRuleCall_0());
            		
            otherlv_1=(Token)match(input,31,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getQCMAccess().getQuestionTypeKeyword_1());
            		
            // InternalMdl.g:714:3: ( (lv_type_2_0= ruleTypeQCM ) )
            // InternalMdl.g:715:4: (lv_type_2_0= ruleTypeQCM )
            {
            // InternalMdl.g:715:4: (lv_type_2_0= ruleTypeQCM )
            // InternalMdl.g:716:5: lv_type_2_0= ruleTypeQCM
            {

            					newCompositeNode(grammarAccess.getQCMAccess().getTypeTypeQCMParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_23);
            lv_type_2_0=ruleTypeQCM();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQCMRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"org.xtext.mdl.Mdl.TypeQCM");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,32,FOLLOW_8); 

            			newLeafNode(otherlv_3, grammarAccess.getQCMAccess().getTitleQuestionKeyword_3());
            		
            // InternalMdl.g:737:3: ( (lv_intitule_4_0= RULE_STRING ) )
            // InternalMdl.g:738:4: (lv_intitule_4_0= RULE_STRING )
            {
            // InternalMdl.g:738:4: (lv_intitule_4_0= RULE_STRING )
            // InternalMdl.g:739:5: lv_intitule_4_0= RULE_STRING
            {
            lv_intitule_4_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

            					newLeafNode(lv_intitule_4_0, grammarAccess.getQCMAccess().getIntituleSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQCMRule());
            					}
            					setWithLastConsumed(
            						current,
            						"intitule",
            						lv_intitule_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalMdl.g:755:3: (otherlv_5= 'PossibleResponse:' ( (lv_responses_6_0= RULE_STRING ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==33) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalMdl.g:756:4: otherlv_5= 'PossibleResponse:' ( (lv_responses_6_0= RULE_STRING ) )
            	    {
            	    otherlv_5=(Token)match(input,33,FOLLOW_8); 

            	    				newLeafNode(otherlv_5, grammarAccess.getQCMAccess().getPossibleResponseKeyword_5_0());
            	    			
            	    // InternalMdl.g:760:4: ( (lv_responses_6_0= RULE_STRING ) )
            	    // InternalMdl.g:761:5: (lv_responses_6_0= RULE_STRING )
            	    {
            	    // InternalMdl.g:761:5: (lv_responses_6_0= RULE_STRING )
            	    // InternalMdl.g:762:6: lv_responses_6_0= RULE_STRING
            	    {
            	    lv_responses_6_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

            	    						newLeafNode(lv_responses_6_0, grammarAccess.getQCMAccess().getResponsesSTRINGTerminalRuleCall_5_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getQCMRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"responses",
            	    							lv_responses_6_0,
            	    							"org.eclipse.xtext.common.Terminals.STRING");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            this_RA_7=(Token)match(input,RULE_RA,FOLLOW_4); 

            			newLeafNode(this_RA_7, grammarAccess.getQCMAccess().getRATerminalRuleCall_6());
            		
            // InternalMdl.g:783:3: ( (lv_suite_8_0= ruleQCM ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_LA) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMdl.g:784:4: (lv_suite_8_0= ruleQCM )
                    {
                    // InternalMdl.g:784:4: (lv_suite_8_0= ruleQCM )
                    // InternalMdl.g:785:5: lv_suite_8_0= ruleQCM
                    {

                    					newCompositeNode(grammarAccess.getQCMAccess().getSuiteQCMParserRuleCall_7_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_suite_8_0=ruleQCM();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getQCMRule());
                    					}
                    					set(
                    						current,
                    						"suite",
                    						lv_suite_8_0,
                    						"org.xtext.mdl.Mdl.QCM");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQCM"


    // $ANTLR start "entryRuleTypeQCM"
    // InternalMdl.g:806:1: entryRuleTypeQCM returns [EObject current=null] : iv_ruleTypeQCM= ruleTypeQCM EOF ;
    public final EObject entryRuleTypeQCM() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeQCM = null;


        try {
            // InternalMdl.g:806:48: (iv_ruleTypeQCM= ruleTypeQCM EOF )
            // InternalMdl.g:807:2: iv_ruleTypeQCM= ruleTypeQCM EOF
            {
             newCompositeNode(grammarAccess.getTypeQCMRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeQCM=ruleTypeQCM();

            state._fsp--;

             current =iv_ruleTypeQCM; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeQCM"


    // $ANTLR start "ruleTypeQCM"
    // InternalMdl.g:813:1: ruleTypeQCM returns [EObject current=null] : ( ( (lv_OPENQUESTION_0_0= 'OpenQuestion' ) ) | ( (lv_CHECKBOX_1_0= 'CheckBox' ) ) | ( (lv_RADIOBUTTON_2_0= 'RadioButton' ) ) ) ;
    public final EObject ruleTypeQCM() throws RecognitionException {
        EObject current = null;

        Token lv_OPENQUESTION_0_0=null;
        Token lv_CHECKBOX_1_0=null;
        Token lv_RADIOBUTTON_2_0=null;


        	enterRule();

        try {
            // InternalMdl.g:819:2: ( ( ( (lv_OPENQUESTION_0_0= 'OpenQuestion' ) ) | ( (lv_CHECKBOX_1_0= 'CheckBox' ) ) | ( (lv_RADIOBUTTON_2_0= 'RadioButton' ) ) ) )
            // InternalMdl.g:820:2: ( ( (lv_OPENQUESTION_0_0= 'OpenQuestion' ) ) | ( (lv_CHECKBOX_1_0= 'CheckBox' ) ) | ( (lv_RADIOBUTTON_2_0= 'RadioButton' ) ) )
            {
            // InternalMdl.g:820:2: ( ( (lv_OPENQUESTION_0_0= 'OpenQuestion' ) ) | ( (lv_CHECKBOX_1_0= 'CheckBox' ) ) | ( (lv_RADIOBUTTON_2_0= 'RadioButton' ) ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt11=1;
                }
                break;
            case 35:
                {
                alt11=2;
                }
                break;
            case 36:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalMdl.g:821:3: ( (lv_OPENQUESTION_0_0= 'OpenQuestion' ) )
                    {
                    // InternalMdl.g:821:3: ( (lv_OPENQUESTION_0_0= 'OpenQuestion' ) )
                    // InternalMdl.g:822:4: (lv_OPENQUESTION_0_0= 'OpenQuestion' )
                    {
                    // InternalMdl.g:822:4: (lv_OPENQUESTION_0_0= 'OpenQuestion' )
                    // InternalMdl.g:823:5: lv_OPENQUESTION_0_0= 'OpenQuestion'
                    {
                    lv_OPENQUESTION_0_0=(Token)match(input,34,FOLLOW_2); 

                    					newLeafNode(lv_OPENQUESTION_0_0, grammarAccess.getTypeQCMAccess().getOPENQUESTIONOpenQuestionKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTypeQCMRule());
                    					}
                    					setWithLastConsumed(current, "OPENQUESTION", lv_OPENQUESTION_0_0, "OpenQuestion");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMdl.g:836:3: ( (lv_CHECKBOX_1_0= 'CheckBox' ) )
                    {
                    // InternalMdl.g:836:3: ( (lv_CHECKBOX_1_0= 'CheckBox' ) )
                    // InternalMdl.g:837:4: (lv_CHECKBOX_1_0= 'CheckBox' )
                    {
                    // InternalMdl.g:837:4: (lv_CHECKBOX_1_0= 'CheckBox' )
                    // InternalMdl.g:838:5: lv_CHECKBOX_1_0= 'CheckBox'
                    {
                    lv_CHECKBOX_1_0=(Token)match(input,35,FOLLOW_2); 

                    					newLeafNode(lv_CHECKBOX_1_0, grammarAccess.getTypeQCMAccess().getCHECKBOXCheckBoxKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTypeQCMRule());
                    					}
                    					setWithLastConsumed(current, "CHECKBOX", lv_CHECKBOX_1_0, "CheckBox");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMdl.g:851:3: ( (lv_RADIOBUTTON_2_0= 'RadioButton' ) )
                    {
                    // InternalMdl.g:851:3: ( (lv_RADIOBUTTON_2_0= 'RadioButton' ) )
                    // InternalMdl.g:852:4: (lv_RADIOBUTTON_2_0= 'RadioButton' )
                    {
                    // InternalMdl.g:852:4: (lv_RADIOBUTTON_2_0= 'RadioButton' )
                    // InternalMdl.g:853:5: lv_RADIOBUTTON_2_0= 'RadioButton'
                    {
                    lv_RADIOBUTTON_2_0=(Token)match(input,36,FOLLOW_2); 

                    					newLeafNode(lv_RADIOBUTTON_2_0, grammarAccess.getTypeQCMAccess().getRADIOBUTTONRadioButtonKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTypeQCMRule());
                    					}
                    					setWithLastConsumed(current, "RADIOBUTTON", lv_RADIOBUTTON_2_0, "RadioButton");
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeQCM"


    // $ANTLR start "entryRuleReminder"
    // InternalMdl.g:869:1: entryRuleReminder returns [EObject current=null] : iv_ruleReminder= ruleReminder EOF ;
    public final EObject entryRuleReminder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReminder = null;


        try {
            // InternalMdl.g:869:49: (iv_ruleReminder= ruleReminder EOF )
            // InternalMdl.g:870:2: iv_ruleReminder= ruleReminder EOF
            {
             newCompositeNode(grammarAccess.getReminderRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReminder=ruleReminder();

            state._fsp--;

             current =iv_ruleReminder; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReminder"


    // $ANTLR start "ruleReminder"
    // InternalMdl.g:876:1: ruleReminder returns [EObject current=null] : (otherlv_0= 'Reminder' ( (lv_date_1_0= RULE_DATE ) )+ ( (lv_mail_2_0= ruleMail ) ) ) ;
    public final EObject ruleReminder() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_date_1_0=null;
        EObject lv_mail_2_0 = null;



        	enterRule();

        try {
            // InternalMdl.g:882:2: ( (otherlv_0= 'Reminder' ( (lv_date_1_0= RULE_DATE ) )+ ( (lv_mail_2_0= ruleMail ) ) ) )
            // InternalMdl.g:883:2: (otherlv_0= 'Reminder' ( (lv_date_1_0= RULE_DATE ) )+ ( (lv_mail_2_0= ruleMail ) ) )
            {
            // InternalMdl.g:883:2: (otherlv_0= 'Reminder' ( (lv_date_1_0= RULE_DATE ) )+ ( (lv_mail_2_0= ruleMail ) ) )
            // InternalMdl.g:884:3: otherlv_0= 'Reminder' ( (lv_date_1_0= RULE_DATE ) )+ ( (lv_mail_2_0= ruleMail ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getReminderAccess().getReminderKeyword_0());
            		
            // InternalMdl.g:888:3: ( (lv_date_1_0= RULE_DATE ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_DATE) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMdl.g:889:4: (lv_date_1_0= RULE_DATE )
            	    {
            	    // InternalMdl.g:889:4: (lv_date_1_0= RULE_DATE )
            	    // InternalMdl.g:890:5: lv_date_1_0= RULE_DATE
            	    {
            	    lv_date_1_0=(Token)match(input,RULE_DATE,FOLLOW_25); 

            	    					newLeafNode(lv_date_1_0, grammarAccess.getReminderAccess().getDateDATETerminalRuleCall_1_0());
            	    				

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getReminderRule());
            	    					}
            	    					addWithLastConsumed(
            	    						current,
            	    						"date",
            	    						lv_date_1_0,
            	    						"org.xtext.mdl.Mdl.DATE");
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            // InternalMdl.g:906:3: ( (lv_mail_2_0= ruleMail ) )
            // InternalMdl.g:907:4: (lv_mail_2_0= ruleMail )
            {
            // InternalMdl.g:907:4: (lv_mail_2_0= ruleMail )
            // InternalMdl.g:908:5: lv_mail_2_0= ruleMail
            {

            					newCompositeNode(grammarAccess.getReminderAccess().getMailMailParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_mail_2_0=ruleMail();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReminderRule());
            					}
            					set(
            						current,
            						"mail",
            						lv_mail_2_0,
            						"org.xtext.mdl.Mdl.Mail");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReminder"


    // $ANTLR start "entryRuleMail"
    // InternalMdl.g:929:1: entryRuleMail returns [EObject current=null] : iv_ruleMail= ruleMail EOF ;
    public final EObject entryRuleMail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMail = null;


        try {
            // InternalMdl.g:929:45: (iv_ruleMail= ruleMail EOF )
            // InternalMdl.g:930:2: iv_ruleMail= ruleMail EOF
            {
             newCompositeNode(grammarAccess.getMailRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMail=ruleMail();

            state._fsp--;

             current =iv_ruleMail; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMail"


    // $ANTLR start "ruleMail"
    // InternalMdl.g:936:1: ruleMail returns [EObject current=null] : (this_LA_0= RULE_LA otherlv_1= 'From:' ( (lv_expediteur_2_0= RULE_ADDRESSEMAIL ) ) otherlv_3= 'To:' ( (lv_destinataire_4_0= RULE_ADDRESSEMAIL ) )+ (otherlv_5= 'Attachment:' ( (lv_pj_6_0= RULE_STRING ) ) )? otherlv_7= 'Body:' ( (lv_corps_8_0= ruleContenu ) ) this_RA_9= RULE_RA ) ;
    public final EObject ruleMail() throws RecognitionException {
        EObject current = null;

        Token this_LA_0=null;
        Token otherlv_1=null;
        Token lv_expediteur_2_0=null;
        Token otherlv_3=null;
        Token lv_destinataire_4_0=null;
        Token otherlv_5=null;
        Token lv_pj_6_0=null;
        Token otherlv_7=null;
        Token this_RA_9=null;
        EObject lv_corps_8_0 = null;



        	enterRule();

        try {
            // InternalMdl.g:942:2: ( (this_LA_0= RULE_LA otherlv_1= 'From:' ( (lv_expediteur_2_0= RULE_ADDRESSEMAIL ) ) otherlv_3= 'To:' ( (lv_destinataire_4_0= RULE_ADDRESSEMAIL ) )+ (otherlv_5= 'Attachment:' ( (lv_pj_6_0= RULE_STRING ) ) )? otherlv_7= 'Body:' ( (lv_corps_8_0= ruleContenu ) ) this_RA_9= RULE_RA ) )
            // InternalMdl.g:943:2: (this_LA_0= RULE_LA otherlv_1= 'From:' ( (lv_expediteur_2_0= RULE_ADDRESSEMAIL ) ) otherlv_3= 'To:' ( (lv_destinataire_4_0= RULE_ADDRESSEMAIL ) )+ (otherlv_5= 'Attachment:' ( (lv_pj_6_0= RULE_STRING ) ) )? otherlv_7= 'Body:' ( (lv_corps_8_0= ruleContenu ) ) this_RA_9= RULE_RA )
            {
            // InternalMdl.g:943:2: (this_LA_0= RULE_LA otherlv_1= 'From:' ( (lv_expediteur_2_0= RULE_ADDRESSEMAIL ) ) otherlv_3= 'To:' ( (lv_destinataire_4_0= RULE_ADDRESSEMAIL ) )+ (otherlv_5= 'Attachment:' ( (lv_pj_6_0= RULE_STRING ) ) )? otherlv_7= 'Body:' ( (lv_corps_8_0= ruleContenu ) ) this_RA_9= RULE_RA )
            // InternalMdl.g:944:3: this_LA_0= RULE_LA otherlv_1= 'From:' ( (lv_expediteur_2_0= RULE_ADDRESSEMAIL ) ) otherlv_3= 'To:' ( (lv_destinataire_4_0= RULE_ADDRESSEMAIL ) )+ (otherlv_5= 'Attachment:' ( (lv_pj_6_0= RULE_STRING ) ) )? otherlv_7= 'Body:' ( (lv_corps_8_0= ruleContenu ) ) this_RA_9= RULE_RA
            {
            this_LA_0=(Token)match(input,RULE_LA,FOLLOW_26); 

            			newLeafNode(this_LA_0, grammarAccess.getMailAccess().getLATerminalRuleCall_0());
            		
            otherlv_1=(Token)match(input,38,FOLLOW_27); 

            			newLeafNode(otherlv_1, grammarAccess.getMailAccess().getFromKeyword_1());
            		
            // InternalMdl.g:952:3: ( (lv_expediteur_2_0= RULE_ADDRESSEMAIL ) )
            // InternalMdl.g:953:4: (lv_expediteur_2_0= RULE_ADDRESSEMAIL )
            {
            // InternalMdl.g:953:4: (lv_expediteur_2_0= RULE_ADDRESSEMAIL )
            // InternalMdl.g:954:5: lv_expediteur_2_0= RULE_ADDRESSEMAIL
            {
            lv_expediteur_2_0=(Token)match(input,RULE_ADDRESSEMAIL,FOLLOW_28); 

            					newLeafNode(lv_expediteur_2_0, grammarAccess.getMailAccess().getExpediteurADDRESSEMAILTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMailRule());
            					}
            					setWithLastConsumed(
            						current,
            						"expediteur",
            						lv_expediteur_2_0,
            						"org.xtext.mdl.Mdl.ADDRESSEMAIL");
            				

            }


            }

            otherlv_3=(Token)match(input,39,FOLLOW_27); 

            			newLeafNode(otherlv_3, grammarAccess.getMailAccess().getToKeyword_3());
            		
            // InternalMdl.g:974:3: ( (lv_destinataire_4_0= RULE_ADDRESSEMAIL ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ADDRESSEMAIL) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalMdl.g:975:4: (lv_destinataire_4_0= RULE_ADDRESSEMAIL )
            	    {
            	    // InternalMdl.g:975:4: (lv_destinataire_4_0= RULE_ADDRESSEMAIL )
            	    // InternalMdl.g:976:5: lv_destinataire_4_0= RULE_ADDRESSEMAIL
            	    {
            	    lv_destinataire_4_0=(Token)match(input,RULE_ADDRESSEMAIL,FOLLOW_29); 

            	    					newLeafNode(lv_destinataire_4_0, grammarAccess.getMailAccess().getDestinataireADDRESSEMAILTerminalRuleCall_4_0());
            	    				

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getMailRule());
            	    					}
            	    					addWithLastConsumed(
            	    						current,
            	    						"destinataire",
            	    						lv_destinataire_4_0,
            	    						"org.xtext.mdl.Mdl.ADDRESSEMAIL");
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            // InternalMdl.g:992:3: (otherlv_5= 'Attachment:' ( (lv_pj_6_0= RULE_STRING ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==40) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalMdl.g:993:4: otherlv_5= 'Attachment:' ( (lv_pj_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,40,FOLLOW_8); 

                    				newLeafNode(otherlv_5, grammarAccess.getMailAccess().getAttachmentKeyword_5_0());
                    			
                    // InternalMdl.g:997:4: ( (lv_pj_6_0= RULE_STRING ) )
                    // InternalMdl.g:998:5: (lv_pj_6_0= RULE_STRING )
                    {
                    // InternalMdl.g:998:5: (lv_pj_6_0= RULE_STRING )
                    // InternalMdl.g:999:6: lv_pj_6_0= RULE_STRING
                    {
                    lv_pj_6_0=(Token)match(input,RULE_STRING,FOLLOW_30); 

                    						newLeafNode(lv_pj_6_0, grammarAccess.getMailAccess().getPjSTRINGTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMailRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"pj",
                    							lv_pj_6_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,41,FOLLOW_8); 

            			newLeafNode(otherlv_7, grammarAccess.getMailAccess().getBodyKeyword_6());
            		
            // InternalMdl.g:1020:3: ( (lv_corps_8_0= ruleContenu ) )
            // InternalMdl.g:1021:4: (lv_corps_8_0= ruleContenu )
            {
            // InternalMdl.g:1021:4: (lv_corps_8_0= ruleContenu )
            // InternalMdl.g:1022:5: lv_corps_8_0= ruleContenu
            {

            					newCompositeNode(grammarAccess.getMailAccess().getCorpsContenuParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_12);
            lv_corps_8_0=ruleContenu();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMailRule());
            					}
            					set(
            						current,
            						"corps",
            						lv_corps_8_0,
            						"org.xtext.mdl.Mdl.Contenu");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_RA_9=(Token)match(input,RULE_RA,FOLLOW_2); 

            			newLeafNode(this_RA_9, grammarAccess.getMailAccess().getRATerminalRuleCall_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMail"


    // $ANTLR start "entryRuleContenu"
    // InternalMdl.g:1047:1: entryRuleContenu returns [EObject current=null] : iv_ruleContenu= ruleContenu EOF ;
    public final EObject entryRuleContenu() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContenu = null;


        try {
            // InternalMdl.g:1047:48: (iv_ruleContenu= ruleContenu EOF )
            // InternalMdl.g:1048:2: iv_ruleContenu= ruleContenu EOF
            {
             newCompositeNode(grammarAccess.getContenuRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContenu=ruleContenu();

            state._fsp--;

             current =iv_ruleContenu; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContenu"


    // $ANTLR start "ruleContenu"
    // InternalMdl.g:1054:1: ruleContenu returns [EObject current=null] : ( (lv_corps_0_0= RULE_STRING ) ) ;
    public final EObject ruleContenu() throws RecognitionException {
        EObject current = null;

        Token lv_corps_0_0=null;


        	enterRule();

        try {
            // InternalMdl.g:1060:2: ( ( (lv_corps_0_0= RULE_STRING ) ) )
            // InternalMdl.g:1061:2: ( (lv_corps_0_0= RULE_STRING ) )
            {
            // InternalMdl.g:1061:2: ( (lv_corps_0_0= RULE_STRING ) )
            // InternalMdl.g:1062:3: (lv_corps_0_0= RULE_STRING )
            {
            // InternalMdl.g:1062:3: (lv_corps_0_0= RULE_STRING )
            // InternalMdl.g:1063:4: lv_corps_0_0= RULE_STRING
            {
            lv_corps_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_corps_0_0, grammarAccess.getContenuAccess().getCorpsSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getContenuRule());
            				}
            				setWithLastConsumed(
            					current,
            					"corps",
            					lv_corps_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContenu"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000001F00100L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000002000000200L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000480L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000001C00000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000030000000800L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000020000000000L});

}