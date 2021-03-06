package asteroids.studentdefined;
import asteroids.Util;
import be.kuleuven.cs.som.annotate.*;

/**
 * 
 * 
 * A class of velocity holds a velocity in the two-dimensional space, divided into an x-component
 * and an y-component
 * 
 * @invar 	The value of velocityX must always be legal. It may never be higher than the
 * 			speed of light.
 * 			| isValidVelocity(getVelocityX())
 * @invar	The value of velocityY must always be legal. It may never be higher than the
 * 			speed of light.
 * 			| isValidVelocity(getVelocityY())
 * @invar	The value of maxVelocity must always be legal. It may never be higher than the
 * 			speed of light.
 * 			| getMaxVelocity() <= SPEED_OF_LIGHT)
 * 
 * @version 1.1
 * 
 * @author Kristof Bruyninckx
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 *
 */
@Value
public class Velocity implements Comparable<Velocity>{
	/**
	 * Initialize this new velocity with the given velocity in the x direction, 
	 * the given velocity in the y direction and a given maximum velocity (never higher than
	 * the speed of light).
	 * 
	 * @param	velocityX
	 * 			The value for the velocity in the x-direction.
	 * @param	velocityY
	 * 			The value for the velocity in the y-direction.
	 * @param	maxVelocity
	 * 			The value for the maximum velocity. This value may
	 * 			never be higher than the speed of light.
	 * @post	The velocity in the x and y direction is equal to the given 
	 * 			velocity in the x and y direction, if the given velocity is valid.
	 * 			If the given velocity is invalid the velocity of this ship in the x direction equals 0.
	 * 			| if (isValidVelocity(computeVelocity(velocityX,velocityY))
	 * 			| 	then new.getVelocityX() == velocityX
	 * 			|		 new.getVelocityY() == velocityY
	 * 			| else
	 * 			| 	new.getVelocityX() == 0
	 * 			|	new.getVelocityY() == 0
	 * @post	If the given maximum velocity is valid, this ship's maximum velocity is equal to the given 
	 * 			maximum velocity, else this ship's maximum velocity is equal to the speed of light.
	 * 			| if (maxVelocity > SPEED_OF_LIGHT || Double.isNaN(maxVelocity)) 
	 * 			| 	then new.getMaxVelocity == SPEED_OF_LIGHT
	 * 			|else
	 * 			|	new.getMaxVelocity == maxVelocity
	 */
	public Velocity(double velocityX, double velocityY, double maxVelocity){
		if(maxVelocity > SPEED_OF_LIGHT || Double.isNaN(maxVelocity)){
			maxVelocity = SPEED_OF_LIGHT; 
		}
		this.maxVelocity = maxVelocity;
		
		if(!isValidVelocity(computeVelocity(velocityX,velocityY))){
			velocityX = 0;
			velocityY = 0;
		}
		this.velocityX = velocityX;
		this.velocityY = velocityY;

	}

	/**
	 * Initialize this new velocity with the given velocity in the x direction 
	 * and the given velocity in the y direction in the two-dimensional space.
	 * Maximum velocity is set to the speed of light.
	 * 
	 * @param	velocityX
	 * 			The value for the velocity in the x-direction.
	 * @param	velocityY
	 * 			The value for the velocity in the y-direction.
	 * @effect	This new velocity is initialized with given velocities in x and y direction and
	 * 			the speed of light as maximum velocity.
	 * 			| this(velocityX,velocityY,SPEED_OF_LIGHT)
	 */

	public Velocity(double velocityX, double velocityY){
		this(velocityX,velocityY,SPEED_OF_LIGHT);
	}

	/**
	 * Initialize this new velocity with initial x and y components equal to zero and with a 
	 * maximum velocity of the speed of light. 
	 * 
	 * @effect	The new velocity is initialized zero as values for x and y velocities and
	 * 			the speed of light as maximum velocity.
	 * 			|this(0,0,SPEED_OF_LIGHT)
	 */
	public Velocity(){
		this(0,0,SPEED_OF_LIGHT);
	}

	/**
	 * Return the velocity in the x direction.
	 */
	@Basic @Raw
	public double getVelocityX(){return velocityX;}

	/**
	 * Holds the velocity in the x direction.
	 */
	private double velocityX;

