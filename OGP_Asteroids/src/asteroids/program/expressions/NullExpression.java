package asteroids.program.expressions;

import asteroids.program.ProgramContainer;
import asteroids.program.types.EntityType;
import asteroids.program.types.Type;
import asteroids.studentdefined.Ship;

public class NullExpression extends Expression {

	public NullExpression(int line, int column) {
		super(line, column);
		
	}

	@Override
	public Type getType() {
		this.type = new EntityType(ProgramContainer.getNullShip());
		return type;
	}

}
