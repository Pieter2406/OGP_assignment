package asteroids.program.expressions.booleans.binary;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.booleans.ComposedBooleanExpression;
import asteroids.program.types.BooleanType;

public class Conjunction extends ComposedBooleanExpression {

	public Conjunction(int line, int column, Expression lhs, Expression rhs) {
		super(line, column,lhs, rhs);
	}

	@Override
	public BooleanType getType() {
		return new BooleanType((boolean) lhs.getType().getValue() && (boolean) rhs.getType().getValue());
		}

}
