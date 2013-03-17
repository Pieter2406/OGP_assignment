package asteroids.studentdefined;
import asteroids.IShip;
import asteroids.Util;
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
	/**
	 * Initialize the position, the radius and the angle of this ship with respectively the given position, radius and angle. 
	 * Initialize the velocity of this ship to zero.
	 * @param 	x
	 * 			The position on the x-as for this new ship.
	 * @param 	y 
	 * 			The position on the y-as for this new ship.
	 * @param	velocityX
	 * 			The velocity in the x direction.
	 * @param	velocityY
	 * 			The velocity in the y direction.
	 * @param	radius
	 * 			The radius for this new ship.
	 * @param 	angle
	 * 			The angle for this new ship.
	 * @pre		The given radius must be a valid radius
	 * 			| isValidRadius(radius)
	 * @post	The Position, the radius and the angle of this ship are equal to respectively the given position, the given radius and the given angle.
	 * 			The speed of this ship is initialized to zero.
	 * 			| new.getPosition().getX == x
	 * 			| new.getPosition().getY == y
	 * 			| new.getRadius == radius
	 * 			| new.getVelocity().getVelocityX() == velocityX
	 * 			| new.getVelocity().getVelocityY() == velocityY
	 * 			| new.getAngle() == angle
	 * @note		Speed will always be zero at the creation of an object, it is therefore not included as a parameter.
	 */
	public Ship(double x, double y,double velocityX, double velocityY, double radius, double angle){
		this.position = new Coordinate(x,y);
		this.radius = radius; // no setRadius as it is final, only initialized once.
		this.setAngle(angle);
		this.velocity = new Velocity(velocityX,velocityY);
		this.minimumRadius = 10;
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
	 * @param 	minimumRadius
	 * 			The minimum radius for this new ship.
	 * @pre		The given radius must be a valid radius
	 * 			| isValidRadius(radius)
	 * @effect 	This new ship is initialized with a given x coordinate, a given y coordinate, 
	 * 			a velocity of zero in the x and y direction,
	 * 			a radius and a given angle.
	 * 			| this(x,y,0,0,radius, angle)
	 */
	public Ship(double x, double y, double radius, double angle){
		this(x,y,0,0,radius,angle);
	}

	/**
	 * Return the velocity of this ship. 
	 */
	@Basic @Raw
	public Velocity getVelocity(){
		return velocity;
	}



	/**
	 * The method thrust serves to change the current velocity
	 * 
	 * @param amount
	 * 			The amount of velocity added to the current velocity in Km/h.
	 * 
	 * @post	If the given amount is higher than zero, this amount is added to the current velocity. If the new velocity 
	 * 			exceeds the speed of light, it will take on the value of the speed of light.
	 * 			|if(new.getVelocity > getVelocity().SPEED_OF_LIGHT)
	 * 			|	new.getVelocity == getVelocity().SPEED_OF_Light
	 * 
	 */
	public void thrust(double amount){
		double checkedAmount = amount;
		if(amount < 0){
			checkedAmount = 0;
		}
		getVelocity().setVelocity	(	getVelocity().getVelocityX() + (checkedAmount * Math.cos(getAngle()))
				,
				getVelocity().getVelocityY() + (checkedAmount * Math.sin(getAngle()))
				);
	}
	/**
	 * Variables holding the total speed of a ship.
	 */
	private Velocity velocity; // used for redundancy

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

	/**
	 * Turn the ship into another direction.
	 * @param 	angle
	 * 			The given angle to be added to the current angle.
	 * @pre		The given angle must be a valid angle.
	 * 		    | isValidAngle(angle)
	 * @effect 	Set the angle to the current angle plus the given angle.
	 * 			| setAngle(this.getAngle() + angle)
	 */
	public void turn(double angle){
		setAngle(getAngle() + angle);
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
	 * Set the new position of this ship based on a given x and y coordinate.
	 * @param 	x
	 * 			Holds the new x coordinate for this ship.
	 * @param 	y
	 * 			Holds the new y coordinate for this ship.
	 * @effect	If the given x and y values are valid numbers, the x and y values of this 
	 * 			ships coordinates are set to the given x and y values.
	 */
	@Raw
	public void setPosition(double x, double y){
		getPosition().transformTo(x,y); // values will be checked in the coordinate class.
	}

	/**
	 * Move this ship in its current direction for a given amount of time.
	 * @param 	duration
	 * 			The duration of how long the ship moves in its current direction.
	 * @effect	The position of the ship is set to its new position according
	 * 			to the time it would have moved.
	 * 			|new.setPosition(newPositionX,newPositionY)
	 * @throws	IllegalValueException
	 * 			The given duration is not a valid duration.
	 * 			|(duration < 0)
	 */
	public void move(double duration){
		if(duration < 0){
			throw new IllegalValueException(duration);
		}
		double newPositionX = getPosition().getX() + (duration * getVelocity().getVelocityX());
		double newPositionY = getPosition().getY() + (duration * getVelocity().getVelocityY());
		setPosition(newPositionX,newPositionY); 
	}


	/**
	 * Variable holding a Coordinate object. 
	 */
	private Coordinate position;

	/**
	 * Return the distance between this ship and another given ship.
	 * @param 	other
	 * 			A given ship used to calculate a distance between it and this ship.
	 * @throws  IllegalArgumentException
	 * 			The other ship is not effective.
	 * 			| other == null
	 * @return  If the given ship is this ship 0.0 is returned, 
	 * 			if the given ship is another ship the distance between both ships's coordinates is computed
	 * 			and the radius of both ships is then subtracted from this value.
	 * 			| if (other == this)
	 * 			| then 0.0
	 * 			| else getPosition().getDistanceBetween(other.getPosition()) - this.getRadius() - other.getRadius()
	 */
	public double getDistanceBetween(Ship other) throws IllegalArgumentException{
		// Interface Iship is not yet implemented, if Iship is implemented the type of other should change to Iship.
		try {
			if (other == this)
				return 0.0;
			double rawDistance = getPosition().getDistanceBetween(other.getPosition());
			double actualDistance = rawDistance - getRadius() - other.getRadius();
			return actualDistance;
		}
		catch (NullPointerException excError){
			assert (other == null);
			throw new IllegalArgumentException ("Not an initialized given ship");
		}
	}

	/**
	 * Return true if this ship overlaps with the given ship.
	 * @param 	other
	 * 			A given ship used to check if it overlaps with this ship.
	 * @throws  IllegalArgumentException
	 * 			The other ship is not effective.
	 * 			| other == null
	 * @return  True if and only if the given ship is the same as this ship,
	 * 			or the distance between both ships is smaller than zero.
	 * 			| result == 
	 * 			|	other == this
	 * 			|	|| getDistanceBetween(other) < 0
	 */
	public boolean overlap(Ship other){
		try {
			if (other == this)
				return true;
			if (getDistanceBetween(other) < 0)
				return true;
			return false;
		}
		catch (NullPointerException excError){
			assert (other == null);
			throw new IllegalArgumentException ("Not an initialized given ship");
		}
	}

	/**
	 * Return when (in seconds), if ever, this ship will collide with the given other ship.
	 * 
	 * @param 	other
	 * 			A given ship with which will be tested if this ship will collide with other ship.
	 * @throws	illegalArgumentException
	 * 			The other ship is not effective
	 * 			|other == null
	 * @return
	 * 			The time in seconds of how long it would take for this ship and the given ship
	 * 			(if ever) to collide.
	 * 			If the ships never collide, this method will return infinity.
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
	public double getTimeToCollision(Ship other)throws IllegalArgumentException{
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
			throw new IllegalArgumentException("Not an initialized ship");
		}
	}

	/**
	 * Calculates the position of collision between this ship and a given ship, if they will ever collide
	 * @param 	other
	 * 			A given ship used to calculate the position of collision with this ship.
	 * @throws  IllegalArgumentException
	 * 			The other ship is not effective.
	 * 			| other == null
	 * @return  the Coordinate of collision between both ships, if the ships don't collide
	 * 			return a null pointer.
	 * 			| if (colx == Double.POSITIVE_INFINITY)
	 * 			| 	then null
	 * 			| else Coordinate(getPosition().getX() + getVelocity().getVelocityX() * getTimeToCollision(other)
	 * 			|	,getPosition().getY() + getVelocity().getVelocityY() * getTimeToCollision(other))
	 */
	public Coordinate getCollisionPosition(Ship other) throws IllegalArgumentException  {
		try {
			if (getTimeToCollision(other) == Double.POSITIVE_INFINITY){
				return null;
			}
			else {
				// calculate each ship's position at the time of collision
				double shipX = getPosition().getX() + getVelocity().getVelocityX() * getTimeToCollision(other);
				double shipY = getPosition().getY() + getVelocity().getVelocityY() * getTimeToCollision(other);
				double otherX = other.getPosition().getX() + other.getVelocity().getVelocityX() * getTimeToCollision(other);
				double otherY = other.getPosition().getY() + other.getVelocity().getVelocityY() * getTimeToCollision(other);
				// use cos and sin to determine new position
				double distancebetween = this.getRadius() + other.getRadius();
				double newX = getPosition().getX() + this.getRadius() * (shipX - otherX) / distancebetween;
				double newY = getPosition().getY() + this.getRadius() * (shipY - otherY) / distancebetween;

				return new Coordinate(newX,newY);
			}
		}
		catch (NullPointerException excError){
			assert (other == null);
			throw new IllegalArgumentException ("Not an initialized given ship");
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


	/**
	 * @param 	minimumRadius
	 * 			The given minimum radius for this ship.
	 * @return	True if and only if the given minimum radius is positive or zero.
	 * 
	 */
	public static boolean isValidMinimumRadius(double minimumRadius){
		return !Double.isNaN(minimumRadius) && minimumRadius > 0;
	}

	/**
	 * Variable containing the minimum radius of a ship. 
	 */
	private final double minimumRadius;
}
