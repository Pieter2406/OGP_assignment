package asteroids.program.statements.conditionals;

import asteroids.program.expressions.Expression;
import asteroids.program.statements.ConditionalStatement;
import asteroids.program.statements.SequenceStatement;
import asteroids.program.statements.Statement;

public class WhileConditionalStatement extends LoopConditionalStatement {
	private boolean success = true;
	public WhileConditionalStatement(int line, int column, Expression condition, Statement body) {
		super(line, column, condition,body);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute() {

		if((boolean) condition.getType().getValue() || success == false){
			success = body.execute();
		}else if(!(boolean) condition.getType().getValue()){
			return true;
		}else{
			if(success){
				this.execute();
			}else{
				return false;
			} 
		}
		return false;



		/*
			if ((boolean) condition.getType().getValue()){
				body.execute(); 
				if(sourceProgram.getIC() >= this.startInstruction + body.getLastLine())
					sourceProgram.setIC(startInstruction - 1);
			}
		 */
	}


}
