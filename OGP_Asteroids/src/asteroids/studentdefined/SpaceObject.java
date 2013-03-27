package asteroids.studentdefined;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;

/**
 * A class of SpaceObject is an abstract class with a Coordinate and a Velocity.
 * 
 * TODO: Write @invar (if necessary)
 * 
 * @version 1.1
 * 
 * @author Kristof Bruyninckx
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 *
 */
public abstract class SpaceObject {
	
	/**
	 * Initialize the position and the velocity of the SapceObject with a given x and y coordinate, 
	 * a given x and y velocity and a given radius.
	 * 
	 * TODO: write @pre and @post.
	 * 
	 * @param x
	 * @param y
	 * @param velocityX
	 * @param velocityY
	 */
	public SpaceObject(double x, double y, double velocityX, double velocityY, double radius){
		//TODO: Write constructor
	}
	
	/**
	 * Initialize the position and the velocity of the SpaceObject with position(0,0) and velocity(0,0) and a given radius.
	 * 
	 * @param radius
	 */
	public SpaceObject(double radius){
		this(0,0,0,0,radius);
	}
	
	/**
	 * Initialize the position and the velocity of the SpaceObject with position (0,0) and velocity (0,0) and a radius of 0;
	 * 
	 * TODO: write @effect
	 */
	public SpaceObject(){
		this(0,0,0,0,0);
	}
	
	
	/**
	 * Return the velocity of this SpaceObject. 
	 */
	@Basic @Raw
	public Velocity getVelocity(){
		return velocity;
	}
	
	/**
	 * Variables holding the total speed of a SpaceObject.
	 */
	protected Velocity velocity; // used for redundancy	
	
	/**
	 * Set the new velocity of this SpaceObject based on a given x and y velocity.
	 * @param 	velocityX
	 * 			Holds the new x velocity for this SpaceObject.
	 * @param 	velocityY
	 * 			Holds the new y velocity for this SpaceObject.
	 * @effect	If the given x and y values are valid numbers, the x and y values of this 
	 * 			SpaceObjects velocities are set to the given x and y values.
	 */
	@Raw
	public void setVelocity(double velocityX, double velocityY){
		getVelocity().setVelocity(velocityX, velocityY); // values will be checked in the Velocity class.
	}
	
	/**
	 * Return this SpaceObject's position.
	 */
	public Coordinate getPosition(){
		return position;
	}

	/**
	 * Variable holding a Coordinate object. 
	 */
	protected Coordinate position;
	
	/**
	 * Set the new position of this SpaceObject based on a given x and y coordinate.
	 * @param 	x
	 * 			Holds the new x coordinate for this SpaceObject.
	 * @param 	y
	 * 			Holds the new y coordinate for this SpaceObject.
	 * @effect	If the given x and y values are valid numbers, the x and y values of this 
	 * 			SpaceObjects coordinates are set to the given x and y values.
	 */
	@Raw
	public void setPosition(double x, double y){
		getPosition().transformTo(x,y); // values will be checked in the coordinate class.
	}
	
	public void move(double duration){
		if(duration < 0){
			throw new IllegalValueException(duration);
		}
		double newPositionX = getPosition().getX() + (duration * getVelocity().getVelocityX());
		double newPositionY = getPosition().getY() + (duration * getVelocity().getVelocityY());
		setPosition(newPositionX,newPositionY); 
	}


