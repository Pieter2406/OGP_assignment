package asteroids.program.expression.property;

import asteroids.program.expression.EntityExpression;
import asteroids.program.expression.Expression;
import asteroids.program.expression.PropertyDoubleExpression;
import asteroids.program.types.DoubleType;

public class GetVy extends PropertyDoubleExpression {
	public GetVy(int line, int column, Expression e) {
		super(line,column,(EntityExpression) e);
	}
	
	@Override
	public DoubleType getType() {
		DoubleType velocityY = new DoubleType(expression.getType().getValue().getVelocity().getVelocityY());
		return velocityY;
	}

}
