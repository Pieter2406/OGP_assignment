package asteroids.program.expressions.entities;

import asteroids.program.ProgramContainer;
import asteroids.program.expressions.EntityExpression;
import asteroids.program.types.EntityType;

public class SelfEntityExpression extends EntityExpression {
	public SelfEntityExpression(int line, int column) {
		super(line, column);
		this.type = null;
	}
	@Override
	public EntityType getType(){
		return new EntityType(ProgramContainer.getProgram().getSourceShip());
	}
	



}
