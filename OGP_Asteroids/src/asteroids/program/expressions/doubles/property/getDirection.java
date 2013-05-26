package asteroids.program.expressions.doubles.property;

import asteroids.program.ProgramContainer;
import asteroids.program.expressions.doubles.PropertyDoubleExpression;
import asteroids.program.types.DoubleType;

public class getDirection extends PropertyDoubleExpression {

	public getDirection(int line, int column) {
		super(line, column, null);
	}


	@Override
	public DoubleType getType() {
		return new DoubleType(ProgramContainer.getProgram().getSourceShip().getAngle());
	}

}
