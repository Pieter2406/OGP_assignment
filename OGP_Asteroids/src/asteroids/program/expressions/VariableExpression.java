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
	
	@Override
	public boolean isTypeCorrect(){
		if (ProgramContainer.getGlobals().containsKey(name)) // Check if the name of this variable is in globals.
			return true;
		return false;
	}

	
	@Override
	public String toString() {
		return "Variable [name=" + name + ", value=" + type.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
}
