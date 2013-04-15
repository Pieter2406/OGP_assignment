package asteroids.collisions;

import asteroids.studentdefined.Asteroid;
import asteroids.studentdefined.Bullet;
import asteroids.studentdefined.Facade;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Velocity;

import java.util.Random;

public class AsteroidBulletCollision implements CollisionType {
	private Asteroid o1;
	private Bullet o2;
	public AsteroidBulletCollision(Asteroid o1, Bullet o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	@Override
	public void collide() {
		if (o1.getRadius() >= 30){
			Random r = new Random(); 
			double randomAngle = r.nextDouble() * 2*Math.PI; // random angle for 1 of the new asteroids.
			double incX = Math.cos(randomAngle) * o1.getRadius()/2;
			double incY = Math.sin(randomAngle) * o1.getRadius()/2;
			double velocity = 1.5 * Velocity.computeVelocity(o1.getVelocity().getVelocityX(), o1.getVelocity().getVelocityY());
			double velocityX = Math.cos(randomAngle) * velocity;
			double velocityY = Math.sin(randomAngle) * velocity;
			o1.getWorld().addAsteroid(new Asteroid(o1.getPosition().getX() + incX , o1.getPosition().getY() + incY, velocityX, velocityY,  
										o1.getRadius()/2, o1.getWorld()));
			o1.getWorld().addAsteroid(new Asteroid(o1.getPosition().getX() - incX, o1.getPosition().getY() - incY, -velocityX, -velocityY,  
										o1.getRadius()/2, o1.getWorld()));
		}
		
		o1.terminate();
		o2.terminate();
	}

}
