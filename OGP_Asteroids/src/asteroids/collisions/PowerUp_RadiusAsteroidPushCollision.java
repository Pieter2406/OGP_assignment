/**
 * 
 */
package asteroids.collisions;

import asteroids.powerups.RadiusAsteroidPushPowerUp;
import asteroids.studentdefined.Asteroid;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Velocity;

/**
 * A class of radius asteroid push collision collision inherits from ShipPowerUpCollision
 * and holds a ship and a radius asteroid push powerup.
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
public class PowerUp_RadiusAsteroidPushCollision extends ShipPowerUpCollision  {
	
	/**
	 * Initializes the radius asteroid push collision with a given ship and a 
	 * given bigger bullet size powerup.
	 * 
	 * @effect	Initialize this collision with a given ship and given powerup.
	 * 			| super(o1,o2)
	 */
	public PowerUp_RadiusAsteroidPushCollision(Ship o1, RadiusAsteroidPushPowerUp o2) {
		super(o1,o2);
	}
	
	/**
	 * Holds the range in which the push effect is effective.
	 */
	private static final double PUSH_RADIUS = 1000;
	
	
	
	 /**
	  * Handle the collision between a ship and a radius asteroid push powerup.
	  * 
	  * @post	The asteroids, surrounding the ship in a certain asteroid: PUSH_RADIUS,
	  * 		are pushed away from the ship.
	  * 		| angle = Math.atan(dY/dX)
	  * 		| newVelocityX == velocity * Math.cos(angle)
	  * 		| newVelocityY == velocity * Math.sin(angle)
	  * 		| for each Asteroid ast in o1.getWorld().getAllAsteroids()
	  * 		|		if ast.getDistanceBetween(o1) < PUSH_RADIUS
	  * 		|			ast.setVelocity(newVelocityX, newVelocityY)
	  */
	@Override
	public void collide() {
		for(Asteroid ast : o1.getWorld().getAllAsteroids()){
			if(ast.getDistanceBetween(o1) < PUSH_RADIUS){
				double dX = ast.getPosition().getX() - o1.getPosition().getX();
				double dY = ast.getPosition().getY() - o1.getPosition().getY();
				double astV = Velocity.computeVelocity(ast.getVelocity().getVelocityX(), ast.getVelocity().getVelocityY());
				double angle = Math.atan(dY/dX);
				if(dX < 0){
					angle += Math.PI;
				}
				double newVx = astV * Math.cos(angle);
				double newVy = astV * Math.sin(angle);
				
				ast.setVelocity(newVx, newVy);
			}
		}
		o2.terminate();
	}
	
}
