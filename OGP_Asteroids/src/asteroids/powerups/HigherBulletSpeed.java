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
public class HigherBulletSpeed extends SpaceObject {

	/**
	 * @param x
	 * @param y
	 * @param velocityX
	 * @param velocityY
	 * @param radius
	 * @param minimumRadius
	 */
	public HigherBulletSpeed(double x, double y, double velocityX,
			double velocityY, double radius, double minimumRadius) {
		super(x, y, velocityX, velocityY, radius, minimumRadius);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param radius
	 * @param minimumRadius
	 */
	public HigherBulletSpeed(double radius, double minimumRadius) {
		super(radius, minimumRadius);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public HigherBulletSpeed() {
		// TODO Auto-generated constructor stub
	}

}
