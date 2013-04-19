/**
 * 
 */
package asteroids.collisions;

import asteroids.powerups.BiggerBulletSizePowerUp;
import asteroids.studentdefined.Ship;

/**
 * A class of bigger bullet size collision inherits from ShipPowerUpCollision
 * and holds a ship and a bigger bullet size powerup.
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

public class PowerUp_BiggerBulletSizeCollision extends ShipPowerUpCollision{
	
	/**
	 * Initializes the bigger bullet size collision with a given ship and a 
	 * given bigger bullet size powerup.
	 * 
	 * @effect	Initialize this collision with a given ship and given powerup.
	 * 			| super(o1,o2)
	 */
	public PowerUp_BiggerBulletSizeCollision(Ship o1, BiggerBulletSizePowerUp o2) {
		super(o1,o2);
	}
	
	/**
	 * Handle the collision between a ship and a bigger bullet size powerup.
	 * 
	 * @post	The scale of the bullets that the ship fires are scaled with a factor
	 * 			upto a maximum of 4 times its initial size. The powerup is terminated and thus
	 * 			deleted out of the world of the ship.
	 * 			| o1.setBulletScaleMultiplier(o1.getBulletScaleMultiplier() + 1)
	 * 			| o2.terminate()
	 */
	@Override
	public void collide() {
		double scale;
		if(o1.getBulletScaleMultiplier() < 4){
			scale = o1.getBulletScaleMultiplier() + 1;
		}else{
			scale = o1.getBulletScaleMultiplier();
		}
		o1.setBulletScaleMultiplier(scale);
		o2.terminate();
	}

}

