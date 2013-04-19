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
	 * 			factor upto a maximum of 4 times its initial speed. The powerup is terminated and thus
	 * 			deleted out of the world of the ship.
	 * 			| o1.setBulletSpeedMultiplier(o1.getBulletSpeedMultiplier + 1)
	 * 			| o2.terminate()
	 * 			
	 */
	@Override
	public void collide() {
		o2.terminate();
		double speed = 1;
		if(o1.getBulletSpeedMultiplier() < 4){
			speed = o1.getBulletSpeedMultiplier() + 1;
		}
		o1.setBulletSpeedMultiplier(speed);
	}

}
