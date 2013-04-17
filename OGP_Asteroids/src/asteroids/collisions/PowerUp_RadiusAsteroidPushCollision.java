/**
 * 
 */
package asteroids.collisions;

import asteroids.powerups.RadiusAsteroidPushPowerUp;
import asteroids.studentdefined.Asteroid;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Velocity;

/**
 * @author Pieter
 *
 */
public class PowerUp_RadiusAsteroidPushCollision implements CollisionType {
	private Ship o1;
	private RadiusAsteroidPushPowerUp o2;
	private static final double PUSH_RADIUS = 1000;
	/**
	 * 
	 */
	public PowerUp_RadiusAsteroidPushCollision(Ship o1, RadiusAsteroidPushPowerUp o2) {
		this.o1 = o1;
		this.o2 = o2;
	}


	@Override
	public void collide() {
		for(Asteroid ast : o1.getWorld().getAsteroids()){
			if(ast.getDistanceBetween(o1) < PUSH_RADIUS){
				double dX = ast.getPosition().getX() - o1.getPosition().getX();
				double dY = ast.getPosition().getY() - o1.getPosition().getY();
				double astV = Velocity.computeVelocity(ast.getVelocity().getVelocityX(), ast.getVelocity().getVelocityY());
				double angle = Math.atan(dY/dX);
				System.out.println(angle);
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
