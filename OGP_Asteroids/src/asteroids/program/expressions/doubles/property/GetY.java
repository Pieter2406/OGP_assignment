package asteroids.program.expressions.doubles.property;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.doubles.PropertyDoubleExpression;
import asteroids.program.types.DoubleType;
import asteroids.program.types.EntityType;

public class GetY extends PropertyDoubleExpression {
	public GetY(int line, int column, Expression e) {
		super(line,column, e);
	}
	
	@Override
	public DoubleType getType() {
		EntityType spaceObject = (EntityType) expression.getType();
		DoubleType yPos = new DoubleType(spaceObject.getValue().getPosition().getY());
		return yPos;
	}
	@Override
	public String toString() {
		return "Get y position property [expression=" + expression + "]";
	}
}