	/**
	 * Return the distance between this SpaceObject and another given SpaceObject.
	 * @param 	other
	 * 			A given SpaceObject used to calculate a distance between it and this SpaceObject.
	 * @throws  IllegalArgumentException
	 * 			The other SpaceObject is not effective.
	 * 			| other == null
	 * @return  If the given SpaceObject is this SpaceObject 0.0 is returned, 
	 * 			if the given SpaceObject is another SpaceObject the distance between both SpaceObjects' coordinates is computed
	 * 			and the radius of both SpaceObjects is then subtracted from this value.
	 * 			| if (other == this)
	 * 			| then 0.0
	 * 			| else getPosition().getDistanceBetween(other.getPosition()) - this.getRadius() - other.getRadius()
	 */
	public double getDistanceBetween(SpaceObject other) throws IllegalArgumentException{
		// Interface ISpaceObject is not yet implemented, if ISpaceObject is implemented the type of other should change to ISpaceObject.
		try {
			if (other == this)
				return 0.0;
			double rawDistance = getPosition().getDistanceBetween(other.getPosition());
			double actualDistance = rawDistance - getRadius() - other.getRadius();
			return actualDistance;
		}
		catch (NullPointerException excError){
			assert (other == null);
			throw new IllegalArgumentException ("Not an initialized given SpaceObject");
		}
	}

	/**
	 * Return true if this SpaceObject overlaps with the given SpaceObject.
	 * @param 	other
	 * 			A given SpaceObject used to check if it overlaps with this SpaceObject.
	 * @throws  IllegalArgumentException
	 * 			The other SpaceObject is not effective.
	 * 			| other == null
	 * @return  True if and only if the given SpaceObject is the same as this SpaceObject,
	 * 			or the distance between both SpaceObjcts is smaller than zero.
	 * 			| result == 
	 * 			|	other == this
	 * 			|	|| getDistanceBetween(other) < 0
	 */
	public boolean overlap(SpaceObject other){
		try {
			if (other == this)
				return true;
			if (getDistanceBetween(other) < 0)
				return true;
			return false;
		}
		catch (NullPointerException excError){
			assert (other == null);
			throw new IllegalArgumentException ("Not an initialized given SpaceObject");
		}
	}

	/**
	 * Return when (in seconds), if ever, this SpaceObject will collide with the given other SpaceObject.
	 * 
	 * @param 	other
	 * 			A given SpaceObject with which will be tested if this SpaceObject will collide with other SpaceObject.
	 * @throws	illegalArgumentException
	 * 			The other SpaceObject is not effective
	 * 			|other == null
	 * @return
	 * 			The time in seconds of how long it would take for this SpaceObject and the given SpaceObject
	 * 			(if ever) to collide.
	 * 			If the SpaceObjects never collide, this method will return infinity.
	 * 			| dVx = this.getVelocity().getVelocityX() - other.getVelocity().getVelocityX()
	 * 			| dVy = this.getVelocity().getVelocityY() - other.getVelocity().getVelocityY()
	 * 			| dX = this.getPosition().getX() - other.getPosition().getX()
	 * 			| dY = this.getPosition().getY() - other.getPosition().getY()
	 * 			| dVdV = (Math.pow(dVx,2)) + (Math.pow(dVy, 2))
	 * 			| dVdR = (dVx*dX) + (dVy*dY)
	 * 			| dRdR = (Math.pow(dX, 2) + Math.pow(dY, 2))
	 * 			| sigma = this.getRadius() + other.getRadius()
	 * 			| discriminant = Math.pow(dVdR, 2) - (dVdV)*(dRdR - Math.pow(sigma, 2))
	 * 			| dT = -(dVdR + Math.sqrt(discriminant))/dVdV
	 * 			| result ==
	 * 			|		if (dVdR >= 0)
	 * 			|			Double.POSITIVE_INFINITY
	 * 			|		else if(discriminant <= 0)
	 * 			|			Double.POSITIVE_INFINITY
	 * 			|		else
	 * 			|			dT
	 */
	public double getTimeToCollision(SpaceObject other)throws IllegalArgumentException{
		try{
			double dVx = this.getVelocity().getVelocityX() - other.getVelocity().getVelocityX();
			double dVy = this.getVelocity().getVelocityY() - other.getVelocity().getVelocityY();
			double dX = this.getPosition().getX() - other.getPosition().getX();
			double dY = this.getPosition().getY() - other.getPosition().getY();
			double dVdV = (Math.pow(dVx,2)) + (Math.pow(dVy, 2));
			double dVdR = (dVx*dX) + (dVy*dY);
			double dRdR = (Math.pow(dX, 2) + Math.pow(dY, 2));
			double sigma = this.getRadius() + other.getRadius();
			double discriminant = Math.pow(dVdR, 2) - (dVdV)*(dRdR - Math.pow(sigma, 2));

			if(dVdR >= 0){
				return Double.POSITIVE_INFINITY;
			}else if(discriminant <= 0){
				return Double.POSITIVE_INFINITY;
			}else{
				double dT = -(dVdR + Math.sqrt(discriminant))/dVdV;
				return dT;
			}
		}catch (NullPointerException excError){
			assert(other == null);
			throw new IllegalArgumentException("Not an initialized SpaceObject");
		}
	}

