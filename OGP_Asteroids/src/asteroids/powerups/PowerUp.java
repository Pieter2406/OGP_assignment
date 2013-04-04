/**
 * 
 */
package asteroids.powerups;

import asteroids.studentdefined.SpaceObject;
import asteroids.studentdefined.World;

/**
 * @author Pieter
 *
 */
public class PowerUp extends SpaceObject {

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
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param radius
	 * @param minimumRadius
	 * @param mass
	 * @param world
	 */
	public PowerUp(double radius, double minimumRadius, double mass, World world) {
		super(radius, minimumRadius, mass, world);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public PowerUp() {
		// TODO Auto-generated constructor stub
	}

}
