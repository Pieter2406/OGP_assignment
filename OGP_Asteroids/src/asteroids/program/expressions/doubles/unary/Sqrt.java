package asteroids.program.expressions.doubles.unary;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.doubles.UnaryComposedDoubleExpression;
import asteroids.program.types.DoubleType;

public class Sqrt extends UnaryComposedDoubleExpression {

	public Sqrt(int line, int column, Expression e) {
		super(line,column, e);
	}

	@Override
	public DoubleType getType() {
		return new DoubleType(Math.sqrt((double)e.getType().getValue()));
	}

}
