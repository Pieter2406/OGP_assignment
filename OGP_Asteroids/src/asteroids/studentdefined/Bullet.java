package asteroids.studentdefined;

import be.kuleuven.cs.som.annotate.Basic;
/**********************************************************************************
 * 								GENERAL TODO LIST:		              			  *
 **********************************************************************************
 *		- radius / minimumRadius = 3											  *
 *		- private final Ship sourceShip (mag nooit null zijn)					  *
 *		- public final double initVelocity = 250 km/s							  *	
 *		- public static final double massDensity = 7,8E12 kg/km³				  *
 *		- public double angle 													  *
 **********************************************************************************/

/**
 * A class of Bullet extends to SpaceObject and involves a position and a velocity.
 * 
 * @version 1.1
 * 
 * @invar	The source of a ship must be valid.
 * 			| isValidSource()
 * 
 * @author Kristof Bruynincks
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 */
public class Bullet extends SpaceObject{
	/**
	 * Initialise this new bullet with a given position , a given velocity and a given radius.
	 * @param 	x
	 * 			The position on the x axis for this new bullet.
	 * @param 	y
	 * 			The position on the y axis for this new bullet.
	 * @param 	velocityX
	 * 			the velocity on the x axis for this new bullet.
	 * @param 	velocityY
	 * 			the velocity on the y axis for this new bullet.
	 * @param 	radius
	 * 			The given radius for this new bullet.
	 * @param 	source
	 * 			The given ship that fired this bullet.
	 * @effect 	This bullet is intialised as a spaceobject with the given parameters.
	 * 			| super((x, y, velocityX, velocityY, radius, 0, Mass.computeCircularMass(MASS_DENSITY, radius))
	 * @throws	IllegalArgumentException
	 * 			if source is not a valid ship
	 * 			| !isValidSource()
	 */
	public Bullet(double x, double y, Ship source, World world,double speedMultiplier, double bulletScaler, double angle)	throws IllegalArgumentException{
		super(x, y, bulletScaler * DEFAULT_BULLET_RADIUS, Mass.computeCircularMass(MASS_DENSITY, bulletScaler * DEFAULT_BULLET_RADIUS), world);
		if (isValidSource(source)){
			this.source = source; // source is final no setter.
			this.setAngle(angle);
			this.setVelocity(Velocity.computeXVelocity(this.getAngle(), REGULAR_BULLETSPEED * speedMultiplier),Velocity.computeYVelocity(this.getAngle(), REGULAR_BULLETSPEED* speedMultiplier));
		}
		else
			throw new IllegalArgumentException("Not a valid source.");

	}

	 /*_____________________________SOURCE_____________________________*/
	
	/**
	 * Return the source of this bullet.
	 */
	@Basic
	public Ship getSource(){
		return this.source;
	}
	
	/**
	 * Return whether the given source is a valid ship.
	 * @param 	source
	 * @return	True if the source is an existing ship
	 */
	public static boolean isValidSource(Ship source){
		if (source == null)
			return false;
		return true;
	}
	
	/**
	 * Holds the source of the ship.
	 */
	private final Ship source;
	
	/*_____________________________ANGLE_____________________________*/
	
	/**
	 * Return the angle of this bullet.
	 */
	@Basic
	public double getAngle(){
		return angle;
	}
	/**
	 * Set the angle of this bullet to the given angle.
	 * @param 	angle
	 * 			The given new angle for this ship
	 * @post 	The angle of this bullet is equal to the given angle.
	 * 			| new.angle = getAngle();
	 */
	public void setAngle(double angle){
		this.angle = angle;
	}
	/**
	 * Holds the angle of the bullet in which 
	 * direction this bullet is fired.
	 */
	private double angle;
	
	/*_____________________________HAS_HIT_WALL_____________________________*/
	
	/**
	 * Return true if the bullet has hit a wall.
	 */
	@Basic
	public boolean getHasHitWall(){return hasHitWall;}

	/**
	 * Set whether this bullet has hit a wall.
	 * @param	bool
	 * 			the boolean value (true or false)
	 * @post	The boolean that holds whether the
	 * 			bullet has hit a wall is set to
	 * 			the given argument.
	 */
	public void setHasHitWall(boolean bool){this.hasHitWall = bool;}

	/**
	 * Holds the boolean value whether this bullet
	 * has hit a wall.
	 */
	private boolean hasHitWall = false;
	
	
	/**
	 * Checks if the given object is a valid bullet.
	 *
	 * @param 	o 
	 * 		The object to check.
	 * @return 	True, if the given object is a valid bullet.
	 */
	public static boolean isValidBullet(Object o){
		if(o == null || !(o instanceof Bullet)){
			return false;
		}else{
			return true;
		}
	}
	
	private final static double MASS_DENSITY = 7.8E12;
	private final static double DEFAULT_BULLET_RADIUS = 3;
	private final static double REGULAR_BULLETSPEED = 250;
}
