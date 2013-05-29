package asteroids.program.expressions;

import asteroids.program.ProgramContainer;
import asteroids.program.types.EntityType;
import asteroids.program.types.Type;
import asteroids.studentdefined.Ship;

public class NullExpression extends Expression {

	public NullExpression(int line, int column) {
		super(line, column);
		this.type = new EntityType(ProgramContainer.getNullShip());
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public boolean isTypeCorrect() {
		return true; // always type correct.
	}

}
