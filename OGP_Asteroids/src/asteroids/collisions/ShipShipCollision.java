
package asteroids.collisions;

import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Facade;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Velocity;
import be.kuleuven.cs.som.annotate.Basic;

import java.util.Random;


/**
 * A class of ShipShipCollision implements CollisionType and handles the collision
 * between a ship and a ship in the world.
 * 
 * @invar	The collision is always between a Ship and another ship. The first object needs to be a Ship
 * 			and the second object needs to be a ship.
 * 			| Ship.isValidShip(getO1())
 * 			| Ship.isValidShip(getO2())
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */
public class ShipShipCollision implements CollisionType {

	/**
	 * Instantiates a new ship ship collision.
	 * 
	 * @param 	o1
	 *          A given ship.
	 * @param 	o2
	 *          A given ship.
	 * @effect	The first ship is set with the given ship.
	 * 			| setO1(o1)
	 * @effect 	The second ship is set with the given ship.
	 * 			| setO2(o2)
	 */
	public ShipShipCollision(Ship o1, Ship o2) {
		this.setO1(o1);
		this.setO2(o2);
	}

	/*_____________________________FIRST_SHIP_____________________________*/

	/**
	 * @return the first ship.
	 */
	@Basic
	private Ship getO1() {
		return o1;
	}

	/**
	 * Set the first ship in the collision.
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
	 * Holds the first ship.
	 */
	private Ship o1;

	/*_____________________________SECOND_SHIP_____________________________*/

	/**
	 * @return the second ship.
	 */
	@Basic
	private Ship getO2() {
		return o2;
	}

	/**
	 * Set the second ship in the collision.
	 * 
	 * @param 	o2 
	 *			the ship to set.
	 * @post	If the given argument is a valid ship, the ship is set to the given new ship.
	 * 			| if(Ship.isVallidShip())
	 * 			|	new.getO2() == o2
	 * @throws	IllegalArgumentException
	 * 			The given argument is not a valid argument. In other words
	 * 			the argument is either null or not a ship.
	 * 			| ! Ship.isValidShip(o2)
	 */
	private void setO2(Ship o2) throws IllegalArgumentException {
		if(!Ship.isValidShip(o2)){
			throw new IllegalArgumentException("Not a valid ship");
		}
		this.o2 = o2;
	}

	/** 
	 * The second ship in the collision.
	 */
	private Ship o2;

	/*_____________________________METHODS_____________________________*/

	/**
	 * Handle the collision between two ships.
	 * 
	 * @post	The new velocity is equal to the calculated velocity.
	 * 		| new.o1.getVelocity().getVelocityX() = newVelocityX
	 * 		| new.o1.getVelocity().getVelocityY() = newVelocityY
	 * 		| new.o2.getVelocity().getVelocityX() = newVelocityX
	 * 		| new.o2.getVelocity().getVelocityY() = newVelocityY
	 */
	@Override
	public void collide() {
		double dVx = o2.getVelocity().getVelocityX() - o1.getVelocity().getVelocityX();
		double dVy = o2.getVelocity().getVelocityY() - o1.getVelocity().getVelocityY();
		double dV = Math.sqrt(Math.pow(dVx, 2) + Math.pow(dVy, 2));;
		double sigma = o1.getRadius() + o2.getRadius();
		double dX = o2.getPosition().getX() - o1.getPosition().getX();
		double dY = o2.getPosition().getY() - o1.getPosition().getY();
		double dR = Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));
		double j = (2 * o1.getMass().getMass()*o2.getMass().getMass()*(dV*dR))/(sigma*(o1.getMass().getMass() + o2.getMass().getMass()));
		double jX = (j*dX)/sigma;
		double jY = (j*dY)/sigma;

		double newVelocityO1X = o1.getVelocity().getVelocityX() - (jX / o1.getMass().getMass());
		double newVelocityO1Y = o1.getVelocity().getVelocityY() - (jY / o1.getMass().getMass());

		double newVelocityO2X = o2.getVelocity().getVelocityX() + (jX / o2.getMass().getMass());
		double newVelocityO2Y = o2.getVelocity().getVelocityY() + (jY / o2.getMass().getMass());

		o1.setVelocity(newVelocityO1X, newVelocityO1Y);
		o2.setVelocity(newVelocityO2X, newVelocityO2Y);
	}

}
