/**
 * 
 */
package asteroids.powerups;

import asteroids.studentdefined.PowerUp;
import asteroids.studentdefined.World;

/**
 * @author Pieter
 *
 */
public class RadiusAsteroidPushPowerUp extends PowerUp {
private final static int TYPE = 5;
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
	public RadiusAsteroidPushPowerUp(double x, double y, double velocityX,
			double velocityY, double radius, double minimumRadius, double mass,
			World world) {
		super(x, y, velocityX, velocityY, radius, minimumRadius, mass, world,
				TYPE);
	}

	/**
	 * @param x
	 * @param y
	 * @param radius
	 * @param mass
	 * @param world
	 */
	public RadiusAsteroidPushPowerUp(double x, double y, double radius,
			double mass, World world) {
		super(x, y, radius, mass, world, TYPE);
	}

	/**
	 * @param radius
	 * @param minimumRadius
	 * @param mass
	 * @param world
	 */
	public RadiusAsteroidPushPowerUp(double radius, double minimumRadius,
			double mass, World world) {
		super(radius, minimumRadius, mass, world, TYPE);
	}

	/**
	 * 
	 */
	public RadiusAsteroidPushPowerUp() {
		super(TYPE);
	}

}
