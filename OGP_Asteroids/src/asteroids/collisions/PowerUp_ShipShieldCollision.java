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
 * @invar	The collision is always between a Ship and a powerup. The first object needs to be a Ship
 * 			and the second object needs to be a powerup.
 * 			| Ship.isValidShip(getO1())
 * 			| Ship.isValidPowerUp(getO2())
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
	 * 
	 * @effect	The powerup is terminated.
	 * 			| o2.terminated()
	 * @effect	The shield of the ship is increased with 1.
	 * 			| o1.incShield()
	 */
	@Override
	public void collide() {
		o1.incShield();
		o2.terminate();
		
	}

}
