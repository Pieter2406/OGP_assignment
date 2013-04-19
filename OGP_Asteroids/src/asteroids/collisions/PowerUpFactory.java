/**
 * 
 */
package asteroids.collisions;

import asteroids.powerups.*;
import asteroids.studentdefined.PowerUp;
import asteroids.studentdefined.Ship;


/**
 * A PowerUpFactory handles all the collisions between PowerUps and Ships.
 * @version 1.1
 * 
 * @author Kristof Bruynincks
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 */
public final class PowerUpFactory {

	/**
	 * This factory produces a powerup type relative to the given objects.
	 * 
	 * @param 	o1
	 * 			The first object that is given.
	 * @param 	o2
	 * 			The second object that is given.
	 * 
	 * @return	a powerup type relative to the two given objects, in other
	 * 			words an object of ObjectObjectCollision. 
	 * 			|  if (o1 instanceof Ship && o2 instanceof Object)
	 * 			|		result == PowerUp_poweruptypeCollision
	 */
	public static CollisionType collide(Object o1, PowerUp o2){
		if(o1 instanceof Ship && o2 instanceof SmallerShipPowerUp){
			return new PowerUp_SmallerShipCollision((Ship)o1,(SmallerShipPowerUp)o2);
		}
		
		if(o1 instanceof Ship && o2 instanceof IncreaseBulletSpeedPowerUp){
			return new PowerUp_IncreaseBulletSpeedCollision((Ship)o1,(IncreaseBulletSpeedPowerUp)o2);
		}
		
		if(o1 instanceof Ship && o2 instanceof BiggerBulletSizePowerUp){
			return new PowerUp_BiggerBulletSizeCollision((Ship)o1,(BiggerBulletSizePowerUp)o2);
		}
		if(o1 instanceof Ship && o2 instanceof TriShotBulletsPowerUp){
			return new PowerUp_TriShotBulletsCollision((Ship)o1, (TriShotBulletsPowerUp)o2);
		}
		if(o1 instanceof Ship && o2 instanceof ShipShieldPowerUp){
			return new PowerUp_ShipShieldCollision((Ship)o1, (ShipShieldPowerUp)o2);
		}
		if(o1 instanceof Ship && o2 instanceof RadiusAsteroidPushPowerUp){
			return new PowerUp_RadiusAsteroidPushCollision((Ship)o1, (RadiusAsteroidPushPowerUp)o2);
		}
		else{
			return new NoCollision();
		}
		
	}
}
