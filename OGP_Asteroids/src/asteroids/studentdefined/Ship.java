package asteroids.studentdefined;
import asteroids.IShip;
import asteroids.Util;
import be.kuleuven.cs.som.annotate.*;


/**
 * A class of a Ship is a SpaceObject involves a position in the two dimensional space, a velocity, a radius (the ship has a round form) and a direction.
 * 
 * @invar 	The radius of a ship is always higher than the minimum radius of all ships, and is always a valid number.
 * 			| isValidRadius(getRadius())
 * @invar 	The angle of a ship must always be a valid number.
 * 			| isValidAngle(getAngle()) 
 * 
 * @version 1.1
 * 
 * @author Kristof Bruyninckx
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 * 
 */
public class Ship extends SpaceObject implements IShip {
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
	 * 
	 * TODO: write @effect with super class
	 */
	public Ship(double x, double y,double velocityX, double velocityY, double radius, double angle){
		super(x,y,velocityX,velocityY,radius);
		this.setAngle(angle);
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
}
