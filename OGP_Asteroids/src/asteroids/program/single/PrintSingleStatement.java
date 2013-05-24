package asteroids.program.single;

import asteroids.program.SingleStatement;
import asteroids.program.expression.Expression;
import asteroids.studentdefined.Program;


public class PrintSingleStatement extends SingleStatement {
	Expression expression;
	public PrintSingleStatement(int line, int column, Expression e) {
		super(line, column);
		this.expression = e;
	}

	@Override
	public void execute(){
		System.out.println(expression.toString());
	}
}
