package asteroids.program.expressions;

import asteroids.program.ProgramContainer;
import asteroids.program.types.Type;

public class VariableExpression extends Expression {
	private String name;
	public VariableExpression(int line, int column, String name) {
		super(line, column);
		this.type = null;
		this.name = name;
	}

	@Override
	public Type getType() {
		Type t = ProgramContainer.getGlobal(name);
		this.type = t;
		return t;
	}
}
