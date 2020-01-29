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

    public InternalV1Lexer() {;} 
    public InternalV1Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalV1Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalV1.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:11:7: ( 'From' )
            // InternalV1.g:11:9: 'From'
            {
            match("From"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:12:7: ( 'To' )
            // InternalV1.g:12:9: 'To'
            {
            match("To"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:13:7: ( 'PJ' )
            // InternalV1.g:13:9: 'PJ'
            {
            match("PJ"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:14:7: ( 'Body' )
            // InternalV1.g:14:9: 'Body'
            {
            match("Body"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:15:7: ( 'OpenQuestion' )
            // InternalV1.g:15:9: 'OpenQuestion'
            {
            match("OpenQuestion"); 


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
            // InternalV1.g:16:7: ( 'CheckBox' )
            // InternalV1.g:16:9: 'CheckBox'
            {
            match("CheckBox"); 


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
            // InternalV1.g:17:7: ( 'RadioButton' )
            // InternalV1.g:17:9: 'RadioButton'
            {
            match("RadioButton"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "RULE_DATE"
    public final void mRULE_DATE() throws RecognitionException {
        try {
            int _type = RULE_DATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:1899:11: ( '0' .. '2' '0' .. '9' '/' '0' .. '1' '0' .. '9' '/' '0' .. '9' '0' .. '9' )
            // InternalV1.g:1899:13: '0' .. '2' '0' .. '9' '/' '0' .. '1' '0' .. '9' '/' '0' .. '9' '0' .. '9'
            {
            matchRange('0','2'); 
            matchRange('0','9'); 
            match('/'); 
            matchRange('0','1'); 
            matchRange('0','9'); 
            match('/'); 
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
            // InternalV1.g:1901:19: ( ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+ '@' ( 'a' .. 'z' | 'A' .. 'Z' )+ '.' ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            // InternalV1.g:1901:21: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+ '@' ( 'a' .. 'z' | 'A' .. 'Z' )+ '.' ( 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // InternalV1.g:1901:21: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
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
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            match('@'); 
            // InternalV1.g:1901:55: ( 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='A' && LA2_0<='Z')||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
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
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            match('.'); 
            // InternalV1.g:1901:80: ( 'a' .. 'z' | 'A' .. 'Z' )+
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ADDRESSEMAIL"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalV1.g:1903:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalV1.g:1903:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalV1.g:1903:11: ( '^' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='^') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalV1.g:1903:11: '^'
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

            // InternalV1.g:1903:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
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
            	    break loop5;
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
            // InternalV1.g:1905:10: ( ( '0' .. '9' )+ )
            // InternalV1.g:1905:12: ( '0' .. '9' )+
            {
            // InternalV1.g:1905:12: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalV1.g:1905:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
            // InternalV1.g:1907:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalV1.g:1907:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalV1.g:1907:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\"') ) {
                alt9=1;
            }
            else if ( (LA9_0=='\'') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalV1.g:1907:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalV1.g:1907:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalV1.g:1907:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalV1.g:1907:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop7;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalV1.g:1907:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalV1.g:1907:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='&')||(LA8_0>='(' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalV1.g:1907:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalV1.g:1907:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop8;
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
            // InternalV1.g:1909:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalV1.g:1909:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalV1.g:1909:24: ( options {greedy=false; } : . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='*') ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1=='/') ) {
                        alt10=2;
                    }
                    else if ( ((LA10_1>='\u0000' && LA10_1<='.')||(LA10_1>='0' && LA10_1<='\uFFFF')) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0>='\u0000' && LA10_0<=')')||(LA10_0>='+' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalV1.g:1909:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop10;
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
            // InternalV1.g:1911:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalV1.g:1911:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalV1.g:1911:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalV1.g:1911:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop11;
                }
            } while (true);

            // InternalV1.g:1911:40: ( ( '\\r' )? '\\n' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\n'||LA13_0=='\r') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalV1.g:1911:41: ( '\\r' )? '\\n'
                    {
                    // InternalV1.g:1911:41: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalV1.g:1911:41: '\\r'
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
            // InternalV1.g:1913:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalV1.g:1913:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalV1.g:1913:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {
                    alt14=1;
                }


                switch (alt14) {
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
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
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
            // InternalV1.g:1915:16: ( . )
            // InternalV1.g:1915:18: .
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
        // InternalV1.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | RULE_DATE | RULE_ADDRESSEMAIL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt15=16;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // InternalV1.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalV1.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalV1.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalV1.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalV1.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalV1.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalV1.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalV1.g:1:52: RULE_DATE
                {
                mRULE_DATE(); 

                }
                break;
            case 9 :
                // InternalV1.g:1:62: RULE_ADDRESSEMAIL
                {
                mRULE_ADDRESSEMAIL(); 

                }
                break;
            case 10 :
                // InternalV1.g:1:80: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 11 :
                // InternalV1.g:1:88: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 12 :
                // InternalV1.g:1:97: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 13 :
                // InternalV1.g:1:109: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 14 :
                // InternalV1.g:1:125: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 15 :
                // InternalV1.g:1:141: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 16 :
                // InternalV1.g:1:149: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\1\uffff\7\24\1\35\1\24\1\21\1\35\1\uffff\3\21\2\uffff\2\24\2\uffff\1\44\1\45\4\24\1\35\1\uffff\1\35\4\uffff\1\24\2\uffff\4\24\1\uffff\1\60\1\61\3\24\2\uffff\12\24\1\77\2\24\1\uffff\4\24\1\106\1\107\2\uffff";
    static final String DFA15_eofS =
        "\110\uffff";
    static final String DFA15_minS =
        "\1\0\11\60\1\101\1\60\1\uffff\2\0\1\52\2\uffff\2\60\2\uffff\6\60\1\57\1\uffff\1\60\4\uffff\1\60\2\uffff\4\60\1\uffff\5\60\2\uffff\15\60\1\uffff\6\60\2\uffff";
    static final String DFA15_maxS =
        "\1\uffff\13\172\1\uffff\2\uffff\1\57\2\uffff\2\172\2\uffff\7\172\1\uffff\1\172\4\uffff\1\172\2\uffff\4\172\1\uffff\5\172\2\uffff\15\172\1\uffff\6\172\2\uffff";
    static final String DFA15_acceptS =
        "\14\uffff\1\12\3\uffff\1\17\1\20\2\uffff\1\12\1\11\7\uffff\1\13\1\uffff\1\14\1\15\1\16\1\17\1\uffff\1\2\1\3\4\uffff\1\10\5\uffff\1\1\1\4\15\uffff\1\6\6\uffff\1\7\1\5";
    static final String DFA15_specialS =
        "\1\0\14\uffff\1\2\1\1\71\uffff}>";
    static final String[] DFA15_transitionS = {
            "\11\21\2\20\2\21\1\20\22\21\1\20\1\21\1\15\4\21\1\16\7\21\1\17\3\10\7\13\7\21\1\11\1\4\1\6\2\11\1\1\10\11\1\5\1\3\1\11\1\7\1\11\1\2\6\11\3\21\1\12\1\14\1\21\32\11\uff85\21",
            "\12\23\6\uffff\1\25\32\23\6\uffff\21\23\1\22\10\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\16\23\1\26\13\23",
            "\12\23\6\uffff\1\25\11\23\1\27\20\23\6\uffff\32\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\16\23\1\30\13\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\17\23\1\31\12\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\7\23\1\32\22\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\1\33\31\23",
            "\12\34\6\uffff\33\25\6\uffff\32\25",
            "\12\23\6\uffff\1\25\32\23\6\uffff\32\23",
            "\32\24\4\uffff\1\24\1\uffff\32\24",
            "\12\36\6\uffff\33\25\6\uffff\32\25",
            "",
            "\0\37",
            "\0\37",
            "\1\40\4\uffff\1\41",
            "",
            "",
            "\12\23\6\uffff\1\25\32\23\6\uffff\16\23\1\43\13\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\32\23",
            "",
            "",
            "\12\23\6\uffff\1\25\32\23\4\uffff\1\24\1\uffff\32\23",
            "\12\23\6\uffff\1\25\32\23\4\uffff\1\24\1\uffff\32\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\3\23\1\46\26\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\4\23\1\47\25\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\4\23\1\50\25\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\3\23\1\51\26\23",
            "\1\52\12\36\6\uffff\33\25\6\uffff\32\25",
            "",
            "\12\36\6\uffff\33\25\6\uffff\32\25",
            "",
            "",
            "",
            "",
            "\12\23\6\uffff\1\25\32\23\6\uffff\14\23\1\53\15\23",
            "",
            "",
            "\12\23\6\uffff\1\25\32\23\6\uffff\30\23\1\54\1\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\15\23\1\55\14\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\2\23\1\56\27\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\10\23\1\57\21\23",
            "",
            "\12\23\6\uffff\1\25\32\23\4\uffff\1\24\1\uffff\32\23",
            "\12\23\6\uffff\1\25\32\23\4\uffff\1\24\1\uffff\32\23",
            "\12\23\6\uffff\1\25\20\23\1\62\11\23\6\uffff\32\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\12\23\1\63\17\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\16\23\1\64\13\23",
            "",
            "",
            "\12\23\6\uffff\1\25\32\23\6\uffff\24\23\1\65\5\23",
            "\12\23\6\uffff\1\25\1\23\1\66\30\23\6\uffff\32\23",
            "\12\23\6\uffff\1\25\1\23\1\67\30\23\6\uffff\32\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\4\23\1\70\25\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\16\23\1\71\13\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\24\23\1\72\5\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\22\23\1\73\7\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\27\23\1\74\2\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\23\23\1\75\6\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\23\23\1\76\6\23",
            "\12\23\6\uffff\1\25\32\23\4\uffff\1\24\1\uffff\32\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\23\23\1\100\6\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\10\23\1\101\21\23",
            "",
            "\12\23\6\uffff\1\25\32\23\6\uffff\16\23\1\102\13\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\16\23\1\103\13\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\15\23\1\104\14\23",
            "\12\23\6\uffff\1\25\32\23\6\uffff\15\23\1\105\14\23",
            "\12\23\6\uffff\1\25\32\23\4\uffff\1\24\1\uffff\32\23",
            "\12\23\6\uffff\1\25\32\23\4\uffff\1\24\1\uffff\32\23",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | RULE_DATE | RULE_ADDRESSEMAIL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_0 = input.LA(1);

                        s = -1;
                        if ( (LA15_0=='F') ) {s = 1;}

                        else if ( (LA15_0=='T') ) {s = 2;}

                        else if ( (LA15_0=='P') ) {s = 3;}

                        else if ( (LA15_0=='B') ) {s = 4;}

                        else if ( (LA15_0=='O') ) {s = 5;}

                        else if ( (LA15_0=='C') ) {s = 6;}

                        else if ( (LA15_0=='R') ) {s = 7;}

                        else if ( ((LA15_0>='0' && LA15_0<='2')) ) {s = 8;}

                        else if ( (LA15_0=='A'||(LA15_0>='D' && LA15_0<='E')||(LA15_0>='G' && LA15_0<='N')||LA15_0=='Q'||LA15_0=='S'||(LA15_0>='U' && LA15_0<='Z')||(LA15_0>='a' && LA15_0<='z')) ) {s = 9;}

                        else if ( (LA15_0=='^') ) {s = 10;}

                        else if ( ((LA15_0>='3' && LA15_0<='9')) ) {s = 11;}

                        else if ( (LA15_0=='_') ) {s = 12;}

                        else if ( (LA15_0=='\"') ) {s = 13;}

                        else if ( (LA15_0=='\'') ) {s = 14;}

                        else if ( (LA15_0=='/') ) {s = 15;}

                        else if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {s = 16;}

                        else if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='!'||(LA15_0>='#' && LA15_0<='&')||(LA15_0>='(' && LA15_0<='.')||(LA15_0>=':' && LA15_0<='@')||(LA15_0>='[' && LA15_0<=']')||LA15_0=='`'||(LA15_0>='{' && LA15_0<='\uFFFF')) ) {s = 17;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_14 = input.LA(1);

                        s = -1;
                        if ( ((LA15_14>='\u0000' && LA15_14<='\uFFFF')) ) {s = 31;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_13 = input.LA(1);

                        s = -1;
                        if ( ((LA15_13>='\u0000' && LA15_13<='\uFFFF')) ) {s = 31;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}