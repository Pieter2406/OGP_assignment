package asteroids.studentdefined;
import asteroids.IShip;
import asteroids.Util;
import be.kuleuven.cs.som.annotate.*;
/**********************************************************************************
 * 								GENERAL TODO LIST:		              			  *
 **********************************************************************************
 *		- Implement mass	(OK, in SpaceObject)								  *
 *		- Implement thruster (eventueel aparte klasse)	(OK)					  *
 *		- Implement fireBullet	(OK specificatie)								  *
 *		- Bekijk aanpassingen van feedback !!									  *
 *		- Position: DEFENSIEF													  *
 *		- Velocity: TOTAAL														  *
 *		- Radius: DEFENSIEF														  *
 *		- Angle/Direction: NOMINAAL												  *	
 *																				  *
 **********************************************************************************/

/**
 * A class of a Ship extends to SpaceObject and involves a position in the two dimensional space, a velocity, a radius (the ship has a round form) and a direction.
 * 
 * @invar 	The radius of a ship is always higher than the minimum radius of all ships, and is always a valid number.
 * 			| isValidRadius(getRadius())
 * @invar 	The angle of a ship must always be a valid number.
 * 			| isValidAngle(getAngle())
 * @invar	Each ship is equipped with exactly one thruster. This thruster is a proper thruster that has this ship as its source.
 * 			| getThruster() InstanceOf thruster && getThruster() != null && getThruster().getSource() == this
 * 
 * @version 1.1
 * 
 * @author Kristof Bruyninckx
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 * 
 */
public class Ship extends SpaceObject implements IShip {
	/**
	 * Initialize the position, the radius and the angle of this ship with respectively the given position, radius and angle. 
	 * Initialize the velocity of this ship to zero.
	 * @param 	x
	 * 			The position on the x-as for this new ship.
	 * @param 	y 
	 * 			The position on the y-as for this new ship.
	 * @param	velocityX
	 * 			The velocity in the x direction.
	 * @param	velocityY
	 * 			The velocity in the y direction.
	 * @param	radius
	 * 			The radius for this new ship.
	 * @param 	angle
	 * 			The angle for this new ship.
	 * @param 	mass
	 * 			The mass for this new ship.
	 * @pre		The given radius must be a valid radius
	 * 			| isValidRadius(radius)
	 * @effect	The Position, the radius and the angle of this ship are equal to respectively the given position, the given radius and the given angle.
	 * 			The speed of this ship is initialized with a given velocity in x and y directions. The mass is initialized with a given mass.
	 * 			| super(x,y,velocityX,velocityY,radius, 10, mass)
	 * 			| this.setAngle(angle)
	 * 
	 */
	public Ship(double x, double y,double velocityX, double velocityY, double radius, double angle, double mass, World world){
		super(x,y,velocityX,velocityY,radius,10, mass, world);
		this.setAngle(angle);
		thruster = new Thruster(this);
	}


	/**
	 * Initialize the position, the radius and the angle of this ship with respectively the given position, radius and angle. 
	 * Initialize the velocity of this ship to zero.
	 * @param 	x
	 * 			The position on the x-as for this new ship.
	 * @param 	y 
	 * 			The position on the y-as for this new ship.
	 * @param	radius
	 * 			The radius for this new ship.
	 * @param 	angle
	 * 			The angle for this new ship.
	 * @param	mass
	 * 			The mass for this new ship.
	 * @pre		The given radius must be a valid radius
	 * 			| isValidRadius(radius)
	 * @effect 	This new ship is initialized with a given x coordinate, a given y coordinate, 
	 * 			a velocity of zero in the x and y direction,
	 * 			a radius and a given angle.
	 * 			| this(x,y,0,0,radius, angle)
	 */
	public Ship(double x, double y, double radius, double angle, double mass, World world){
		this(x,y,0,0,radius,angle,mass, world);
	}

	/**
	 * Enables the thruster that is attached to this ship.
	 */
	public void enableThruster() {
		getThruster().enable();
	}
	
	/**
	 * Disables the thruster that is attached to this ship.
	 */
	public void disableThruster() {
		getThruster().disable();
	}
	
	/**
	 * Returns the thruster that is currently attached to this ship.
	 * @return The thruster that is attached to this ship.
	 */
	public Thruster getThruster() {
		return thruster;
	}
	
	public boolean isThrusterActive() {
		return getThruster().isEnabled();
	}
	
	/**
	 * Holds the thruster that is attached to this ship.
	 */
	private Thruster thruster;
	
	/**
	 * Return this ship's angle.
	 */
	@Basic @Raw
	public double getAngle(){
		return angle;
	}

	/**
	 * Return true if the given angle is a valid angle.
	 * @param 	angle
	 * 			The given angle for this ship.
	 * @return	True if and only if the given angle is a valid number.
	 */
	public static boolean isValidAngle(double angle){
		return !Double.isNaN(angle);
	}

	/**
	 * Set the angle of this ship to the given angle.
	 * @param 	angle
	 * 			The new angle for this ship.
	 * @pre		The given angle must be a valid angle.
	 * 			| isValidAngle(angle)
	 * @post	If the given angle is smaller than 2PI and higher than -2PI,
	 * 			the angle of this ship is equal to the given angle. If the given
	 * 			angle is not within those boundaries the angle of this ship
	 * 			is equal to the given angle modulo 2PI.
	 * 			| if (angle < 2*Math.PI && angle > (-2)*Math.PI
	 * 			| 	new.getAngle() == angle
	 * 			| else 
	 * 			| 	new.getAngle() == angle % 2*Math.PI
	 */
	@Raw
	public void setAngle(double angle){
		if (angle < 2*Math.PI && angle > (-2)*Math.PI)
			this.angle = angle;
		else
			this.angle = angle % (2*Math.PI);
	}