	/**
	 * Calculates the position of collision between this SpaceObject and a given SpaceObject, if they will ever collide
	 * @param 	other
	 * 			A given SpaceObject used to calculate the position of collision with this SpaceObject.
	 * @throws  IllegalArgumentException
	 * 			The other SpaceObject is not effective.
	 * 			| other == null
	 * @return  the Coordinate of collision between both SpaceObjects, if the SpaceObjects don't collide
	 * 			return a null pointer.
	 * 			| if (colx == Double.POSITIVE_INFINITY)
	 * 			| 	then null
	 * 			| else Coordinate(getPosition().getX() + getVelocity().getVelocityX() * getTimeToCollision(other)
	 * 			|	,getPosition().getY() + getVelocity().getVelocityY() * getTimeToCollision(other))
	 */
	public Coordinate getCollisionPosition(SpaceObject other) throws IllegalArgumentException  {
		try {
			if (getTimeToCollision(other) == Double.POSITIVE_INFINITY){
				return null;
			}
			else {
				// calculate each SpaceObject's position at the time of collision
				double SpaceObjectX = getPosition().getX() + getVelocity().getVelocityX() * getTimeToCollision(other);
				double SpaceObjectY = getPosition().getY() + getVelocity().getVelocityY() * getTimeToCollision(other);
				double otherX = other.getPosition().getX() + other.getVelocity().getVelocityX() * getTimeToCollision(other);
				double otherY = other.getPosition().getY() + other.getVelocity().getVelocityY() * getTimeToCollision(other);
				// use cos and sin to determine new position
				double distancebetween = this.getRadius() + other.getRadius();
				double newX = getPosition().getX() + this.getRadius() * (SpaceObjectX - otherX) / distancebetween;
				double newY = getPosition().getY() + this.getRadius() * (SpaceObjectY - otherY) / distancebetween;

				return new Coordinate(newX,newY);
			}
		}
		catch (NullPointerException excError){
			assert (other == null);
			throw new IllegalArgumentException ("Not an initialized given SpaceObject");
		}
	}
	//}

	/**
	 * Return the current radius.
	 */
	@Basic @Raw
	public double getRadius() {
		return this.radius;
	}
	/**
	 * Check whether the given radius is a valid radius.
	 * @param 	radius
	 * 			The given radius for this SpaceObject.
	 * @return	True if and only if the given radius is a valid number and is higher than the minimum radius.
	 */
	public boolean isValidRadius(double radius){
		return (!Double.isNaN(radius) && radius >= minimumRadius);
	}

	/**
	 * Variable containing the radius of a SpaceObject. 
	 */
	protected final double radius;


	/**
	 * @param 	minimumRadius
	 * 			The given minimum radius for this SpaceObject.
	 * @return	True if and only if the given minimum radius is positive or zero.
	 * 
	 */
	public static boolean isValidMinimumRadius(double minimumRadius){
		return !Double.isNaN(minimumRadius) && minimumRadius > 0;
	}

	/**
	 * Variable containing the minimum radius of a SpaceObject. 
	 */
	protected final double minimumRadius;
}
