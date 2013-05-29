/**
 * 
 */
package asteroids.powerups;

import asteroids.studentdefined.PowerUp;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.World;

/**
 * A class of tri shot bullets powerup holds an object in the world
 * that powerups the ship. It extends from the superclass PowerUp.
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */

public class TriShotBulletsPowerUp extends PowerUp {
	public final static int TYPE = 0;
	public final static long MAXIMUM_LIFE_TIME = 5000;
	/**
	 * @param 	x
	 * 			The x coordinate of this powerup in the world.
	 * @param 	y
	 * 			The u coordinate of this powerup in the world.
	 * @param	world
	 * 			The world where this powerup is effective.
	 * @param	sourceShip
	 * 			The ship where this powerup is active
	 * @effect	The powerup is initialized with
	 * 			an x coordinate, an y coordinate, a default radius,
	 * 			0 velocity, a world and a sourceShip.
	 * 
	 */
	public TriShotBulletsPowerUp(double x, double y, World world, Ship sourceShip) {
		super(x, y, world, TYPE, sourceShip);
	}
	
	@Override
	protected boolean hasPassedActiveLifeTime() {
		return (this.getActiveLifeTime() > MAXIMUM_LIFE_TIME);
	}
	/**
	 * Activates the powerup on the source ship. The source ship
	 * will fire three bullets moving away in a certain angle from the 
	 * original bullet.
	 * @effect	The source ship fires three bullets in stead of one.
	 * 			|sourceShip.toggleTriShotBullets(true);
	 * @effect	The active life time of this powerup is set to the current system time.
	 * 			|this.setActiveLifeTime()
	 */
	@Override
	public void activate() {
		this.setActiveLifeTime();
		sourceShip.toggleTriShotBullets(true);
	}
	/**
	 * Evaluates this powerups lifetime. If it exceeds the maximum life time
	 * of this powerup, if will be deactivated and removed.
	 */
	@Override
	public void evaluate() {
		if(hasPassedActiveLifeTime()){
			sourceShip.toggleTriShotBullets(false);
			this.terminate();
		}
	}

}
