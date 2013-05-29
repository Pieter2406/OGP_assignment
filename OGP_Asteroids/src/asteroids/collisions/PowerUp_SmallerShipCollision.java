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
	 * @effect	All associations with the powerup and its world are broken and
	 * 			a new association is made with its ship. In other words it is attached
	 * 			to the given ship.
	 * 			| o2.attachToShip(o1);
	 * @effect	The radius of the ship is set to a new radius smaller than
	 * 			its previous radius.
	 * 			| o2.activate
	 */

	@Override
	public void collide() {
		o2.attachToShip(o1);
		o2.activate();
	}
	
}
