package asteroids.collisions;

import asteroids.studentdefined.Asteroid;
import asteroids.studentdefined.Ship;

public class AsteroidShipCollision implements CollisionType {
	private Asteroid o1;
	private Ship o2;
	public AsteroidShipCollision(Asteroid o1, Ship o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	/* (non-Javadoc)
	 * @see asteroids.collisions.CollisionType#collide()
	 */
	@Override
	public void collide() {
		o2.terminate(); 
	}

}
