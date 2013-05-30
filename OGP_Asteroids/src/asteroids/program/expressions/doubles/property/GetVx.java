package asteroids.program.expressions.doubles.property;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.doubles.PropertyDoubleExpression;
import asteroids.program.types.DoubleType;
import asteroids.program.types.EntityType;

public class GetVx extends PropertyDoubleExpression {
	public GetVx(int line, int column, Expression e) {
		super(line,column, e);
	}
	
	@Override
	public DoubleType getType() {
		EntityType spaceObject = (EntityType) expression.getType();
		DoubleType velocityX = new DoubleType(spaceObject.getValue().getVelocity().getVelocityX());
		return velocityX;
	}
	
	@Override
	public String toString() {
		return "Get x velocity property [expression=" + expression + "]";
	}
}
