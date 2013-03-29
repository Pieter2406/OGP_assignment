/**
 * 
 */
package asteroids.powerups;

import asteroids.studentdefined.SpaceObject;

/**
 * @author Pieter
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
	 * @param mass
	 */
	public SmallerShip(double x, double y, double velocityX, double velocityY,
			double radius, double minimumRadius, double mass) {
		super(x, y, velocityX, velocityY, radius, minimumRadius, mass);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param radius
	 * @param minimumRadius
	 * @param mass
	 */
	public SmallerShip(double radius, double minimumRadius, double mass) {
		super(radius, minimumRadius, mass);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public SmallerShip() {
		// TODO Auto-generated constructor stub
	}

}
