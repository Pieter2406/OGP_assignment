package asteroids.studentdefined;
import be.kuleuven.cs.som.annotate.*;

/**
 * TODO: write Velocity in total manner!!
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
public class Velocity {
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
	 * @post	The velocity in the x direction is equal to the given 
	 * 			velocity in the x direction.
	 * 			| new.getVelocityX() == velocityX
	 * @post	The velocity in the y direction is equal to the given
	 * 			velocity in the y direction.
	 * 			| new.getVelocityY() == velocityY
	 * @post	The maximum velocity is equal to the given velocity.
	 * 			| new.getMaxVelocity == maxVelocity
	 * @throws	IllegalValueException
	 * 			The given velocity in the x direction is not a valid velocity.
	 * 			| ! isValidVelocity(velocityX)
	 * @throws	IllegalValueException
	 * 			The given velocity in the y direction is not a valid velocity.
	 * 			| ! isValidVelocity(velocityY)
	 * @throws	IllegalValueException
	 * 			The given maximum velocity is higher than the speed of light or is not 
	 * 			a number
	 * 			| (maxVelocity > SPEED_OF_LIGHT || Double.isNaN(maxVelocity)) 
	 */
	public Velocity(double velocityX, double velocityY, double maxVelocity){
//		if(!isValidVelocity(velocityX)){
//			throw new IllegalValueException(velocityX);
//		}
//		if(!isValidVelocity(velocityY)){
//			throw new IllegalValueException(velocityY);
//		}
//		if(maxVelocity > SPEED_OF_LIGHT || Double.isNaN(maxVelocity)){
//			throw new IllegalValueException(maxVelocity);
//		}
		
		this.velocityX = velocityX;
		this.velocityY = velocityY;
		this.maxVelocity = maxVelocity;
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
	 * 			|this(velocityX,velocityY,SPEED_OF_LIGHT)
	 * @throws	IllegalValueException
	 * 			The given velocity in the x direction is not a valid velocity.
	 * 			| ! isValidVelocity(velocityX)
	 * @throws	IllegalValueException
	 * 			The given velocity in the y direction is not a valid velocity.
	 * 			| ! isValidVelocity(velocityY)
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
	 * @return	The net velocity based on the velocity in the x and y direction of this object.
	 */
	public double computeVelocity(){
		double velocity = 0.0;
		velocity = Math.sqrt(
				Math.pow(getVelocityX(),2) 
						+ 
				Math.pow(getVelocityY(),2)
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
	 * 			|	then new.setVelocityX(velocityX)
	 * @post	if the given velocity in the Y direction is a valid velocity,
	 * 			the velocity in the Y direction of this class is set to the
	 * 			given value.
	 * 			| if(isValidVelocity(velocityY)
	 * 			|	then new.setVelocityY(velocityY)
	 * @throws	IllegalValueException
	 * 			The given velocity in the x direction is not a valid velocity.
	 * 			| ! isValidVelocity(velocityX)
	 * @throws	IllegalValueException
	 * 			The given velocity in the y direction is not a valid velocity.
	 * 			| ! isValidVelocity(velocityY)
	 */
	public void setVelocity(double velocityX, double velocityY){
		if(!isValidVelocity(velocityX)){
			throw new IllegalValueException(velocityX);
		}
		if(!isValidVelocity(velocityY)){
			throw new IllegalValueException(velocityY);
		}
		this.setVelocityX(velocityX);
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
		
}
