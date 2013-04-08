/**
 * 
 */
package asteroids.powerups;

import asteroids.studentdefined.SpaceObject;
import asteroids.studentdefined.World;

/**
 * Abstract class that holds methods and function for PowerUps and 
 * inherits from SpaceObject
 * @author Kristof Bruyninckx
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 * @version 1.1
 * TODO: Write PowerUp class
 */
public abstract class PowerUp extends SpaceObject {

	/**
	 * @param x
	 * @param y
	 * @param velocityX
	 * @param velocityY
	 * @param radius
	 * @param minimumRadius
	 * @param mass
	 * @param world
	 */
	public PowerUp(double x, double y, double velocityX, double velocityY,
			double radius, double minimumRadius, double mass, World world) {
		super(x, y, velocityX, velocityY, radius, minimumRadius, mass, world);
	}

	/**
	 * @param x
	 * @param y
	 * @param radius
	 * @param mass
	 * @param world
	 */
	public PowerUp(double x, double y, double radius, double mass, World world) {
		super(x, y, radius, mass, world);
	}

	/**
	 * @param radius
	 * @param minimumRadius
	 * @param mass
	 * @param world
	 */
	public PowerUp(double radius, double minimumRadius, double mass, World world) {
		super(radius, minimumRadius, mass, world);
	}

	/**
	 * 
	 */
	public PowerUp() {
	}

}
