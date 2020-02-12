package org.xtext.mdl.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalV1Lexer extends Lexer {
    public static final int RULE_LA=4;
    public static final int RULE_RA=5;
    public static final int RULE_STRING=10;
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
    public static final int RULE_DATE=8;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=9;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=13;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int RULE_RP=7;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int RULE_LP=6;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators

    public InternalV1Lexer() {;} 
    public InternalV1Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalV1Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalV1.g"; }

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:11:7: ( 'StartDate:' )
            // InternalV1.g:11:9: 'StartDate:'
            {
            match("StartDate:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:12:7: ( 'StepNumber:' )
            // InternalV1.g:12:9: 'StepNumber:'
            {
            match("StepNumber:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:13:7: ( 'StepName:' )
            // InternalV1.g:13:9: 'StepName:'
            {
            match("StepName:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:14:7: ( 'Questions' )
            // InternalV1.g:14:9: 'Questions'
            {
            match("Questions"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:15:7: ( 'Mail' )
            // InternalV1.g:15:9: 'Mail'
            {
            match("Mail"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:16:7: ( 'Calendar' )
            // InternalV1.g:16:9: 'Calendar'
            {
            match("Calendar"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:17:7: ( 'FileDepository' )
            // InternalV1.g:17:9: 'FileDepository'
            {
            match("FileDepository"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:18:7: ( 'TimeLaps' )
            // InternalV1.g:18:9: 'TimeLaps'
            {
            match("TimeLaps"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:19:7: ( 'ParticipantsRequired:' )
            // InternalV1.g:19:9: 'ParticipantsRequired:'
            {
            match("ParticipantsRequired:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:20:7: ( 'StartingDate:' )
            // InternalV1.g:20:9: 'StartingDate:'
            {
            match("StartingDate:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:21:7: ( 'EndingDate:' )
            // InternalV1.g:21:9: 'EndingDate:'
            {
            match("EndingDate:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:22:7: ( 'Accuracy:' )
            // InternalV1.g:22:9: 'Accuracy:'
            {
            match("Accuracy:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:23:7: ( 'TitleSubmission:' )
            // InternalV1.g:23:9: 'TitleSubmission:'
            {
            match("TitleSubmission:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:24:7: ( 'SizeLimite:' )
            // InternalV1.g:24:9: 'SizeLimite:'
            {
            match("SizeLimite:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:25:7: ( 'QuestionType:' )
            // InternalV1.g:25:9: 'QuestionType:'
            {
            match("QuestionType:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:26:7: ( 'TitleQuestion:' )
            // InternalV1.g:26:9: 'TitleQuestion:'
            {
            match("TitleQuestion:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:27:7: ( 'PossibleResponse:' )
            // InternalV1.g:27:9: 'PossibleResponse:'
            {
            match("PossibleResponse:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:28:7: ( 'Reminder' )
            // InternalV1.g:28:9: 'Reminder'
            {
            match("Reminder"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:29:7: ( 'From:' )
            // InternalV1.g:29:9: 'From:'
            {
            match("From:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:30:7: ( 'To:' )
            // InternalV1.g:30:9: 'To:'
            {
            match("To:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:31:7: ( 'Body:' )
            // InternalV1.g:31:9: 'Body:'
            {
            match("Body:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:32:7: ( 'Attachment:' )
            // InternalV1.g:32:9: 'Attachment:'
            {
            match("Attachment:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:33:7: ( 'OpenQuestion' )
            // InternalV1.g:33:9: 'OpenQuestion'
            {
            match("OpenQuestion"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:34:7: ( 'CheckBox' )
            // InternalV1.g:34:9: 'CheckBox'
            {
            match("CheckBox"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:35:7: ( 'RadioButton' )
            // InternalV1.g:35:9: 'RadioButton'
            {
            match("RadioButton"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "RULE_DATE"
    public final void mRULE_DATE() throws RecognitionException {
        try {
            int _type = RULE_DATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:2890:11: ( '0' .. '2' '0' .. '9' '/' '0' .. '1' '0' .. '9' '/' ( '2' .. '9' '0' .. '9' )? '0' .. '9' '0' .. '9' )
            // InternalV1.g:2890:13: '0' .. '2' '0' .. '9' '/' '0' .. '1' '0' .. '9' '/' ( '2' .. '9' '0' .. '9' )? '0' .. '9' '0' .. '9'
            {
            matchRange('0','2'); 
            matchRange('0','9'); 
            match('/'); 
            matchRange('0','1'); 
            matchRange('0','9'); 
            match('/'); 
            // InternalV1.g:2890:57: ( '2' .. '9' '0' .. '9' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>='2' && LA1_0<='9')) ) {
                int LA1_1 = input.LA(2);

                if ( ((LA1_1>='0' && LA1_1<='9')) ) {
                    int LA1_3 = input.LA(3);

                    if ( ((LA1_3>='0' && LA1_3<='9')) ) {
                        alt1=1;
                    }
                }
            }
            switch (alt1) {
                case 1 :
                    // InternalV1.g:2890:58: '2' .. '9' '0' .. '9'
                    {
                    matchRange('2','9'); 
                    matchRange('0','9'); 

                    }
                    break;

            }

            matchRange('0','9'); 
            matchRange('0','9'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DATE"

    // $ANTLR start "RULE_ADDRESSEMAIL"
    public final void mRULE_ADDRESSEMAIL() throws RecognitionException {
        try {
            int _type = RULE_ADDRESSEMAIL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:2892:19: ( ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+ '@' ( 'a' .. 'z' | 'A' .. 'Z' )+ '.' ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            // InternalV1.g:2892:21: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+ '@' ( 'a' .. 'z' | 'A' .. 'Z' )+ '.' ( 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // InternalV1.g:2892:21: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalV1.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            match('@'); 
            // InternalV1.g:2892:55: ( 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='A' && LA3_0<='Z')||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalV1.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

            match('.'); 
            // InternalV1.g:2892:80: ( 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='A' && LA4_0<='Z')||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalV1.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ADDRESSEMAIL"

    // $ANTLR start "RULE_RP"
    public final void mRULE_RP() throws RecognitionException {
        try {
            int _type = RULE_RP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:2894:9: ( ')' )
            // InternalV1.g:2894:11: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RP"

    // $ANTLR start "RULE_LP"
    public final void mRULE_LP() throws RecognitionException {
        try {
            int _type = RULE_LP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:2896:9: ( '(' )
            // InternalV1.g:2896:11: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LP"

    // $ANTLR start "RULE_RA"
    public final void mRULE_RA() throws RecognitionException {
        try {
            int _type = RULE_RA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:2898:9: ( '}' )
            // InternalV1.g:2898:11: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RA"

    // $ANTLR start "RULE_LA"
    public final void mRULE_LA() throws RecognitionException {
        try {
            int _type = RULE_LA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:2900:9: ( '{' )
            // InternalV1.g:2900:11: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LA"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:2902:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalV1.g:2902:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalV1.g:2902:11: ( '^' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='^') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalV1.g:2902:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalV1.g:2902:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalV1.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:2904:10: ( ( '0' .. '9' )+ )
            // InternalV1.g:2904:12: ( '0' .. '9' )+
            {
            // InternalV1.g:2904:12: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalV1.g:2904:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:2906:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalV1.g:2906:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalV1.g:2906:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\"') ) {
                alt10=1;
            }
            else if ( (LA10_0=='\'') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalV1.g:2906:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalV1.g:2906:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalV1.g:2906:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalV1.g:2906:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalV1.g:2906:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalV1.g:2906:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='\\') ) {
                            alt9=1;
                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='&')||(LA9_0>='(' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalV1.g:2906:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalV1.g:2906:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:2908:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalV1.g:2908:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalV1.g:2908:24: ( options {greedy=false; } : . )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='*') ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1=='/') ) {
                        alt11=2;
                    }
                    else if ( ((LA11_1>='\u0000' && LA11_1<='.')||(LA11_1>='0' && LA11_1<='\uFFFF')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<=')')||(LA11_0>='+' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalV1.g:2908:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:2910:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalV1.g:2910:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalV1.g:2910:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalV1.g:2910:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // InternalV1.g:2910:40: ( ( '\\r' )? '\\n' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\n'||LA14_0=='\r') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalV1.g:2910:41: ( '\\r' )? '\\n'
                    {
                    // InternalV1.g:2910:41: ( '\\r' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='\r') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalV1.g:2910:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:2912:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalV1.g:2912:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalV1.g:2912:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalV1.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:2914:16: ( . )
            // InternalV1.g:2914:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalV1.g:1:8: ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | RULE_DATE | RULE_ADDRESSEMAIL | RULE_RP | RULE_LP | RULE_RA | RULE_LA | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt16=38;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // InternalV1.g:1:10: T__17
                {
                mT__17(); 

                }
                break;
            case 2 :
                // InternalV1.g:1:16: T__18
                {
                mT__18(); 

                }
                break;
            case 3 :
                // InternalV1.g:1:22: T__19
                {
                mT__19(); 

                }
                break;
            case 4 :
                // InternalV1.g:1:28: T__20
                {
                mT__20(); 

                }
                break;
            case 5 :
                // InternalV1.g:1:34: T__21
                {
                mT__21(); 

                }
                break;
            case 6 :
                // InternalV1.g:1:40: T__22
                {
                mT__22(); 

                }
                break;
            case 7 :
                // InternalV1.g:1:46: T__23
                {
                mT__23(); 

                }
                break;
            case 8 :
                // InternalV1.g:1:52: T__24
                {
                mT__24(); 

                }
                break;
            case 9 :
                // InternalV1.g:1:58: T__25
                {
                mT__25(); 

                }
                break;
            case 10 :
                // InternalV1.g:1:64: T__26
                {
                mT__26(); 

                }
                break;
            case 11 :
                // InternalV1.g:1:70: T__27
                {
                mT__27(); 

                }
                break;
            case 12 :
                // InternalV1.g:1:76: T__28
                {
                mT__28(); 

                }
                break;
            case 13 :
                // InternalV1.g:1:82: T__29
                {
                mT__29(); 

                }
                break;
            case 14 :
                // InternalV1.g:1:88: T__30
                {
                mT__30(); 

                }
                break;
            case 15 :
                // InternalV1.g:1:94: T__31
                {
                mT__31(); 

                }
                break;
            case 16 :
                // InternalV1.g:1:100: T__32
                {
                mT__32(); 

                }
                break;
            case 17 :
                // InternalV1.g:1:106: T__33
                {
                mT__33(); 

                }
                break;
            case 18 :
                // InternalV1.g:1:112: T__34
                {
                mT__34(); 

                }
                break;
            case 19 :
                // InternalV1.g:1:118: T__35
                {
                mT__35(); 

                }
                break;
            case 20 :
                // InternalV1.g:1:124: T__36
                {
                mT__36(); 

                }
                break;
            case 21 :
                // InternalV1.g:1:130: T__37
                {
                mT__37(); 

                }
                break;
            case 22 :
                // InternalV1.g:1:136: T__38
                {
                mT__38(); 

                }
                break;
            case 23 :
                // InternalV1.g:1:142: T__39
                {
                mT__39(); 

                }
                break;
            case 24 :
                // InternalV1.g:1:148: T__40
                {
                mT__40(); 

                }
                break;
            case 25 :
                // InternalV1.g:1:154: T__41
                {
                mT__41(); 

                }
                break;
            case 26 :
                // InternalV1.g:1:160: RULE_DATE
                {
                mRULE_DATE(); 

                }
                break;
            case 27 :
                // InternalV1.g:1:170: RULE_ADDRESSEMAIL
                {
                mRULE_ADDRESSEMAIL(); 

                }
                break;
            case 28 :
                // InternalV1.g:1:188: RULE_RP
                {
                mRULE_RP(); 

                }
                break;
            case 29 :
                // InternalV1.g:1:196: RULE_LP
                {
                mRULE_LP(); 

                }
                break;
            case 30 :
                // InternalV1.g:1:204: RULE_RA
                {
                mRULE_RA(); 

                }
                break;
            case 31 :
                // InternalV1.g:1:212: RULE_LA
                {
                mRULE_LA(); 

                }
                break;
            case 32 :
                // InternalV1.g:1:220: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 33 :
                // InternalV1.g:1:228: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 34 :
                // InternalV1.g:1:237: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 35 :
                // InternalV1.g:1:249: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 36 :
                // InternalV1.g:1:265: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 37 :
                // InternalV1.g:1:281: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 38 :
                // InternalV1.g:1:289: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\1\uffff\14\35\1\62\1\35\4\uffff\1\32\1\62\1\uffff\3\32\2\uffff\2\35\2\uffff\22\35\1\62\5\uffff\1\62\4\uffff\13\35\1\uffff\11\35\1\uffff\4\35\1\152\23\35\1\uffff\3\35\1\uffff\11\35\1\uffff\57\35\1\u00bd\1\u00be\1\35\1\u00c0\7\35\1\u00c8\5\35\1\uffff\1\35\1\u00cf\1\35\2\uffff\1\35\1\uffff\5\35\1\uffff\1\35\1\uffff\2\35\1\uffff\3\35\1\uffff\13\35\2\uffff\6\35\2\uffff\1\u00ee\10\35\1\uffff\1\u00f7\2\uffff\5\35\1\uffff\1\u00fd\1\35\1\uffff\2\35\1\uffff\3\35\1\uffff\3\35\1\uffff\3\35\1\uffff";
    static final String DFA16_eofS =
        "\u010a\uffff";
    static final String DFA16_minS =
        "\1\0\16\60\4\uffff\1\101\1\60\1\uffff\2\0\1\52\2\uffff\2\60\2\uffff\22\60\1\57\5\uffff\1\60\4\uffff\13\60\1\uffff\11\60\1\uffff\30\60\1\uffff\3\60\1\uffff\11\60\1\uffff\100\60\1\uffff\3\60\2\uffff\1\60\1\uffff\5\60\1\uffff\1\60\1\uffff\2\60\1\uffff\3\60\1\uffff\13\60\2\uffff\6\60\2\uffff\11\60\1\uffff\1\60\2\uffff\5\60\1\uffff\2\60\1\uffff\2\60\1\uffff\3\60\1\uffff\3\60\1\uffff\3\60\1\uffff";
    static final String DFA16_maxS =
        "\1\uffff\16\172\4\uffff\2\172\1\uffff\2\uffff\1\57\2\uffff\2\172\2\uffff\23\172\5\uffff\1\172\4\uffff\13\172\1\uffff\11\172\1\uffff\30\172\1\uffff\3\172\1\uffff\11\172\1\uffff\100\172\1\uffff\3\172\2\uffff\1\172\1\uffff\5\172\1\uffff\1\172\1\uffff\2\172\1\uffff\3\172\1\uffff\13\172\2\uffff\6\172\2\uffff\11\172\1\uffff\1\172\2\uffff\5\172\1\uffff\2\172\1\uffff\2\172\1\uffff\3\172\1\uffff\3\172\1\uffff\3\172\1\uffff";
    static final String DFA16_acceptS =
        "\17\uffff\1\34\1\35\1\36\1\37\2\uffff\1\40\3\uffff\1\45\1\46\2\uffff\1\40\1\33\23\uffff\1\41\1\34\1\35\1\36\1\37\1\uffff\1\42\1\43\1\44\1\45\13\uffff\1\24\11\uffff\1\32\30\uffff\1\5\3\uffff\1\23\11\uffff\1\25\100\uffff\1\3\3\uffff\1\6\1\30\1\uffff\1\10\5\uffff\1\14\1\uffff\1\22\2\uffff\1\1\3\uffff\1\4\13\uffff\1\2\1\16\6\uffff\1\13\1\26\11\uffff\1\31\1\uffff\1\12\1\17\5\uffff\1\27\2\uffff\1\20\2\uffff\1\7\3\uffff\1\15\3\uffff\1\21\3\uffff\1\11";
    static final String DFA16_specialS =
        "\1\1\25\uffff\1\0\1\2\u00f2\uffff}>";
    static final String[] DFA16_transitionS = {
            "\11\32\2\31\2\32\1\31\22\32\1\31\1\32\1\26\4\32\1\27\1\20\1\17\5\32\1\30\3\15\7\24\7\32\1\11\1\13\1\4\1\16\1\10\1\5\6\16\1\3\1\16\1\14\1\7\1\2\1\12\1\1\1\6\6\16\3\32\1\23\1\25\1\32\32\16\1\22\1\32\1\21\uff82\32",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\34\12\37\1\33\6\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\24\37\1\40\5\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\1\41\31\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\1\42\6\37\1\43\22\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\44\10\37\1\45\10\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\46\5\37\1\47\13\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\1\50\15\37\1\51\13\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\15\37\1\52\14\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\2\37\1\53\20\37\1\54\6\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\1\56\3\37\1\55\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\16\37\1\57\13\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\17\37\1\60\12\37",
            "\12\61\6\uffff\33\36\6\uffff\32\36",
            "\12\37\6\uffff\1\36\32\37\6\uffff\32\37",
            "",
            "",
            "",
            "",
            "\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\67\6\uffff\33\36\6\uffff\32\36",
            "",
            "\0\70",
            "\0\70",
            "\1\71\4\uffff\1\72",
            "",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\1\74\3\37\1\75\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\31\37\1\76",
            "",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\77\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\100\21\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\13\37\1\101\16\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\102\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\13\37\1\103\16\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\16\37\1\104\13\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\14\37\1\105\6\37\1\106\6\37",
            "\12\37\1\107\5\uffff\1\36\32\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\21\37\1\110\10\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\22\37\1\111\7\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\3\37\1\112\26\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\2\37\1\113\27\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\23\37\1\114\6\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\14\37\1\115\15\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\3\37\1\116\26\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\3\37\1\117\26\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\120\25\37",
            "\1\121\12\67\6\uffff\33\36\6\uffff\32\36",
            "",
            "",
            "",
            "",
            "",
            "\12\67\6\uffff\33\36\6\uffff\32\36",
            "",
            "",
            "",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\21\37\1\122\10\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\17\37\1\123\12\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\124\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\22\37\1\125\7\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\13\37\1\126\16\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\127\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\2\37\1\130\27\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\131\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\14\37\1\132\15\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\133\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\13\37\1\134\16\37",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\23\37\1\135\6\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\22\37\1\136\7\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\137\21\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\24\37\1\140\5\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\1\141\31\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\142\21\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\143\21\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\30\37\1\144\1\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\15\37\1\145\14\37",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\23\37\1\146\6\37",
            "\12\37\6\uffff\1\36\15\37\1\147\14\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\13\37\1\150\16\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\23\37\1\151\6\37",
            "\12\37\6\uffff\1\36\32\37\4\uffff\1\35\1\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\15\37\1\153\14\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\12\37\1\154\17\37",
            "\12\37\6\uffff\1\36\3\37\1\155\26\37\6\uffff\32\37",
            "\12\37\1\156\5\uffff\1\36\32\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\13\37\1\157\16\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\160\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\161\21\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\162\21\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\15\37\1\163\14\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\21\37\1\164\10\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\2\37\1\165\27\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\15\37\1\166\14\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\16\37\1\167\13\37",
            "\12\37\1\170\5\uffff\1\36\32\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\20\37\1\171\11\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\3\37\1\172\26\37\6\uffff\10\37\1\173\21\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\1\175\23\37\1\174\5\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\176\21\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\177\21\37",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\3\37\1\u0080\26\37",
            "\12\37\6\uffff\1\36\1\37\1\u0081\30\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\u0082\25\37",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\1\u0083\31\37",
            "\12\37\6\uffff\1\36\20\37\1\u0085\1\37\1\u0084\7\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\2\37\1\u0086\27\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\1\37\1\u0087\30\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\6\37\1\u0088\23\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\1\u0089\31\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\7\37\1\u008a\22\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\3\37\1\u008b\26\37",
            "\12\37\6\uffff\1\36\1\37\1\u008c\30\37\6\uffff\32\37",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\24\37\1\u008d\5\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\1\u008e\31\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\15\37\1\u008f\14\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\14\37\1\u0090\15\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\14\37\1\u0091\15\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\14\37\1\u0092\15\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\16\37\1\u0093\13\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\1\u0094\31\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\16\37\1\u0095\13\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\17\37\1\u0096\12\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\17\37\1\u0097\12\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\24\37\1\u0098\5\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\24\37\1\u0099\5\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\u009a\21\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\13\37\1\u009b\16\37",
            "\12\37\6\uffff\1\36\3\37\1\u009c\26\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\2\37\1\u009d\27\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\14\37\1\u009e\15\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\u009f\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\24\37\1\u00a0\5\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\u00a1\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\23\37\1\u00a2\6\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\6\37\1\u00a3\23\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\1\37\1\u00a4\30\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\u00a5\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\u00a6\21\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\15\37\1\u00a7\14\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\21\37\1\u00a8\10\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\27\37\1\u00a9\2\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\16\37\1\u00aa\13\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\22\37\1\u00ab\7\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\1\37\1\u00ac\30\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\u00ad\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\17\37\1\u00ae\12\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\u00af\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\1\u00b0\31\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\30\37\1\u00b1\1\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\u00b2\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\21\37\1\u00b3\10\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\23\37\1\u00b4\6\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\22\37\1\u00b5\7\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\u00b6\25\37",
            "\12\37\6\uffff\1\36\3\37\1\u00b7\26\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\u00b8\25\37",
            "\12\37\1\u00b9\5\uffff\1\36\32\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\23\37\1\u00ba\6\37",
            "\12\37\6\uffff\1\36\23\37\1\u00bc\6\37\6\uffff\22\37\1\u00bb\7\37",
            "\12\37\6\uffff\1\36\32\37\4\uffff\1\35\1\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\4\uffff\1\35\1\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\22\37\1\u00bf\7\37",
            "\12\37\6\uffff\1\36\32\37\4\uffff\1\35\1\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\14\37\1\u00c1\15\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\22\37\1\u00c2\7\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\1\u00c3\31\37",
            "\12\37\6\uffff\1\36\21\37\1\u00c4\10\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\23\37\1\u00c5\6\37",
            "\12\37\1\u00c6\5\uffff\1\36\32\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\15\37\1\u00c7\14\37",
            "\12\37\6\uffff\1\36\32\37\4\uffff\1\35\1\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\23\37\1\u00c9\6\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\23\37\1\u00ca\6\37",
            "\12\37\1\u00cb\5\uffff\1\36\32\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\1\u00cc\31\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\21\37\1\u00cd\10\37",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\u00ce\25\37",
            "\12\37\6\uffff\1\36\32\37\4\uffff\1\35\1\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\30\37\1\u00d0\1\37",
            "",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\u00d1\21\37",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\u00d2\21\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\23\37\1\u00d3\6\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\15\37\1\u00d4\14\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\u00d5\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\u00d6\25\37",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\23\37\1\u00d7\6\37",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\16\37\1\u00d8\13\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\u00d9\21\37",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\23\37\1\u00da\6\37",
            "\12\37\1\u00db\5\uffff\1\36\32\37\6\uffff\32\37",
            "\12\37\1\u00dc\5\uffff\1\36\32\37\6\uffff\32\37",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\17\37\1\u00dd\12\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\23\37\1\u00de\6\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\22\37\1\u00df\7\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\u00e0\21\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\23\37\1\u00e1\6\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\22\37\1\u00e2\7\37",
            "\12\37\1\u00e3\5\uffff\1\36\32\37\6\uffff\32\37",
            "\12\37\1\u00e4\5\uffff\1\36\32\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\15\37\1\u00e5\14\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\16\37\1\u00e6\13\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\u00e7\25\37",
            "",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\u00e8\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\16\37\1\u00e9\13\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\22\37\1\u00ea\7\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\16\37\1\u00eb\13\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\22\37\1\u00ec\7\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\17\37\1\u00ed\12\37",
            "",
            "",
            "\12\37\6\uffff\1\36\32\37\4\uffff\1\35\1\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\15\37\1\u00ef\14\37",
            "\12\37\1\u00f0\5\uffff\1\36\32\37\6\uffff\32\37",
            "\12\37\1\u00f1\5\uffff\1\36\32\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\21\37\1\u00f2\10\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\u00f3\21\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\15\37\1\u00f4\14\37",
            "\12\37\6\uffff\1\36\21\37\1\u00f5\10\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\16\37\1\u00f6\13\37",
            "",
            "\12\37\6\uffff\1\36\32\37\4\uffff\1\35\1\uffff\32\37",
            "",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\30\37\1\u00f8\1\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\16\37\1\u00f9\13\37",
            "\12\37\1\u00fa\5\uffff\1\36\32\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\u00fb\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\15\37\1\u00fc\14\37",
            "",
            "\12\37\6\uffff\1\36\32\37\4\uffff\1\35\1\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\15\37\1\u00fe\14\37",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\20\37\1\u00ff\11\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\22\37\1\u0100\7\37",
            "",
            "\12\37\1\u0101\5\uffff\1\36\32\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\24\37\1\u0102\5\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\u0103\25\37",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\10\37\1\u0104\21\37",
            "\12\37\1\u0105\5\uffff\1\36\32\37\6\uffff\32\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\21\37\1\u0106\10\37",
            "",
            "\12\37\6\uffff\1\36\32\37\6\uffff\4\37\1\u0107\25\37",
            "\12\37\6\uffff\1\36\32\37\6\uffff\3\37\1\u0108\26\37",
            "\12\37\1\u0109\5\uffff\1\36\32\37\6\uffff\32\37",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | RULE_DATE | RULE_ADDRESSEMAIL | RULE_RP | RULE_LP | RULE_RA | RULE_LA | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_22 = input.LA(1);

                        s = -1;
                        if ( ((LA16_22>='\u0000' && LA16_22<='\uFFFF')) ) {s = 56;}

                        else s = 26;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_0 = input.LA(1);

                        s = -1;
                        if ( (LA16_0=='S') ) {s = 1;}

                        else if ( (LA16_0=='Q') ) {s = 2;}

                        else if ( (LA16_0=='M') ) {s = 3;}

                        else if ( (LA16_0=='C') ) {s = 4;}

                        else if ( (LA16_0=='F') ) {s = 5;}

                        else if ( (LA16_0=='T') ) {s = 6;}

                        else if ( (LA16_0=='P') ) {s = 7;}

                        else if ( (LA16_0=='E') ) {s = 8;}

                        else if ( (LA16_0=='A') ) {s = 9;}

                        else if ( (LA16_0=='R') ) {s = 10;}

                        else if ( (LA16_0=='B') ) {s = 11;}

                        else if ( (LA16_0=='O') ) {s = 12;}

                        else if ( ((LA16_0>='0' && LA16_0<='2')) ) {s = 13;}

                        else if ( (LA16_0=='D'||(LA16_0>='G' && LA16_0<='L')||LA16_0=='N'||(LA16_0>='U' && LA16_0<='Z')||(LA16_0>='a' && LA16_0<='z')) ) {s = 14;}

                        else if ( (LA16_0==')') ) {s = 15;}

                        else if ( (LA16_0=='(') ) {s = 16;}

                        else if ( (LA16_0=='}') ) {s = 17;}

                        else if ( (LA16_0=='{') ) {s = 18;}

                        else if ( (LA16_0=='^') ) {s = 19;}

                        else if ( ((LA16_0>='3' && LA16_0<='9')) ) {s = 20;}

                        else if ( (LA16_0=='_') ) {s = 21;}

                        else if ( (LA16_0=='\"') ) {s = 22;}

                        else if ( (LA16_0=='\'') ) {s = 23;}

                        else if ( (LA16_0=='/') ) {s = 24;}

                        else if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' ') ) {s = 25;}

                        else if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\u001F')||LA16_0=='!'||(LA16_0>='#' && LA16_0<='&')||(LA16_0>='*' && LA16_0<='.')||(LA16_0>=':' && LA16_0<='@')||(LA16_0>='[' && LA16_0<=']')||LA16_0=='`'||LA16_0=='|'||(LA16_0>='~' && LA16_0<='\uFFFF')) ) {s = 26;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_23 = input.LA(1);

                        s = -1;
                        if ( ((LA16_23>='\u0000' && LA16_23<='\uFFFF')) ) {s = 56;}

                        else s = 26;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}