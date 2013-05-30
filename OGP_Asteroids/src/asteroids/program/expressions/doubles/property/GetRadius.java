package asteroids.program.expressions.doubles.property;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.doubles.PropertyDoubleExpression;
import asteroids.program.types.DoubleType;
import asteroids.program.types.EntityType;

public class GetRadius extends PropertyDoubleExpression {
	public GetRadius(int line, int column, Expression e) {
		super(line,column,e);
	}
	
	@Override
	public DoubleType getType() {
		EntityType spaceObject = (EntityType) expression.getType();
		DoubleType radius = new DoubleType(spaceObject.getValue().getRadius());
		return radius;
	}

	@Override
	public String toString() {
		return "Get radius property [expression=" + expression + "]";
	}
}
