package asteroids.program.expressions.doubles;

import asteroids.program.expressions.Expression;



public abstract class UnaryComposedDoubleExpression extends ComposedDoubleExpression {
	protected Expression e;
	public UnaryComposedDoubleExpression(int line, int column, Expression e) {
		super(line,column);
		this.e = e;
	}

}
