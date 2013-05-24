package asteroids.program.expression.property;

import asteroids.program.expression.EntityExpression;
import asteroids.program.expression.Expression;
import asteroids.program.expression.PropertyDoubleExpression;
import asteroids.program.types.DoubleType;

public class GetX extends PropertyDoubleExpression {
	public GetX(int line, int column, Expression e) {
		super(line,column,(EntityExpression) e);
	}
	
	@Override
	public DoubleType getType() {
		DoubleType xPos = new DoubleType(expression.getType().getValue().getPosition().getX());
		return xPos;
	}

}
