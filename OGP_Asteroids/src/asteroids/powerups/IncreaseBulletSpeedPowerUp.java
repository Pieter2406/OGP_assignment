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
public class IncreaseBulletSpeedPowerUp extends PowerUp {
private final static int TYPE = 2;
	/**
	 * @param x
	 * @param y
	 * @param velocityX
	 * @param velocityY
	 * @param radius
	 * @param minimumRadius
	 * @param mass
	 * @param world
	 * @param type
	 */
	public IncreaseBulletSpeedPowerUp(double x, double y, double velocityX, double velocityY, double radius, double minimumRadius, double mass,
			World world) {
		super(x, y, velocityX, velocityY, radius, minimumRadius, mass, world,TYPE);
	}

	/**
	 * @param x
	 * @param y
	 * @param radius
	 * @param mass
	 * @param world
	 * @param type
	 */
	public IncreaseBulletSpeedPowerUp(double x, double y, double radius, double mass,
			World world) {
		super(x, y, radius, mass, world, TYPE);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param radius
	 * @param minimumRadius
	 * @param mass
	 * @param world
	 * @param type
	 */
	public IncreaseBulletSpeedPowerUp(double radius, double minimumRadius,
			double mass, World world) {
		super(radius, minimumRadius, mass, world, TYPE);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param type
	 */
	public IncreaseBulletSpeedPowerUp() {
		super(TYPE);
	}

}