	/**
	 * Return the velocity in the y direction.
	 */
	@Basic @Raw
	public double getVelocityY(){return velocityY;}

	/**
	 * Holds the velocity in the y direction.
	 */
	private double velocityY;

	/**
	 * Return the maximum velocity.
	 */
	@Basic @Raw
	public double getMaxVelocity(){return maxVelocity;}

	/**
	 * Holds the maximum velocity.
	 */
	private final double maxVelocity;

	/**
	 * Return the computed velocity based on the velocity in the x and the y direction of this object.
	 * 
	 * @param	velocityX
	 * 			The given velocity in the X direction.
	 * @param	velocityY
	 * 			The given velocity in the Y direction.
	 * @return	The net velocity based on the given velocity in the x and y direction.
	 */
	public static double computeVelocity(double velocityX, double velocityY){
		double velocity = 0.0;
		velocity = Math.sqrt(
				Math.pow(velocityX,2) 
				+ 
				Math.pow(velocityY,2)
				);
		return velocity;
	}

	/**
	 * Holds the speed of light.
	 */
	public static final double SPEED_OF_LIGHT = 299792.458;

	/**
	 * Return true if the given velocity is a valid value. In other words
	 * the given velocity may not exceed the maximum velocity or not be less than
	 * zero, and must be a number.
	 * @param 	velocity
	 * 			The velocity to check.
	 * @return	True if and only if the given velocity does not exceed the
	 * 			maximum velocity, is not less than zero and is a number.
	 * 			| result ==
	 * 			|	velocity <= maxVelocity
	 * 			|	velocity >= 0
	 * 			|	!Double.isNaN(velocity)
	 */
	private boolean isValidVelocity(double velocity){
		if(velocity <= getMaxVelocity() && velocity >= -getMaxVelocity() && !Double.isNaN(velocity)){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Set the velocity with velocities in the x an y direction.
	 * @param 	velocityX
	 * 			The velocity in the x direction.
	 * @param 	velocityY
	 * 			The velocity in the y direction.
	 * @post	if the given velocity in the x direction is a valid velocity,
	 * 			the velocity in the x direction of this class is set to the
	 * 			given value.
	 * 			| if(isValidVelocity(velocityX)
	 * 			|	then new.getVelocityX == velocityX
	 * @post	if the given velocity in the Y direction is a valid velocity,
	 * 			the velocity in the Y direction of this class is set to the
	 * 			given value.
	 * 			| if(isValidVelocity(velocityY)
	 * 			|	then new.getVelocityY == velocityY
	 */
	public void setVelocity(double velocityX, double velocityY){
		if(isValidVelocity(velocityX))
			this.setVelocityX(velocityX);
		if(isValidVelocity(velocityY))
			this.setVelocityY(velocityY);
	}

	/**
	 * Set the value of the velocity in the X direction.
	 * @param 	velocityX
	 * 			The new velocity in the x direction.
	 */
	private void setVelocityX(double velocityX){this.velocityX = velocityX;}

	/**
	 * Set the value of the velocity in the y direction.
	 * @param 	velocityY
	 * 			The new velocity in the y direction.
	 */
	private void setVelocityY(double velocityY){this.velocityY = velocityY;}

	public static double computeXVelocity(double angle, double trueVelocity){
		return Math.cos(angle) * trueVelocity;
	}

	public static double computeYVelocity(double angle, double trueVelocity){
		return Math.sin(angle) * trueVelocity;
	}

	// Value class method overides
	//_____________________________________________________________________________________
	
	@Override
	public int compareTo(Velocity other) {
		if (other == null)
			return 1; // if other does not exist this velocity is always bigger (total programming).
		if (Util.fuzzyEquals(computeVelocity(getVelocityX(),getVelocityY()),computeVelocity(other.getVelocityX(), other.getVelocityY())))
			return 0;
		if (computeVelocity(getVelocityX(),getVelocityY()) < computeVelocity(other.getVelocityX(), other.getVelocityY()))
			return -1;
		else
			return 1;
	}
	
	
	
	@Override
	public int hashCode(){
		Double velocityX = ((Double)getVelocityX());
		Double velocityY = ((Double)getVelocityY());
		return velocityX.hashCode() + velocityY.hashCode();
	}
	
	@Override
	public String toString(){
		return computeVelocity(getVelocityX(),getVelocityY()) + "";
	}
}
