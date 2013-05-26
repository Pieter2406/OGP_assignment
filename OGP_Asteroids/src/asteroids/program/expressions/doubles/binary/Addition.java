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
		return new DoubleType(this.lhs.getType().getValue() + this.rhs.getType().getValue());
	}
}
