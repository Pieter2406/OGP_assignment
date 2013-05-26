package asteroids.program.expressions;

import asteroids.program.types.Type;

public abstract class Expression{
	protected final int line;
	protected final int column;
	protected Type type;
	//protected Program sourceProgram;
	public Expression(int line, int column) {
		this.line = line;
		this.column = column;
	}
	public abstract Type getType();

	@Override
	public String toString(){
		return getType().toString();
	}
}
