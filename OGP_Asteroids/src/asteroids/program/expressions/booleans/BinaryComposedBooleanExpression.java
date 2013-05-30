package asteroids.program.expressions.booleans;

import asteroids.program.expressions.Expression;
import asteroids.program.types.BooleanType;
import asteroids.program.types.DoubleType;

public abstract class BinaryComposedBooleanExpression extends ComposedBooleanExpression {
	protected Expression rhs;
	protected Expression lhs;
	public BinaryComposedBooleanExpression(int line, int column,
			Expression lhs, Expression rhs) {
		super(line, column);
		this.rhs =  rhs;
		this.lhs =  lhs;
	}

	@Override
	public BooleanType getType() {
		// TODO Auto-generated method stub
		return null;
	}
}
