package asteroids.program.expression;

import asteroids.program.types.DoubleType;
import asteroids.program.types.Type;

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
