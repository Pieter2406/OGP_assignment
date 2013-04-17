/**
 * 
 */
package asteroids.powerups;

import be.kuleuven.cs.som.annotate.Raw;
import asteroids.studentdefined.PowerUp;
import asteroids.studentdefined.World;

/**
 * A class of SmallerShip extends the class PowerUp. This class adds an object with the
 * possibility to make the ship smaller for a certain time.
 * 
 * @author Wouter Bruyninckx
 * @author Kristof Bruyninckx
 * @author Pieter Verlinden
 * 
 * @version 1.1
 */
public class SmallerShipPowerUp extends PowerUp {
private final static int TYPE = 4;
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
	@Raw
	public SmallerShipPowerUp(double x, double y, double velocityX, double velocityY, double radius, double minimumRadius, double mass, World world) {
		super(x, y, velocityX, velocityY, radius, minimumRadius, mass, world, TYPE);
	}

	/**
	 * @param x
	 * @param y
	 * @param radius
	 * @param mass
	 * @param world
	 */
	@Raw
	public SmallerShipPowerUp(double x, double y, double radius, double mass,World world) {
		super(x, y, radius, mass, world,TYPE);
	}

	/**
	 * @param radius
	 * @param minimumRadius
	 * @param mass
	 * @param world
	 */
	@Raw
	public SmallerShipPowerUp(double radius, double minimumRadius, double mass,
			World world) {
		super(radius, minimumRadius, mass, world,TYPE);
	}

	/**
	 * 
	 */
	public SmallerShipPowerUp() {
		super(TYPE);
	}

}
