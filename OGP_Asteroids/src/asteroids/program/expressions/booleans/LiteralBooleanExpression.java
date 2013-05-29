package asteroids.program.expressions.booleans;

import asteroids.program.types.BooleanType;

public class LiteralBooleanExpression extends BooleanExpression {

	public LiteralBooleanExpression(int line, int column, boolean b) {
		super(line, column);
		this.type = new BooleanType(b);
	}

	@Override
	public BooleanType getType() {
		return (BooleanType) type;
	}

	@Override
	public boolean isTypeCorrect() {
		return true; // always type correct.
	}

}
