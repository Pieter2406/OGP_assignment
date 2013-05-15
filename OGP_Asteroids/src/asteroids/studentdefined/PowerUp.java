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
protected final long lifeTime;
		
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
	 * @effect	Initializes this powerup with 0 velocity and no mass.
	 * 			|super(x,y,DEFAULT_RADIUS,0,world)
	 */
	@Raw
	public PowerUp(double x, double y, World world, int type) {
		super(x,y,DEFAULT_RADIUS,0, world);
		this.type = type;
		lifeTime = System.currentTimeMillis();
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
		long timeDifference = System.currentTimeMillis() - lifeTime;
		if (timeDifference > World.POWER_UP_LIFE_TIME){
			terminate();
		}
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
}
