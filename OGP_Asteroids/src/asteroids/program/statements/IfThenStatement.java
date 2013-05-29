/**
 * 
 */
package asteroids.program.statements;

import asteroids.program.expressions.Expression;
import asteroids.studentdefined.Program;

public class IfThenStatement extends Statement {

	private Expression condition;
	private Statement then;
	private Statement otherwise;
	private boolean inThen = false;
	private boolean inOtherwise = false;
	public IfThenStatement(int line, int column, Expression condition, Statement then, Statement otherwise) {
		super(line,column);
		this.condition = condition;
		this.then = then;
		this.otherwise = otherwise;
	}
	public void setSource(Program sourceProgram){
		this.sourceProgram = sourceProgram;
		this.then.setSource(sourceProgram);
		this.otherwise.setSource(sourceProgram);
	}
	
	@Override
	public boolean execute() {
		boolean success;
		if(inThen == false && inOtherwise == false){
			if((boolean)condition.getType().getValue()){
				inThen = true;
				success = then.execute();
				if(success){
					inThen = false;
				}
				return success;
			}else{
				inOtherwise = true;
				success = otherwise.execute();
				if(success){
					inOtherwise = false;
				}
				return success;
			}
		}else if(inThen == true){
			return then.execute();
		}else if(inOtherwise == true){
			return otherwise.execute();
		}else{
			return false;
		}
	}
	@Override
	public boolean typeCheck() {
		if (!then.typeCheck() || !otherwise.typeCheck()){
			return false; // if then or otherwise is type incorrect return false, else return true.
		}
		return true;
	}
}
