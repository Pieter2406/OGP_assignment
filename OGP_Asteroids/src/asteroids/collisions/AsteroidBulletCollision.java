package asteroids.collisions;

import asteroids.studentdefined.Asteroid;
import asteroids.studentdefined.Bullet;
import asteroids.studentdefined.Facade;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Velocity;
import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;

import java.util.Random;


/**
 * A class of AsteroidBulletCollision implements CollisionType and handles the collision
 * between an asteroid and a bullet.
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */
public class AsteroidBulletCollision implements CollisionType {

    /**
     * Instantiates a new asteroid bullet collision.
     * 
     * @param 	o1
     *          A given asteroid.
     * @param 	o2
     *          A given bullet.
     * @effect	The asteroid is set with the given asteroid.
     * 			| setO1(o1)
     * @effect 	The bullet is set with the given bullet.
     * 			| setO2(o2)
     */
    public AsteroidBulletCollision(Asteroid o1, Bullet o2) {
	this.setO1(o1);
	this.setO2(o2);
    }
    
/*_____________________________ASTEROID_____________________________*/
    
    /**
     * @return the asteroid.
     */
    @Basic @Raw
    private Asteroid getO1() {
	return o1;
    }

    /**
     * Set the asteroid in the collision.
     * 
     * @param 	o1 
     *			The new asteroid to set.
     * @post	If the given argument is a valid asteroid, the asteroid is set to the given asteroid.
     * 			|new.getO1() == o1
     * @throws	IllegalArgumentException
     * 			The given argument is not a valid argument. in other words,
     * 			the argument is either null or not an asteroid.
     * 			|! Asteroid.isValidAsteroid()
     */
    private void setO1(Asteroid o1) throws IllegalArgumentException{
	if(!Asteroid.isValidAsteroid(o1)){
	    throw new IllegalArgumentException("Not a valid asteroid");
	}
	this.o1 = o1;
    }

    /**  
     * Holds the asteroid.
     */
    private Asteroid o1;
    
    /*_____________________________BULLET_____________________________*/
    
    /**
     * @return the bullet.
     */
    @Basic @Raw
    private Bullet getO2() {
    	return o2;
    }

    /**
     * Set the bullet in the collision.
     * 
     * @param 	o2 
     *			the bullet to set.
     * @post	If the given argument is a valid bullet, the bullet is set to the given new bullet.
     * 			| if(Bullet.isVallidBullet())
     * 			|	new.getO2() == o2
     * @throws	IllegalArgumentException
     * 			The given argument is not a valid argument. In other words
     * 			the argument is either null or not a bullet.
     * 			| ! Bullet.isValidBullet(o2)
     */
    private void setO2(Bullet o2) throws IllegalArgumentException {
	if(!Bullet.isValidBullet(o2)){
	    throw new IllegalArgumentException("Not a valid bullet");
	}
	this.o2 = o2;
    }

    /** 
     * The bullet in the collision.
     */
    private Bullet o2;

    /*_____________________________METHODS_____________________________*/

    /**
     * Handle the collision between an asteroid and a bullet.
     * 
     * @post	The initial asteroid and bullet are terminated and two
     * 			new asteroids are created if their radius is big enough. 
     * 			| if(o1.getRadius() >= 30)
     * 			| 	Asteroid newAsteroid1 = new Asteroid()
     * 			|	Asteroid newAsteroid2 = new Asteroid()
     *      	| o1.terminate()
     * 			| o2.terminate()
     * @post	If two new asteroids are created, they have opposing velocities, 
     * 			one of these is generated randomly.
     * 			| newAsteroid1.getAngle() == randomAngle
     * 			| newAsteroid1.getAngle() == -randomAngle
     * @post	Both new asteroids have a new position based on their radius and angle.
     * 			| newAsteroid1.getPosition().getX() = o1.getPosition().getX() + Math.cos(randomAngle) * o1.getRadius()/2;
	 *  		| newAsteroid1.getPosition().getY()	= o1.getPosition().getY() + Math.sin(randomAngle) * o1.getRadius()/2;
     * 			| newAsteroid2.getPosition().getX() = o1.getPosition().getX() - Math.cos(randomAngle) * o1.getRadius()/2;
	 *  		| newAsteroid2.getPosition().getY()	= o1.getPosition().getY() - Math.sin(randomAngle) * o1.getRadius()/2;
     */
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
