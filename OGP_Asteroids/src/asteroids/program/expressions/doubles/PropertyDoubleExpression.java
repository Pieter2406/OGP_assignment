package asteroids.program.expressions.doubles;

import asteroids.program.expressions.DoubleExpression;
import asteroids.program.expressions.Expression;

public abstract class PropertyDoubleExpression extends DoubleExpression {
	protected Expression expression;
	
	public PropertyDoubleExpression(int line, int column, Expression exp) {
		super(line,column);
		this.expression = exp; 
	}

	

}
