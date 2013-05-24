package asteroids.program.expression.property;

import asteroids.program.expression.EntityExpression;
import asteroids.program.expression.Expression;
import asteroids.program.expression.PropertyDoubleExpression;
import asteroids.program.types.DoubleType;

public class GetRadius extends PropertyDoubleExpression {
	public GetRadius(int line, int column, EntityExpression e) {
		super(line,column,e);
	}
	
	@Override
	public DoubleType getType() {
		DoubleType radius = new DoubleType(expression.getType().getValue().getRadius());
		return radius;
	}

}
