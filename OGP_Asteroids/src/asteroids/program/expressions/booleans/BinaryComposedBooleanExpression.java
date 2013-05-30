package asteroids.program.expressions.booleans;

import asteroids.program.expressions.Expression;
import asteroids.program.types.BooleanType;

public abstract class BinaryComposedBooleanExpression extends ComposedBooleanExpression {
	protected Expression rhs;
	protected Expression lhs;
	public BinaryComposedBooleanExpression(int line, int column, Expression lhs, Expression rhs) {
		super(line, column);
		this.rhs =  rhs;
		this.lhs =  lhs;
	}

	@Override
	public abstract BooleanType getType();

	@Override
	public boolean isTypeCorrect(){
		if (lhs.getType() instanceof BooleanType && rhs.getType() instanceof BooleanType)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Boolean [left expression=" + lhs.toString() + ", right expression=" + rhs.toString()
				+ ", value=" + type.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lhs == null) ? 0 : lhs.hashCode());
		result = prime * result + ((rhs == null) ? 0 : rhs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BinaryComposedBooleanExpression other = (BinaryComposedBooleanExpression) obj;
		if (lhs == null) {
			if (other.lhs != null)
				return false;
		} else if (!lhs.equals(other.lhs))
			return false;
		if (rhs == null) {
			if (other.rhs != null)
				return false;
		} else if (!rhs.equals(other.rhs))
			return false;
		return true;
	}
	
	
}
