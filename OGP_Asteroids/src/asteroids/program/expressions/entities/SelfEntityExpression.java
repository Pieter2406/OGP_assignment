package asteroids.program.expressions.entities;

import asteroids.program.ProgramContainer;
import asteroids.program.expressions.EntityExpression;
import asteroids.program.types.EntityType;

public class SelfEntityExpression extends EntityExpression {
	public SelfEntityExpression(int line, int column) {
		super(line, column, null);
	}
	@Override
	public EntityType getType(){
		type = new EntityType(ProgramContainer.getProgram().getSourceShip());
		return (EntityType) type;
	}
	
	@Override
	public String toString() {
		return "Return this ship as entity";
	}
}
