package asteroids.program.expression.unary;

import asteroids.program.expression.ComposedBooleanExpression;
import asteroids.program.expression.Expression;
import asteroids.program.types.BooleanType;

public class Not extends ComposedBooleanExpression {

	public Not(int line, int column, Expression e) {
		super(line, column, null, e);
	}

	@Override
	public BooleanType getType() {
		return new BooleanType(!rhs.getType().getValue());
	}

}
