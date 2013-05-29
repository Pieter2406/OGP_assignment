package asteroids.program.expressions.doubles;

import asteroids.program.expressions.Expression;
import asteroids.program.types.DoubleType;



public abstract class UnaryComposedDoubleExpression extends ComposedDoubleExpression {
	protected Expression e;
	public UnaryComposedDoubleExpression(int line, int column, Expression e) {
		super(line,column);
		this.e = e;
	}
	
	@Override
	public boolean isTypeCorrect(){
		if (e.getType() instanceof DoubleType) // expressions of UnaryComposedDoubleExpression must all have type double.
			return true;
		return false;
	}

}
