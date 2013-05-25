package asteroids.program.expressions.doubles.property;

import asteroids.program.expressions.EntityExpression;
import asteroids.program.expressions.Expression;
import asteroids.program.expressions.doubles.PropertyDoubleExpression;
import asteroids.program.types.DoubleType;

public class GetVx extends PropertyDoubleExpression {
	public GetVx(int line, int column, Expression e) {
		super(line,column,(EntityExpression) e);
	}
	
	@Override
	public DoubleType getType() {
		DoubleType velocityX = new DoubleType(expression.getType().getValue().getVelocity().getVelocityX());
		return velocityX;
	}

}
