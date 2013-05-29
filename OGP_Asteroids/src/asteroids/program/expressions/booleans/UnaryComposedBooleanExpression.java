package asteroids.program.expressions.booleans;

import asteroids.program.expressions.Expression;
import asteroids.program.types.BooleanType;

public abstract class UnaryComposedBooleanExpression extends ComposedBooleanExpression {
	protected Expression expression;
	public UnaryComposedBooleanExpression(int line, int column, Expression e) {
		super(line, column);
		this.expression = e;
	}

	@Override
	public boolean isTypeCorrect() {
		if (expression.getType() instanceof BooleanType)
			return true;
		return false;
	}

}
