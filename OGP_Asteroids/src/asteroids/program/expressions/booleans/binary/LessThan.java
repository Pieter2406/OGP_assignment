package asteroids.program.expressions.booleans.binary;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.booleans.BinaryComposedBooleanExpression;
import asteroids.program.expressions.booleans.ComposedBooleanExpression;
import asteroids.program.types.BooleanType;
import asteroids.program.types.DoubleType;


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
	public boolean isTypeCorrect() {
		if (lhs.getType() instanceof DoubleType && rhs.getType() instanceof DoubleType)
			return true;
		return false;
	}
	
}
