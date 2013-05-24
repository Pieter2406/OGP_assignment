package asteroids.program.expression;

import asteroids.program.types.DoubleType;

public abstract class DoubleExpression extends Expression {

	public DoubleExpression(int line, int column) {
		super(line,column);
	}

	
	@Override
	public abstract DoubleType getType();


}
