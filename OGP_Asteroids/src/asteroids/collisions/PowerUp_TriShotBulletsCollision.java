/**
 * 
 */
package asteroids.collisions;

import asteroids.powerups.TriShotBulletsPowerUp;
import asteroids.studentdefined.Ship;

/**
 * @author Pieter
 *
 */
public class PowerUp_TriShotBulletsCollision implements CollisionType {
private Ship o1;
private TriShotBulletsPowerUp o2;
	/**
	 * 
	 */
	public PowerUp_TriShotBulletsCollision(Ship o1, TriShotBulletsPowerUp o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	
	@Override
	public void collide() {
	o2.terminate();
	o1.toggleTriShotBullets(true);
	}

}
