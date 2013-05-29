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
	
		/*
		 * 
		 
		
		 
		 * If the condition is met or the inner iteration is not yet finished
		 * execute the body of the while loop.
		 
		while(loopCondition && inBody){
			success = body.execute();
			if (success)
				inBody = false;
			else
				inBody = true;
		
		 * If the condition is not met and the inner iteration is finished. This breaks out the loop.
		 
		}if(!(boolean) condition.getType().getValue()){
			return true;
		
		 * In all other cases, if the inner body is finished, proceed whit this iteration. If the inner body
		 * is not yet finished return false. This will continue the loop the next time.
		 
		}else{
			if(success){
				this.execute();
			}else{
				return false;
			} 
		}
		return false;
		 */
		

		/*
			if ((boolean) condition.getType().getValue()){
				body.execute(); 
				if(sourceProgram.getIC() >= this.startInstruction + body.getLastLine())
					sourceProgram.setIC(startInstruction - 1);
			}
		 */
	}
}
