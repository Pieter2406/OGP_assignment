package asteroids.studentdefined;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;


/**
 * A class of SpaceObject is an abstract class with a Coordinate and a Velocity.
 * 
 * TODO: Write @invar (if necessary) in SpaceObject class
 * 
 * @version 1.1
 * 
 * @author Kristof Bruyninckx
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 * 
 * @invar 	The world associated with each SpaceObject must be either a proper World, or a null reference.
 * 			| hasProperWorld()
 *
 */
public abstract class SpaceObject {
	
	/**
	 * Initialize this new SpaceObject with a given x and y coordinate, 
	 * a given x and y velocity, a given radius, a given minimum radius, a given mass and a given world.
	 * 
	 * TODO: Write @pre and @post for constructor in SpaceObject class.
	 * 
	 * @param 	x
	 * @param 	y
	 * @param 	velocityX
	 * @param 	velocityY
	 * @param 	radius
	 * @param 	minimumRadius
	 * @param 	mass
	 */
	@Raw
	protected SpaceObject(double x, double y, double velocityX, double velocityY, double radius, double minimumRadius, double mass, World world){
		this.position = new Coordinate(x,y);
		this.velocity = new Velocity(velocityX,velocityY);
		this.radius = radius;
		this.minimumRadius = minimumRadius;
		this.mass = new Mass(mass);
		this.pendingVelocityChange = true;
		this.setWorld(world);
	}
	
	/**
	 * Initialize the position and the velocity of the SpaceObject with a given x and y coordinate, 
	 *  a given radius and a given mass.
	 * 
	 * TODO: Write @effect for SpaceObject constructor.
	 * 
	 * @param 	x
	 * @param 	y
	 * @param 	radius
	 * @param 	mass
	 */
	@Raw
	protected SpaceObject(double x, double y, double radius, double mass, World world){
		this(x,y,0,0,radius,0,mass, world);
	}
	
	/**
	 * Initialize the position and the velocity of the SpaceObject with position(0,0) and velocity(0,0), a given radius, 
	 * a given minimum radius and a given mass.
	 * 
	 * @effect TODO write @effect in SpaceObject constructor.
	 * 
	 * @param 	radius
	 * @param 	minimumRadius
	 * @param	mass
	 */
	@Raw
	protected SpaceObject(double radius, double minimumRadius, double mass, World world){
		this(0,0,0,0,radius,minimumRadius,mass, world);
	}
	
	/**
	 * Initialize the position and the velocity of the SpaceObject with position (0,0) and velocity (0,0), a radius of 0 and a minimum radius of 0.
	 * 
	 * TODO: Write @effect for constructor in SpaceObject.
	 */
	@Raw
	protected SpaceObject(){
		this(0,0,0,0,0,0,0, null);
	}
	
	
	/**
	 * Return the velocity of this SpaceObject. 
	 */
	@Basic @Raw
	public Velocity getVelocity(){
		return velocity;
	}
	
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
		setPendingVelocityChange(true);
	}
	
	/**
	 * Variables holding the total speed of a SpaceObject.
	 */
	protected Velocity velocity; // used for redundancy	
	
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
	
	/**
	 * Return this SpaceObject's mass.
	 */
	public Mass getMass(){
		return mass;
	}
	
	/**
	 * Set the new mass of this SpaceOject.
	 * 
	 * @param 	newMass
	 * 			Holds the new mass for this SpaceObject.	
	 * @effect	If the given mass is a valid mass, the mass of this SpaceObject
	 * 			is set to the given mass.
	 */
	@Raw
	public void setMass(double newMass){
		this.mass.setMass(newMass);
	}
	
	/**
	 * Variable holding the mass of the SpaceObject.
	 */
	protected Mass mass;
	
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
	 * 			If the SpaceObjects never collide or if the same object is given as an argument, this method will return infinity.
	 * 			| colThis = this.move(collisiontime);
	 * 			| colOther = other.move(collisiontime);
	 * 			| if (newThis.overlaps(newOther))
	 * 			|	result == collisiontime
	 * 			| else 
				|	result == Double.POSITIVE_INFINITY	
	 */
	public double getTimeToCollision(SpaceObject other)throws IllegalArgumentException{
		try{
			if (this.equals(other)) // An object can never collide with itself.
				return Double.POSITIVE_INFINITY;
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
	 * 			| if (getTimeToCollision(other) == Double.POSITIVE_INFINITY)
	 * 			| 	then result == null
	 * 			| else result ==  Coordinate(getPosition().getX() + getVelocity().getVelocityX() * getTimeToCollision(other)
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
				double newX = SpaceObjectX + this.getRadius() * (otherX - SpaceObjectX) / distancebetween;
				double newY = SpaceObjectY + this.getRadius() * (otherY - SpaceObjectY) / distancebetween;

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
	 * Set the current radius.
	 */
	@Basic @Raw
	public void setRadius(double radius) {
		if(isValidRadius(radius)){
			this.radius = radius;
			//When radius changes, new collision times need to be reset
			this.setPendingVelocityChange(true);
		}
		
	}
	
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
	protected double radius;


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
	
	/**
	 * Set whether the velocity is changed over time.
	 * 
	 * @param 	bool
	 * 			The given boolean value for the pending velocity change.
	 */
	public void setPendingVelocityChange(boolean bool){
		this.pendingVelocityChange = bool;
	}
	
	/**
	 * Tell the caller whether this SpaceObject has a pending velocity change.
	 * 
	 * @return	true if and only if the velocity has changed over time.
	 */
	public boolean hasPendingVelocityChange(){
		return pendingVelocityChange;
	}
	
	/**
	 * Boolean containing true if its velocity has changed.
	 */
	protected boolean pendingVelocityChange;
	
	/**
	 * Returns the World that is associated with this SpaceObject.
	 * @return The World this SpaceObject is located in.
	 */
	public World getWorld() {
		return this.world;
	}
	
	/**
	 * Sets the World of this SpaceObject to world.
	 * @post The World associated with this SpaceObject is the given World.
	 * @param world The world to associate this SpaceObject with.
	 */
	public void setWorld(World world) {
		this.world = world;
	}
		
	/**
	 * Returns whether the World associated with this SpaceObject is either a null reference, or contains this SpaceObject.
	 */
	public boolean hasProperWorld() {
		if (this.world == null)
			return true;
		else
			return this.world.containsSpaceObject(this);
	}
	
	/**
	 * The world with which this SpaceObject is associated.
	 * A SpaceObject can only be associated with one world, and can only appear once in that world.
	 */
	protected World world;
	
	/**
	 * Delete this SpaceObject from the current world and break its current associations.
	 */
	public void terminate(){
		this.isTerminated = true;
		this.getWorld().removeSpaceObject(this);
	}	
	
	/**
	 * 
	 */
	public boolean isTerminated(){
		return isTerminated;
	}
	
	/**
	 * 
	 */
	private boolean isTerminated = false;
	
}
