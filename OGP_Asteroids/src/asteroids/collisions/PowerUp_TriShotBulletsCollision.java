/**
 * 
 */
package asteroids.collisions;

import asteroids.powerups.TriShotBulletsPowerUp;
import asteroids.studentdefined.Ship;

/**
 * A class of tri shot bullets collision inherits from ShipPowerUpCollision
 * and holds a ship and a radius asteroid push powerup.
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */

public class PowerUp_TriShotBulletsCollision extends ShipPowerUpCollision {

	/**
	 * Initializes the radius asteroid push collision with a given ship and a 
	 * given tri shot bullets powerup.
	 * 
	 * @effect	Initialize this collision with a given ship and given powerup.
	 * 			| super(o1,o2)
	 */
	public PowerUp_TriShotBulletsCollision(Ship o1, TriShotBulletsPowerUp o2) {
		super(o1,o2);
	}

	/**
	 * Handle the collision between a ship and a tri shot bullet powerup.
	 * 
	 * @effect	All associations with the powerup and its world are broken and
	 * 			a new association is made with its ship. In other words it is attached
	 * 			to the given ship.
	 * 			| o2.attachToShip(o1);
	 * @effect	Set the flag for triple bullet shots true in ship.
	 * 			|sourceShip.toggleTriShotBullets(true);
	 */
	@Override
	public void collide() {
		o2.attachToShip(o1);
		o2.activate();
	}

}
