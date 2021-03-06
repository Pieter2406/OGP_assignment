
package asteroids.collisions;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;
import asteroids.studentdefined.Asteroid;
import asteroids.studentdefined.Velocity;

/**
 * A class of AsteroidAsteroidCollision implements CollisionType and handles the collision
 * between two asteroids.
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */
public class AsteroidAsteroidCollision implements CollisionType {

    /**
     * Initializes object one and object two with the asteroids that will collide.
     *
     * @param 	o1 
     * 			The first asteroid of the collision.
     * @param 	o2 
     * 			the second asteroid of the collision.
     * @effect	The first asteroid is set with the given first parameter.
     * 			| setO1(o1)
     * @effect	The second asteroid is set with the second given parameter.
     * 			| setO2(o2)
     */
    public AsteroidAsteroidCollision(Asteroid o1, Asteroid o2) {
	this.setO1(o1);
	this.setO2(o2);
    }

    /*_____________________________FIRST_ASTEROID_______________________________*/

    /**
     * Return the first asteroid in this collision.
     */
    @Basic @Raw
    private Asteroid getO1() {
	return o1;
    }

    /**
     * Sets the first asteroid in the collision.
     *
     * @param 	o1 
     * 			the new first asteroid.
     * @post	If the given argument is a valid asteroid, the first asteroid is set to the given new asteroid.
     * 			| if(Asteroid.isValidAsteroid(o1)
     * 			|	new.getO1() == o1
     * @throws	IllegalArgumentException
     * 			The given argument is not a valid argument. In other words, the
     * 			argument is either null or not an asteroid.
     * 			| ! Asteroid.isValidAsteroid(o1)
     */
    private void setO1(Asteroid o1) throws IllegalArgumentException {
	if(!Asteroid.isValidAsteroid(o1)){
	    throw new IllegalArgumentException("Not a valid asteroid.");
	}
	this.o1 = o1;
    }

    /**
     * The first asteroid in the collision.
     */
    private Asteroid o1;



    /*_____________________________SECOND_ASTEROID_____________________________*/

    /**
     * Return the second asteroid in this collision.
     */
    @Basic @Raw
    private Asteroid getO2() {
	return o2;
    }

    /**
     * Set the second asteroid in the collision.
     *
     * @param 	o2 
     * 			the new second asteroid.
     * @post	If the given argument is a valid asteroid, the second asteroid is set to the given new asteroid.
     * 			| if(Asteroid.isValidAsteroid())
     * 			|	new.getO2() == o2
     * @throws	IllegalArgumentException
     * 			The given argument is not a valid argument. In other words, the
     * 			argument is either null or not an asteroid.
     * 			| ! isValidAsteroid(o2)
     */
    private void setO2(Asteroid o2) throws IllegalArgumentException {
	if(!Asteroid.isValidAsteroid(o2)){
	    throw new IllegalArgumentException("Not a valid asteroid.");
	}
	this.o2 = o2;
    }
    
    /**
     * The second asteroid in the collision.
     */
    private Asteroid o2;


    /*_____________________________METHODS_____________________________*/

    /**
     * Handle the collision between two asteroids.
     * 
     * @effect	The new velocity of both asteroids is set to the calculated velocity which makes
     * 			the asteroids 'bounce' of each other.
     * 			| new.o1.getVelocity().getVelocityX() = newVelocityX
     * 			| new.o1.getVelocity().getVelocityY() = newVelocityY
     * 			| new.o2.getVelocity().getVelocityX() = newVelocityX
     * 			| new.o2.getVelocity().getVelocityY() = newVelocityY
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
	double j = (2 * o1.getMass().getValue()*o2.getMass().getValue()*(dV*dR))/(sigma*(o1.getMass().getValue() + o2.getMass().getValue()));
	double jX = (j*dX)/sigma;
	double jY = (j*dY)/sigma;

	double newVelocityO1X = o1.getVelocity().getVelocityX() - (jX / o1.getMass().getValue());
	double newVelocityO1Y = o1.getVelocity().getVelocityY() - (jY / o1.getMass().getValue());

	double newVelocityO2X = o2.getVelocity().getVelocityX() + (jX / o2.getMass().getValue());
	double newVelocityO2Y = o2.getVelocity().getVelocityY() + (jY / o2.getMass().getValue());

	o1.setVelocity(newVelocityO1X, newVelocityO1Y);
	o2.setVelocity(newVelocityO2X, newVelocityO2Y);
    }

}

