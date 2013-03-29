/**
 * 
 */
package asteroids.powerups;

import asteroids.studentdefined.SpaceObject;

/**
 * @author Pieter
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
	 * @param mass
	 */
	public HigherBulletSpeed(double x, double y, double velocityX,
			double velocityY, double radius, double minimumRadius, double mass) {
		super(x, y, velocityX, velocityY, radius, minimumRadius, mass);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param radius
	 * @param minimumRadius
	 * @param mass
	 */
	public HigherBulletSpeed(double radius, double minimumRadius, double mass) {
		super(radius, minimumRadius, mass);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public HigherBulletSpeed() {
		// TODO Auto-generated constructor stub
	}

}
