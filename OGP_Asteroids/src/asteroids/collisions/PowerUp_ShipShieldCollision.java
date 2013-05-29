/**
 * 
 */
package asteroids.collisions;

import asteroids.powerups.ShipShieldPowerUp;
import asteroids.studentdefined.Ship;

/**
 * A class of ship shield collision inherits from ShipPowerUpCollision
 * and holds a ship and a ship shield powerup.
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */

public class PowerUp_ShipShieldCollision extends ShipPowerUpCollision {

	/**
	 * Initializes the ship shield collision with a given ship and a 
	 * given  ship shield powerup.
	 * 
	 * @effect	Initialize this collision with a given ship and given powerup.
	 * 			| super(o1,o2)
	 */
	public PowerUp_ShipShieldCollision(Ship o1, ShipShieldPowerUp o2) {
		super(o1,o2);
	}

	/**
	 * Handle the collision between a ship and a ship shield powerup.
	 * @effect	The source ship of the powerup is set to the ship colliding
	 * 			with this one. any associations with the world are broken and
	 * 			a new association is set between the powerup and its source ship.
	 * 			| o2.attachToShip(o1)
	 * @effect	The shield of the ship is increased with 1.
	 * 			| o2.activate()
	 */
	@Override
	public void collide() {
		o2.attachToShip(o1);
		o2.activate();
		
	}

}
