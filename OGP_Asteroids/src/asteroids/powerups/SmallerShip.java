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
public class SmallerShip extends SpaceObject {

	/**
	 * @param x
	 * @param y
	 * @param velocityX
	 * @param velocityY
	 * @param radius
	 * @param minimumRadius
	 */
	public SmallerShip(double x, double y, double velocityX, double velocityY,
			double radius, double minimumRadius) {
		super(x, y, velocityX, velocityY, radius, minimumRadius);
	}

	/**
	 * @param radius
	 * @param minimumRadius
	 */
	public SmallerShip(double radius, double minimumRadius) {
		super(radius, minimumRadius);
	}

	/**
	 * 
	 */
	public SmallerShip() {
	}

}
