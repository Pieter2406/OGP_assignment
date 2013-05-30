package asteroids.program.expressions.doubles;

import asteroids.program.expressions.DoubleExpression;
import asteroids.program.expressions.Expression;
import asteroids.program.types.DoubleType;
import asteroids.program.types.EntityType;

public abstract class PropertyDoubleExpression extends DoubleExpression {
	protected Expression expression;
	
	public PropertyDoubleExpression(int line, int column, Expression exp) {
		super(line,column);
		this.expression = exp; 
	}

	@Override
	public abstract DoubleType getType();
	
	@Override
	public boolean isTypeCorrect(){
		if (expression.getType() instanceof EntityType)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Property double [expression=" + expression.toString() + ", value=" + type.toString() +  "]";
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
		PropertyDoubleExpression other = (PropertyDoubleExpression) obj;
		if (expression == null) {
			if (other.expression != null)
				return false;
		} else if (!expression.equals(other.expression))
			return false;
		return true;
	}
	

	
}
