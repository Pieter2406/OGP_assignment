package asteroids.program.expressions.booleans.binary;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.booleans.BinaryComposedBooleanExpression;
import asteroids.program.expressions.booleans.ComposedBooleanExpression;
import asteroids.program.types.BooleanType;

public class GreaterThan extends BinaryComposedBooleanExpression {
	public GreaterThan(int line, int column, Expression lhs, Expression rhs) {
		super(line, column, lhs, rhs);
	}
	
	@Override
	public BooleanType getType() {
		return new BooleanType((double)lhs.getType().getValue() > (double) rhs.getType().getValue());
	}
	
	

}
