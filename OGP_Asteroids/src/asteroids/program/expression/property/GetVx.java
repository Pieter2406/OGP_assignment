package asteroids.program.expression.property;

import asteroids.program.expression.EntityExpression;
import asteroids.program.expression.Expression;
import asteroids.program.expression.PropertyDoubleExpression;
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
