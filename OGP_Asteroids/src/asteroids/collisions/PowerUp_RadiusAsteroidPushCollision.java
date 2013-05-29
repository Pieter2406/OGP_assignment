/**
 * 
 */
package asteroids.collisions;

import asteroids.powerups.RadiusAsteroidPushPowerUp;
import asteroids.studentdefined.Asteroid;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Velocity;

/**
 * A class of radius asteroid push collision inherits from ShipPowerUpCollision
 * and holds a ship and a radius asteroid push powerup.
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */
public class PowerUp_RadiusAsteroidPushCollision extends ShipPowerUpCollision  {

	/**
	 * Initializes the radius asteroid push collision with a given ship and a 
	 * given radius asteroid push powerup.
	 * 
	 * @effect	Initialize this collision with a given ship and given powerup.
	 * 			| super(o1,o2)
	 */
	public PowerUp_RadiusAsteroidPushCollision(Ship o1, RadiusAsteroidPushPowerUp o2) {
		super(o1,o2);
	}

	/**
	 * Handle the collision between a ship and a radius asteroid push powerup.
	 * 
	 * @effect	The sourceship of the powerup is set to the ship colliding with it.
	 * 			The powerup is added to the list of active powerups of the ship.
	 * 			| o2.attachToShip(o1);	
	 * @effect	The powerup is activated. All asteroids in a certain radius away from the
	 * 			powerup are pushed away from it.	
	 * 			| o2.activate()
	 */
	@Override
	public void collide() {
		o2.attachToShip(o1);
		o2.activate();
	}

}
