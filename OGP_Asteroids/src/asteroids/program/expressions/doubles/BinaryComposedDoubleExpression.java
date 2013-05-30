package asteroids.program.expressions.doubles;

import asteroids.program.expressions.DoubleExpression;
import asteroids.program.expressions.Expression;
import asteroids.program.types.DoubleType;

public abstract class BinaryComposedDoubleExpression extends ComposedDoubleExpression {
	protected Expression lhs;
	protected Expression rhs;
	public BinaryComposedDoubleExpression(int line, int column, Expression lhs, Expression rhs) {
		super(line,column);
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public abstract DoubleType getType();
	
	@Override
	public boolean isTypeCorrect(){
		if (lhs.getType() instanceof DoubleType && (rhs.getType() instanceof DoubleType)) // lhs and rhs of BinaryComposedDoubleExpression must be of type double.
			return true;
		return false;
	}
}
