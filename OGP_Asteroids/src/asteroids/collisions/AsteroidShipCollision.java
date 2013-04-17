package asteroids.collisions;

import java.util.Random;

import be.kuleuven.cs.som.annotate.Basic;

import asteroids.studentdefined.Asteroid;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Velocity;


/**
 * The class AsteroidShipCollision implements CollisionType and handles the collision
 * between an asteroid and a ship.
 * 
 * @invar	The collision is always between an asteroid and a ship. The first object needs to be an asteroid
 * 		and the second object needs to be a ship.
 * 		| Asteroid.isValidAsteroid(getO1())
 * 		| Ship.isValidShip(getO2())
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */
public class AsteroidShipCollision implements CollisionType {

    /**
     * Initializes the Asteroid ship collision.
     *
     * @param	o1 
     * 		The given asteroid.
     * @param 	o2 
     * 		The given ship.
     * @effect	The asteroid is set with the given parameter.
     * 		| setO1(o1)
     * @effect	The ship is set with the given parameter.
     * 		| setO2(o2)
     * 
     */
    public AsteroidShipCollision(Asteroid o1, Ship o2) {
	this.setO1(o1);
	this.setO2(o2);
    }
        
    /*_____________________________ASTEROID_____________________________*/
    
    /**
     * Return the asteroid.
     */
    @Basic
    private Asteroid getO1() {
        return o1;
    }
    
    /**
     * Set the asteroid in the collision.
     * 
     * @param 	o1 
     *		The asteroid to set.
     * @post	If the given argument is a valid asteroid, the asteroid is set to the new given asteroid.
     * 		| if(Asteroid.isValidAsteroid(o1){
     * 			new.getO1 == o1
     * @throws	IllegalArgumentException
     * 		The given argument is not a valid argument. In other words, the
     * 		argument is either null or not an asteroid.
     * 		| ! Asteroid.isValidAsteroid(o1)
     */
    private void setO1(Asteroid o1)throws IllegalArgumentException {
	if(!Asteroid.isValidAsteroid(o1)){
	    throw new IllegalArgumentException("Not a valid asteroid.");
	}
	this.o1 = o1;
    }
    
    /** 
     * Holds the asteroid.
     */
    private Asteroid o1;
    
    /*_____________________________SHIP_____________________________*/
    
    /**
     * Return the ship of this collision.
     */
    @Basic
    private Ship getO2() {
        return o2;
    }
    
    /**
     * Set the ship in the collision.
     * 
     * @param 	o2 
     *		the new ship to set.
     * @post	If the given argument is a valid ship, the ship is set to the new given ship.
     * 		| if(Ship.isValidShip(o2){
     * 			new.getO2 == o2
     * @throws	IllegalArgumentException
     * 		The given argument is not a valid argument. In other words, the
     * 		argument is either null or not an ship.
     * 		| ! Ship.isValidShip(o2)
     */
    private void setO2(Ship o2) throws IllegalArgumentException{
	if(!Ship.isValidShip(o2)){
	    throw new IllegalArgumentException("Not a valid ship.");
	}
	this.o2 = o2;
    }

    /** 
     * Holds the ship. 
     */
    private Ship o2;

    /*_____________________________METHODS_____________________________*/
    
   

    /**
     * Handle the collision between an asteroid and a ship.
     * 
     * @post	If the shield of the ship is not active, the ship will be
     * 		terminated. The asteroid will divide in two smaller separate
     * 		asteroids if its radius is large enough.
     * 		| if(!o2.shieldIsActive())
     * 		|	o2.terminate
     * 		| if(o1.getRadius() >= 30)
     * 		|	o1.terminate()
     * 		|	Asteroid newAsteroid1 = new Asteroid()
     * 		|	Asteroid newAsteroid2 = new Asteroid()
     */
    @Override
    public void collide() {
	if(o2.getShield() > 0){
	    o2.decShield();
	}else{
	    o2.terminate();
	}
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
    }
}
