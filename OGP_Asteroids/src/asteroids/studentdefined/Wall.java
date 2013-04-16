package asteroids.studentdefined;

import be.kuleuven.cs.som.annotate.*;

/**
 * A class of wall involves two coordinates which determine the position and length of the wall and is used to
 * determine the collisions with the boundaries of the field.
 * @version 1.0
 * @author Wouter Bruyninckx
 * @author Kristof Bruyninckx
 * @author Pieter Verlinden
 */
public class Wall {
	/**
	 * Initializes this wall with a coordinate and an orientation. This new wall is a line with the given orientation that goes
	 * through the given coordinate.
	 * @param	p1
	 * 			Holds the first coordinate of this wall.
	 * @param	orientation
	 * 			The orientation of this wall, either "horizontal" or "vertical"
	 * @effect	The first coordinate p1 is set to the given coordinate p1.
	 * 			| setp1(p1)
	 * @effect	The second coordinate p2 is set to the given coordinate p2.
	 * 			| setp2(p2)
	 */
	@Raw
	public Wall(Coordinate p1, String orientation) throws IllegalArgumentException {
		setP1(p1);
		if (orientation.equals("horizontal") || orientation.equals("vertical"))
			this.orientation = orientation;
		else
			throw new IllegalArgumentException("Not a valid wall orientation.");
	}
	
	@Basic @Raw
	public Coordinate getP1() {
		return p1;
	}
	
	/**
	 * Set the first coordinate of this wall to the given coordinate
	 * @param 	p1
	 * 			The new first coordinate for this wall.
	 * @post	This walls first coordinate is equal to the given coordinate
	 * 			| (new this).getp1() == p1
	 * @throws 	IllegalArgumentException
	 * 			The given coordinate is invalid
	 * 			| p1 == null
	 */
	public void setP1(Coordinate p1) throws IllegalArgumentException{
		try {
			this.p1 = p1;
		}
		catch (NullPointerException exc){
			assert (p1 == null);
			throw new IllegalArgumentException("The given coordinate is invalid");
		}
	}
	
	/**
	 * Holds the coordinate that determines the position of this wall.
	 */
	Coordinate p1;
	
	@Basic @Raw
	public String getOrientation() {
		return this.orientation;
	}
	
	/**
	 * Holds the orientation of this wall. Neccesary to determine the position of this wall
	 */
	String orientation;
	
}
