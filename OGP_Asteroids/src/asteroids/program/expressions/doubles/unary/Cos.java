package asteroids.program.expressions.doubles.unary;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.doubles.UnaryComposedDoubleExpression;
import asteroids.program.types.DoubleType;

public class Cos extends UnaryComposedDoubleExpression {
	
	public Cos(int line, int column, Expression e) {
		super(line,column, e);
	}

	@Override
	public DoubleType getType() {
		return new DoubleType(Math.cos((double)e.getType().getValue()));
	}
	
	@Override
	public String toString() {
		return "Get cosine [expression=" + e + "]";
	}

}
