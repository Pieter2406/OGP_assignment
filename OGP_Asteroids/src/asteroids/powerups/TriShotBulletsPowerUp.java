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
public class TriShotBulletsPowerUp extends PowerUp {
private static final int TYPE = 0;
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
	public TriShotBulletsPowerUp(double x, double y, double velocityX,
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
	public TriShotBulletsPowerUp(double x, double y, double radius,
			double mass, World world) {
		super(x, y, radius, mass, world, TYPE);	}

	/**
	 * @param radius
	 * @param minimumRadius
	 * @param mass
	 * @param world
	 * @param type
	 */
	public TriShotBulletsPowerUp(double radius, double minimumRadius,
			double mass, World world) {
		super(radius, minimumRadius, mass, world, TYPE);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param type
	 */
	public TriShotBulletsPowerUp() {
		super(TYPE);
	}

}
