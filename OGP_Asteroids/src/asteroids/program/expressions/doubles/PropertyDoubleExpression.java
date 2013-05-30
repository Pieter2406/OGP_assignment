package asteroids.program.expressions.doubles;

import asteroids.program.expressions.DoubleExpression;
import asteroids.program.expressions.Expression;
import asteroids.program.types.DoubleType;
import asteroids.program.types.EntityType;

public abstract class PropertyDoubleExpression extends DoubleExpression {
	protected Expression expression;
	
	public PropertyDoubleExpression(int line, int column, Expression exp) {
		super(line,column);
		this.expression = exp;
	}

	@Override
	public abstract DoubleType getType();

	@Override
	public boolean isTypeCorrect(){
		if (expression == null || expression.getType() instanceof EntityType) // expression == null --> type == entity (Entities are the only expression that contain null).
			return true;
		return false;
	}
}
