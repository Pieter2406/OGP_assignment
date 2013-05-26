package asteroids.program.expressions.doubles.property;

import asteroids.program.expressions.EntityExpression;
import asteroids.program.expressions.Expression;
import asteroids.program.expressions.doubles.PropertyDoubleExpression;
import asteroids.program.types.DoubleType;
import asteroids.program.types.EntityType;

public class GetX extends PropertyDoubleExpression {
	public GetX(int line, int column, Expression e) {
		super(line,column, e);
	}
	
	@Override
	public DoubleType getType() {
		EntityType spaceObject = (EntityType) expression.getType();
		DoubleType xPos = new DoubleType(spaceObject.getValue().getPosition().getX());
		return xPos;
	}

}
