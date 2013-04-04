package asteroids.studentdefined;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;

/**
 * A class of thrusters that provide acceleration for space ships and possibly for other entities.
 * @author Wouter Bruyninckx
 * @author Kristof Bruyninckx
 * @author Pieter Verlinden
 * @version 1.0
 * 
 * @invar	Each thruster is attached to exactly one space object.
 * 			| hasProperSource()
 */
public class Thruster {
	
	/**
	 * Initialize a thruster which is disabled for a ship by default.
	 * @param 	source
	 * 			The object for which a thruster is initialized.
	 * @post 	This thruster is disabled
	 * 			| !isEnabled()
	 * @post	The force of this thruster is equal to the given force
	 * 			| FORCE_EXERTED == force
	 * @post	The acceleration of this thruster is equal to the force divided by the mass of the ship.
	 * 			this thruster is attached to.
	 * 			| acceleration == force / source.getMass()
	 * @post	The source of this thruster is equal to the given source.
	 * 			| this.getSource() == source
	 */
	public Thruster(Ship source, double force) {
		disable();
		FORCE_EXERTED = force; 
		ACCELERATION = FORCE_EXERTED / source.getMass().getMass();
		setSource(source);
	}
	
	/**
	 * Initialize a thruster which is disabled for a space object.
	 * @param 	source
	 * 			The object for which a thruster is initialized.
	 * @effect	This thruster is initialized with the default force.
	 * 			| this(source, FORCE_EXERTED_DEFAULT)
	*/
	public Thruster(Ship source) {
		this(source, FORCE_EXERTED_DEFAULT); 
	}
	
	@Basic @Raw
	public Ship getSource(){
		return source;
	}
	
	public void setSource(Ship source){
		this.source = source;
	}
	
	public boolean hasProperSource() {
		return this.getSource() != null && this.getSource().getThruster() == this;
	}
	
	/**
	 * Holds the source of a thruster
	 * @invar	The source must reference this thruster and be a valid Ship.
	 * 			| source instanceOf Ship && getSource().getThruster() == this
	 */
	private Ship source;
	
	public void enable(){
		isEnabled = true;
	}
	
	public void disable(){
		isEnabled = false;
	}
	
	public boolean isEnabled() {
		return this.isEnabled;
	}
	
	/**
	 * Holds whether a thruster is enabled.
	 */
	private boolean isEnabled;
	
	@Basic @Raw
	public double getAcceleration(){
		return ACCELERATION;
	}
	
	/**
	 * Holds the amount of acceleration this thruster provides to the SpaceObject it is currently attached to.
	 */
	private final double ACCELERATION;
	
	@Basic @Raw
	public double getForce(){
		return FORCE_EXERTED;
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
