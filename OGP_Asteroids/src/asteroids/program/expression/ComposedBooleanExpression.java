package asteroids.program.expression;

import asteroids.program.types.BooleanType;

public abstract class ComposedBooleanExpression extends BooleanExpression {
	protected BooleanExpression rhs;
	protected BooleanExpression lhs;
	public ComposedBooleanExpression(int line, int column, Expression lhs, Expression rhs) {
		super(line, column);
		this.rhs = (BooleanExpression) rhs;
		this.lhs = (BooleanExpression) lhs;
	}

	@Override
	public abstract BooleanType getType() ;

}