	/**
	 * Turn the ship into another direction.
	 * @param 	angle
	 * 			The given angle to be added to the current angle.
	 * @pre		The given angle must be a valid angle.
	 * 		    | isValidAngle(angle)
	 * @pre		the ship's angle plus the given angle is not allowed to overflow.
	 * 			| if (getAngle() > 0 && angle > 0)
	 * 			| 	angle < Double.MAX_VALUE - getAngle().
	 * 			| else if (getAngle() < 0 && angle < 0)
	 * 			|	angle > Double.MIN_VALUE + getAngle()
	 * @effect 	Set the angle to the current angle plus the given angle.
	 * 			| setAngle(this.getAngle() + angle)
	 */
	public void turn(double angle){
		setAngle(getAngle() + angle);
	}

	/**
	 * Variable holding the angle of a ship in radians.
	 */
	private double angle; 


	/**
	 * Move this ship in its current direction for a given amount of time.
	 * @param 	duration
	 * 			The duration of how long the ship moves in its current direction.
	 * @effect	The position of the ship is set to its new position according
	 * 			to the time it would have moved.
	 * 			|new.setPosition(newPositionX,newPositionY)
	 * @throws	IllegalValueException
	 * 			The given duration is not a valid duration.
	 * 			|(duration < 0)
	 */
	@Override
	public void move(double duration){
		if(duration < 0){
			throw new IllegalValueException(duration);
		}
		if(thruster.isEnabled()){
			getThruster().thrust(duration);
		}
		double newPositionX = getPosition().getX() + (duration * getVelocity().getVelocityX());
		double newPositionY = getPosition().getY() + (duration * getVelocity().getVelocityY());
		setPosition(newPositionX,newPositionY);
		
	}
	
	/**
	 * Creates a bullet right next to the ship, at the direction the ship is currently facing.
	 * @post 	An instance of Bullet is created in the world that is associated with this ship.
	 * 			| this.getWorld().createSpaceObject(new bullet)
	 * @post 	This world contains the new bullet that is created.
	 * 			| this.getWorld().containsSpaceObject(new bullet)
	 * @post 	The new bullet is associated with this ship.
	 * 			| (new bullet).getSource() == this
	 * @post	The new bullet has a location right next to this ship, where this ship is currently facing.
	 * 			| (new bullet).getX() == this.getPosition().getX() + this.getRadius() * Math.cos(this.getAngle())
	 * 			| (new bullet).getY() == this.getPosition().getY() + this.getRadius() * Math.sin(this.getAngle())
	 */
	public void fireBullet() {
		if(!isTriShotBulletsOn()){
			double bulletX = this.getPosition().getX() + this.getRadius() * Math.cos(this.getAngle());
			double bulletY = this.getPosition().getY() + this.getRadius() * Math.sin(this.getAngle());
			this.getWorld().addBullet(new Bullet(bulletX,bulletY,this,this.getWorld(),bulletSpeedMultiplier, bulletScaler, this.getAngle()));
		}else{
			//bullet position
			double bulletX = this.getPosition().getX() + this.getRadius() * Math.cos(this.getAngle());
			double bulletY = this.getPosition().getY() + this.getRadius() * Math.sin(this.getAngle());
			//left bullet relative to Ship
			Bullet leftBullet = new Bullet(bulletX,bulletY,this,this.getWorld(),bulletSpeedMultiplier,bulletScaler, this.getAngle() - (Math.PI / 18));
			//middle bullet relative to Ship
			Bullet middleBullet = new Bullet(bulletX,bulletY,this,this.getWorld(),bulletSpeedMultiplier,bulletScaler, this.getAngle());
			//right bullet relative to Ship
			Bullet rightBullet = new Bullet(bulletX,bulletY,this,this.getWorld(),bulletSpeedMultiplier,bulletScaler, this.getAngle() + (Math.PI / 18));
			this.getWorld().addBullet(leftBullet);
			this.getWorld().addBullet(middleBullet);
			this.getWorld().addBullet(rightBullet);
		}
		
	}
	/**
	 * TODO Write speedMultiplyer contracts
	 */
	private double bulletSpeedMultiplier = 1;
	
	/**
	 * 
	 * @return
	 */
	public double getBulletSpeedMultiplier(){
		return bulletSpeedMultiplier;
	}
	
	/**
	 * 
	 * @param speedMultiplier
	 */
	public void setBulletSpeedMultiplier(double speedMultiplier){this.bulletSpeedMultiplier = speedMultiplier;};
	
	/**
	 * TODO Write bulletScaler contracts
	 */
	private double bulletScaler = 1;
	/**
	 * 
	 * @return
	 */
	public double getBulletScaler(){
		return bulletScaler;
	}
	/**
	 * 
	 * @param bulletScaler
	 */
	public void setBulletScaler(double bulletScaler){
		this.bulletScaler = bulletScaler;
	}
	
	/**
	 * TODO Write contract for triShotBullets
	 */
	private boolean triShotBulletsOn = false;
	
	/**
	 * 
	 * @return
	 */
	public boolean isTriShotBulletsOn(){return triShotBulletsOn;}
	/**
	 * 
	 * @param bool
	 */
	public void toggleTriShotBullets(boolean bool){this.triShotBulletsOn = bool;}
	
}
