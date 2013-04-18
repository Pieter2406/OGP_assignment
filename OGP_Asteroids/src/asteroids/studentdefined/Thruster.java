package asteroids.studentdefined;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;

/**
 * A class of thrusters that provide acceleration for space ships and possibly for other entities.
 * @invar	Each thruster is attached to exactly one space object.
 * 			| hasProperSource()
 * 
 * @version 1.0
 * 
 * @author Wouter Bruyninckx
 * @author Kristof Bruyninckx
 * @author Pieter Verlinden
 */
public class Thruster {
	
	/**
	 * Initialize a thruster which is disabled for a ship by default.
	 * @param 	source
	 * 			The object for which a thruster is initialized.
	 * @post 	This thruster is disabled
	 * 			| !isEnabled()
	 * @post	The force of this thruster is equal to the given force if the given force is
	 * 			a valid force. Otherwise the FORCE_EXERTED is set to the default force.
	 * 			| if(isValidForce(force)
	 * 			| 		FORCE_EXERTED == force
	 * 			| else
	 * 			|		FORCE_EXERTED == FORCE_EXERTED_DEFAULT
	 * @post	The acceleration of this thruster is equal to the force divided by the mass of the ship
	 * 			this thruster is attached to if the source is valid. Otherwise the acceleration
	 * 			is set to 0.
	 * 			| if(hasProperSource())
	 * 			|		ACCELERATION = FORCE_EXERTED / source.getMass()
	 * 			| else
	 * 			|		Acceleration = 0
	 * @effect	The source of this thruster is equal to the given source if the given source is equal.
	 * 			| setSource(source)
	 * 
	 */
	public Thruster(Ship source, double force) {
		disable();
		if(isValidForce(force)){
			FORCE_EXERTED = force; 
		}else{
			FORCE_EXERTED = FORCE_EXERTED_DEFAULT;
		}
		if(Ship.isValidShip(source)){
			ACCELERATION = FORCE_EXERTED / source.getMass().getMass();
		}else{
			ACCELERATION = 0;
		}
		
		setSource(source);
	}


	/**
	 * Initialize a thruster which is disabled for a space object.
	 * 
	 * @param 	source
	 * 			The object for which a thruster is initialized.
	 * @effect	This thruster is initialized with the default force.
	 * 			| this(source, FORCE_EXERTED_DEFAULT)
	*/
	public Thruster(Ship source) {
		this(source, FORCE_EXERTED_DEFAULT); 
	}
	
	/*____________________________METHODS____________________________*/
	
	/**
	 * The method thrust serves to change the current velocity
	 * 
	 * @param amount
	 * 			The amount of velocity added to the current velocity in Km/h.
	 * @effect	If the given amount is higher than zero, this amount is added to the current velocity. If the new velocity 
	 * 			exceeds the speed of light, it will take on the value of the speed of light.
	 * 			| if (amount > 0 && amount < getVelocity().SPEED_OF_LIGHT)
	 * 			|	setVelocity(getVelocity().getVelocityX() + (checkedAmount * Math.cos(getAngle()), getVelocity().getVelocityY() + (checkedAmount * Math.sin(getAngle()))
	 * 			|if(new.getVelocity > getVelocity().SPEED_OF_LIGHT)
	 * 			|	new.getVelocity == getVelocity().SPEED_OF_Light
	 * 			
	 * 
	 */
	public void thrust(double amount){
		double checkedAmount = amount * getAcceleration();
		if(amount > 0){
			double newVelocityX = getSource().getVelocity().getVelocityX() + (checkedAmount * Math.cos(getSource().getAngle()));
			double newVelocityY = getSource().getVelocity().getVelocityY() + (checkedAmount * Math.sin(getSource().getAngle()));
			getSource().setVelocity	(newVelocityX,newVelocityY);
		}
	}
	
	/*____________________________IS_ENABLED____________________________*/
	/**
	 * Enables the thruster.
	 * 
	 * @post	The thruster is enabled.
	 * 			|isEnabled() == true
	 */
	public void enable(){
		isEnabled = true;
	}
	
	/**
	 * Disables the thruster.
	 * 
	 * @post	The thruster is disabled.
	 * 			|isEnabled() == false
	 */
	public void disable(){
		isEnabled = false;
	}
	
	/**
	 * Check whether the thruster is enabled or disabled.
	 * 
	 * @return 	true if the thruster is enabled. Otherwise return false.
	 * 			| if(isEnabled == true)
	 * 			| 		return true
	 * 			| else
	 * 			| 		return false
	 */
	public boolean isEnabled() {
		return this.isEnabled;
	}
	
	/**
	 * Holds whether a thruster is enabled.
	 */
	private boolean isEnabled;
	
	/*____________________________SOURCE____________________________*/
	
	/**
	 * Return the source ship of this thruster.
	 */
	@Basic @Raw
	public Ship getSource(){
		return source;
	}
	
	/**
	 * Set the source of the ship.
	 * 
	 * @param 	source
	 * 			The new source ship for this thruster.
	 * @post	The source of the ship is set to the given ship.
	 * 			If the source ship is not a valid ship, the source
	 * 			is set to null.
	 * 			| if(!Ship.isValidShip(source))
	 * 			|		new.getSource() == null
	 * 			| else
	 * 			|		new.getSource() == source
	 */		
	public void setSource(Ship source){
		if(!Ship.isValidShip(source)){
			this.source = null;
		}else{
			this.source = source;
		}
	}
	
	/**
	 * Check whether this thruster has a proper source.
	 * 
	 * @return	true if and only this thruster has a proper source.
	 * 			In other words, this thruster has a source that is 
	 * 			effective, and the source has a thruster that references
	 *			to this thruster.
	 *			| result == this.getSource() != null && this.getSource().getThruster() == this;
	 */
	public boolean hasProperSource() {
		return this.getSource() != null && this.getSource().getThruster() == this;
	}
	
	/**
	 * Holds the source of a thruster.
	 * 
	 * @invar	The source must reference this thruster and be a valid Ship.
	 * 			| source instanceOf Ship && getSource().getThruster() == this
	 */
	private Ship source;
	
	/*____________________________ACCELERATION____________________________*/
	
	/**
	 * Return the acceleration of this thruster.
	 */
	@Basic @Raw
	public double getAcceleration(){
		return ACCELERATION;
	}
	
	/**
	 * Holds the amount of acceleration this thruster provides to the SpaceObject it is currently attached to.
	 */
	private final double ACCELERATION;
	
	/*____________________________FORCE____________________________*/
	
	/**
	 * Return the exerted force of this thruster.
	 */
	@Basic @Raw
	public double getForce(){
		return FORCE_EXERTED;
	}
	
	/**
	 * Check whether the given force is a valid force.
	 * 
	 * @param 	force
	 * 			The given force to check.
	 * @return	true if and only if the given force is valid. In other words
	 * 			the force is larger than zero and is an effective number.
	 * 			| if(force > 0 && !Double.isNaN(force))
	 * 			|		result == true
	 * 			| else
	 * 			| 		result == false
	 */
	private boolean isValidForce(double force) {
		if(force > 0 && !Double.isNaN(force)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Holds the amount of force of this thruster.
	 */
	private final double FORCE_EXERTED;
	
	/**
	 * Holds the default force for this thruster, to be used if no force is supplied.
	 */
	private static final double FORCE_EXERTED_DEFAULT = 1.1E18;
}
