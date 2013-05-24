package asteroids.program.expression;

public abstract class PropertyDoubleExpression extends DoubleExpression {
	protected EntityExpression expression;
	
	public PropertyDoubleExpression(int line, int column, EntityExpression exp) {
		super(line,column);
		this.expression = exp; 
	}

	

}
