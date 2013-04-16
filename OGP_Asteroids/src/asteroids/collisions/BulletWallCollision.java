/**
 * 
 */
package asteroids.collisions;

import asteroids.studentdefined.Bullet;
import asteroids.studentdefined.Wall;

/**
 * @author Pieter
 *
 */
public class BulletWallCollision implements CollisionType {
private Bullet o1;
private Wall o2;
	/**
	 * 
	 */
	public BulletWallCollision(Bullet o1, Wall o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	@Override
	public void collide() {
		o1.terminate();

	}

}
