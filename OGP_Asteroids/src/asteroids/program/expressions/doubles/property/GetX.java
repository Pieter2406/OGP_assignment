package asteroids.program.expressions.doubles.property;

import asteroids.program.expressions.EntityExpression;
import asteroids.program.expressions.Expression;
import asteroids.program.expressions.doubles.PropertyDoubleExpression;
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
