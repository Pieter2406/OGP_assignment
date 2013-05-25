package asteroids.program.expressions.doubles.property;

import asteroids.program.expressions.EntityExpression;
import asteroids.program.expressions.Expression;
import asteroids.program.expressions.doubles.PropertyDoubleExpression;
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
