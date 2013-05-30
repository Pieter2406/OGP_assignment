package asteroids.program.statements.loops;

import asteroids.program.expressions.Expression;
import asteroids.program.statements.LoopStatement;
import asteroids.program.statements.SequenceStatement;
import asteroids.program.statements.Statement;
import asteroids.studentdefined.Program;

public class WhileLoopStatement extends LoopStatement {
	@Deprecated
	private int startInstruction;
	private Expression condition;
	private boolean inBody = false;
	private boolean success = true;
	public WhileLoopStatement(int line, int column, Expression condition, Statement body) {
		super(line, column, body);
		startInstruction = line;
		this.condition = condition;
		this.body = (SequenceStatement)body;
	}
	@Override
	public void setSource(Program sourceProgram){
		this.sourceProgram = sourceProgram;
		this.body.setSource(sourceProgram);
	}
	@Override
	public boolean execute() {
		/*
		 * While wordt opgeroepen
		 * Als nog niet in body:
		 * 		check condition
		 * 			voer body uit
		 * 		conditie niet voldaan
		 * 			return true
		 * Als wel in body:
		 * 		voer body uit
		 * 
		 * Als body false returned 
		 * 		this.execute
		 */
						
		if(!inBody){
			boolean loopCondition = (boolean) condition.getType().getValue();
			if(loopCondition){
				inBody = !body.execute();
			}else{
				return true;
			}
		}else{
			inBody = !body.execute();
			if(!inBody){
				this.execute();
			}
		}
		
		return !inBody;
	}
	
	@Override
	public boolean typeCheck() {
		if (!condition.isTypeCorrect())
			return false;
		if (!body.typeCheck())
			return false; // if a statement of the body is type incorrect return false, if none is found return true.
		return true;
	}
	@Override
	public String toString() {
		return "WhileLoopStatement [condition=" + condition + ", inBody=" + inBody
				+ ", success=" + success + "]";
	}
	
}
