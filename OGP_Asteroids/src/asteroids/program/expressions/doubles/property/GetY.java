package asteroids.program.expressions.doubles.property;

import asteroids.program.expressions.EntityExpression;
import asteroids.program.expressions.Expression;
import asteroids.program.expressions.doubles.PropertyDoubleExpression;
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
