/**
 * 
 */
package asteroids.collisions;

import asteroids.powerups.*;
import asteroids.studentdefined.PowerUp;
import asteroids.studentdefined.Ship;

/**
 * @author Pieter
 *
 */
public class ShipPowerUpCollision implements CollisionType {
	private Ship o1;
	private PowerUp o2;
	/**
	 * 
	 */
	public ShipPowerUpCollision(Ship o1, PowerUp o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	@Override
	public void collide() {
		CollisionType powerUpCollision = PowerUpFactory.collide(o1, o2);
		powerUpCollision.collide();
	}

}
