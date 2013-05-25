package asteroids.program.expressions.booleans;

import asteroids.program.expressions.Expression;
import asteroids.program.types.BooleanType;

public abstract class ComposedBooleanExpression extends BooleanExpression {
	protected Expression rhs;
	protected Expression lhs;
	public ComposedBooleanExpression(int line, int column, Expression lhs, Expression rhs) {
		super(line, column);
		this.rhs =  rhs;
		this.lhs =  lhs;
	}

	@Override
	public abstract BooleanType getType() ;

}
