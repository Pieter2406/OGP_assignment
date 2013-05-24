package asteroids.program.expression;

import asteroids.program.types.EntityType;
import asteroids.studentdefined.SpaceObject;

public class SelfEntityExpression extends EntityExpression {

	public SelfEntityExpression(int line, int column) {
		super(line, column);
		
	}
	@Override
	public EntityType getType(){
		return (EntityType) type;
	}
	
	public void setEntity(SpaceObject object){
		this.type = new EntityType(object);
	}


}
