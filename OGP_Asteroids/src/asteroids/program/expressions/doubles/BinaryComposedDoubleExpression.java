package asteroids.program.expressions.doubles;

import asteroids.program.expressions.DoubleExpression;
import asteroids.program.expressions.Expression;
import asteroids.program.types.DoubleType;

public abstract class BinaryComposedDoubleExpression extends ComposedDoubleExpression {
	protected DoubleExpression lhs;
	protected DoubleExpression rhs;
	public BinaryComposedDoubleExpression(int line, int column, Expression lhs, Expression rhs) {
		super(line,column);
		this.lhs = (DoubleExpression) lhs;
		this.rhs = (DoubleExpression) rhs;
	}

	@Override
	public abstract DoubleType getType();
}
