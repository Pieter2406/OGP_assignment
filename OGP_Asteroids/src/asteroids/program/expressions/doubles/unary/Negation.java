package asteroids.program.expressions.doubles.unary;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.doubles.UnaryComposedDoubleExpression;
import asteroids.program.types.DoubleType;

public class Negation extends UnaryComposedDoubleExpression {

	public Negation(int line, int column, Expression e) {
		super(line,column,e);
	}

	@Override
	public DoubleType getType() {
		return new DoubleType((-1)*(double)e.getType().getValue());
	}

}
