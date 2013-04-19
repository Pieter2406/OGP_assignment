/**
 * 
 */
package asteroids.collisions;

import asteroids.powerups.SmallerShipPowerUp;
import asteroids.studentdefined.Ship;

/**
 * A class of smaller ship size collision inherits from ShipPowerUpCollision
 * and holds a ship and a smaller ship size powerup.
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

public class PowerUp_SmallerShipCollision extends ShipPowerUpCollision {
	
	/**
	 * Initializes the smaller ship size collision with a given ship and a 
	 * given smaller ship size powerup.
	 * 
	 * @effect	Initialize this collision with a given ship and given powerup.
	 * 			| super(o1,o2)
	 */
	public PowerUp_SmallerShipCollision(Ship o1, SmallerShipPowerUp o2) {
		super(o1,o2);
	}
	
	/**
	 * Handle the collision between a ship and a smaller ship size powerup.
	 * 
	 * @effect	The radius of the ship is set to a new radius smaller than
	 * 			its previous radius.
	 * 			| o1.setRadius(NEW_RADIUS)
	 * @effect 	The powerup is deleted from the world of this ship.
	 * 			| o1.terminate()
	 */

	@Override
	public void collide() {
		o2.terminate();
		o1.setRadius(NEW_RADIUS);
	}
	
	private static final double NEW_RADIUS = 30;
}
