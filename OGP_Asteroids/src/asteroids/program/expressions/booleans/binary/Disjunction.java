package asteroids.program.expressions.booleans.binary;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.booleans.BinaryComposedBooleanExpression;
import asteroids.program.expressions.booleans.ComposedBooleanExpression;
import asteroids.program.types.BooleanType;

public class Disjunction extends BinaryComposedBooleanExpression {

	public Disjunction(int line, int column, Expression lhs, Expression rhs) {
		super(line, column, lhs, rhs);
	}

	@Override
	public BooleanType getType() {
		return new BooleanType((boolean)lhs.getType().getValue() || (boolean)rhs.getType().getValue());
	}

	@Override
	public boolean isTypeCorrect(){
		if (lhs.getType() instanceof BooleanType && rhs.getType() instanceof BooleanType) // for comparisons this method is Overriden.
			return true;
		return false;
	}
	
}
