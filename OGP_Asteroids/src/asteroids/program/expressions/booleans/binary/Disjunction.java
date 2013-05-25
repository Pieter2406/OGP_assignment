package asteroids.program.expressions.booleans.binary;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.booleans.BooleanExpression;
import asteroids.program.expressions.booleans.ComposedBooleanExpression;
import asteroids.program.types.BooleanType;

public class Disjunction extends ComposedBooleanExpression {

	public Disjunction(int line, int column, Expression lhs, Expression rhs) {
		super(line, column, lhs, rhs);
	}

	@Override
	public BooleanType getType() {
		return new BooleanType(((BooleanExpression)lhs).getType().getValue() || ((BooleanExpression)rhs).getType().getValue());
	}

}
