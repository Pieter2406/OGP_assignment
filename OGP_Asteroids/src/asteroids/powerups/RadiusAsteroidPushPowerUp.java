package asteroids.powerups;

import asteroids.studentdefined.Asteroid;
import asteroids.studentdefined.PowerUp;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Velocity;
import asteroids.studentdefined.World;

/**
 * A class of radius asteroid push powerup holds an object in the world
 * that powerups the ship. It extends from the superclass PowerUp.
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */

public class RadiusAsteroidPushPowerUp extends PowerUp {
	public static final int TYPE = 5;
	public static final int PUSH_RADIUS = 1000;
	/**
	 * @param 	x
	 * 			The x coordinate of this powerup in the world.
	 * @param 	y
	 * 			The u coordinate of this powerup in the world.
	 * @param	world
	 * 			The world where this powerup is effective.
	 * @param	sourceShip
	 * 			The ship where this powerup is active.
	 * @effect	The powerup is initialized with
	 * 			an x coordinate, an y coordinate, a default radius,
	 * 			0 velocity and a world.
	 * 
	 */
	public RadiusAsteroidPushPowerUp(double x, double y, World world, Ship sourceShip) {
		super(x, y, world, TYPE, sourceShip);
	}
	
	@Override
	protected boolean hasPassedActiveLifeTime() {
		return true;
	}
	/**
	 * Activates this powerup effects on the source ship.
	 * The asteroids that are present in the push radius of this powerup,
	 * are pushed away from this powerup if it is activated.
	 * @post	The asteroids, surrounding the ship in a certain asteroid: PUSH_RADIUS,
	 * 		are pushed away from the ship.
	 * 		| angle = Math.atan(dY/dX)
	 * 		| newVelocityX == velocity * Math.cos(angle)
	 * 		| newVelocityY == velocity * Math.sin(angle)
	 * 		| for each Asteroid ast in o1.getWorld().getAllAsteroids()
	 * 		|		if ast.getDistanceBetween(o1) < PUSH_RADIUS
	 * 		|			ast.setVelocity(newVelocityX, newVelocityY)
	 * 
	 * @effect	The active life time of this powerup is set to the current system time.
	 * 			|this.setActiveLifeTime()
	 */
	@Override
	public void activate() {
		this.setActiveLifeTime();
		for(Asteroid ast : this.sourceShip.getWorld().getAllAsteroids()){
			if(ast.getDistanceBetween(this) < PUSH_RADIUS){
				double dX = ast.getPosition().getX() - this.getPosition().getX();
				double dY = ast.getPosition().getY() - this.getPosition().getY();
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
	}
	/**
	 * As this powerup has no life time, it will be terminated
	 * on its evaluation.
	 */
	@Override
	public void evaluate() {
		this.terminate();
	}

}