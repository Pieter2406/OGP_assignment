package asteroids.program.expressions.booleans.binary;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.booleans.BinaryComposedBooleanExpression;
import asteroids.program.types.BooleanType;


public class LessThan extends BinaryComposedBooleanExpression {

	public LessThan(int line, int column, Expression lhs, Expression rhs) {
		super(line, column, lhs, rhs);
		this.type = null;
		
	}
	@Override
	public BooleanType getType() {
		this.type = new BooleanType((double)lhs.getType().getValue() < (double) rhs.getType().getValue());
		return (BooleanType) type;
	}
	@Override
	public String toString() {
		return "LessThan [left expression=" + lhs.toString() + ", right expression=" + rhs.toString() + ", outcome value=" + type.toString()
				+ "]";
	}

}
