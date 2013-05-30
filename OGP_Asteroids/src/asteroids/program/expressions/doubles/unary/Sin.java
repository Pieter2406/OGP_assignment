package asteroids.program.expressions.doubles.unary;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.doubles.UnaryComposedDoubleExpression;
import asteroids.program.types.DoubleType;

public class Sin extends UnaryComposedDoubleExpression {

	public Sin(int line, int column, Expression e) {
		super(line,column, e);
	}

	@Override
	public DoubleType getType() {
		return new DoubleType(Math.sin((double)e.getType().getValue()));
	}
	@Override
	public String toString() {
		return "Get sine [expression=" + e + "]";
	}
}
