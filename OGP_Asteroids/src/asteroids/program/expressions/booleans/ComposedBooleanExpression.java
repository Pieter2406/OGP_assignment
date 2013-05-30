package asteroids.program.expressions.booleans;

import asteroids.program.types.BooleanType;

public abstract class ComposedBooleanExpression extends BooleanExpression {
	public ComposedBooleanExpression(int line, int column) {
		super(line, column);
	}

	@Override
	public abstract BooleanType getType();

}
