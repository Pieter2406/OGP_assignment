package asteroids.program.expressions;

import asteroids.program.types.DoubleType;

public abstract class DoubleExpression extends Expression {

	public DoubleExpression(int line, int column) {
		super(line,column);
	}

	
	@Override
	public abstract DoubleType getType();

	public abstract boolean isTypeCorrect();


	@Override
	public String toString() {
		return "Double [value=" + type.toString() + "]";
	}
	
	
}
