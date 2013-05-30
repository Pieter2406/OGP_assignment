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

	@Override
	public String toString() {
		return "Literal boolean [value=" + type.toString() + "]";
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
}
