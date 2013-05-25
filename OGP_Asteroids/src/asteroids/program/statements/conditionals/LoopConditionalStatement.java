package asteroids.program.statements.conditionals;

import asteroids.program.expressions.Expression;
import asteroids.program.statements.ConditionalStatement;
import asteroids.program.statements.SequenceStatement;
import asteroids.program.statements.Statement;
import asteroids.studentdefined.Program;

public abstract class LoopConditionalStatement extends ConditionalStatement {
	protected int startInstruction;
	protected Expression condition;
	protected SequenceStatement body;
	public LoopConditionalStatement(int line, int column, Expression condition, Statement body) {
		super(line, column);
		startInstruction = line;
		this.condition = condition;
		this.body = (SequenceStatement)body;
	}
	@Override
	public void setSource(Program sourceProgram){
		this.sourceProgram = sourceProgram;
		this.body.setSource(sourceProgram);
	}

}
