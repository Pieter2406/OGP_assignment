/**
 * 
 */
package asteroids.collisions;

import asteroids.powerups.ShipShieldPowerUp;
import asteroids.studentdefined.Ship;

/**
 * @author Pieter
 *
 */
public class PowerUp_ShipShieldCollision implements CollisionType {

	private Ship o1;
	private ShipShieldPowerUp o2;
	/**
	 * 
	 */
	public PowerUp_ShipShieldCollision(Ship o1, ShipShieldPowerUp o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	
	@Override
	public void collide() {
		o1.incShield();
		o2.terminate();
		
	}

}
