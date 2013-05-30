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
		this.type = new DoubleType(ProgramContainer.getProgram().getSourceShip().getAngle());
		return (DoubleType) type;
	}


	@Override
	public String toString() {
		return "Get direction property of the source ship";
	}
	
}
