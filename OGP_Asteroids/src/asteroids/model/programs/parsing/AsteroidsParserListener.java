// Generated from C:\Antlr\AsteroidsParser.g4 by ANTLR 4.0
 package asteroids.model.programs.parsing; 
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface AsteroidsParserListener extends ParseTreeListener {
	void enterForeach(AsteroidsParserParser.ForeachContext ctx);
	void exitForeach(AsteroidsParserParser.ForeachContext ctx);

	void enterAssign(AsteroidsParserParser.AssignContext ctx);
	void exitAssign(AsteroidsParserParser.AssignContext ctx);

	void enterEval(AsteroidsParserParser.EvalContext ctx);
	void exitEval(AsteroidsParserParser.EvalContext ctx);

	void enterNamedconst(AsteroidsParserParser.NamedconstContext ctx);
	void exitNamedconst(AsteroidsParserParser.NamedconstContext ctx);

	void enterExpr(AsteroidsParserParser.ExprContext ctx);
	void exitExpr(AsteroidsParserParser.ExprContext ctx);

	void enterType(AsteroidsParserParser.TypeContext ctx);
	void exitType(AsteroidsParserParser.TypeContext ctx);

	void enterCtrl(AsteroidsParserParser.CtrlContext ctx);
	void exitCtrl(AsteroidsParserParser.CtrlContext ctx);

	void enterBinop(AsteroidsParserParser.BinopContext ctx);
	void exitBinop(AsteroidsParserParser.BinopContext ctx);

	void enterFunction(AsteroidsParserParser.FunctionContext ctx);
	void exitFunction(AsteroidsParserParser.FunctionContext ctx);

	void enterWhiledo(AsteroidsParserParser.WhiledoContext ctx);
	void exitWhiledo(AsteroidsParserParser.WhiledoContext ctx);

	void enterFunctioncall(AsteroidsParserParser.FunctioncallContext ctx);
	void exitFunctioncall(AsteroidsParserParser.FunctioncallContext ctx);

	void enterIfthenelse(AsteroidsParserParser.IfthenelseContext ctx);
	void exitIfthenelse(AsteroidsParserParser.IfthenelseContext ctx);

	void enterUnop(AsteroidsParserParser.UnopContext ctx);
	void exitUnop(AsteroidsParserParser.UnopContext ctx);

	void enterAction(AsteroidsParserParser.ActionContext ctx);
	void exitAction(AsteroidsParserParser.ActionContext ctx);

	void enterEntityspec(AsteroidsParserParser.EntityspecContext ctx);
	void exitEntityspec(AsteroidsParserParser.EntityspecContext ctx);

	void enterDecl(AsteroidsParserParser.DeclContext ctx);
	void exitDecl(AsteroidsParserParser.DeclContext ctx);
}