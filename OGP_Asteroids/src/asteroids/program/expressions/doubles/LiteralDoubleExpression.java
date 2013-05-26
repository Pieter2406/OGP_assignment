package asteroids.program.expressions.doubles;

import asteroids.program.expressions.DoubleExpression;
import asteroids.program.types.DoubleType;

public class LiteralDoubleExpression extends DoubleExpression {
	public LiteralDoubleExpression(int line, int column, double d) {
		super(line,column);
		this.type = new DoubleType(d);
	}

	@Override
	public DoubleType getType() {
		return (DoubleType) this.type;
	}
}
