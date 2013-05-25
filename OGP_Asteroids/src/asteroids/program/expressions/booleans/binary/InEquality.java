package asteroids.program.expressions.booleans.binary;

import asteroids.program.expressions.DoubleExpression;
import asteroids.program.expressions.Expression;
import asteroids.program.expressions.booleans.ComposedBooleanExpression;
import asteroids.program.types.BooleanType;

public class InEquality extends ComposedBooleanExpression {

	public InEquality(int line, int column, Expression lhs, Expression rhs) {
		super(line, column, lhs, rhs);
	}

	@Override
	public BooleanType getType() {
		return new BooleanType(((DoubleExpression)lhs).getType().getValue() != ((DoubleExpression)rhs).getType().getValue());
	}

}