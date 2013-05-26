package asteroids.program.expressions.booleans.unary;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.booleans.ComposedBooleanExpression;
import asteroids.program.types.BooleanType;

public class Not extends ComposedBooleanExpression {

	public Not(int line, int column, Expression e) {
		super(line, column, null, e);
	}

	@Override
	public BooleanType getType() {
		return new BooleanType(!(boolean)rhs.getType().getValue());
	}

}
