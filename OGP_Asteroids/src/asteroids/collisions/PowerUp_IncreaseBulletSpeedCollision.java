/**
 * 
 */
package asteroids.collisions;

import asteroids.powerups.*;
import asteroids.studentdefined.Ship;

/**
 * A class of increase bullet speed collision inherits from ShipPowerUpCollision
 * and holds a ship and an increase bullet speed powerup.
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */
public class PowerUp_IncreaseBulletSpeedCollision extends ShipPowerUpCollision implements CollisionType {
	
	/**
	 * Initializes the bigger bullet size collision with a given ship and a 
	 * given bigger bullet size powerup.
	 * 
	 * @effect	Initialize this collision with a given ship and given powerup.
	 * 			| super(o1,o2)
	 */
	public PowerUp_IncreaseBulletSpeedCollision(Ship o1, IncreaseBulletSpeedPowerUp o2) {
		super(o1,o2);
	}

	/**
	 * Handle the collision between the ship and the increase bullet speed powerup.
	 * 
	 * @effect	The sourceship of the powerup is set to the ship colliding with it.
	 * 			The powerup is added to the list of active powerups of the ship.
	 * 			| o2.attachToShip(o1);	
	 * @effect	The powerup is activated. The ships bullet speed is increased
	 * 			with its speed factor.
	 * 			| o2.activate()
	 * 			
	 */
	@Override
	public void collide() {
		o2.attachToShip(o1);
		o2.activate();
		
	}

}
