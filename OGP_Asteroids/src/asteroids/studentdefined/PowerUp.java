/**
 * 
 */
package asteroids.studentdefined;

import be.kuleuven.cs.som.annotate.Raw;

/**
 * Abstract class that holds methods and function for PowerUps and 
 * inherits from SpaceObject.
 * @author Kristof Bruyninckx
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 * @version 1.1
 */
public abstract class PowerUp extends SpaceObject {
protected final int type;
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
	public PowerUp(double x, double y, double velocityX, double velocityY, double radius, double minimumRadius, double mass, World world, int type) {
		super(x, y, velocityX, velocityY, radius, minimumRadius, mass, world);
		this.type = type;
	}

	/**
	 * @param x
	 * @param y
	 * @param radius
	 * @param mass
	 * @param world
	 */
	@Raw
	public PowerUp(double x, double y, double radius, double mass, World world, int type) {
		super(x, y, radius, mass, world);
		this.type = type;
	}

	/**
	 * @param radius
	 * @param minimumRadius
	 * @param mass
	 * @param world
	 */
	@Raw
	public PowerUp(double radius, double minimumRadius, double mass, World world, int type) {
		super(radius, minimumRadius, mass, world);
		this.type = type;
	}

	/**
	 * 
	 */
	public PowerUp(int type) {
		this.type = type;
	}

	public int getType(){
		return type;
	}
}
