package asteroids.program.types;

import asteroids.studentdefined.SpaceObject;

public class EntityType extends Type<SpaceObject> {

	public EntityType(SpaceObject object) {
		this.value = object;
	}

	public EntityType() {
	}
}
