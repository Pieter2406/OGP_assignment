package asteroids.studentdefined;
import asteroids.IShip;
import asteroids.Util;
import be.kuleuven.cs.som.annotate.*;
/**********************************************************************************
 * 								GENERAL TODO LIST:		              			  *
 **********************************************************************************						  *
 *		- Bekijk aanpassingen van feedback !!									  *
 *		- Position: DEFENSIEF													  *
 *		- Velocity: TOTAAL														  *
 *		- Radius: DEFENSIEF														  *
 *		- Angle/Direction: NOMINAAL												  *	
 *																				  *
 **********************************************************************************/

/**
 * A class of a Ship extends to SpaceObject and involves a position in the two dimensional space, a velocity, a radius (the ship has a round form)
 * , a direction, a bulletSpeedMultiplier, a bulletScaleMultiplier, a number of shields and a facility to toggle TriShotBulletsPowerup.
 * 
 * @invar 	The radius of a ship is always higher than the minimum radius of all ships, and is always a valid number.
 * 			| isValidRadius(getRadius())
 * @invar 	The angle of a ship must always be a valid number.
 * 			| isValidAngle(getAngle())
 * @invar	Each ship is equipped with exactly one thruster. This thruster is a proper thruster that has this ship as its source.
 * 			| getThruster() InstanceOf thruster && getThruster() != null && getThruster().getSource() == this
 * @invar	The speed multiplier of a ship's bullet must be a valid multiplier
 * 			| isValidSpeedMultiplier(getBulletSpeedMultiplier())
 * @invar	The bulletScaleMultiplier of this ship must be valid.
 * 			| isValidbulletScaleMultiplier(getScaler())
 * @invar 	The number of shields of a ship must always be between zero and 5.
 * 			| shield > 0 && shield < 5
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
	 * 			The angle for this new ship
	 * @param 	mass
	 * 			The mass for this new ship.
	 * @param 	world
	 * 			The world in which this new ship exists.
	 * @effect	This ship is initialized as a space object with the given x value, y value, velocityX, velocityY, radius, mass and world.
	 * 			The angle of this ship is set to the given angle.
	 * 			This ship's thruster is equal to a new thruster with this ship as it's source.
	 * 			| super(x,y,velocityX,velocityY,radius, 10, mass)
	 * 			| this.setAngle(angle)
	 * 			| (new this).getThruster() == new thruster(this)
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
	 * @effect 	This new ship is initialized with a given x coordinate, a given y coordinate, 
	 * 			a velocity of zero in the x and y direction,
	 * 			a radius,a given angle, a given mass and a given world.
	 * 			| this(x,y,0,0,radius, angle, mass, world)
	 */
	public Ship(double x, double y, double radius, double angle, double mass, World world){
		this(x,y,0,0,radius,angle,mass, world);
	}

	/**
	 * Enables the thruster that is attached to this ship.
	 * @post	This ship's thruster is enabled.
	 * 			| (new this).getThruster == true
	 */
	public void enableThruster() {
		getThruster().enable();
	}

	/**
	 * Disables the thruster that is attached to this ship.
	 * @post	This ship's thruster is enabled.
	 * 			| (new this).getThruster == false
	 */
	public void disableThruster() {
		getThruster().disable();
	}

	/**
	 * Returns the thruster that is currently attached to this ship.
	 */
	@Basic @Raw
	public Thruster getThruster() {
		return thruster;
	}

	/**
	 * Holds the thruster that is attached to this ship.
	 */
	private final Thruster thruster;

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
	 * @return	True if the given angle is a valid number.
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
	 * 			| 	new.getAngle() == angle % (2*Math.PI)
	 */
	@Raw
	public void setAngle(double angle){
		assert isValidAngle(angle): "Precondition: the given angle is valid";
		if (angle < 2*Math.PI && angle > (-2)*Math.PI)
			this.angle = angle;
		else
			this.angle = angle % (2*Math.PI);
	}

	/**
	 * Turn the ship into another direction.
	 * @param 	angle
	 * 			The given angle to be added to the current angle.
	 * @pre		the ship's angle plus the given angle is not allowed to overflow.
	 * 			| if (getAngle() > 0 && angle > 0)
	 * 			| 	angle < Double.MAX_VALUE - getAngle().
	 * 			| else if (getAngle() < 0 && angle < 0)
	 * 			|	angle > Double.MIN_VALUE + getAngle()
	 * @effect 	Set the angle to the current angle plus the given angle.
	 * 			| setAngle(this.getAngle() + angle)
	 */
	public void turn(double angle){
		assert angle < Double.MAX_VALUE - getAngle() && angle > Double.MIN_VALUE + getAngle(): "Precondition: no overflow.";
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
	 * 			| newPositionX = getPosition().getX() + duration * getVelocity().getVelocityX()
	 * 			| newPositionY = getPosition().getY() + (duration * getVelocity().getVelocityY()
	 * 			| new.setPosition(newPositionX,newPositionY)
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
	 * if trippleshot powerup is not activated a bullet is created next to this ship at the direction 
	 * this ship is facing. if trippleshot is activated 2 extra bullets are created at the same position 
	 * diverting from the standard bullet. 
	 * @effect 	An instance of Bullet is created in the world that is associated with this ship. if trippleshot is 
	 * 			activated 2 extra bullets are created.
	 * 			| this.getWorld().createSpaceObject(new bullet1)
	 * 			| if (isTriShotBulletsActivated())
	 * 			|   this.getWorld().createSpaceObject(new bullet2)
	 * 			|	this.getWorld().createSpaceObject(new bullet3)
	 * @effect 	This world contains the new bullet(s) that are created.
	 * 			| for each bullet in newBullets
	 * 			|   this.getWorld().containsSpaceObject(new bullet1)
	 * @post 	The new bullet(s) is associated with this ship.
	 * 			| for each bullet in newBullets
	 * 			| 	(new bullet).getSource() == this
	 * @post	The new bullet has a location right next to this ship, where this ship is currently facing.
	 * 			| (new bullet1).getX() == this.getPosition().getX() + this.getRadius() * Math.cos(this.getAngle())
	 * 			| (new bullet1).getY() == this.getPosition().getY() + this.getRadius() * Math.sin(this.getAngle())
	 * 			| if (isTriShotBulletsActivated())
	 * 			| 	(new bullet2).getX() == this.getPosition().getX() + this.getRadius() * Math.cos(this.getAngle() + Ship.trippleShotAngleOffset)
	 * 			| 	(new bullet2).getY() == this.getPosition().getY() + this.getRadius() * Math.sin(this.getAngle() + Ship.trippleShotAngleOffset)
	 * 			| 	(new bullet3).getX() == this.getPosition().getX() + this.getRadius() * Math.cos(this.getAngle() - Ship.trippleShotAngleOffset)
	 * 			| 	(new bullet3).getY() == this.getPosition().getY() + this.getRadius() * Math.sin(this.getAngle() - Ship.trippleShotAngleOffset)
	 */
	public void fireBullet() {
		if(!isTriShotBulletsActivated()){
			double bulletX = this.getPosition().getX() + this.getRadius() * Math.cos(this.getAngle());
			double bulletY = this.getPosition().getY() + this.getRadius() * Math.sin(this.getAngle());
			this.getWorld().addBullet(new Bullet(bulletX,bulletY,this,this.getWorld(),bulletSpeedMultiplier, bulletScaleMultiplier, this.getAngle()));
		}else{
			//bullet position
			double bulletX = this.getPosition().getX() + this.getRadius() * Math.cos(this.getAngle());
			double bulletY = this.getPosition().getY() + this.getRadius() * Math.sin(this.getAngle());
			//left bullet relative to Ship
			Bullet leftBullet = new Bullet(bulletX,bulletY,this,this.getWorld(),bulletSpeedMultiplier,bulletScaleMultiplier, this.getAngle() - (Math.PI / 18));
			//middle bullet relative to Ship
			Bullet middleBullet = new Bullet(bulletX,bulletY,this,this.getWorld(),bulletSpeedMultiplier,bulletScaleMultiplier, this.getAngle());
			//right bullet relative to Ship
			Bullet rightBullet = new Bullet(bulletX,bulletY,this,this.getWorld(),bulletSpeedMultiplier,bulletScaleMultiplier, this.getAngle() + (Math.PI / 18));
			this.getWorld().addBullet(leftBullet);
			this.getWorld().addBullet(middleBullet);
			this.getWorld().addBullet(rightBullet);
		}

	}

	/**
	 * Holds the multiplier for the speed of bullets shot by this ship.
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
	 * Checks if the given bulletSpeedMultiplier is valid.
	 * @param 	multiplier
	 * 			The given multiplier to be checked.
	 * @return	True if the given multiplier is negative or zero.
	 * 			| result == (multiplier <= 0)
	 */
	public static boolean isValidBulletSpeedMultiplier(double multiplier){
		return multiplier > 0;
	}

	/**
	 * Sets the bulletSpeedMultiplier of this ship to the given multiplier if the given multiplier is Valid.
	 * @param	speedMultiplier
	 * 			The given multiplier for the speed of this ship's bullets.
	 * @post 	If the given multiplier is valid this ship's bulletSpeedMultiplier is equal to the given multiplier
	 * 			| if (isValidSpeedMultiplier(getBulletSpeedMultiplier())
	 * 			| 	(new this).getBulletSpeedMultiplier() == speedMultiplier	
	 * 
	 */
	public void setBulletSpeedMultiplier(double bulletSpeedMultiplier){
		if (isValidBulletSpeedMultiplier(bulletSpeedMultiplier))
			this.bulletSpeedMultiplier = bulletSpeedMultiplier;
	}

	@Basic @Raw
	public double getBulletScaleMultiplier(){
		return bulletScaleMultiplier;
	}

	/**
	 * Checks if the given bulletScaleMultiplier is valid.
	 * @param 	multiplier
	 * 			The given multiplier to be checked.
	 * @return	True if the given multiplier is negative or zero.
	 * 			| result == (multiplier <= 0)
	 */
	public static boolean isValidBulletScaleMultiplier(double multiplier){
		return multiplier > 0;
	}

	/**
	 * Sets the bulletScaleMultiplier to the given multiplier if the given multiplier is valid.
	 * @param 	bulletScaleMultiplier
	 * 			The multiplier to change the scale of this ship's Bullets.
	 * @post 	If the given multiplier is valid this ship's bulletScaleMultiplier is equal to the given multiplier
	 * 			| 	(new this).getBulletScaleMultiplier() == scaleMultiplier	
	 * @throws 	IllegalValueException
	 * 			The given multiplier is invalid
	 * 			| !isValidBulletScaleMultiplier(bulletScaleMultiplier)
	 */
	public void setBulletScaleMultiplier(double bulletScaleMultiplier){
		if (!isValidBulletScaleMultiplier(bulletScaleMultiplier))
			throw new IllegalValueException(bulletScaleMultiplier);
		this.bulletScaleMultiplier = bulletScaleMultiplier;
	}

	/**
	 * Holds the multiplier for the size of bullets shot by this ship.
	 */
	private double bulletScaleMultiplier = 1;

	@Basic @Raw
	public boolean isTriShotBulletsActivated(){return triShotBulletsState;}

	/**
	 * Toggles the triple shot powerup based on a given boolean.
	 * @param 	bool
	 * 			The given boolean for this ships triShotBulletsState.
	 * @post	this ship's triShotBulletsState is equal to the given boolean.
	 * 			| (new this).triShotBulletsState = bool
	 */
	public void toggleTriShotBullets(boolean bool){this.triShotBulletsState = bool;}

	/**
	 * Holds whether tripple shot powerup is activated
	 */
	private boolean triShotBulletsState = false;

	/**
	 * Holds the offset of the extra bullets if tripple shot is activated
	 */
	public static final double TRIPLE_ANGLE_OFFSET=Math.PI/18;

	@Basic @Raw
	public int getShield(){return shield;}

	/**
	 * Holds the amount of shields of this ship.
	 * @param 	shield
	 * 			the given new shields fot this ship.
	 * @post	This ships number of shields is equal to the given number if the given 
	 * 			number is between zero and 5. If the given number is larger than the maximum shields
	 * 			this ship's shields is equal to 5, if it is smaller than zero this ship's shields
	 * 			is equal to zero.
	 * 			| (new this).shield == shield
	 */
	@Model
	private void setShield(int shield){ // this method should only be called by incShield and decShield.
		if(shield > MAX_SHIELDS){
			this.shield = MAX_SHIELDS;
		}else if(shield < 0){
			this.shield = 0;
		}else{
			this.shield = shield;
		}
	}
	/**
	 * Adds an extra shield to this ships amount of shields
	 * @effect	Increments the number of shields.
	 * 			| setShield(getShield() + 1);
	 */
	public void incShield(){
		setShield(getShield() + 1);
	}
	/**
	 * Removes a shield from this ships amount of shields
	 * @effect	Decrements the number of shields.
	 * 			| setShield(getShield() - 1);
	 */
	public void decShield(){
		setShield(getShield() - 1);
	}

	/**
	 * Holds the current number of shields of this ship.
	 */
	private int shield = 0;

	/**
	 * Holds the maximum amount of shields
	 */
	public static final int MAX_SHIELDS = 3; 

	/**
	 * Checks if the given object is a valid ship.
	 *
	 * @param 	o 
	 * 			The object to check.
	 * @return 	True, if the given object is a valid ship.
	 * 			| if(o == null || !(o instanceof Ship)
	 * 			|		return false
	 * 			| else
	 * 			|		return true
	 */
	public static boolean isValidShip(Object o){
		if(o == null || !(o instanceof Ship)){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * TODO: documentation.
	 */
	@Override
	public double getTimeToCollision(Wall wall){
		if (!getThruster().isEnabled()){
			return super.getTimeToCollision(wall);
		}
		else{
			Coordinate startposition = getPosition();
			double accel;
			double difference;
			double velocity;
			if (wall.getOrientation().equals("vertical")){
				velocity = getVelocity().getVelocityX();
				accel = Math.cos(getAngle()) * getThruster().getAcceleration();
				if (wall.getP1().getX() == 0)
					difference = startposition.getX() - wall.getP1().getX() - this.getRadius();
				else
					difference = startposition.getX() - wall.getP1().getX() + this.getRadius();
			}
			else {
				velocity = getVelocity().getVelocityY();
				accel = Math.sin(getAngle()) * getThruster().getAcceleration();
				if (wall.getP1().getY() == 0)
					difference = startposition.getY() - wall.getP1().getY() - this.getRadius();
				else 
					difference = startposition.getY() - wall.getP1().getY() + this.getRadius();
			}
			if(Util.fuzzyEquals(0, accel)){
				return super.getTimeToCollision(wall);
			}
			double discriminant = Math.pow(velocity, 2) - 2 * accel * difference;
			if(discriminant < 0){
				return Double.POSITIVE_INFINITY;
			}
			double solution1 = (-velocity + Math.sqrt(discriminant)) / (accel);
			double solution2 = (-velocity - Math.sqrt(discriminant)) / (accel);

			if (Util.fuzzyEquals(solution1, 0))
				solution1 = 0;
			if (Util.fuzzyEquals(solution2, 0))
				solution2 = 0;
			if (solution1 < 0) {
				if (solution2 < 0) {
					return Double.POSITIVE_INFINITY;
				} else {
					return solution2;
				}
			} else {
				return solution1;
			}
		}

	}

	@Override
	public void terminate(){
		this.thruster.setSource(null);
		super.terminate();
	}

}
