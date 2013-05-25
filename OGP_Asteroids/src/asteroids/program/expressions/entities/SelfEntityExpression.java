package asteroids.program.expressions.entities;

import asteroids.program.ProgramConstructor;
import asteroids.program.expressions.EntityExpression;
import asteroids.program.types.EntityType;
import asteroids.studentdefined.Program;
import asteroids.studentdefined.SpaceObject;

public class SelfEntityExpression extends EntityExpression {
	public SelfEntityExpression(int line, int column) {
		super(line, column);
		this.type = null;
	}
	@Override
	public EntityType getType(){
		return new EntityType(Program.getSourceShip());
	}
	



}
