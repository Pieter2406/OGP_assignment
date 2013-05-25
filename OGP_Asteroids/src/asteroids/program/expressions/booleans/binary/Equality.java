package asteroids.program.expressions.booleans.binary;

import asteroids.program.expressions.DoubleExpression;
import asteroids.program.expressions.Expression;
import asteroids.program.expressions.booleans.ComposedBooleanExpression;
import asteroids.program.types.BooleanType;

public class Equality extends ComposedBooleanExpression {

	public Equality(int line, int column, Expression lhs, Expression rhs) {
		super(line, column, lhs, rhs);
	}

	@Override
	public BooleanType getType() {
		return new BooleanType(((DoubleExpression)lhs).getType().getValue() == ((DoubleExpression)rhs).getType().getValue());
	}

}
