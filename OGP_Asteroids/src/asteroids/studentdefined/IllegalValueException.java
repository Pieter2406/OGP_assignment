package asteroids.studentdefined;

import be.kuleuven.cs.som.annotate.*;

/**
 * A class for signaling illegal values.
 * 
 * @author Kristof Bruyninckx
 * @author Pieter Verlinden
 *
 */

public class IllegalValueException extends RuntimeException {
	
	
	/**
	 * Initialize this new illegal value exception with the given value.
	 * 
	 * @param 	value
	 * 			The value of this new illegal value
	 * @post	The value of this new illegal value exception
	 * 			is equal to the given value.
	 * 			| new.getValue() == value
	 */
	public IllegalValueException(double value){
		this.value = value;
	}
	
	/**
	 * Return the value registered for this illegal value exception
	 */
	@Basic @Immutable
	public double getValue() {
		return this.value;
	}
	
	/**
	 * Variable that holds the value in this illegal value exception.
	 */
	private final double value;
	
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	
}
