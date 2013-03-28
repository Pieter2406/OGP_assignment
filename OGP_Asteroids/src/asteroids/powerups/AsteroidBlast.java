/**
 * 
 */
package asteroids.powerups;

import asteroids.studentdefined.SpaceObject;

/**
 * 
 * @version 1.1
 * 
 * @author Kristof Bruyninckx
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 * 
 */
public class AsteroidBlast extends SpaceObject {

	/**
	 * @param x
	 * @param y
	 * @param velocityX
	 * @param velocityY
	 * @param radius
	 * @param minimumRadius
	 */
	public AsteroidBlast(double x, double y, double velocityX,
			double velocityY, double radius, double minimumRadius, double mass) {
		super(x, y, velocityX, velocityY, radius, minimumRadius, mass);
	}

	/**
	 * @param radius
	 * @param minimumRadius
	 * @param mass
	 */
	public AsteroidBlast(double radius, double minimumRadius, double mass) {
		super(radius, minimumRadius, mass);
	}

	/**
	 * 
	 */
	public AsteroidBlast() {}

}
