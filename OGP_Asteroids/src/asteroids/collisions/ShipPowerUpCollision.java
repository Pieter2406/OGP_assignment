/**
 * 
 */
package asteroids.collisions;

import be.kuleuven.cs.som.annotate.Basic;
import asteroids.powerups.*;
import asteroids.studentdefined.PowerUp;
import asteroids.studentdefined.Ship;

/**
 * A class of ship powerup collision implements CollisionType and handles the collision
 * between a ship and a powerup in the world by invoking a powerup factory which handles
 * the collisions between powerups.
 * 
 * @invar	The collision is always between a Ship and a powerup. The first object needs to be a Ship
 * 			and the second object needs to be a powerup.
 * 			| Ship.isValidShip(getO1())
 * 			| Ship.isValidPowerUp(getO2())
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */

public class ShipPowerUpCollision implements CollisionType {
	/**
	 * Instantiates a new ship powerup collision.
	 * 
	 * @param 	o1
	 *          A given ship.
	 * @param 	o2
	 *          A given powerup.
	 * @effect	The ship is set with the given ship.
	 * 			| setO1(o1)
	 * @effect 	The powerup is set with the given powerup.
	 * 			| setO2(o2)
	 */
	public ShipPowerUpCollision(Ship o1, PowerUp o2) {
		setO1(o1);
		setO2(o2);
	}
	
	/*_____________________________SHIP_____________________________*/
	/**
	 * Return the ship of this collision.
	 */
	@Basic
	private Ship getO1() {
		return o1;
	}

	/**
	 * Set the ship in the collision.
	 * 
	 * @param 	o1 
	 *			The new Ship to set.
	 * @post	If the given argument is a valid Ship, the Ship is set to the given Ship.
	 * 			|new.getO1() == o1
	 * @throws	IllegalArgumentException
	 * 			The given argument is not a valid argument. in other words,
	 * 			the argument is either null or not an Ship.
	 * 			|! Ship.isValidShip()
	 */
	private void setO1(Ship o1) throws IllegalArgumentException{
		if(!Ship.isValidShip(o1)){
			throw new IllegalArgumentException("Not a valid Ship");
		}
		this.o1 = o1;
	}

	/**
	 * Holds the ship in this collision.
	 */
	private Ship o1;
		
	/*_____________________________POWER_UP_____________________________*/
	
	/**
	 * Return the powerup in the collision.
	 */
	@Basic
	private PowerUp getO2() {
		return o2;
	}

	/**
	 * Set the ship in the collision.
	 * 
	 * @param 	o1 
	 *			The new Ship to set.
	 * @post	If the given argument is a valid Ship, the Ship is set to the given Ship.
	 * 			|new.getO1() == o1
	 * @throws	IllegalArgumentException
	 * 			The given argument is not a valid argument. in other words,
	 * 			the argument is either null or not an Ship.
	 * 			|! Ship.isValidShip()
	 */
	private void setO2(PowerUp o2) throws IllegalArgumentException{
		if(!PowerUp.isValidPowerUp(o2)){
			throw new IllegalArgumentException("Not a valid Powerup");
		}
		this.o2 = o2;
	}

	/**
	 * Holds the powerup of this collision.
	 */
	private PowerUp o2;
	

	/*_____________________________METHOD_____________________________*/
	
	/**
	 * Invokes the powerup factory which returns a type of ship powerup collision
	 * according to the given type of powerup collision.
	 * 
	 * @effect	Invokes the collide method in the powerup factory
	 * 			which returns a collisiontype between a ship and a powerup.
	 * 			| powerUpCollisionType = PowerUpFactory.collide(o1,o2)
	 * @effect	Invokes the collide method in the acquired collisiontype
	 * 			which handles the collision between this powerup and ship.
	 * 			| powerUpCollisionType.collide()
	 */
	@Override
	public void collide() {
		CollisionType powerUpCollision = PowerUpFactory.collide(o1, o2);
		powerUpCollision.collide();
	}

}
