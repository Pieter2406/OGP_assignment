package asteroids.program.expression;

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

}
