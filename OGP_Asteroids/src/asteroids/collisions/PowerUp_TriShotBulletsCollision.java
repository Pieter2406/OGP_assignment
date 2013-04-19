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
	 * @effect	Set the flag for triple bullet shots true in ship.
	 * 			|o1.toggleTriShotBullets(true);
	 * @effect	Terminate the powerup and thus delete it from the world
	 * 			of the ship.
	 */
	@Override
	public void collide() {
	o2.terminate();
	o1.toggleTriShotBullets(true);
	}

}
