package asteroids.collisions;

import asteroids.studentdefined.Bullet;
import asteroids.studentdefined.Ship;

public class ShipBulletCollision implements CollisionType {
	private Ship o1;
	private Bullet o2;
	public ShipBulletCollision(Ship o1, Bullet o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	@Override
	public void collide() {
		o1.terminate();
		o2.terminate();
	}

}
