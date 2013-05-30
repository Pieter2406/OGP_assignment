package asteroids.program.expressions.doubles.property;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.doubles.PropertyDoubleExpression;
import asteroids.program.types.DoubleType;
import asteroids.program.types.EntityType;

public class GetVy extends PropertyDoubleExpression {
	public GetVy(int line, int column, Expression e) {
		super(line,column,e);
	}
	
	@Override
	public DoubleType getType() {
		EntityType spaceObject = (EntityType) expression.getType();
		DoubleType velocityY = new DoubleType(spaceObject.getValue().getVelocity().getVelocityY());
		return velocityY;
	}
	
	@Override
	public String toString() {
		return "Get y velocity property [expression=" + expression + "]";
	}
}
