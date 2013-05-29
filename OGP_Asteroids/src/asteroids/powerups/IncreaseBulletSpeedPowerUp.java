/**
 * 
 */
package asteroids.powerups;

import asteroids.studentdefined.PowerUp;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.World;

/**
 * A class of increase bullet speed powerup holds an object in the world
 * that powerups the ship. It extends from the superclass PowerUp.
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */

public class IncreaseBulletSpeedPowerUp extends PowerUp {
	public final static int TYPE = 2;
	public final static long MAXIMUM_LIFE_TIME = 5000;
	public final static long SPEED_FACTOR = 1;
	public final static long MAX_SPEED = 4;
	/**
	 * @param 	x
	 * 			The x coordinate of this powerup in the world.
	 * @param 	y
	 * 			The u coordinate of this powerup in the world.
	 * @param	world
	 * 			The world where this powerup is effective.
	 * @param	sourceShip
	 * 			The ship where this powerup is active.
	 * @effect	The powerup is initialized with
	 * 			an x coordinate, an y coordinate, a default radius,
	 * 			0 velocity, a world and a source ship.
	 * 
	 */
	public IncreaseBulletSpeedPowerUp(double x, double y, World world, Ship sourceShip) {
		super(x, y, world, TYPE, sourceShip);
	}

	@Override
	protected boolean hasPassedActiveLifeTime() {
		return (this.getActiveLifeTime() > MAXIMUM_LIFE_TIME);
	}

	/**
	 * Activates this powerups effects on the source ship.
	 * The speed of the bullets of the sourceship will increase with a certainfactor.
	 * @effect	The speed of the bullets that the ship fires are speedup with a factor
	 * 			upto a maximum of 4 times its initial speed.
	 * 			| sourceShip.setBulletSpeedMultiplier(sourceShip.getBulletSpeedMultiplier() + 1)
	 * @effect	The active live time of this powerup is set to the current system time.
	 * 			|this.setActiveLiveTime();
	 */
	@Override
	public void activate() {
		this.setActiveLifeTime();
		double speed;
		if(sourceShip.getBulletSpeedMultiplier() < MAX_SPEED){
			speed = sourceShip.getBulletSpeedMultiplier() + SPEED_FACTOR;
		}
		else
			speed = MAX_SPEED;
		sourceShip.setBulletSpeedMultiplier(speed);
		
	}
	
	/**
	 * Evaluates this powerups lifetime and removes its effects on the source ship if the lifetime is passed.
	 * The bullets from the sourceship will decrease in speed with the speed factor and this object
	 * is totaly terminated.
	 * @post	If the life time is passed, the bullet speed is decreased with its speed factor.
	 * 			| if(hasPassedLifeTime)
	 * 			|	sourceShip.setBulletSpeedMultiplier(sourceShip.getBulletSpeedMultiplier() - SPEED_FACTOR)
	 * 			|   this.terminate();
	 */
	@Override
	public void evaluate() {
		if(hasPassedActiveLifeTime()){
			double speed = sourceShip.getBulletSpeedMultiplier();
			sourceShip.setBulletSpeedMultiplier(speed - SPEED_FACTOR);
			this.terminate();
		}
	}

}
