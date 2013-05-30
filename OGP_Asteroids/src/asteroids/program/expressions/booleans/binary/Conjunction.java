package asteroids.program.expressions.booleans.binary;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.booleans.BinaryComposedBooleanExpression;
import asteroids.program.types.BooleanType;

public class Conjunction extends BinaryComposedBooleanExpression {

	public Conjunction(int line, int column, Expression lhs, Expression rhs) {
		super(line, column,lhs, rhs);
	}

	@Override
	public BooleanType getType() {
		return new BooleanType((boolean) lhs.getType().getValue() && (boolean) rhs.getType().getValue());
	}

	@Override
	public String toString() {
		return "Conjunction [left expression=" + lhs.toString() + ", right expression=" + rhs.toString() + ", outcome value=" + type.toString()
				+ "]";
	}
	
	
}
