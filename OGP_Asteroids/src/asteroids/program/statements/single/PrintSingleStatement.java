package asteroids.program.statements.single;

import asteroids.program.expressions.Expression;
import asteroids.program.statements.SingleStatement;
import asteroids.studentdefined.Program;


public class PrintSingleStatement extends SingleStatement {
	private Expression expression;
	public PrintSingleStatement(int line, int column, Expression e) {
		super(line, column);
		this.expression = e;
	}

	@Override
	public void execute(){
		System.out.println(this.expression.toString());
	}
}
