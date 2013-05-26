package asteroids.program.expressions.doubles.binary;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.doubles.BinaryComposedDoubleExpression;
import asteroids.program.types.DoubleType;

public class Multiplication extends BinaryComposedDoubleExpression {

	public Multiplication(int line, int column, Expression e1, Expression e2) {
		super(line,column,e1,e2);
		this.type = null;
	}

	
	@Override
	public DoubleType getType() {
		type = new DoubleType((double) this.lhs.getType().getValue() * (double) this.rhs.getType().getValue());
		return (DoubleType) type;
	}

}
