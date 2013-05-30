package asteroids.program.expressions.doubles;

import asteroids.program.expressions.Expression;
import asteroids.program.types.DoubleType;



public abstract class UnaryComposedDoubleExpression extends ComposedDoubleExpression {
	protected Expression e;
	public UnaryComposedDoubleExpression(int line, int column, Expression e) {
		super(line,column);
		this.e = e;
	}
	
	@Override
	public boolean isTypeCorrect(){
		if (e.getType() instanceof DoubleType) // expressions of UnaryComposedDoubleExpression must all have type double.
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Unary double [expression=" + e.toString() + ", value=" + type.toString() +  "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((e == null) ? 0 : e.hashCode());
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
		UnaryComposedDoubleExpression other = (UnaryComposedDoubleExpression) obj;
		if (e == null) {
			if (other.e != null)
				return false;
		} else if (!e.equals(other.e))
			return false;
		return true;
	}

}
