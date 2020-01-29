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
import org.xtext.mdl.services.V1GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalV1Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_DATE", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ADDRESSEMAIL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'OpenQuestion'", "'CheckBox'", "'RadioButton'", "'From'", "'To'", "'PJ'", "'Body'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int RULE_ADDRESSEMAIL=8;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_DATE=4;
    public static final int RULE_INT=7;
    public static final int RULE_ML_COMMENT=9;

    // delegates
    // delegators


        public InternalV1Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalV1Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalV1Parser.tokenNames; }
    public String getGrammarFileName() { return "InternalV1.g"; }



     	private V1GrammarAccess grammarAccess;

        public InternalV1Parser(TokenStream input, V1GrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Workflow";
       	}

       	@Override
       	protected V1GrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleWorkflow"
    // InternalV1.g:64:1: entryRuleWorkflow returns [EObject current=null] : iv_ruleWorkflow= ruleWorkflow EOF ;
    public final EObject entryRuleWorkflow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkflow = null;


        try {
            // InternalV1.g:64:49: (iv_ruleWorkflow= ruleWorkflow EOF )
            // InternalV1.g:65:2: iv_ruleWorkflow= ruleWorkflow EOF
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
    // InternalV1.g:71:1: ruleWorkflow returns [EObject current=null] : ( ( (lv_dateDebut_0_0= RULE_DATE ) )? ( (lv_etapes_1_0= ruleEtape ) )* ) ;
    public final EObject ruleWorkflow() throws RecognitionException {
        EObject current = null;

        Token lv_dateDebut_0_0=null;
        EObject lv_etapes_1_0 = null;



        	enterRule();

        try {
            // InternalV1.g:77:2: ( ( ( (lv_dateDebut_0_0= RULE_DATE ) )? ( (lv_etapes_1_0= ruleEtape ) )* ) )
            // InternalV1.g:78:2: ( ( (lv_dateDebut_0_0= RULE_DATE ) )? ( (lv_etapes_1_0= ruleEtape ) )* )
            {
            // InternalV1.g:78:2: ( ( (lv_dateDebut_0_0= RULE_DATE ) )? ( (lv_etapes_1_0= ruleEtape ) )* )
            // InternalV1.g:79:3: ( (lv_dateDebut_0_0= RULE_DATE ) )? ( (lv_etapes_1_0= ruleEtape ) )*
            {
            // InternalV1.g:79:3: ( (lv_dateDebut_0_0= RULE_DATE ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_DATE) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalV1.g:80:4: (lv_dateDebut_0_0= RULE_DATE )
                    {
                    // InternalV1.g:80:4: (lv_dateDebut_0_0= RULE_DATE )
                    // InternalV1.g:81:5: lv_dateDebut_0_0= RULE_DATE
                    {
                    lv_dateDebut_0_0=(Token)match(input,RULE_DATE,FOLLOW_3); 

                    					newLeafNode(lv_dateDebut_0_0, grammarAccess.getWorkflowAccess().getDateDebutDATETerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getWorkflowRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"dateDebut",
                    						lv_dateDebut_0_0,
                    						"org.xtext.mdl.V1.DATE");
                    				

                    }


                    }
                    break;

            }

            // InternalV1.g:97:3: ( (lv_etapes_1_0= ruleEtape ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalV1.g:98:4: (lv_etapes_1_0= ruleEtape )
            	    {
            	    // InternalV1.g:98:4: (lv_etapes_1_0= ruleEtape )
            	    // InternalV1.g:99:5: lv_etapes_1_0= ruleEtape
            	    {

            	    					newCompositeNode(grammarAccess.getWorkflowAccess().getEtapesEtapeParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_etapes_1_0=ruleEtape();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getWorkflowRule());
            	    					}
            	    					add(
            	    						current,
            	    						"etapes",
            	    						lv_etapes_1_0,
            	    						"org.xtext.mdl.V1.Etape");
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


    // $ANTLR start "entryRuleEtape"
    // InternalV1.g:120:1: entryRuleEtape returns [EObject current=null] : iv_ruleEtape= ruleEtape EOF ;
    public final EObject entryRuleEtape() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEtape = null;


        try {
            // InternalV1.g:120:46: (iv_ruleEtape= ruleEtape EOF )
            // InternalV1.g:121:2: iv_ruleEtape= ruleEtape EOF
            {
             newCompositeNode(grammarAccess.getEtapeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEtape=ruleEtape();

            state._fsp--;

             current =iv_ruleEtape; 
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
    // $ANTLR end "entryRuleEtape"


    // $ANTLR start "ruleEtape"
    // InternalV1.g:127:1: ruleEtape returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_STRING ) ) ( (lv_rappels_2_0= ruleRappel ) )* ( (lv_obj_3_0= ruleObjet ) ) ) ;
    public final EObject ruleEtape() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token lv_name_1_0=null;
        EObject lv_rappels_2_0 = null;

        EObject lv_obj_3_0 = null;



        	enterRule();

        try {
            // InternalV1.g:133:2: ( ( ( (lv_id_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_STRING ) ) ( (lv_rappels_2_0= ruleRappel ) )* ( (lv_obj_3_0= ruleObjet ) ) ) )
            // InternalV1.g:134:2: ( ( (lv_id_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_STRING ) ) ( (lv_rappels_2_0= ruleRappel ) )* ( (lv_obj_3_0= ruleObjet ) ) )
            {
            // InternalV1.g:134:2: ( ( (lv_id_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_STRING ) ) ( (lv_rappels_2_0= ruleRappel ) )* ( (lv_obj_3_0= ruleObjet ) ) )
            // InternalV1.g:135:3: ( (lv_id_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_STRING ) ) ( (lv_rappels_2_0= ruleRappel ) )* ( (lv_obj_3_0= ruleObjet ) )
            {
            // InternalV1.g:135:3: ( (lv_id_0_0= RULE_ID ) )
            // InternalV1.g:136:4: (lv_id_0_0= RULE_ID )
            {
            // InternalV1.g:136:4: (lv_id_0_0= RULE_ID )
            // InternalV1.g:137:5: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_id_0_0, grammarAccess.getEtapeAccess().getIdIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEtapeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"id",
            						lv_id_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalV1.g:153:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalV1.g:154:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalV1.g:154:4: (lv_name_1_0= RULE_STRING )
            // InternalV1.g:155:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEtapeAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEtapeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalV1.g:171:3: ( (lv_rappels_2_0= ruleRappel ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_DATE) ) {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2==16) ) {
                        alt3=1;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // InternalV1.g:172:4: (lv_rappels_2_0= ruleRappel )
            	    {
            	    // InternalV1.g:172:4: (lv_rappels_2_0= ruleRappel )
            	    // InternalV1.g:173:5: lv_rappels_2_0= ruleRappel
            	    {

            	    					newCompositeNode(grammarAccess.getEtapeAccess().getRappelsRappelParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_rappels_2_0=ruleRappel();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEtapeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"rappels",
            	    						lv_rappels_2_0,
            	    						"org.xtext.mdl.V1.Rappel");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalV1.g:190:3: ( (lv_obj_3_0= ruleObjet ) )
            // InternalV1.g:191:4: (lv_obj_3_0= ruleObjet )
            {
            // InternalV1.g:191:4: (lv_obj_3_0= ruleObjet )
            // InternalV1.g:192:5: lv_obj_3_0= ruleObjet
            {

            					newCompositeNode(grammarAccess.getEtapeAccess().getObjObjetParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_obj_3_0=ruleObjet();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEtapeRule());
            					}
            					set(
            						current,
            						"obj",
            						lv_obj_3_0,
            						"org.xtext.mdl.V1.Objet");
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
    // $ANTLR end "ruleEtape"


    // $ANTLR start "entryRuleObjet"
    // InternalV1.g:213:1: entryRuleObjet returns [EObject current=null] : iv_ruleObjet= ruleObjet EOF ;
    public final EObject entryRuleObjet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjet = null;


        try {
            // InternalV1.g:213:46: (iv_ruleObjet= ruleObjet EOF )
            // InternalV1.g:214:2: iv_ruleObjet= ruleObjet EOF
            {
             newCompositeNode(grammarAccess.getObjetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObjet=ruleObjet();

            state._fsp--;

             current =iv_ruleObjet; 
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
    // $ANTLR end "entryRuleObjet"


    // $ANTLR start "ruleObjet"
    // InternalV1.g:220:1: ruleObjet returns [EObject current=null] : ( ( ( (lv_obj_0_0= ruleQCM ) ) ( (lv_cond_1_0= ruleCondFin ) ) ) | ( ( (lv_mail_2_0= ruleMail ) ) ( (lv_dateEnvoi_3_0= RULE_DATE ) ) ) | ( ( (lv_synchDate_4_0= ruleSynchDate ) ) ( (lv_cond_5_0= ruleCondFin ) ) ) | ( (lv_dateFin_6_0= RULE_DATE ) ) | ( (lv_depot_7_0= ruleDepot ) ) ) ;
    public final EObject ruleObjet() throws RecognitionException {
        EObject current = null;

        Token lv_dateEnvoi_3_0=null;
        Token lv_dateFin_6_0=null;
        EObject lv_obj_0_0 = null;

        EObject lv_cond_1_0 = null;

        EObject lv_mail_2_0 = null;

        EObject lv_synchDate_4_0 = null;

        EObject lv_cond_5_0 = null;

        EObject lv_depot_7_0 = null;



        	enterRule();

        try {
            // InternalV1.g:226:2: ( ( ( ( (lv_obj_0_0= ruleQCM ) ) ( (lv_cond_1_0= ruleCondFin ) ) ) | ( ( (lv_mail_2_0= ruleMail ) ) ( (lv_dateEnvoi_3_0= RULE_DATE ) ) ) | ( ( (lv_synchDate_4_0= ruleSynchDate ) ) ( (lv_cond_5_0= ruleCondFin ) ) ) | ( (lv_dateFin_6_0= RULE_DATE ) ) | ( (lv_depot_7_0= ruleDepot ) ) ) )
            // InternalV1.g:227:2: ( ( ( (lv_obj_0_0= ruleQCM ) ) ( (lv_cond_1_0= ruleCondFin ) ) ) | ( ( (lv_mail_2_0= ruleMail ) ) ( (lv_dateEnvoi_3_0= RULE_DATE ) ) ) | ( ( (lv_synchDate_4_0= ruleSynchDate ) ) ( (lv_cond_5_0= ruleCondFin ) ) ) | ( (lv_dateFin_6_0= RULE_DATE ) ) | ( (lv_depot_7_0= ruleDepot ) ) )
            {
            // InternalV1.g:227:2: ( ( ( (lv_obj_0_0= ruleQCM ) ) ( (lv_cond_1_0= ruleCondFin ) ) ) | ( ( (lv_mail_2_0= ruleMail ) ) ( (lv_dateEnvoi_3_0= RULE_DATE ) ) ) | ( ( (lv_synchDate_4_0= ruleSynchDate ) ) ( (lv_cond_5_0= ruleCondFin ) ) ) | ( (lv_dateFin_6_0= RULE_DATE ) ) | ( (lv_depot_7_0= ruleDepot ) ) )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 13:
            case 14:
            case 15:
                {
                alt4=1;
                }
                break;
            case 16:
                {
                alt4=2;
                }
                break;
            case RULE_DATE:
                {
                int LA4_3 = input.LA(2);

                if ( (LA4_3==RULE_DATE) ) {
                    alt4=3;
                }
                else if ( (LA4_3==EOF||LA4_3==RULE_ID) ) {
                    alt4=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
                {
                alt4=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalV1.g:228:3: ( ( (lv_obj_0_0= ruleQCM ) ) ( (lv_cond_1_0= ruleCondFin ) ) )
                    {
                    // InternalV1.g:228:3: ( ( (lv_obj_0_0= ruleQCM ) ) ( (lv_cond_1_0= ruleCondFin ) ) )
                    // InternalV1.g:229:4: ( (lv_obj_0_0= ruleQCM ) ) ( (lv_cond_1_0= ruleCondFin ) )
                    {
                    // InternalV1.g:229:4: ( (lv_obj_0_0= ruleQCM ) )
                    // InternalV1.g:230:5: (lv_obj_0_0= ruleQCM )
                    {
                    // InternalV1.g:230:5: (lv_obj_0_0= ruleQCM )
                    // InternalV1.g:231:6: lv_obj_0_0= ruleQCM
                    {

                    						newCompositeNode(grammarAccess.getObjetAccess().getObjQCMParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_obj_0_0=ruleQCM();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObjetRule());
                    						}
                    						set(
                    							current,
                    							"obj",
                    							lv_obj_0_0,
                    							"org.xtext.mdl.V1.QCM");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalV1.g:248:4: ( (lv_cond_1_0= ruleCondFin ) )
                    // InternalV1.g:249:5: (lv_cond_1_0= ruleCondFin )
                    {
                    // InternalV1.g:249:5: (lv_cond_1_0= ruleCondFin )
                    // InternalV1.g:250:6: lv_cond_1_0= ruleCondFin
                    {

                    						newCompositeNode(grammarAccess.getObjetAccess().getCondCondFinParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_cond_1_0=ruleCondFin();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObjetRule());
                    						}
                    						set(
                    							current,
                    							"cond",
                    							lv_cond_1_0,
                    							"org.xtext.mdl.V1.CondFin");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalV1.g:269:3: ( ( (lv_mail_2_0= ruleMail ) ) ( (lv_dateEnvoi_3_0= RULE_DATE ) ) )
                    {
                    // InternalV1.g:269:3: ( ( (lv_mail_2_0= ruleMail ) ) ( (lv_dateEnvoi_3_0= RULE_DATE ) ) )
                    // InternalV1.g:270:4: ( (lv_mail_2_0= ruleMail ) ) ( (lv_dateEnvoi_3_0= RULE_DATE ) )
                    {
                    // InternalV1.g:270:4: ( (lv_mail_2_0= ruleMail ) )
                    // InternalV1.g:271:5: (lv_mail_2_0= ruleMail )
                    {
                    // InternalV1.g:271:5: (lv_mail_2_0= ruleMail )
                    // InternalV1.g:272:6: lv_mail_2_0= ruleMail
                    {

                    						newCompositeNode(grammarAccess.getObjetAccess().getMailMailParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_mail_2_0=ruleMail();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObjetRule());
                    						}
                    						set(
                    							current,
                    							"mail",
                    							lv_mail_2_0,
                    							"org.xtext.mdl.V1.Mail");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalV1.g:289:4: ( (lv_dateEnvoi_3_0= RULE_DATE ) )
                    // InternalV1.g:290:5: (lv_dateEnvoi_3_0= RULE_DATE )
                    {
                    // InternalV1.g:290:5: (lv_dateEnvoi_3_0= RULE_DATE )
                    // InternalV1.g:291:6: lv_dateEnvoi_3_0= RULE_DATE
                    {
                    lv_dateEnvoi_3_0=(Token)match(input,RULE_DATE,FOLLOW_2); 

                    						newLeafNode(lv_dateEnvoi_3_0, grammarAccess.getObjetAccess().getDateEnvoiDATETerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getObjetRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"dateEnvoi",
                    							lv_dateEnvoi_3_0,
                    							"org.xtext.mdl.V1.DATE");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalV1.g:309:3: ( ( (lv_synchDate_4_0= ruleSynchDate ) ) ( (lv_cond_5_0= ruleCondFin ) ) )
                    {
                    // InternalV1.g:309:3: ( ( (lv_synchDate_4_0= ruleSynchDate ) ) ( (lv_cond_5_0= ruleCondFin ) ) )
                    // InternalV1.g:310:4: ( (lv_synchDate_4_0= ruleSynchDate ) ) ( (lv_cond_5_0= ruleCondFin ) )
                    {
                    // InternalV1.g:310:4: ( (lv_synchDate_4_0= ruleSynchDate ) )
                    // InternalV1.g:311:5: (lv_synchDate_4_0= ruleSynchDate )
                    {
                    // InternalV1.g:311:5: (lv_synchDate_4_0= ruleSynchDate )
                    // InternalV1.g:312:6: lv_synchDate_4_0= ruleSynchDate
                    {

                    						newCompositeNode(grammarAccess.getObjetAccess().getSynchDateSynchDateParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_synchDate_4_0=ruleSynchDate();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObjetRule());
                    						}
                    						set(
                    							current,
                    							"synchDate",
                    							lv_synchDate_4_0,
                    							"org.xtext.mdl.V1.SynchDate");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalV1.g:329:4: ( (lv_cond_5_0= ruleCondFin ) )
                    // InternalV1.g:330:5: (lv_cond_5_0= ruleCondFin )
                    {
                    // InternalV1.g:330:5: (lv_cond_5_0= ruleCondFin )
                    // InternalV1.g:331:6: lv_cond_5_0= ruleCondFin
                    {

                    						newCompositeNode(grammarAccess.getObjetAccess().getCondCondFinParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_cond_5_0=ruleCondFin();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObjetRule());
                    						}
                    						set(
                    							current,
                    							"cond",
                    							lv_cond_5_0,
                    							"org.xtext.mdl.V1.CondFin");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalV1.g:350:3: ( (lv_dateFin_6_0= RULE_DATE ) )
                    {
                    // InternalV1.g:350:3: ( (lv_dateFin_6_0= RULE_DATE ) )
                    // InternalV1.g:351:4: (lv_dateFin_6_0= RULE_DATE )
                    {
                    // InternalV1.g:351:4: (lv_dateFin_6_0= RULE_DATE )
                    // InternalV1.g:352:5: lv_dateFin_6_0= RULE_DATE
                    {
                    lv_dateFin_6_0=(Token)match(input,RULE_DATE,FOLLOW_2); 

                    					newLeafNode(lv_dateFin_6_0, grammarAccess.getObjetAccess().getDateFinDATETerminalRuleCall_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getObjetRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"dateFin",
                    						lv_dateFin_6_0,
                    						"org.xtext.mdl.V1.DATE");
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalV1.g:369:3: ( (lv_depot_7_0= ruleDepot ) )
                    {
                    // InternalV1.g:369:3: ( (lv_depot_7_0= ruleDepot ) )
                    // InternalV1.g:370:4: (lv_depot_7_0= ruleDepot )
                    {
                    // InternalV1.g:370:4: (lv_depot_7_0= ruleDepot )
                    // InternalV1.g:371:5: lv_depot_7_0= ruleDepot
                    {

                    					newCompositeNode(grammarAccess.getObjetAccess().getDepotDepotParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_depot_7_0=ruleDepot();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getObjetRule());
                    					}
                    					set(
                    						current,
                    						"depot",
                    						lv_depot_7_0,
                    						"org.xtext.mdl.V1.Depot");
                    					afterParserOrEnumRuleCall();
                    				

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
    // $ANTLR end "ruleObjet"


    // $ANTLR start "entryRuleCondFin"
    // InternalV1.g:392:1: entryRuleCondFin returns [EObject current=null] : iv_ruleCondFin= ruleCondFin EOF ;
    public final EObject entryRuleCondFin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondFin = null;


        try {
            // InternalV1.g:392:48: (iv_ruleCondFin= ruleCondFin EOF )
            // InternalV1.g:393:2: iv_ruleCondFin= ruleCondFin EOF
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
    // InternalV1.g:399:1: ruleCondFin returns [EObject current=null] : ( (lv_date_0_0= RULE_DATE ) ) ;
    public final EObject ruleCondFin() throws RecognitionException {
        EObject current = null;

        Token lv_date_0_0=null;


        	enterRule();

        try {
            // InternalV1.g:405:2: ( ( (lv_date_0_0= RULE_DATE ) ) )
            // InternalV1.g:406:2: ( (lv_date_0_0= RULE_DATE ) )
            {
            // InternalV1.g:406:2: ( (lv_date_0_0= RULE_DATE ) )
            // InternalV1.g:407:3: (lv_date_0_0= RULE_DATE )
            {
            // InternalV1.g:407:3: (lv_date_0_0= RULE_DATE )
            // InternalV1.g:408:4: lv_date_0_0= RULE_DATE
            {
            lv_date_0_0=(Token)match(input,RULE_DATE,FOLLOW_2); 

            				newLeafNode(lv_date_0_0, grammarAccess.getCondFinAccess().getDateDATETerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getCondFinRule());
            				}
            				setWithLastConsumed(
            					current,
            					"date",
            					lv_date_0_0,
            					"org.xtext.mdl.V1.DATE");
            			

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
    // InternalV1.g:427:1: entryRuleSynchDate returns [EObject current=null] : iv_ruleSynchDate= ruleSynchDate EOF ;
    public final EObject entryRuleSynchDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynchDate = null;


        try {
            // InternalV1.g:427:50: (iv_ruleSynchDate= ruleSynchDate EOF )
            // InternalV1.g:428:2: iv_ruleSynchDate= ruleSynchDate EOF
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
    // InternalV1.g:434:1: ruleSynchDate returns [EObject current=null] : ( ( (lv_start_0_0= RULE_DATE ) ) ( (lv_end_1_0= RULE_DATE ) ) ( (lv_precision_2_0= RULE_STRING ) )? ) ;
    public final EObject ruleSynchDate() throws RecognitionException {
        EObject current = null;

        Token lv_start_0_0=null;
        Token lv_end_1_0=null;
        Token lv_precision_2_0=null;


        	enterRule();

        try {
            // InternalV1.g:440:2: ( ( ( (lv_start_0_0= RULE_DATE ) ) ( (lv_end_1_0= RULE_DATE ) ) ( (lv_precision_2_0= RULE_STRING ) )? ) )
            // InternalV1.g:441:2: ( ( (lv_start_0_0= RULE_DATE ) ) ( (lv_end_1_0= RULE_DATE ) ) ( (lv_precision_2_0= RULE_STRING ) )? )
            {
            // InternalV1.g:441:2: ( ( (lv_start_0_0= RULE_DATE ) ) ( (lv_end_1_0= RULE_DATE ) ) ( (lv_precision_2_0= RULE_STRING ) )? )
            // InternalV1.g:442:3: ( (lv_start_0_0= RULE_DATE ) ) ( (lv_end_1_0= RULE_DATE ) ) ( (lv_precision_2_0= RULE_STRING ) )?
            {
            // InternalV1.g:442:3: ( (lv_start_0_0= RULE_DATE ) )
            // InternalV1.g:443:4: (lv_start_0_0= RULE_DATE )
            {
            // InternalV1.g:443:4: (lv_start_0_0= RULE_DATE )
            // InternalV1.g:444:5: lv_start_0_0= RULE_DATE
            {
            lv_start_0_0=(Token)match(input,RULE_DATE,FOLLOW_6); 

            					newLeafNode(lv_start_0_0, grammarAccess.getSynchDateAccess().getStartDATETerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSynchDateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"start",
            						lv_start_0_0,
            						"org.xtext.mdl.V1.DATE");
            				

            }


            }

            // InternalV1.g:460:3: ( (lv_end_1_0= RULE_DATE ) )
            // InternalV1.g:461:4: (lv_end_1_0= RULE_DATE )
            {
            // InternalV1.g:461:4: (lv_end_1_0= RULE_DATE )
            // InternalV1.g:462:5: lv_end_1_0= RULE_DATE
            {
            lv_end_1_0=(Token)match(input,RULE_DATE,FOLLOW_7); 

            					newLeafNode(lv_end_1_0, grammarAccess.getSynchDateAccess().getEndDATETerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSynchDateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"end",
            						lv_end_1_0,
            						"org.xtext.mdl.V1.DATE");
            				

            }


            }

            // InternalV1.g:478:3: ( (lv_precision_2_0= RULE_STRING ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalV1.g:479:4: (lv_precision_2_0= RULE_STRING )
                    {
                    // InternalV1.g:479:4: (lv_precision_2_0= RULE_STRING )
                    // InternalV1.g:480:5: lv_precision_2_0= RULE_STRING
                    {
                    lv_precision_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    					newLeafNode(lv_precision_2_0, grammarAccess.getSynchDateAccess().getPrecisionSTRINGTerminalRuleCall_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSynchDateRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"precision",
                    						lv_precision_2_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

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
    // $ANTLR end "ruleSynchDate"


    // $ANTLR start "entryRuleDepot"
    // InternalV1.g:500:1: entryRuleDepot returns [EObject current=null] : iv_ruleDepot= ruleDepot EOF ;
    public final EObject entryRuleDepot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDepot = null;


        try {
            // InternalV1.g:500:46: (iv_ruleDepot= ruleDepot EOF )
            // InternalV1.g:501:2: iv_ruleDepot= ruleDepot EOF
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
    // InternalV1.g:507:1: ruleDepot returns [EObject current=null] : ( ( (lv_intitule_0_0= RULE_STRING ) ) ( (lv_limiteSize_1_0= RULE_INT ) ) ( (lv_format_2_0= RULE_STRING ) )* ) ;
    public final EObject ruleDepot() throws RecognitionException {
        EObject current = null;

        Token lv_intitule_0_0=null;
        Token lv_limiteSize_1_0=null;
        Token lv_format_2_0=null;


        	enterRule();

        try {
            // InternalV1.g:513:2: ( ( ( (lv_intitule_0_0= RULE_STRING ) ) ( (lv_limiteSize_1_0= RULE_INT ) ) ( (lv_format_2_0= RULE_STRING ) )* ) )
            // InternalV1.g:514:2: ( ( (lv_intitule_0_0= RULE_STRING ) ) ( (lv_limiteSize_1_0= RULE_INT ) ) ( (lv_format_2_0= RULE_STRING ) )* )
            {
            // InternalV1.g:514:2: ( ( (lv_intitule_0_0= RULE_STRING ) ) ( (lv_limiteSize_1_0= RULE_INT ) ) ( (lv_format_2_0= RULE_STRING ) )* )
            // InternalV1.g:515:3: ( (lv_intitule_0_0= RULE_STRING ) ) ( (lv_limiteSize_1_0= RULE_INT ) ) ( (lv_format_2_0= RULE_STRING ) )*
            {
            // InternalV1.g:515:3: ( (lv_intitule_0_0= RULE_STRING ) )
            // InternalV1.g:516:4: (lv_intitule_0_0= RULE_STRING )
            {
            // InternalV1.g:516:4: (lv_intitule_0_0= RULE_STRING )
            // InternalV1.g:517:5: lv_intitule_0_0= RULE_STRING
            {
            lv_intitule_0_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(lv_intitule_0_0, grammarAccess.getDepotAccess().getIntituleSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDepotRule());
            					}
            					setWithLastConsumed(
            						current,
            						"intitule",
            						lv_intitule_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalV1.g:533:3: ( (lv_limiteSize_1_0= RULE_INT ) )
            // InternalV1.g:534:4: (lv_limiteSize_1_0= RULE_INT )
            {
            // InternalV1.g:534:4: (lv_limiteSize_1_0= RULE_INT )
            // InternalV1.g:535:5: lv_limiteSize_1_0= RULE_INT
            {
            lv_limiteSize_1_0=(Token)match(input,RULE_INT,FOLLOW_7); 

            					newLeafNode(lv_limiteSize_1_0, grammarAccess.getDepotAccess().getLimiteSizeINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDepotRule());
            					}
            					setWithLastConsumed(
            						current,
            						"limiteSize",
            						lv_limiteSize_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalV1.g:551:3: ( (lv_format_2_0= RULE_STRING ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_STRING) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalV1.g:552:4: (lv_format_2_0= RULE_STRING )
            	    {
            	    // InternalV1.g:552:4: (lv_format_2_0= RULE_STRING )
            	    // InternalV1.g:553:5: lv_format_2_0= RULE_STRING
            	    {
            	    lv_format_2_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            	    					newLeafNode(lv_format_2_0, grammarAccess.getDepotAccess().getFormatSTRINGTerminalRuleCall_2_0());
            	    				

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getDepotRule());
            	    					}
            	    					addWithLastConsumed(
            	    						current,
            	    						"format",
            	    						lv_format_2_0,
            	    						"org.eclipse.xtext.common.Terminals.STRING");
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end "ruleDepot"


    // $ANTLR start "entryRuleQCM"
    // InternalV1.g:573:1: entryRuleQCM returns [EObject current=null] : iv_ruleQCM= ruleQCM EOF ;
    public final EObject entryRuleQCM() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQCM = null;


        try {
            // InternalV1.g:573:44: (iv_ruleQCM= ruleQCM EOF )
            // InternalV1.g:574:2: iv_ruleQCM= ruleQCM EOF
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
    // InternalV1.g:580:1: ruleQCM returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeQCM ) ) ( (lv_intitule_1_0= RULE_STRING ) ) ( (lv_responses_2_0= RULE_STRING ) )* ( (lv_suite_3_0= ruleQCM ) )? ) ;
    public final EObject ruleQCM() throws RecognitionException {
        EObject current = null;

        Token lv_intitule_1_0=null;
        Token lv_responses_2_0=null;
        EObject lv_type_0_0 = null;

        EObject lv_suite_3_0 = null;



        	enterRule();

        try {
            // InternalV1.g:586:2: ( ( ( (lv_type_0_0= ruleTypeQCM ) ) ( (lv_intitule_1_0= RULE_STRING ) ) ( (lv_responses_2_0= RULE_STRING ) )* ( (lv_suite_3_0= ruleQCM ) )? ) )
            // InternalV1.g:587:2: ( ( (lv_type_0_0= ruleTypeQCM ) ) ( (lv_intitule_1_0= RULE_STRING ) ) ( (lv_responses_2_0= RULE_STRING ) )* ( (lv_suite_3_0= ruleQCM ) )? )
            {
            // InternalV1.g:587:2: ( ( (lv_type_0_0= ruleTypeQCM ) ) ( (lv_intitule_1_0= RULE_STRING ) ) ( (lv_responses_2_0= RULE_STRING ) )* ( (lv_suite_3_0= ruleQCM ) )? )
            // InternalV1.g:588:3: ( (lv_type_0_0= ruleTypeQCM ) ) ( (lv_intitule_1_0= RULE_STRING ) ) ( (lv_responses_2_0= RULE_STRING ) )* ( (lv_suite_3_0= ruleQCM ) )?
            {
            // InternalV1.g:588:3: ( (lv_type_0_0= ruleTypeQCM ) )
            // InternalV1.g:589:4: (lv_type_0_0= ruleTypeQCM )
            {
            // InternalV1.g:589:4: (lv_type_0_0= ruleTypeQCM )
            // InternalV1.g:590:5: lv_type_0_0= ruleTypeQCM
            {

            					newCompositeNode(grammarAccess.getQCMAccess().getTypeTypeQCMParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
            lv_type_0_0=ruleTypeQCM();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQCMRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"org.xtext.mdl.V1.TypeQCM");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalV1.g:607:3: ( (lv_intitule_1_0= RULE_STRING ) )
            // InternalV1.g:608:4: (lv_intitule_1_0= RULE_STRING )
            {
            // InternalV1.g:608:4: (lv_intitule_1_0= RULE_STRING )
            // InternalV1.g:609:5: lv_intitule_1_0= RULE_STRING
            {
            lv_intitule_1_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

            					newLeafNode(lv_intitule_1_0, grammarAccess.getQCMAccess().getIntituleSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQCMRule());
            					}
            					setWithLastConsumed(
            						current,
            						"intitule",
            						lv_intitule_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalV1.g:625:3: ( (lv_responses_2_0= RULE_STRING ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_STRING) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalV1.g:626:4: (lv_responses_2_0= RULE_STRING )
            	    {
            	    // InternalV1.g:626:4: (lv_responses_2_0= RULE_STRING )
            	    // InternalV1.g:627:5: lv_responses_2_0= RULE_STRING
            	    {
            	    lv_responses_2_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

            	    					newLeafNode(lv_responses_2_0, grammarAccess.getQCMAccess().getResponsesSTRINGTerminalRuleCall_2_0());
            	    				

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getQCMRule());
            	    					}
            	    					addWithLastConsumed(
            	    						current,
            	    						"responses",
            	    						lv_responses_2_0,
            	    						"org.eclipse.xtext.common.Terminals.STRING");
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalV1.g:643:3: ( (lv_suite_3_0= ruleQCM ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=13 && LA8_0<=15)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalV1.g:644:4: (lv_suite_3_0= ruleQCM )
                    {
                    // InternalV1.g:644:4: (lv_suite_3_0= ruleQCM )
                    // InternalV1.g:645:5: lv_suite_3_0= ruleQCM
                    {

                    					newCompositeNode(grammarAccess.getQCMAccess().getSuiteQCMParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_suite_3_0=ruleQCM();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getQCMRule());
                    					}
                    					set(
                    						current,
                    						"suite",
                    						lv_suite_3_0,
                    						"org.xtext.mdl.V1.QCM");
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
    // InternalV1.g:666:1: entryRuleTypeQCM returns [EObject current=null] : iv_ruleTypeQCM= ruleTypeQCM EOF ;
    public final EObject entryRuleTypeQCM() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeQCM = null;


        try {
            // InternalV1.g:666:48: (iv_ruleTypeQCM= ruleTypeQCM EOF )
            // InternalV1.g:667:2: iv_ruleTypeQCM= ruleTypeQCM EOF
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
    // InternalV1.g:673:1: ruleTypeQCM returns [EObject current=null] : ( ( (lv_OPENQUESTION_0_0= 'OpenQuestion' ) ) | ( (lv_CHECKBOX_1_0= 'CheckBox' ) ) | ( (lv_RADIOBUTTON_2_0= 'RadioButton' ) ) ) ;
    public final EObject ruleTypeQCM() throws RecognitionException {
        EObject current = null;

        Token lv_OPENQUESTION_0_0=null;
        Token lv_CHECKBOX_1_0=null;
        Token lv_RADIOBUTTON_2_0=null;


        	enterRule();

        try {
            // InternalV1.g:679:2: ( ( ( (lv_OPENQUESTION_0_0= 'OpenQuestion' ) ) | ( (lv_CHECKBOX_1_0= 'CheckBox' ) ) | ( (lv_RADIOBUTTON_2_0= 'RadioButton' ) ) ) )
            // InternalV1.g:680:2: ( ( (lv_OPENQUESTION_0_0= 'OpenQuestion' ) ) | ( (lv_CHECKBOX_1_0= 'CheckBox' ) ) | ( (lv_RADIOBUTTON_2_0= 'RadioButton' ) ) )
            {
            // InternalV1.g:680:2: ( ( (lv_OPENQUESTION_0_0= 'OpenQuestion' ) ) | ( (lv_CHECKBOX_1_0= 'CheckBox' ) ) | ( (lv_RADIOBUTTON_2_0= 'RadioButton' ) ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt9=1;
                }
                break;
            case 14:
                {
                alt9=2;
                }
                break;
            case 15:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalV1.g:681:3: ( (lv_OPENQUESTION_0_0= 'OpenQuestion' ) )
                    {
                    // InternalV1.g:681:3: ( (lv_OPENQUESTION_0_0= 'OpenQuestion' ) )
                    // InternalV1.g:682:4: (lv_OPENQUESTION_0_0= 'OpenQuestion' )
                    {
                    // InternalV1.g:682:4: (lv_OPENQUESTION_0_0= 'OpenQuestion' )
                    // InternalV1.g:683:5: lv_OPENQUESTION_0_0= 'OpenQuestion'
                    {
                    lv_OPENQUESTION_0_0=(Token)match(input,13,FOLLOW_2); 

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
                    // InternalV1.g:696:3: ( (lv_CHECKBOX_1_0= 'CheckBox' ) )
                    {
                    // InternalV1.g:696:3: ( (lv_CHECKBOX_1_0= 'CheckBox' ) )
                    // InternalV1.g:697:4: (lv_CHECKBOX_1_0= 'CheckBox' )
                    {
                    // InternalV1.g:697:4: (lv_CHECKBOX_1_0= 'CheckBox' )
                    // InternalV1.g:698:5: lv_CHECKBOX_1_0= 'CheckBox'
                    {
                    lv_CHECKBOX_1_0=(Token)match(input,14,FOLLOW_2); 

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
                    // InternalV1.g:711:3: ( (lv_RADIOBUTTON_2_0= 'RadioButton' ) )
                    {
                    // InternalV1.g:711:3: ( (lv_RADIOBUTTON_2_0= 'RadioButton' ) )
                    // InternalV1.g:712:4: (lv_RADIOBUTTON_2_0= 'RadioButton' )
                    {
                    // InternalV1.g:712:4: (lv_RADIOBUTTON_2_0= 'RadioButton' )
                    // InternalV1.g:713:5: lv_RADIOBUTTON_2_0= 'RadioButton'
                    {
                    lv_RADIOBUTTON_2_0=(Token)match(input,15,FOLLOW_2); 

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


    // $ANTLR start "entryRuleRappel"
    // InternalV1.g:729:1: entryRuleRappel returns [EObject current=null] : iv_ruleRappel= ruleRappel EOF ;
    public final EObject entryRuleRappel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRappel = null;


        try {
            // InternalV1.g:729:47: (iv_ruleRappel= ruleRappel EOF )
            // InternalV1.g:730:2: iv_ruleRappel= ruleRappel EOF
            {
             newCompositeNode(grammarAccess.getRappelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRappel=ruleRappel();

            state._fsp--;

             current =iv_ruleRappel; 
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
    // $ANTLR end "entryRuleRappel"


    // $ANTLR start "ruleRappel"
    // InternalV1.g:736:1: ruleRappel returns [EObject current=null] : ( ( (lv_date_0_0= RULE_DATE ) ) ( (lv_mail_1_0= ruleMail ) ) ) ;
    public final EObject ruleRappel() throws RecognitionException {
        EObject current = null;

        Token lv_date_0_0=null;
        EObject lv_mail_1_0 = null;



        	enterRule();

        try {
            // InternalV1.g:742:2: ( ( ( (lv_date_0_0= RULE_DATE ) ) ( (lv_mail_1_0= ruleMail ) ) ) )
            // InternalV1.g:743:2: ( ( (lv_date_0_0= RULE_DATE ) ) ( (lv_mail_1_0= ruleMail ) ) )
            {
            // InternalV1.g:743:2: ( ( (lv_date_0_0= RULE_DATE ) ) ( (lv_mail_1_0= ruleMail ) ) )
            // InternalV1.g:744:3: ( (lv_date_0_0= RULE_DATE ) ) ( (lv_mail_1_0= ruleMail ) )
            {
            // InternalV1.g:744:3: ( (lv_date_0_0= RULE_DATE ) )
            // InternalV1.g:745:4: (lv_date_0_0= RULE_DATE )
            {
            // InternalV1.g:745:4: (lv_date_0_0= RULE_DATE )
            // InternalV1.g:746:5: lv_date_0_0= RULE_DATE
            {
            lv_date_0_0=(Token)match(input,RULE_DATE,FOLLOW_10); 

            					newLeafNode(lv_date_0_0, grammarAccess.getRappelAccess().getDateDATETerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRappelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"date",
            						lv_date_0_0,
            						"org.xtext.mdl.V1.DATE");
            				

            }


            }

            // InternalV1.g:762:3: ( (lv_mail_1_0= ruleMail ) )
            // InternalV1.g:763:4: (lv_mail_1_0= ruleMail )
            {
            // InternalV1.g:763:4: (lv_mail_1_0= ruleMail )
            // InternalV1.g:764:5: lv_mail_1_0= ruleMail
            {

            					newCompositeNode(grammarAccess.getRappelAccess().getMailMailParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_mail_1_0=ruleMail();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRappelRule());
            					}
            					set(
            						current,
            						"mail",
            						lv_mail_1_0,
            						"org.xtext.mdl.V1.Mail");
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
    // $ANTLR end "ruleRappel"


    // $ANTLR start "entryRuleMail"
    // InternalV1.g:785:1: entryRuleMail returns [EObject current=null] : iv_ruleMail= ruleMail EOF ;
    public final EObject entryRuleMail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMail = null;


        try {
            // InternalV1.g:785:45: (iv_ruleMail= ruleMail EOF )
            // InternalV1.g:786:2: iv_ruleMail= ruleMail EOF
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
    // InternalV1.g:792:1: ruleMail returns [EObject current=null] : (otherlv_0= 'From' ( (lv_expediteur_1_0= RULE_ADDRESSEMAIL ) ) otherlv_2= 'To' ( (lv_destinataire_3_0= RULE_ADDRESSEMAIL ) )+ otherlv_4= 'PJ' ( (lv_pj_5_0= RULE_STRING ) )? otherlv_6= 'Body' ( (lv_corps_7_0= ruleContenu ) ) ) ;
    public final EObject ruleMail() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_expediteur_1_0=null;
        Token otherlv_2=null;
        Token lv_destinataire_3_0=null;
        Token otherlv_4=null;
        Token lv_pj_5_0=null;
        Token otherlv_6=null;
        EObject lv_corps_7_0 = null;



        	enterRule();

        try {
            // InternalV1.g:798:2: ( (otherlv_0= 'From' ( (lv_expediteur_1_0= RULE_ADDRESSEMAIL ) ) otherlv_2= 'To' ( (lv_destinataire_3_0= RULE_ADDRESSEMAIL ) )+ otherlv_4= 'PJ' ( (lv_pj_5_0= RULE_STRING ) )? otherlv_6= 'Body' ( (lv_corps_7_0= ruleContenu ) ) ) )
            // InternalV1.g:799:2: (otherlv_0= 'From' ( (lv_expediteur_1_0= RULE_ADDRESSEMAIL ) ) otherlv_2= 'To' ( (lv_destinataire_3_0= RULE_ADDRESSEMAIL ) )+ otherlv_4= 'PJ' ( (lv_pj_5_0= RULE_STRING ) )? otherlv_6= 'Body' ( (lv_corps_7_0= ruleContenu ) ) )
            {
            // InternalV1.g:799:2: (otherlv_0= 'From' ( (lv_expediteur_1_0= RULE_ADDRESSEMAIL ) ) otherlv_2= 'To' ( (lv_destinataire_3_0= RULE_ADDRESSEMAIL ) )+ otherlv_4= 'PJ' ( (lv_pj_5_0= RULE_STRING ) )? otherlv_6= 'Body' ( (lv_corps_7_0= ruleContenu ) ) )
            // InternalV1.g:800:3: otherlv_0= 'From' ( (lv_expediteur_1_0= RULE_ADDRESSEMAIL ) ) otherlv_2= 'To' ( (lv_destinataire_3_0= RULE_ADDRESSEMAIL ) )+ otherlv_4= 'PJ' ( (lv_pj_5_0= RULE_STRING ) )? otherlv_6= 'Body' ( (lv_corps_7_0= ruleContenu ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getMailAccess().getFromKeyword_0());
            		
            // InternalV1.g:804:3: ( (lv_expediteur_1_0= RULE_ADDRESSEMAIL ) )
            // InternalV1.g:805:4: (lv_expediteur_1_0= RULE_ADDRESSEMAIL )
            {
            // InternalV1.g:805:4: (lv_expediteur_1_0= RULE_ADDRESSEMAIL )
            // InternalV1.g:806:5: lv_expediteur_1_0= RULE_ADDRESSEMAIL
            {
            lv_expediteur_1_0=(Token)match(input,RULE_ADDRESSEMAIL,FOLLOW_12); 

            					newLeafNode(lv_expediteur_1_0, grammarAccess.getMailAccess().getExpediteurADDRESSEMAILTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMailRule());
            					}
            					setWithLastConsumed(
            						current,
            						"expediteur",
            						lv_expediteur_1_0,
            						"org.xtext.mdl.V1.ADDRESSEMAIL");
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getMailAccess().getToKeyword_2());
            		
            // InternalV1.g:826:3: ( (lv_destinataire_3_0= RULE_ADDRESSEMAIL ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ADDRESSEMAIL) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalV1.g:827:4: (lv_destinataire_3_0= RULE_ADDRESSEMAIL )
            	    {
            	    // InternalV1.g:827:4: (lv_destinataire_3_0= RULE_ADDRESSEMAIL )
            	    // InternalV1.g:828:5: lv_destinataire_3_0= RULE_ADDRESSEMAIL
            	    {
            	    lv_destinataire_3_0=(Token)match(input,RULE_ADDRESSEMAIL,FOLLOW_13); 

            	    					newLeafNode(lv_destinataire_3_0, grammarAccess.getMailAccess().getDestinataireADDRESSEMAILTerminalRuleCall_3_0());
            	    				

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getMailRule());
            	    					}
            	    					addWithLastConsumed(
            	    						current,
            	    						"destinataire",
            	    						lv_destinataire_3_0,
            	    						"org.xtext.mdl.V1.ADDRESSEMAIL");
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            otherlv_4=(Token)match(input,18,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getMailAccess().getPJKeyword_4());
            		
            // InternalV1.g:848:3: ( (lv_pj_5_0= RULE_STRING ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_STRING) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalV1.g:849:4: (lv_pj_5_0= RULE_STRING )
                    {
                    // InternalV1.g:849:4: (lv_pj_5_0= RULE_STRING )
                    // InternalV1.g:850:5: lv_pj_5_0= RULE_STRING
                    {
                    lv_pj_5_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

                    					newLeafNode(lv_pj_5_0, grammarAccess.getMailAccess().getPjSTRINGTerminalRuleCall_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMailRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"pj",
                    						lv_pj_5_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,19,FOLLOW_4); 

            			newLeafNode(otherlv_6, grammarAccess.getMailAccess().getBodyKeyword_6());
            		
            // InternalV1.g:870:3: ( (lv_corps_7_0= ruleContenu ) )
            // InternalV1.g:871:4: (lv_corps_7_0= ruleContenu )
            {
            // InternalV1.g:871:4: (lv_corps_7_0= ruleContenu )
            // InternalV1.g:872:5: lv_corps_7_0= ruleContenu
            {

            					newCompositeNode(grammarAccess.getMailAccess().getCorpsContenuParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_2);
            lv_corps_7_0=ruleContenu();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMailRule());
            					}
            					set(
            						current,
            						"corps",
            						lv_corps_7_0,
            						"org.xtext.mdl.V1.Contenu");
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
    // $ANTLR end "ruleMail"


    // $ANTLR start "entryRuleContenu"
    // InternalV1.g:893:1: entryRuleContenu returns [EObject current=null] : iv_ruleContenu= ruleContenu EOF ;
    public final EObject entryRuleContenu() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContenu = null;


        try {
            // InternalV1.g:893:48: (iv_ruleContenu= ruleContenu EOF )
            // InternalV1.g:894:2: iv_ruleContenu= ruleContenu EOF
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
    // InternalV1.g:900:1: ruleContenu returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => ( (lv_corps_1_0= RULE_STRING ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_invitation_2_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleContenu() throws RecognitionException {
        EObject current = null;

        Token lv_corps_1_0=null;
        Token lv_invitation_2_0=null;


        	enterRule();

        try {
            // InternalV1.g:906:2: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_corps_1_0= RULE_STRING ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_invitation_2_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) ) )
            // InternalV1.g:907:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_corps_1_0= RULE_STRING ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_invitation_2_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) )
            {
            // InternalV1.g:907:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_corps_1_0= RULE_STRING ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_invitation_2_0= RULE_STRING ) ) ) ) ) )+ {...}?) ) )
            // InternalV1.g:908:3: ( ( ( ({...}? => ( ({...}? => ( (lv_corps_1_0= RULE_STRING ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_invitation_2_0= RULE_STRING ) ) ) ) ) )+ {...}?) )
            {
            // InternalV1.g:908:3: ( ( ( ({...}? => ( ({...}? => ( (lv_corps_1_0= RULE_STRING ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_invitation_2_0= RULE_STRING ) ) ) ) ) )+ {...}?) )
            // InternalV1.g:909:4: ( ( ({...}? => ( ({...}? => ( (lv_corps_1_0= RULE_STRING ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_invitation_2_0= RULE_STRING ) ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getContenuAccess().getUnorderedGroup());
            			
            // InternalV1.g:912:4: ( ( ({...}? => ( ({...}? => ( (lv_corps_1_0= RULE_STRING ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_invitation_2_0= RULE_STRING ) ) ) ) ) )+ {...}?)
            // InternalV1.g:913:5: ( ({...}? => ( ({...}? => ( (lv_corps_1_0= RULE_STRING ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_invitation_2_0= RULE_STRING ) ) ) ) ) )+ {...}?
            {
            // InternalV1.g:913:5: ( ({...}? => ( ({...}? => ( (lv_corps_1_0= RULE_STRING ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_invitation_2_0= RULE_STRING ) ) ) ) ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_STRING) ) {
                    int LA12_2 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getContenuAccess().getUnorderedGroup(), 0) ) {
                        alt12=1;
                    }
                    else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getContenuAccess().getUnorderedGroup(), 1) ) {
                        alt12=2;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // InternalV1.g:914:3: ({...}? => ( ({...}? => ( (lv_corps_1_0= RULE_STRING ) ) ) ) )
            	    {
            	    // InternalV1.g:914:3: ({...}? => ( ({...}? => ( (lv_corps_1_0= RULE_STRING ) ) ) ) )
            	    // InternalV1.g:915:4: {...}? => ( ({...}? => ( (lv_corps_1_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContenuAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleContenu", "getUnorderedGroupHelper().canSelect(grammarAccess.getContenuAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalV1.g:915:101: ( ({...}? => ( (lv_corps_1_0= RULE_STRING ) ) ) )
            	    // InternalV1.g:916:5: ({...}? => ( (lv_corps_1_0= RULE_STRING ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getContenuAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalV1.g:919:8: ({...}? => ( (lv_corps_1_0= RULE_STRING ) ) )
            	    // InternalV1.g:919:9: {...}? => ( (lv_corps_1_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContenu", "true");
            	    }
            	    // InternalV1.g:919:18: ( (lv_corps_1_0= RULE_STRING ) )
            	    // InternalV1.g:919:19: (lv_corps_1_0= RULE_STRING )
            	    {
            	    // InternalV1.g:919:19: (lv_corps_1_0= RULE_STRING )
            	    // InternalV1.g:920:9: lv_corps_1_0= RULE_STRING
            	    {
            	    lv_corps_1_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            	    									newLeafNode(lv_corps_1_0, grammarAccess.getContenuAccess().getCorpsSTRINGTerminalRuleCall_0_0());
            	    								

            	    									if (current==null) {
            	    										current = createModelElement(grammarAccess.getContenuRule());
            	    									}
            	    									setWithLastConsumed(
            	    										current,
            	    										"corps",
            	    										lv_corps_1_0,
            	    										"org.eclipse.xtext.common.Terminals.STRING");
            	    								

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContenuAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalV1.g:941:3: ({...}? => ( ({...}? => ( (lv_invitation_2_0= RULE_STRING ) ) ) ) )
            	    {
            	    // InternalV1.g:941:3: ({...}? => ( ({...}? => ( (lv_invitation_2_0= RULE_STRING ) ) ) ) )
            	    // InternalV1.g:942:4: {...}? => ( ({...}? => ( (lv_invitation_2_0= RULE_STRING ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getContenuAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleContenu", "getUnorderedGroupHelper().canSelect(grammarAccess.getContenuAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalV1.g:942:101: ( ({...}? => ( (lv_invitation_2_0= RULE_STRING ) ) ) )
            	    // InternalV1.g:943:5: ({...}? => ( (lv_invitation_2_0= RULE_STRING ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getContenuAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalV1.g:946:8: ({...}? => ( (lv_invitation_2_0= RULE_STRING ) ) )
            	    // InternalV1.g:946:9: {...}? => ( (lv_invitation_2_0= RULE_STRING ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleContenu", "true");
            	    }
            	    // InternalV1.g:946:18: ( (lv_invitation_2_0= RULE_STRING ) )
            	    // InternalV1.g:946:19: (lv_invitation_2_0= RULE_STRING )
            	    {
            	    // InternalV1.g:946:19: (lv_invitation_2_0= RULE_STRING )
            	    // InternalV1.g:947:9: lv_invitation_2_0= RULE_STRING
            	    {
            	    lv_invitation_2_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            	    									newLeafNode(lv_invitation_2_0, grammarAccess.getContenuAccess().getInvitationSTRINGTerminalRuleCall_1_0());
            	    								

            	    									if (current==null) {
            	    										current = createModelElement(grammarAccess.getContenuRule());
            	    									}
            	    									setWithLastConsumed(
            	    										current,
            	    										"invitation",
            	    										lv_invitation_2_0,
            	    										"org.eclipse.xtext.common.Terminals.STRING");
            	    								

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getContenuAccess().getUnorderedGroup());
            	    				

            	    }


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

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getContenuAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleContenu", "getUnorderedGroupHelper().canLeave(grammarAccess.getContenuAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getContenuAccess().getUnorderedGroup());
            			

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000001E050L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000000000000E042L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080000L});

}
