package asteroids.program.expressions.booleans.unary;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.booleans.UnaryComposedBooleanExpression;
import asteroids.program.types.BooleanType;

public class Not extends UnaryComposedBooleanExpression {

	public Not(int line, int column, Expression e) {
		super(line, column, e);
	}

	@Override
	public BooleanType getType() {
		return new BooleanType(!(boolean)expression.getType().getValue());
	}

	@Override
	public String toString() {
		return "Not [expression=" + expression + ", value=" + type.toString() + "]";
	}
	
}
