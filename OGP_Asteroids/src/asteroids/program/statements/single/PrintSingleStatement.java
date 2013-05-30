package asteroids.program.statements.single;

import asteroids.program.expressions.Expression;
import asteroids.program.statements.SingleStatement;


public class PrintSingleStatement extends SingleStatement {
	private Expression expression;
	public PrintSingleStatement(int line, int column, Expression e) {
		super(line, column);
		this.expression = e;
	}

	@Override
	public boolean execute(){
		System.out.println(this.expression.toString());
		return true;
	}

	@Override
	public boolean typeCheck() {
		return (expression.isTypeCorrect());
	}

	@Override
	public String toString() {
		return "PrintSingleStatement [expression=" + expression + ", line="
				+ line + ", column=" + column + "]";
	}
	
	
}
