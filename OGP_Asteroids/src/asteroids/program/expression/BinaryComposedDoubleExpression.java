package asteroids.program.expression;

import asteroids.program.types.DoubleType;

public abstract class BinaryComposedDoubleExpression extends
		ComposedDoubleExpression {

	public BinaryComposedDoubleExpression(int line, int column) {
		super(line,column);
	}

	@Override
	public abstract DoubleType getType();
}
