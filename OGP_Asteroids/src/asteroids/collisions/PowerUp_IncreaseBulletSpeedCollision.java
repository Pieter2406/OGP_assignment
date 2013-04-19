/**
 * 
 */
package asteroids.collisions;

import asteroids.powerups.*;
import asteroids.studentdefined.Ship;

/**
 * @author Pieter
 *
 */
public class PowerUp_IncreaseBulletSpeedCollision implements CollisionType {
	private Ship o1;
	private IncreaseBulletSpeedPowerUp o2;
	/**
	 * 
	 */
	public PowerUp_IncreaseBulletSpeedCollision(Ship o1, IncreaseBulletSpeedPowerUp o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	@Override
	public void collide() {
		o2.terminate();
		double speed;
		if(o1.getBulletSpeedMultiplier() < 4){
			speed = o1.getBulletSpeedMultiplier() + 1;
		}
		else
			speed = 4;
		o1.setBulletSpeedMultiplier(speed);
	}

}
