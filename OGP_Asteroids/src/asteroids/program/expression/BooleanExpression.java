package asteroids.program.expression;

import asteroids.program.types.BooleanType;

public abstract class BooleanExpression extends Expression {

	public BooleanExpression(int line, int column) {
		super(line, column);
	}

	@Override
	public abstract BooleanType getType() ;

	
}
