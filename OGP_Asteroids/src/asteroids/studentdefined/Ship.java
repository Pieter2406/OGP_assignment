package asteroids.studentdefined;
import asteroids.IShip;
import be.kuleuven.cs.som.annotate.*;


/**
 * A class of a ship involves a position in the two dimensional space, a velocity, a radius (the ship has a round form) and a direction.
 * 
 * @invar 	The radius of a ship is always higher than the minimum radius of all ships, and is always a valid number.
 * 			| isValidRadius(getRadius())
 * @invar 	The angle of a ship must always be a valid number.
 * 			| isValidAngle(getAngle())
 * 
 * @version 1.0
 * @author Kristof Bruyninckx
 * @author Pieter Verlinden
 * 
 */
public class Ship implements IShip {

	//TODO: write doc
	public Ship(double x, double y, double radius, double minimumRadius, double angle){
		this.position = new Coordinate(x,y);
		this.radius = radius; // no setRadius as it is final, only initialized once.
		this.setAngle(angle);
		this.velocity = new Velocity();
		this.minimumRadius = minimumRadius;
	}

	/**
	 * Initialize the position, the radius and the angle of this ship with respectively the given position, radius and angle. 
	 * Initialize the velocity of this ship to zero.
	 * @param 	x
	 * 			The position on the x-as for this new ship.
	 * @param 	y 
	 * 			The position on the y-as for this new ship.
	 * @param	radius
	 * 			The radius for this new ship.
	 * @param 	angle
	 * 			The angle for this new ship.
	 * @pre		The given radius must be a valid radius
	 * 			| isValidRadius(radius)
	 * @post		The Position, the radius and the angle of this ship are equal to respectively the given position, the given radius and the given angle.
	 * 			The speed of this ship is initialized to zero.
	 * @note		Speed will always be zero at the creation of an object, it is therefore not included as a parameter.
	 */
	public Ship(double x, double y, double radius, double angle){
		this(x,y,radius, 0, angle);
	}

	/**
	 * Return the velocity of this ship. 
	 */
	@Basic @Raw
	public Velocity getVelocity(){
		return velocity;
	}

	/**
	 * Variables holding the total speed of a ship.
	 */
	private Velocity velocity; // used for redundancy
	
	/**
	 * The method thrust serves to change the current velocity
	 * 
	 * @param amount
	 * 			The amount of velocity added to the current velocity in Km/h.
	 * 
	 * @post	If the given amount is higher than zero, this amount is added to the current velocity. If the new velocity 
	 * 			exceeds the speed of light (300'000 Km/s), it will take on the value of the speed of light.
	 * 
	 */
	public void thrust(double amount){
		//TODO: write method thrust
	}

	/**
	 * Return this ship's angle.
	 */
	@Basic @Raw
	public double getAngle(){
		return angle;
	}

	/**
	 * Return true if the given angle is a valid angle.
	 * @param 	angle
	 * 			The given angle for this ship.
	 * @return	True if and only if the given angle is a valid number.
	 */
	public static boolean isValidAngle(double angle){
		return !Double.isNaN(angle);
	}

	/**
	 * Set the angle of this ship to the given angle.
	 * @param 	angle
	 * 			The new angle for this ship.
	 * @pre		The given angle must be a valid angle.
	 * 			| isValidAngle(angle)
	 * @post	The angle of this ship is equal to the given angle
	 * 			| new.getAngle() == angle
	 */
	@Raw
	public void setAngle(double angle){
		this.angle = angle;
	}

	//TODO: write doc
	public void turn(double angle){
		//TODO: write method turn
	}

	/**
	 * Variable holding the angle of a ship in radians.
	 */
	private double angle; 

	/**
	 * Return this ship's position.
	 */
	public Coordinate getPosition(){
		return position;
	}

	/**
	 * Sets the new position of this ship based on a given x and y coordinate.
	 * @param 	x
	 * 			Holds the new x coordinate for this ship.
	 * @param 	y
	 * 			Holds the new y coordinate for this ship.
	 * @throws IllegalValueException 
	 * @post 	The position of this ship is changed according to the given x and y coordinates.
	 */
	@Raw
	public void setPosition(double x, double y){
		this.position.transformTo(x,y); // values will be checked in the coordinate class.
	}

	//TODO: defensive documentation
	public void move(double time){
		//TODO: write method move
	}

	/**
	 * Variable holding a Coordinate object. 
	 */
	private Coordinate position;


	//TODO: defensive documentation{
	public double getDistanceBetween(Ship other){
		throw new RuntimeException("NOT IMPLEMENTED");
		//TODO: write getter getDistanceBetween
	}

	public boolean overlap(Ship other){
		throw new RuntimeException("NOT IMPLEMENTED");
		//TODO: write method overlap
	}

	public double getTimeToCollision(Ship other){
		throw new RuntimeException("NOT IMPLEMENTED");
		//TODO: write getter getTimeToCollision
	}

	public double getCollisionPosition(Ship other){
		throw new RuntimeException("NOT IMPLEMENTED");
		//TODO: write getter getCollisionPosition
	}
	//}

	/**
	 * Check whether the given radius is a valid radius.
	 * @param 	radius
	 * 			The given radius for this ship.
	 * @return	True if and only if the given radius is a valid number and is higher than the minimum radius.
	 */
	public boolean isValidRadius(double radius){
		return (!Double.isNaN(radius) && radius >= minimumRadius);
	}

	/**
	 * Variable containing the radius of a ship. 
	 */
	private final double radius;
	
	//	/**
	//	 * 
	//	 * @param 	radius
	//	 * 			The new radius for this ship
	//	 * @post	The angle of this ship is set to the given angle
	//	 * 			| new.getRadius() == radius
	//	 * @throws 	IllegalValueException
	//	 * 			The given radius is not a valid radius.
	//	 * 			| !isValidRadius(radius)
	//	 */
	//	private void setRadius(double radius) throws IllegalValueException{
	//		if (!isValidRadius(radius))
	//			throw new IllegalValueException(radius);
	//		this.radius = radius;
	//	}


	/**
	 * @param 	minimumRadius
	 * 			The given minimum radius for this ship.
	 * @return	True if and only if the given minimum radius is positive or zero.
	 * 
	 */
	public static boolean isValidMinimumRadius(double minimumRadius){
		return minimumRadius > 0;
	}
	
	/**
	 * Variable containing the minimum radius of a ship. 
	 */
	private final double minimumRadius;
}
