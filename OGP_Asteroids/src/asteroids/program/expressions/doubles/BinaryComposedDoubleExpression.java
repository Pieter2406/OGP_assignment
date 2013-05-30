package asteroids.program.expressions.doubles;

import asteroids.program.expressions.Expression;
import asteroids.program.types.DoubleType;

public abstract class BinaryComposedDoubleExpression extends ComposedDoubleExpression {
	protected Expression lhs;
	protected Expression rhs;
	public BinaryComposedDoubleExpression(int line, int column, Expression lhs, Expression rhs) {
		super(line,column);
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public abstract DoubleType getType();
	
	@Override
	public boolean isTypeCorrect(){
		if (lhs.getType() instanceof DoubleType && (rhs.getType() instanceof DoubleType)) // lhs and rhs of BinaryComposedDoubleExpression must be of type double.
			return true;
		return false;
	}

	
	@Override
	public String toString() {
		return "Binary double [left expression=" + lhs.toString() + ", right expression=" + rhs.toString() + ", outcome value=" + type.toString()
				+ "]";
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
		BinaryComposedDoubleExpression other = (BinaryComposedDoubleExpression) obj;
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
