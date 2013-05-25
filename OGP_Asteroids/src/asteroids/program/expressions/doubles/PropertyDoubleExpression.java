package asteroids.program.expressions.doubles;

import asteroids.program.expressions.DoubleExpression;
import asteroids.program.expressions.EntityExpression;

public abstract class PropertyDoubleExpression extends DoubleExpression {
	protected EntityExpression expression;
	
	public PropertyDoubleExpression(int line, int column, EntityExpression exp) {
		super(line,column);
		this.expression = exp; 
	}

	

}
