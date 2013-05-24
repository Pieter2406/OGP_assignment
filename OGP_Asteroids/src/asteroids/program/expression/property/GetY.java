package asteroids.program.expression.property;

import asteroids.program.expression.EntityExpression;
import asteroids.program.expression.Expression;
import asteroids.program.expression.PropertyDoubleExpression;
import asteroids.program.types.DoubleType;

public class GetY extends PropertyDoubleExpression {
	public GetY(int line, int column, Expression e) {
		super(line,column,(EntityExpression) e);
	}
	
	@Override
	public DoubleType getType() {
		DoubleType yPos = new DoubleType(expression.getType().getValue().getPosition().getY());
		return yPos;
	}
}