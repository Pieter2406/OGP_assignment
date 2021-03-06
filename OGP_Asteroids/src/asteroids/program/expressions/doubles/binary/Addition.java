package asteroids.program.expressions.doubles.binary;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.doubles.BinaryComposedDoubleExpression;
import asteroids.program.types.DoubleType;

public class Addition extends BinaryComposedDoubleExpression {


	public Addition(int line, int column, Expression lhs, Expression rhs ) {
		super(line,column,lhs,rhs);
		this.type = null;
	}

	@Override
	public DoubleType getType() {
		type = new DoubleType((double) this.lhs.getType().getValue() + (double) this.rhs.getType().getValue());
		return (DoubleType) type;
	}
	
	@Override
	public String toString() {
		return "Addition [left expression=" + lhs.toString() + ", right expression=" + rhs.toString() + ", outcome value=" + type.toString()
				+ "]";
	}
	
}
