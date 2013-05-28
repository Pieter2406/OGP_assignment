package asteroids.program.types;

import asteroids.program.ProgramContainer;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.SpaceObject;

public class EntityType extends Type<SpaceObject> {

	public EntityType(SpaceObject object) {
		super(object);
	}

	public EntityType() { 
		super(ProgramContainer.getNullShip());
	}
}
