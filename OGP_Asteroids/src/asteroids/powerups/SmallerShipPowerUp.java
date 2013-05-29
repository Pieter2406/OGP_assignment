/**
 * 
 */
package asteroids.powerups;

import asteroids.studentdefined.PowerUp;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.World;

/**
 * A class of smaller ship powerup holds an object in the world
 * that powerups the ship. It extends from the superclass PowerUp.
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */

public class SmallerShipPowerUp extends PowerUp {
	private final static int TYPE = 4;
	public final static int NEW_RADIUS = 30;
	public final static int DEFAULT_RADIUS = 40;
	public final static double DEFAULT_MASS = 5E15;
	public final static double NEW_MASS = DEFAULT_MASS * (NEW_RADIUS/DEFAULT_RADIUS);
	public final static long MAXIMUM_LIFE_TIME = 10000;
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
	public SmallerShipPowerUp(double x, double y, World world, Ship sourceShip) {
		super(x, y, world, TYPE, sourceShip);
	}
	
	@Override
	public boolean hasPassedActiveLifeTime() {
		return(this.getActiveLifeTime() > MAXIMUM_LIFE_TIME);
	}
	/**
	 * Activates this powerups effect on the source ship.
	 * The source ship will get smaller @Deprecated(and it's Mass is lowered).
	 * @effect	The radius of the ship is set to a new radius smaller than
	 * 			its previous radius.
	 * 			| o1.setRadius(NEW_RADIUS)
	 * @effect 	The active life time of this powerup is set to the current system time.
	 * 			| this.setActiveLifeTime()
	 */
	@Override
	public void activate() {
		this.setActiveLifeTime();
		sourceShip.setPendingVelocityChange(true);
		sourceShip.setRadius(NEW_RADIUS);
		//sourceShip.setMass(NEW_MASS); gives error in collision
	}
	
	/**
	 * Evaluates the lifetime of this powerup. If it is exceeded, the ships
	 * radius will be set back to default radius.
	 * @post	If the lifetime is exceeded the radius of the soure ship
	 * 			is set back to its default radius and this powerup is
	 * 			terminated.
	 * 			| if(hasPassedLifeTime()
	 * 			|	sourceShip.setRadius(DEFAULT_RADIUS)
	 * 			|	this.terminate
	 */
	@Override
	public void evaluate() {
		if(hasPassedActiveLifeTime()){
			sourceShip.setRadius(DEFAULT_RADIUS);
			sourceShip.setMass(DEFAULT_MASS);
			this.terminate();
		}
	}

}
