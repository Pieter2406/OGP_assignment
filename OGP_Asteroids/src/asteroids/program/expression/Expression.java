package asteroids.program.expression;

import asteroids.program.types.Type;

public abstract class Expression{
	protected final int line;
	protected final int column;
	protected Type type;
	public Expression(int line, int column) {
		this.line = line;
		this.column = column;
	}
	public abstract Type getType();
	
	@Override
	public String toString(){
		return type.toString();
	}
}
