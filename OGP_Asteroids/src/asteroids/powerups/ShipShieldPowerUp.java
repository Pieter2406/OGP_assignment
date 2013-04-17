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
public class ShipShieldPowerUp extends PowerUp {
private final static int TYPE = 1;
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
	public ShipShieldPowerUp(double x, double y, double velocityX,
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
	 * @param type
	 */
	public ShipShieldPowerUp(double x, double y, double radius, double mass,
			World world) {
		super(x, y, radius, mass, world, TYPE);
	}

	/**
	 * @param radius
	 * @param minimumRadius
	 * @param mass
	 * @param world
	 * @param type
	 */
	public ShipShieldPowerUp(double radius, double minimumRadius, double mass,
			World world) {
		super(radius, minimumRadius, mass, world, TYPE);
	}

	/**
	 * 
	 */
	public ShipShieldPowerUp() {
		super(TYPE);
	}

}
