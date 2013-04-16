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
	 * 
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
		else{
			return new NoCollision();
		}
		
	}
}
