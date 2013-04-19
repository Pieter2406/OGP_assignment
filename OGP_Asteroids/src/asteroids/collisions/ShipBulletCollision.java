package asteroids.collisions;

import java.util.Random;

import be.kuleuven.cs.som.annotate.Basic;

import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Bullet;
import asteroids.studentdefined.Velocity;


/**
 * The class ShipShipCollision implements CollisionType and handles the collision
 * between an ship and a ship.
 * 
 * @invar	The collision is always between an ship and a ship. The first object needs to be an ship
 * 		and the second object needs to be a ship.
 * 		| Ship.isValidShip(getO1())
 * 		| Bullet.isValidShip(getO2())
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */
public class ShipBulletCollision implements CollisionType {

	/**
	 * Initializes the Ship ship collision.
	 *
	 * @param	o1 
	 * 			The given ship.
	 * @param 	o2 
	 * 			The given bullet.
	 * @effect	The ship is set with the given parameter.
	 * 			| setO1(o1)
	 * @effect	The bullet is set with the given parameter.
	 * 			| setO2(o2)
	 * 
	 */
	public ShipBulletCollision(Ship o1, Bullet o2) {
		this.setO1(o1);
		this.setO2(o2);
	}

	/*_____________________________SHIP_____________________________*/

	/**
	 * Return the ship.
	 */
	@Basic
	private Ship getO1() {
		return o1;
	}

	/**
	 * Set the ship in the collision.
	 * 
	 * @param 	o1 
	 *		The ship to set.
	 * @post	If the given argument is a valid ship, the ship is set to the new given ship.
	 * 		| if(Ship.isValidShip(o1){
	 * 			new.getO1 == o1
	 * @throws	IllegalArgumentException
	 * 		The given argument is not a valid argument. In other words, the
	 * 		argument is either null or not an ship.
	 * 		| ! Ship.isValidShip(o1)
	 */
	private void setO1(Ship o1)throws IllegalArgumentException {
		if(!Ship.isValidShip(o1)){
			throw new IllegalArgumentException("Not a valid ship.");
		}
		this.o1 = o1;
	}

	/** 
	 * Holds the ship.
	 */
	private Ship o1;

	/*_____________________________BULLET_____________________________*/

	/**
	 * Return the bullet of this collision.
	 */
	@Basic
	private Bullet getO2() {
		return o2;
	}

	/**
	 * Set the ship in the collision.
	 * 
	 * @param 	o2 
	 *			the new ship to set.
	 * @post	If the given argument is a valid bullet, the bullet is set to the new given bullet.
	 * 			| if(Bullet.isValidBullet(o2){
	 * 			new.getO2 == o2
	 * @throws	IllegalArgumentException
	 * 			The given argument is not a valid argument. In other words, the
	 * 			argument is either null or not a bullet.
	 * 			| ! Bullet.isValidBullet(o2)
	 */
	private void setO2(Bullet o2) throws IllegalArgumentException{
		if(!Bullet.isValidBullet(o2)){
			throw new IllegalArgumentException("Not a valid bullet.");
		}
		this.o2 = o2;
	}

	/** 
	 * Holds the bullet. 
	 */
	private Bullet o2;

	/*_____________________________METHODS_____________________________*/


	/**
	 * Handle the collision between ship and bullet.
	 * 
	 * @effect	If the ship has not an active shield, the
	 * 			ship is terminated. Otherwise the shield is decremented.
	 * 			| if(o1.getShield <= 0)
	 * 			| 	o1.terminate()
	 * 			| else
	 * 			|	o1.decShield
	 * @effect	The bullet is terminated in the world.
	 * 			| o2.terminate()
	 */
	public void collide() {
		if(o1.getShield() > 0){
			o1.decShield();
		}else{
			o1.terminate();
		}
		o2.terminate();
	}
}
