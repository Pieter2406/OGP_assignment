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
	 * @post	The speed of the bullets, fired by the ship, is increased with a
	 * 			factor upto a maximum of 4 times its initial speed. 
	 * 			| o1.setBulletSpeedMultiplier(o1.getBulletSpeedMultiplier + 1)
	 * 	@effect The powerup is terminated and thus deleted out of the world of the ship.
	 * 			| o2.terminate()
	 * 			
	 */
	@Override
	public void collide() {
		o2.terminate();
		double speed;
		if(o1.getBulletSpeedMultiplier() < 4){
			speed = o1.getBulletSpeedMultiplier() + 1;
		}
		else
			speed = 4;
		o1.setBulletSpeedMultiplier(speed);
	}

}
