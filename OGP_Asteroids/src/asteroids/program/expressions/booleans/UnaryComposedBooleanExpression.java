package asteroids.program.expressions.booleans;

import asteroids.program.expressions.Expression;
import asteroids.program.types.BooleanType;

public abstract class UnaryComposedBooleanExpression extends ComposedBooleanExpression {
	protected Expression expression;
	public UnaryComposedBooleanExpression(int line, int column, Expression e) {
		super(line, column);
		this.expression = e;
	}

	@Override
	public boolean isTypeCorrect() {
		if (expression.getType() instanceof BooleanType)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Unary boolean [expression=" + expression
				+ ", value=" + type.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((expression == null) ? 0 : expression.hashCode());
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
		UnaryComposedBooleanExpression other = (UnaryComposedBooleanExpression) obj;
		if (expression == null) {
			if (other.expression != null)
				return false;
		} else if (!expression.equals(other.expression))
			return false;
		return true;
	}

	
	
	
}
