// Generated from C:\Antlr\AsteroidsParser.g4 by ANTLR 4.0
 package asteroids.model.programs.parsing; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AsteroidsParserParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SELF=1, TRUE=2, FALSE=3, NULL=4, BOOL=5, DOUBLE=6, ENTITY=7, VOID=8, SHIP=9, 
		ASTEROID=10, BULLET=11, ANY=12, GETRADIUS=13, GETX=14, GETY=15, GETVX=16, 
		GETVY=17, GETDIR=18, SQRT=19, SIN=20, COS=21, NOT=22, THRUSTON=23, THRUSTOFF=24, 
		TURN=25, FIRE=26, SKIP=27, PRINT=28, IF=29, THEN=30, ELSE=31, WHILE=32, 
		DO=33, FOREACH=34, ASSIGN=35, MUL=36, DIV=37, ADD=38, SUB=39, EQ=40, NEQ=41, 
		LT=42, GT=43, LEQ=44, GEQ=45, AND=46, OR=47, NUMBER=48, FLOAT=49, INTEGER=50, 
		IDENTIFIER=51, LEFT_PAREN=52, RIGHT_PAREN=53, LEFT_BRACE=54, RIGHT_BRACE=55, 
		SEMICOLON=56, COMMA=57, WHITESPACE=58, SINGLE_COMMENT=59;
	public static final String[] tokenNames = {
		"<INVALID>", "'self'", "'true'", "'false'", "'null'", "'bool'", "'double'", 
		"'entity'", "'void'", "'ship'", "'asteroid'", "'bullet'", "'any'", "'getradius'", 
		"'getx'", "'gety'", "'getvx'", "'getvy'", "'getdir'", "'sqrt'", "'sin'", 
		"'cos'", "'!'", "'thrust'", "'thrust_off'", "'turn'", "'fire'", "'skip'", 
		"'print'", "'if'", "'then'", "'else'", "'while'", "'do'", "'foreach'", 
		"':='", "'*'", "'/'", "'+'", "'-'", "'=='", "'!='", "'<'", "'>'", "'<='", 
		"'>='", "'&&'", "'||'", "NUMBER", "FLOAT", "INTEGER", "IDENTIFIER", "'('", 
		"')'", "'{'", "'}'", "';'", "','", "WHITESPACE", "SINGLE_COMMENT"
	};
	public static final int
		RULE_eval = 0, RULE_decl = 1, RULE_action = 2, RULE_unop = 3, RULE_ctrl = 4, 
		RULE_ifthenelse = 5, RULE_whiledo = 6, RULE_foreach = 7, RULE_assign = 8, 
		RULE_functioncall = 9, RULE_function = 10, RULE_expr = 11, RULE_namedconst = 12, 
		RULE_type = 13, RULE_entityspec = 14, RULE_binop = 15;
	public static final String[] ruleNames = {
		"eval", "decl", "action", "unop", "ctrl", "ifthenelse", "whiledo", "foreach", 
		"assign", "functioncall", "function", "expr", "namedconst", "type", "entityspec", 
		"binop"
	};

	@Override
	public String getGrammarFileName() { return "AsteroidsParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }




	public AsteroidsParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EvalContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(AsteroidsParserParser.SEMICOLON, 0); }
		public EvalContext eval() {
			return getRuleContext(EvalContext.class,0);
		}
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRINT() { return getToken(AsteroidsParserParser.PRINT, 0); }
		public CtrlContext ctrl() {
			return getRuleContext(CtrlContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public EvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).enterEval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).exitEval(this);
		}
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_eval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << DOUBLE) | (1L << ENTITY) | (1L << VOID) | (1L << THRUSTON) | (1L << THRUSTOFF) | (1L << TURN) | (1L << FIRE) | (1L << SKIP) | (1L << PRINT) | (1L << IF) | (1L << WHILE) | (1L << FOREACH) | (1L << IDENTIFIER) | (1L << SEMICOLON))) != 0)) {
				{
				setState(47);
				switch (_input.LA(1)) {
				case BOOL:
				case DOUBLE:
				case ENTITY:
				case VOID:
					{
					setState(32); decl();
					setState(33); match(SEMICOLON);
					}
					break;
				case THRUSTON:
				case THRUSTOFF:
				case TURN:
				case FIRE:
				case SKIP:
					{
					setState(35); action();
					setState(36); match(SEMICOLON);
					}
					break;
				case IDENTIFIER:
					{
					setState(38); assign();
					setState(39); match(SEMICOLON);
					}
					break;
				case PRINT:
					{
					setState(41); match(PRINT);
					setState(42); expr(0);
					setState(43); match(SEMICOLON);
					}
					break;
				case IF:
				case WHILE:
				case FOREACH:
					{
					setState(45); ctrl();
					}
					break;
				case SEMICOLON:
					{
					setState(46); match(SEMICOLON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(50);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(49); eval();
					}
					break;
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(AsteroidsParserParser.IDENTIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(AsteroidsParserParser.ASSIGN, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54); type();
			setState(55); match(IDENTIFIER);
			setState(58);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(56); match(ASSIGN);
				setState(57); expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionContext extends ParserRuleContext {
		public TerminalNode FIRE() { return getToken(AsteroidsParserParser.FIRE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode TURN() { return getToken(AsteroidsParserParser.TURN, 0); }
		public TerminalNode THRUSTOFF() { return getToken(AsteroidsParserParser.THRUSTOFF, 0); }
		public TerminalNode THRUSTON() { return getToken(AsteroidsParserParser.THRUSTON, 0); }
		public TerminalNode SKIP() { return getToken(AsteroidsParserParser.SKIP, 0); }
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).exitAction(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_action);
		try {
			setState(66);
			switch (_input.LA(1)) {
			case THRUSTON:
				enterOuterAlt(_localctx, 1);
				{
				setState(60); match(THRUSTON);
				}
				break;
			case THRUSTOFF:
				enterOuterAlt(_localctx, 2);
				{
				setState(61); match(THRUSTOFF);
				}
				break;
			case TURN:
				enterOuterAlt(_localctx, 3);
				{
				setState(62); match(TURN);
				setState(63); expr(0);
				}
				break;
			case FIRE:
				enterOuterAlt(_localctx, 4);
				{
				setState(64); match(FIRE);
				}
				break;
			case SKIP:
				enterOuterAlt(_localctx, 5);
				{
				setState(65); match(SKIP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnopContext extends ParserRuleContext {
		public TerminalNode GETVY() { return getToken(AsteroidsParserParser.GETVY, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(AsteroidsParserParser.LEFT_PAREN, 0); }
		public TerminalNode GETVX() { return getToken(AsteroidsParserParser.GETVX, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(AsteroidsParserParser.RIGHT_PAREN, 0); }
		public TerminalNode NOT() { return getToken(AsteroidsParserParser.NOT, 0); }
		public TerminalNode SIN() { return getToken(AsteroidsParserParser.SIN, 0); }
		public TerminalNode SQRT() { return getToken(AsteroidsParserParser.SQRT, 0); }
		public TerminalNode GETRADIUS() { return getToken(AsteroidsParserParser.GETRADIUS, 0); }
		public TerminalNode GETY() { return getToken(AsteroidsParserParser.GETY, 0); }
		public TerminalNode GETX() { return getToken(AsteroidsParserParser.GETX, 0); }
		public TerminalNode COS() { return getToken(AsteroidsParserParser.COS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).enterUnop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).exitUnop(this);
		}
	}

	public final UnopContext unop() throws RecognitionException {
		UnopContext _localctx = new UnopContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_unop);
		try {
			setState(95);
			switch (_input.LA(1)) {
			case GETRADIUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(68); match(GETRADIUS);
				setState(69); expr(0);
				}
				break;
			case GETX:
				enterOuterAlt(_localctx, 2);
				{
				setState(70); match(GETX);
				setState(71); expr(0);
				}
				break;
			case GETY:
				enterOuterAlt(_localctx, 3);
				{
				setState(72); match(GETY);
				setState(73); expr(0);
				}
				break;
			case GETVX:
				enterOuterAlt(_localctx, 4);
				{
				setState(74); match(GETVX);
				setState(75); expr(0);
				}
				break;
			case GETVY:
				enterOuterAlt(_localctx, 5);
				{
				setState(76); match(GETVY);
				setState(77); expr(0);
				}
				break;
			case SQRT:
				enterOuterAlt(_localctx, 6);
				{
				setState(78); match(SQRT);
				setState(79); match(LEFT_PAREN);
				setState(80); expr(0);
				setState(81); match(RIGHT_PAREN);
				}
				break;
			case SIN:
				enterOuterAlt(_localctx, 7);
				{
				setState(83); match(SIN);
				setState(84); match(LEFT_PAREN);
				setState(85); expr(0);
				setState(86); match(RIGHT_PAREN);
				}
				break;
			case COS:
				enterOuterAlt(_localctx, 8);
				{
				setState(88); match(COS);
				setState(89); match(LEFT_PAREN);
				setState(90); expr(0);
				setState(91); match(RIGHT_PAREN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 9);
				{
				setState(93); match(NOT);
				setState(94); expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CtrlContext extends ParserRuleContext {
		public ForeachContext foreach() {
			return getRuleContext(ForeachContext.class,0);
		}
		public WhiledoContext whiledo() {
			return getRuleContext(WhiledoContext.class,0);
		}
		public IfthenelseContext ifthenelse() {
			return getRuleContext(IfthenelseContext.class,0);
		}
		public CtrlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctrl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).enterCtrl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).exitCtrl(this);
		}
	}

	public final CtrlContext ctrl() throws RecognitionException {
		CtrlContext _localctx = new CtrlContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ctrl);
		try {
			setState(100);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(97); ifthenelse();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(98); whiledo();
				}
				break;
			case FOREACH:
				enterOuterAlt(_localctx, 3);
				{
				setState(99); foreach();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfthenelseContext extends ParserRuleContext {
		public List<TerminalNode> RIGHT_BRACE() { return getTokens(AsteroidsParserParser.RIGHT_BRACE); }
		public EvalContext eval(int i) {
			return getRuleContext(EvalContext.class,i);
		}
		public TerminalNode THEN() { return getToken(AsteroidsParserParser.THEN, 0); }
		public List<EvalContext> eval() {
			return getRuleContexts(EvalContext.class);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> LEFT_BRACE() { return getTokens(AsteroidsParserParser.LEFT_BRACE); }
		public TerminalNode RIGHT_BRACE(int i) {
			return getToken(AsteroidsParserParser.RIGHT_BRACE, i);
		}
		public TerminalNode ELSE() { return getToken(AsteroidsParserParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(AsteroidsParserParser.IF, 0); }
		public TerminalNode LEFT_BRACE(int i) {
			return getToken(AsteroidsParserParser.LEFT_BRACE, i);
		}
		public IfthenelseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifthenelse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).enterIfthenelse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).exitIfthenelse(this);
		}
	}

	public final IfthenelseContext ifthenelse() throws RecognitionException {
		IfthenelseContext _localctx = new IfthenelseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifthenelse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102); match(IF);
			setState(103); expr(0);
			setState(105);
			_la = _input.LA(1);
			if (_la==THEN) {
				{
				setState(104); match(THEN);
				}
			}

			setState(107); match(LEFT_BRACE);
			setState(108); eval();
			setState(109); match(RIGHT_BRACE);
			setState(115);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(110); match(ELSE);
				setState(111); match(LEFT_BRACE);
				setState(112); eval();
				setState(113); match(RIGHT_BRACE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhiledoContext extends ParserRuleContext {
		public TerminalNode RIGHT_BRACE() { return getToken(AsteroidsParserParser.RIGHT_BRACE, 0); }
		public TerminalNode DO() { return getToken(AsteroidsParserParser.DO, 0); }
		public EvalContext eval() {
			return getRuleContext(EvalContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(AsteroidsParserParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(AsteroidsParserParser.LEFT_BRACE, 0); }
		public WhiledoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whiledo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).enterWhiledo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).exitWhiledo(this);
		}
	}

	public final WhiledoContext whiledo() throws RecognitionException {
		WhiledoContext _localctx = new WhiledoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_whiledo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); match(WHILE);
			setState(118); expr(0);
			setState(120);
			_la = _input.LA(1);
			if (_la==DO) {
				{
				setState(119); match(DO);
				}
			}

			setState(122); match(LEFT_BRACE);
			setState(123); eval();
			setState(124); match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForeachContext extends ParserRuleContext {
		public TerminalNode RIGHT_BRACE() { return getToken(AsteroidsParserParser.RIGHT_BRACE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(AsteroidsParserParser.LEFT_PAREN, 0); }
		public TerminalNode DO() { return getToken(AsteroidsParserParser.DO, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(AsteroidsParserParser.RIGHT_PAREN, 0); }
		public TerminalNode FOREACH() { return getToken(AsteroidsParserParser.FOREACH, 0); }
		public EvalContext eval() {
			return getRuleContext(EvalContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(AsteroidsParserParser.COMMA, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(AsteroidsParserParser.LEFT_BRACE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(AsteroidsParserParser.IDENTIFIER, 0); }
		public EntityspecContext entityspec() {
			return getRuleContext(EntityspecContext.class,0);
		}
		public ForeachContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreach; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).enterForeach(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).exitForeach(this);
		}
	}

	public final ForeachContext foreach() throws RecognitionException {
		ForeachContext _localctx = new ForeachContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_foreach);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); match(FOREACH);
			setState(127); match(LEFT_PAREN);
			setState(128); entityspec();
			setState(129); match(COMMA);
			setState(130); match(IDENTIFIER);
			setState(131); match(RIGHT_PAREN);
			setState(133);
			_la = _input.LA(1);
			if (_la==DO) {
				{
				setState(132); match(DO);
				}
			}

			setState(135); match(LEFT_BRACE);
			setState(136); eval();
			setState(137); match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(AsteroidsParserParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(AsteroidsParserParser.ASSIGN, 0); }
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); match(IDENTIFIER);
			setState(140); match(ASSIGN);
			setState(141); expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctioncallContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(AsteroidsParserParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(AsteroidsParserParser.RIGHT_PAREN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(AsteroidsParserParser.COMMA, i);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AsteroidsParserParser.COMMA); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode IDENTIFIER() { return getToken(AsteroidsParserParser.IDENTIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctioncallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functioncall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).enterFunctioncall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).exitFunctioncall(this);
		}
	}

	public final FunctioncallContext functioncall() throws RecognitionException {
		FunctioncallContext _localctx = new FunctioncallContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functioncall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143); type();
			setState(144); match(IDENTIFIER);
			setState(145); match(LEFT_PAREN);
			setState(154);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELF) | (1L << TRUE) | (1L << FALSE) | (1L << NULL) | (1L << GETRADIUS) | (1L << GETX) | (1L << GETY) | (1L << GETVX) | (1L << GETVY) | (1L << GETDIR) | (1L << SQRT) | (1L << SIN) | (1L << COS) | (1L << NOT) | (1L << NUMBER) | (1L << IDENTIFIER) | (1L << LEFT_PAREN))) != 0)) {
				{
				setState(146); expr(0);
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(147); match(COMMA);
					setState(148); expr(0);
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(156); match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode RIGHT_BRACE() { return getToken(AsteroidsParserParser.RIGHT_BRACE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(AsteroidsParserParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(AsteroidsParserParser.RIGHT_PAREN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(AsteroidsParserParser.COMMA, i);
		}
		public EvalContext eval() {
			return getRuleContext(EvalContext.class,0);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AsteroidsParserParser.COMMA); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode LEFT_BRACE() { return getToken(AsteroidsParserParser.LEFT_BRACE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(AsteroidsParserParser.IDENTIFIER, 0); }
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158); type();
			setState(159); match(IDENTIFIER);
			setState(160); match(LEFT_PAREN);
			setState(172);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << DOUBLE) | (1L << ENTITY) | (1L << VOID))) != 0)) {
				{
				setState(161); type();
				setState(162); expr(0);
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(163); match(COMMA);
					setState(164); type();
					setState(165); expr(0);
					}
					}
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(174); match(RIGHT_PAREN);
			setState(175); match(LEFT_BRACE);
			setState(176); eval();
			setState(177); match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public int _p;
		public TerminalNode LEFT_PAREN() { return getToken(AsteroidsParserParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(AsteroidsParserParser.RIGHT_PAREN, 0); }
		public UnopContext unop() {
			return getRuleContext(UnopContext.class,0);
		}
		public TerminalNode GETDIR() { return getToken(AsteroidsParserParser.GETDIR, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public NamedconstContext namedconst() {
			return getRuleContext(NamedconstContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode IDENTIFIER() { return getToken(AsteroidsParserParser.IDENTIFIER, 0); }
		public BinopContext binop() {
			return getRuleContext(BinopContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(AsteroidsParserParser.NUMBER, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState, _p);
		ExprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, RULE_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(180); match(NUMBER);
				}
				break;
			case IDENTIFIER:
				{
				setState(181); match(IDENTIFIER);
				}
				break;
			case GETDIR:
				{
				setState(182); match(GETDIR);
				}
				break;
			case LEFT_PAREN:
				{
				setState(183); match(LEFT_PAREN);
				setState(184); expr(0);
				setState(185); match(RIGHT_PAREN);
				}
				break;
			case SELF:
			case TRUE:
			case FALSE:
			case NULL:
				{
				setState(187); namedconst();
				}
				break;
			case GETRADIUS:
			case GETX:
			case GETY:
			case GETVX:
			case GETVY:
			case SQRT:
			case SIN:
			case COS:
			case NOT:
				{
				setState(188); unop();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(191);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(192); binop();
					setState(193); expr(0);
					}
					} 
				}
				setState(199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NamedconstContext extends ParserRuleContext {
		public TerminalNode FALSE() { return getToken(AsteroidsParserParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(AsteroidsParserParser.TRUE, 0); }
		public TerminalNode SELF() { return getToken(AsteroidsParserParser.SELF, 0); }
		public TerminalNode NULL() { return getToken(AsteroidsParserParser.NULL, 0); }
		public NamedconstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedconst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).enterNamedconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).exitNamedconst(this);
		}
	}

	public final NamedconstContext namedconst() throws RecognitionException {
		NamedconstContext _localctx = new NamedconstContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_namedconst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELF) | (1L << TRUE) | (1L << FALSE) | (1L << NULL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode DOUBLE() { return getToken(AsteroidsParserParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(AsteroidsParserParser.VOID, 0); }
		public TerminalNode ENTITY() { return getToken(AsteroidsParserParser.ENTITY, 0); }
		public TerminalNode BOOL() { return getToken(AsteroidsParserParser.BOOL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << DOUBLE) | (1L << ENTITY) | (1L << VOID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EntityspecContext extends ParserRuleContext {
		public TerminalNode ANY() { return getToken(AsteroidsParserParser.ANY, 0); }
		public TerminalNode BULLET() { return getToken(AsteroidsParserParser.BULLET, 0); }
		public TerminalNode SHIP() { return getToken(AsteroidsParserParser.SHIP, 0); }
		public TerminalNode ASTEROID() { return getToken(AsteroidsParserParser.ASTEROID, 0); }
		public EntityspecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entityspec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).enterEntityspec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).exitEntityspec(this);
		}
	}

	public final EntityspecContext entityspec() throws RecognitionException {
		EntityspecContext _localctx = new EntityspecContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_entityspec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SHIP) | (1L << ASTEROID) | (1L << BULLET) | (1L << ANY))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinopContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(AsteroidsParserParser.GT, 0); }
		public TerminalNode LT() { return getToken(AsteroidsParserParser.LT, 0); }
		public TerminalNode SUB() { return getToken(AsteroidsParserParser.SUB, 0); }
		public TerminalNode NEQ() { return getToken(AsteroidsParserParser.NEQ, 0); }
		public TerminalNode GEQ() { return getToken(AsteroidsParserParser.GEQ, 0); }
		public TerminalNode EQ() { return getToken(AsteroidsParserParser.EQ, 0); }
		public TerminalNode DIV() { return getToken(AsteroidsParserParser.DIV, 0); }
		public TerminalNode AND() { return getToken(AsteroidsParserParser.AND, 0); }
		public TerminalNode MUL() { return getToken(AsteroidsParserParser.MUL, 0); }
		public TerminalNode OR() { return getToken(AsteroidsParserParser.OR, 0); }
		public TerminalNode LEQ() { return getToken(AsteroidsParserParser.LEQ, 0); }
		public TerminalNode ADD() { return getToken(AsteroidsParserParser.ADD, 0); }
		public BinopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).enterBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AsteroidsParserListener ) ((AsteroidsParserListener)listener).exitBinop(this);
		}
	}

	public final BinopContext binop() throws RecognitionException {
		BinopContext _localctx = new BinopContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_binop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << ADD) | (1L << SUB) | (1L << EQ) | (1L << NEQ) | (1L << LT) | (1L << GT) | (1L << LEQ) | (1L << GEQ) | (1L << AND) | (1L << OR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 1 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3=\u00d3\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\5\2\62\n\2\3\2\5\2\65\n\2\5\2\67\n\2\3\3\3\3\3\3\3\3\5\3=\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\5\4E\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5b"+
		"\n\5\3\6\3\6\3\6\5\6g\n\6\3\7\3\7\3\7\5\7l\n\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\5\7v\n\7\3\b\3\b\3\b\5\b{\n\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\5\t\u0088\n\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\7\13\u0098\n\13\f\13\16\13\u009b\13\13\5\13\u009d\n"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00aa\n\f\f\f\16"+
		"\f\u00ad\13\f\5\f\u00af\n\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u00c0\n\r\3\r\3\r\3\r\3\r\7\r\u00c6\n\r\f\r\16"+
		"\r\u00c9\13\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\2\22\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \2\6\3\3\6\3\7\n\3\13\16\3&\61\u00e6"+
		"\2\66\3\2\2\2\48\3\2\2\2\6D\3\2\2\2\ba\3\2\2\2\nf\3\2\2\2\fh\3\2\2\2\16"+
		"w\3\2\2\2\20\u0080\3\2\2\2\22\u008d\3\2\2\2\24\u0091\3\2\2\2\26\u00a0"+
		"\3\2\2\2\30\u00bf\3\2\2\2\32\u00ca\3\2\2\2\34\u00cc\3\2\2\2\36\u00ce\3"+
		"\2\2\2 \u00d0\3\2\2\2\"#\5\4\3\2#$\7:\2\2$\62\3\2\2\2%&\5\6\4\2&\'\7:"+
		"\2\2\'\62\3\2\2\2()\5\22\n\2)*\7:\2\2*\62\3\2\2\2+,\7\36\2\2,-\5\30\r"+
		"\2-.\7:\2\2.\62\3\2\2\2/\62\5\n\6\2\60\62\7:\2\2\61\"\3\2\2\2\61%\3\2"+
		"\2\2\61(\3\2\2\2\61+\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\64\3\2\2\2\63"+
		"\65\5\2\2\2\64\63\3\2\2\2\64\65\3\2\2\2\65\67\3\2\2\2\66\61\3\2\2\2\66"+
		"\67\3\2\2\2\67\3\3\2\2\289\5\34\17\29<\7\65\2\2:;\7%\2\2;=\5\30\r\2<:"+
		"\3\2\2\2<=\3\2\2\2=\5\3\2\2\2>E\7\31\2\2?E\7\32\2\2@A\7\33\2\2AE\5\30"+
		"\r\2BE\7\34\2\2CE\7\35\2\2D>\3\2\2\2D?\3\2\2\2D@\3\2\2\2DB\3\2\2\2DC\3"+
		"\2\2\2E\7\3\2\2\2FG\7\17\2\2Gb\5\30\r\2HI\7\20\2\2Ib\5\30\r\2JK\7\21\2"+
		"\2Kb\5\30\r\2LM\7\22\2\2Mb\5\30\r\2NO\7\23\2\2Ob\5\30\r\2PQ\7\25\2\2Q"+
		"R\7\66\2\2RS\5\30\r\2ST\7\67\2\2Tb\3\2\2\2UV\7\26\2\2VW\7\66\2\2WX\5\30"+
		"\r\2XY\7\67\2\2Yb\3\2\2\2Z[\7\27\2\2[\\\7\66\2\2\\]\5\30\r\2]^\7\67\2"+
		"\2^b\3\2\2\2_`\7\30\2\2`b\5\30\r\2aF\3\2\2\2aH\3\2\2\2aJ\3\2\2\2aL\3\2"+
		"\2\2aN\3\2\2\2aP\3\2\2\2aU\3\2\2\2aZ\3\2\2\2a_\3\2\2\2b\t\3\2\2\2cg\5"+
		"\f\7\2dg\5\16\b\2eg\5\20\t\2fc\3\2\2\2fd\3\2\2\2fe\3\2\2\2g\13\3\2\2\2"+
		"hi\7\37\2\2ik\5\30\r\2jl\7 \2\2kj\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn\78\2\2"+
		"no\5\2\2\2ou\79\2\2pq\7!\2\2qr\78\2\2rs\5\2\2\2st\79\2\2tv\3\2\2\2up\3"+
		"\2\2\2uv\3\2\2\2v\r\3\2\2\2wx\7\"\2\2xz\5\30\r\2y{\7#\2\2zy\3\2\2\2z{"+
		"\3\2\2\2{|\3\2\2\2|}\78\2\2}~\5\2\2\2~\177\79\2\2\177\17\3\2\2\2\u0080"+
		"\u0081\7$\2\2\u0081\u0082\7\66\2\2\u0082\u0083\5\36\20\2\u0083\u0084\7"+
		";\2\2\u0084\u0085\7\65\2\2\u0085\u0087\7\67\2\2\u0086\u0088\7#\2\2\u0087"+
		"\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\78"+
		"\2\2\u008a\u008b\5\2\2\2\u008b\u008c\79\2\2\u008c\21\3\2\2\2\u008d\u008e"+
		"\7\65\2\2\u008e\u008f\7%\2\2\u008f\u0090\5\30\r\2\u0090\23\3\2\2\2\u0091"+
		"\u0092\5\34\17\2\u0092\u0093\7\65\2\2\u0093\u009c\7\66\2\2\u0094\u0099"+
		"\5\30\r\2\u0095\u0096\7;\2\2\u0096\u0098\5\30\r\2\u0097\u0095\3\2\2\2"+
		"\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009d"+
		"\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u0094\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u009f\7\67\2\2\u009f\25\3\2\2\2\u00a0\u00a1\5\34"+
		"\17\2\u00a1\u00a2\7\65\2\2\u00a2\u00ae\7\66\2\2\u00a3\u00a4\5\34\17\2"+
		"\u00a4\u00ab\5\30\r\2\u00a5\u00a6\7;\2\2\u00a6\u00a7\5\34\17\2\u00a7\u00a8"+
		"\5\30\r\2\u00a8\u00aa\3\2\2\2\u00a9\u00a5\3\2\2\2\u00aa\u00ad\3\2\2\2"+
		"\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab"+
		"\3\2\2\2\u00ae\u00a3\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00b1\7\67\2\2\u00b1\u00b2\78\2\2\u00b2\u00b3\5\2\2\2\u00b3\u00b4\79"+
		"\2\2\u00b4\27\3\2\2\2\u00b5\u00b6\b\r\1\2\u00b6\u00c0\7\62\2\2\u00b7\u00c0"+
		"\7\65\2\2\u00b8\u00c0\7\24\2\2\u00b9\u00ba\7\66\2\2\u00ba\u00bb\5\30\r"+
		"\2\u00bb\u00bc\7\67\2\2\u00bc\u00c0\3\2\2\2\u00bd\u00c0\5\32\16\2\u00be"+
		"\u00c0\5\b\5\2\u00bf\u00b5\3\2\2\2\u00bf\u00b7\3\2\2\2\u00bf\u00b8\3\2"+
		"\2\2\u00bf\u00b9\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0"+
		"\u00c7\3\2\2\2\u00c1\u00c2\6\r\2\3\u00c2\u00c3\5 \21\2\u00c3\u00c4\5\30"+
		"\r\2\u00c4\u00c6\3\2\2\2\u00c5\u00c1\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\31\3\2\2\2\u00c9\u00c7\3\2\2"+
		"\2\u00ca\u00cb\t\2\2\2\u00cb\33\3\2\2\2\u00cc\u00cd\t\3\2\2\u00cd\35\3"+
		"\2\2\2\u00ce\u00cf\t\4\2\2\u00cf\37\3\2\2\2\u00d0\u00d1\t\5\2\2\u00d1"+
		"!\3\2\2\2\23\61\64\66<Dafkuz\u0087\u0099\u009c\u00ab\u00ae\u00bf\u00c7";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}