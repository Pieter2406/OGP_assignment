package asteroids.collisions;

import asteroids.studentdefined.Bullet;

public class BulletBulletCollision implements CollisionType {
	private Bullet o1;
	private Bullet o2;
	
	public BulletBulletCollision(Bullet o1, Bullet o2){
		this.o1 = o1;
		this.o2 = o2;
	}
	
	@Override
	public void collide() {
		o1.terminate();
		o2.terminate();
	}
}