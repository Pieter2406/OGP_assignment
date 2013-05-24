package asteroids.program.expression.binary;

import asteroids.program.expression.ComposedBooleanExpression;
import asteroids.program.expression.Expression;
import asteroids.program.types.BooleanType;

public class Disjunction extends ComposedBooleanExpression {

	public Disjunction(int line, int column, Expression lhs, Expression rhs) {
		super(line, column, lhs, rhs);
	}

	@Override
	public BooleanType getType() {
		return new BooleanType(lhs.getType().getValue() || rhs.getType().getValue());
	}

}