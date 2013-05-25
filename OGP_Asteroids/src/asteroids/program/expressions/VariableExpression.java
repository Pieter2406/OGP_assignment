package asteroids.program.expressions;

import asteroids.program.types.Type;
import asteroids.studentdefined.Program;

public class VariableExpression extends Expression {
	private String name;
	public VariableExpression(int line, int column, String name) {
		super(line, column);
		this.type = null;
		this.name = name;
	}

	@Override
	public Type getType() {
		
	}

}
