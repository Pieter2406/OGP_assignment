/**
 * 
 */
package asteroids.collisions;

import asteroids.powerups.BiggerBulletSizePowerUp;
import asteroids.studentdefined.Ship;

/**
 * A class of bigger bullet size collision inherits from ShipPowerUpCollision
 * and holds a ship and a bigger bullet size powerup.
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */

public class PowerUp_BiggerBulletSizeCollision extends ShipPowerUpCollision{
	
	/**
	 * Initializes the bigger bullet size collision with a given ship and a 
	 * given bigger bullet size powerup.
	 * 
	 * @effect	Initialize this collision with a given ship and given powerup.
	 * 			| super(o1,o2)
	 */
	public PowerUp_BiggerBulletSizeCollision(Ship o1, BiggerBulletSizePowerUp o2) {
		super(o1,o2);
	}
	
	/**
	 * Handle the collision between a ship and a bigger bullet size powerup.
	 * @effect	The sourceship of the powerup is set to the ship colliding with it.
	 * 			The powerup is added to the list of active powerups of the ship.
	 * 			Associations with the world of the powerup are broken.
	 * 			| o2.attachToShip(o1);	
	 * @effect	The powerup is activated. The ships bullet scale is increased
	 * 			with its growth factor.
	 * 			| o2.activate()
	 */
	@Override
	public void collide() {
		o2.attachToShip(o1);
		o2.activate();
	}

}

