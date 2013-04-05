package asteroids.collisions;

import asteroids.studentdefined.Asteroid;
import asteroids.studentdefined.Bullet;

public class AsteroidBulletCollision implements CollisionType {
	private Asteroid o1;
	private Bullet o2;
	public AsteroidBulletCollision(Asteroid o1, Bullet o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	@Override
	public void collide() {
		o1.terminate();
		o2.terminate();
	}

}
