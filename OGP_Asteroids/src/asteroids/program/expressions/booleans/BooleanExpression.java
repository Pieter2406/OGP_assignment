package asteroids.program.expressions.booleans;

import asteroids.program.expressions.Expression;
import asteroids.program.types.BooleanType;

public abstract class BooleanExpression extends Expression {

	public BooleanExpression(int line, int column) {
		super(line, column);
	}

	@Override
	public abstract BooleanType getType();
	
}
