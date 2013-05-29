/**
 * 
 */
package asteroids.powerups;

import asteroids.studentdefined.PowerUp;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.World;

/**
 * A class of bigger bullet size powerup holds an object in the world
 * that powerups the ship. It extends from the superclass PowerUp.
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */
public class BiggerBulletSizePowerUp extends PowerUp {
public static final int TYPE = 3;
public static final long MAXIMUM_LIFE_TIME = 10000;
public static final int GROWTH_FACTOR = 1;
public static final int MAX_FACTOR = 4;
	/**
	 * @param 	x
	 * 			The x coordinate of this powerup in the world.
	 * @param 	y
	 * 			The u coordinate of this powerup in the world.
	 * @param	world
	 * 			The world where this powerup is effective.
	 * @param	sourceShip
	 * 			The ship where this powerup is active.
	 * @effect	The bigger bullet size powerup is initialized with
	 * 			an x coordinate, an y coordinate, a default radius,
	 * 			0 velocity, a world and a source ship.
	 * 
	 */
	public BiggerBulletSizePowerUp(double x, double y, World world, Ship sourceShip) {
		super(x, y, world, TYPE, sourceShip);
	}

	@Override
	public boolean hasPassedActiveLifeTime() {
		return (this.getActiveLifeTime() > MAXIMUM_LIFE_TIME);
	}

	/**
	 * Activates this powerups effects on the source ship.
	 * The bullets from the sourceship will increase in length with a certainfactor.
	 * @effect	The scale of the bullets that the ship fires are scaled with a factor
	 * 			upto a maximum of 4 times its initial size.
	 * 			| sourceShip.setBulletScaleMultiplier(sourceShip.getBulletScaleMultiplier() + 1)
	 * @effect	The active life time of this powerup is set to the current system time.
	 * 			|this.setActiveLifeTime();
	 */
	@Override
	public void activate() {
		this.setActiveLifeTime();
		double scale;
		if(sourceShip.getBulletScaleMultiplier() < MAX_FACTOR){
			scale = sourceShip.getBulletScaleMultiplier() + GROWTH_FACTOR;
		}else{
			scale = sourceShip.getBulletScaleMultiplier();
		}
		sourceShip.setBulletScaleMultiplier(scale);
		
	}

	/**
	 * Evaluates this powerups lifetime and removes its effects on the source ship if the lifetime is passed.
	 * The bullets from the sourceship will decrease in length with the growth factor.
	 * @post	If the life time is passed, the bullet scale is decreased with its growth factor.
	 * 			| if(hasPassedLifeTime)
	 * 			|	sourceShip.setBulletScaleMultiplier(sourceShip.getBulletScaleMultiplier() - GROWTH_FACTOR)
	 */
	@Override
	public void evaluate() {
		if(hasPassedActiveLifeTime()){
			double scale = sourceShip.getBulletScaleMultiplier();
			sourceShip.setBulletScaleMultiplier(scale - GROWTH_FACTOR);
			this.terminate();
		}		
	}


}
