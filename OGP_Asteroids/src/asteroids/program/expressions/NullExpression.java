package asteroids.program.expressions;

import asteroids.program.types.Type;

public class NullExpression extends Expression {

	public NullExpression(int line, int column) {
		super(line, column);
		
	}

	@Override
	public Type getType() {
		return null;
	}

}
