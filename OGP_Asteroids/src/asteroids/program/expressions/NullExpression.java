package asteroids.program.expressions;

import asteroids.program.ProgramContainer;
import asteroids.program.types.EntityType;
import asteroids.program.types.Type;
import asteroids.studentdefined.Ship;

public class NullExpression extends EntityExpression { // special sort of entity expression, null is only valid for entities

	public NullExpression(int line, int column) {
		super(line, column, null);
		this.type = new EntityType(ProgramContainer.getNullShip());
	}

	@Override
	public EntityType getType() {
		return (EntityType)type;
	}

	@Override
	public boolean isTypeCorrect() {
		return true; // always type correct.
	}

	@Override
	public String toString() {
		return "Null";
	}
}
