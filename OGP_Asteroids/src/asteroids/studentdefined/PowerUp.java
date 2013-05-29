/**
 * 
 */
package asteroids.studentdefined;


import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;

/**
 * Abstract class that holds methods and function for PowerUps and 
 * inherits from SpaceObject.
 * 
 * @author Kristof Bruyninckx
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 * 
 * @version 1.1
 */
public abstract class PowerUp extends SpaceObject {
protected final int type;
public static final double DEFAULT_RADIUS = 30;
@Deprecated
public final long lifeTime;
public double activatedLifeTime;
protected Ship sourceShip;
		
	/**
	 * Initializes the power up with a given x and y coordinate, a world and a type.
	 * @param	x
	 * 			The x coordinate of this powerup.
	 * @param	y
	 * 			The y coordinate of this powerup.
	 * @param 	world
	 * 			The world where this powerup exists.
	 * @param	type
	 * 			The type of the powerup.
	 * @param	sourceShip
	 * 			The sourceShip that has this powerup as active.
	 * @effect	Initializes this powerup with 0 velocity and no mass.
	 * 			|super(x,y,DEFAULT_RADIUS,0,world)
	 */
	@Raw
	public PowerUp(double x, double y, World world, int type, Ship sourceShip) {
		super(x,y,DEFAULT_RADIUS,0, world);
		this.type = type;
		lifeTime = System.currentTimeMillis();
		activatedLifeTime = 0.0;
		this.sourceShip = sourceShip;
	}

	/**
	 * Return the type of this powerup.
	 */
	@Basic
	public int getType(){
		return type;
	}
	
	@Override
	public void move(double time){
		/*
		long timeDifference = System.currentTimeMillis() - lifeTime;
		if (timeDifference > World.POWER_UP_LIFE_TIME){
			terminate();
		}
		*/
	}
	/**
	 * Checks if the given object is a valid powerup.
	 *
	 * @param 	o 
	 * 			The object to check.
	 * @return 	True, if the given object is a valid powerup.
	 */
	public static boolean isValidPowerUp(Object o){
		if(o == null || !(o instanceof PowerUp)){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * Return the the total time that this powerup is active.
	 * @return total time this powerup is active.
	 */
	protected double getActiveLifeTime(){
		return System.currentTimeMillis() - activatedLifeTime;
	}
	
	/**
	 * Return true if the lifetime of this powerup is exceeded.
	 * @return true if and only if the time of this powerup is exceeded
	 * 		| return (getLifeTime() > MAXIMUM_LIFE_TIME)
	 */
	protected abstract boolean hasPassedActiveLifeTime();
	
	/**
	 * Return the ship that has this powerup active.
	 * @return the ship that has this powerup as active.
	 * 		| return this.sourceShip;
	 */
	public Ship getSourceShip(){
		return this.sourceShip;
	}
	
	/**
	 * Set the source ship of this powerup to the given ship.
	 * @param	sourceShip
	 * 			The given ship that will be set to the source ship of this powerup.
	 * @post	the source ship of this powerup is set to the given ship and
	 * 			the power up is added to the list of powerups in the source ship.
	 * 			| this.sourceShip = sourceShip
	 * 			| sourceship.addPowerUp(this)
	 */
	public void setSourceShip(Ship sourceShip){
		if(Ship.isValidShip(sourceShip)){
			this.sourceShip = sourceShip;
			sourceShip.addPowerUp(this);
		}
		
	}
	/**
	 * Set the active life time to the current system time.
	 * @post	The active life time of this powerup is set to the current
	 * 			system time.
	 * 			|this.activatedLifeTime = System.currentTimeMillis();
	 */
	public void setActiveLifeTime(){
		this.activatedLifeTime = System.currentTimeMillis();
	}
	/**
	 * Activates the powerups and its corresponding effects.
	 */
	public abstract void activate();
	
	/**
	 * Evaluates the powerups lifetime and deactivates it if 
	 * its lifetime is passed.
	 */
	public abstract void evaluate();
	
	/**
	 * Terminates this object.
	 * @effect	set the source ship of this powerup to null,
	 * 			remove this powerup from the list of active powerups
	 * 			out of its source ship.
	 * 			remove all references to this powerup in the world.
	 * 
	 */
	@Override
	public void terminate(){
		if(sourceShip != null){
			sourceShip.removePowerUp(this);
			this.setSourceShip(null);
		}
		if(getWorld() != null){
			getWorld().removeSpaceObject(this);
		}
	}
	
	/**
	 * Attached a powerup to a ship and removes the association with its world.
	 * @param 	ship
	 * 			The ship where this powerup will be attached to.
	 * @effect	Associates the given ship with this powerup.
	 * 			|this.setSourceShip(ship)
	 */
	public void attachToShip(Ship ship){
		this.isTerminated = true;
		getWorld().removeSpaceObject(this);
		this.setSourceShip(ship);
	}
}
