package asteroids.program.expressions.booleans.binary;

import asteroids.program.expressions.DoubleExpression;
import asteroids.program.expressions.Expression;
import asteroids.program.expressions.VariableExpression;
import asteroids.program.expressions.booleans.ComposedBooleanExpression;
import asteroids.program.types.BooleanType;
import asteroids.program.types.DoubleType;

public class LessThan extends ComposedBooleanExpression {

	public LessThan(int line, int column, Expression lhs, Expression rhs) {
		super(line, column, lhs, rhs);
		this.type = null;
		
	}
	@Override
	public BooleanType getType() {
		return new BooleanType((double)lhs.getType().getValue() < (double) rhs.getType().getValue());
	}

}
