package asteroids.studentdefined;

import be.kuleuven.cs.som.annotate.*;

/**
 * A class of a coordinate involves a x position and an y position in the two-dimensional space.
 * 
 * @invar 	The value of x must always be legal
 * 			| isValidValue(getX())
 * @invar	The value of y must always be legal
 * 			| isValidValue(getY())
 * 
 * @version 1.0
 * 
 * @author Kristof Bruynincks
 * @author Pieter Verlinden
 *
 */
public class Coordinate {
	/**
	 * Initialize this new coordinate with the given x and y values.
	 * @param 	x
	 * 			The value for the x-coordinate.
	 * @param 	y
	 * 			The value for the y-coordinate.
	 * @post	The x value of the new coordinate is equal to the given x value.
	 * 			| new.getX() == x
	 * @post	The y value of the new coordinate is equal to the given y value.
	 * 			| new.getY() == y
	 * @throws	IllegalValueException
	 * 			The given x is not a valid value for the x coordinate.
	 * 			| ! isValidValue(x)
	 * @throws	IllegalValueException
	 * 			The given y is not a valid value for the y coordinate.
	 * 			| ! isValidValue(y)
	 */
	public Coordinate(double x, double y){
		if(!isValidValue(x)){
			throw new IllegalValueException(x);
		}
		if(!isValidValue(y)){
			throw new IllegalValueException(y);
		}
		this.x = x;
		this.y = y;

	}
	
	/**
	 * Initialize this new coordinate with initial x and y values equal to zero.
	 * 
	 * @effect	This new coordinate is initialized with zero as x and y value.
	 * 			|this(0,0)
	 */
	public Coordinate(){
		this(0,0);
	}

	//public Coordinate(double angle, double r){ //TODO: (Optional) write constructor for Coordinate for polar coordinates }

	/**
	 * Return the x-value of the coordinate.
	 */
	@Basic @Raw
	public double getX(){return x;}

	/**
	 * Holds the x-value of the coordinate. 
	 */
	private double x;

	/**
	 * Return the y-value of the coordinate.
	 */
	@Basic @Raw
	public double getY(){return y;}

	/**
	 * Holds the y-value of the coordinate.
	 */
	private double y;

	/**
	 * Return true if the given value is a valid value.
	 * @param 	value
	 * 			The value to check.
	 * @return	True if and only if the given value is a number.
	 * 			| result == !(Double.isNaN(value)
	 */
	private static boolean isValidValue(double value){
		return !(Double.isNaN(value));
	}

	/**
	 * Return the distance between this coordinate and an other. 
	 * given coordinate
	 * 
	 * @param 	other
	 * 			The other given coordinate.
	 * @return	The distance between this coordinate and the other coordinate.
	 * 			| result ==
	 * 			| Math.sqrt(Math.pow(this.getX() - other.getX(),2)
	 * 			| 		 +	Math.pow(this.getY() - other.getY(),2))	
	 * @throws	illegalArgumentException
	 * 			the other coordinate is not effective
	 * 			|other == null
	 * 			
	 */
	public double getDistanceBetween(Coordinate other) throws IllegalArgumentException{
		try{
			double distance = 0.0;
			distance = Math.sqrt(Math.pow(this.getX() - other.getX(),2) + Math.pow(this.getY() - other.getY(), 2));
			return distance;
		}catch (NullPointerException excError){
			assert (other == null);
			throw new IllegalArgumentException("Not an initialized coordinate");
		}

	}

	/**
	 * Return the distance between this coordinate and an other. 
	 * given x and y coordinate.
	 * 
	 * @param 	x
	 * 			A given x coordinate.
	 * @param	y
	 * 			A given y coordinate.
	 * @return	The distance between this coordinate and the other coordinate.
	 * 			| result ==
	 * 			| Math.sqrt(Math.pow(this.getX() - x ,2)
	 * 			| 		 +	Math.pow(this.getY() - y ,2))	
	 */
	public double getDistanceBetween(double x, double y){
		double distance = 0.0;
		distance = Math.sqrt(Math.pow(this.getX() - x,2) + Math.pow(this.getY() - y, 2));
		return distance;
	}

	/**
	 * Return true if the position of this coordinate is equal to the position of the other coordinate.
	 * @param 	other
	 * 			The other coordinate to compare positions with.
	 * @return	True if and only if this coordinate is on the same position
	 * 			of the other coordinate.
	 * 			| result ==
	 * 			| 	(this.getX() == other.getX() && this.getY() == other.getY())
	 * @throws 	illegalArgumentException;
	 * 			The other coordinate is not effective
	 * 			|other == null
	 */
	public boolean hasEqualPosition(Coordinate other)throws IllegalArgumentException{
		try{
			if(this.getX() == other.getX() && this.getY() == other.getY()){
				return true;
			}else{
				return false;
			}

		}catch (NullPointerException excError){
			assert (other == null);
			throw new IllegalArgumentException("Not an initialized coordinate");
		}
	}

	/**
	 * Set the position of this coordinate to the new position.
	 * @param 	newPosition
	 * 			The other coordinate to transform to.
	 * @effect	The x and y values of the other coordinate are assigned to 
	 * 			the x and y values of this coordinate.
	 * 			|this.setX(newPosition.getX());
	 * 			|this.setY(newPosition.getY());
	 * @throws IllegalArgumentException
	 * 			The other coordinate is not effective
	 * 			|newPosition == null
	 */
	public void transformTo(Coordinate newPosition) throws IllegalArgumentException{
		try{
			this.setX(newPosition.getX());
			this.setY(newPosition.getY());

		}catch (NullPointerException excError){
			assert (newPosition == null);
			throw new IllegalArgumentException("Not an initialized coordinate");
		}
	}

	/**
	 * Set the position of this coordinate to the new position given by the x and y values. 
	 * @param 	x
	 * 			The new x value for the x coordinate.
	 * @param 	y
	 * 			the new y value for the y coordinate.
	 * @post	If the given x value is a valid number, the x value of this coordinate
	 * 			is set to the given value.
	 * 			| if(isValidValue(x))
	 * 			| 	then new.setX(x)
	 * @post 	If the given y value is a valid number, the y value of this coordinate 
	 * 			is set to the given value.
	 * 			| if(isValidValue(y)
	 * 			|	then new.setY(y)
	 * @throws	IllegalValueException
	 * 			The given x is not a valid value for the x coordinate
	 * 			| ! isValidValue(x)
	 * @throws	IllegalValueException
	 * 			The given y is not a valid value for the y coordinate
	 * 			| ! isValidValue(y)
	 */
	public void transformTo(double x, double y){
		if(!isValidValue(x)){
			throw new IllegalValueException(x);
		}
		if(!isValidValue(y)){
			throw new IllegalValueException(y);
		}
		this.setX(x);
		this.setY(y);
	}

	/**
	 * Set the value of the x coordinate.
	 * @param 	newValue
	 * 			The new value for the x coordinate.
	 */
	private void setX(double newValue){this.x = newValue;}

	/**
	 * Set the value of the y coordinate
	 * @param 	newValue
	 * 			The new value for the y coordinate.
	 */
	private void setY(double newValue){this.y = newValue;}


}
