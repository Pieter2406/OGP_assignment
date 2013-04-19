package asteroids.collisions;

import be.kuleuven.cs.som.annotate.Basic;
import asteroids.studentdefined.Asteroid;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Wall;

/**
 * The Class AsteroidWallCollision implements CollisionType and handles the collision
 * between an asteroid and a wall.
 * 
 * @invar	The collision is always between an asteroid and a wall. The first object needs to be an asteroid
 * 		and the second object needs to be a ship.
 * 		| Asteroid.isValidAsteroid(getO1())
 * 		| Wall.isValidWall(getO2())
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */
public class AsteroidWallCollision implements CollisionType{



    /**
     * initializes the Asteroid wall collision with a given asteroid an given wall.
     *
     * @param 	o1 
     * 			The asteroid of this collision.
     * @param 	o2 
     * 			The wall of this collision.
     */
    public AsteroidWallCollision(Asteroid o1, Wall o2) {
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
    private void setO1(Asteroid o1) {
	if(!Asteroid.isValidAsteroid(o1)){
	    throw new IllegalArgumentException("Not a valid asteroid.");
	}
	this.o1 = o1;
    }
    
    /** 
     * Holds the asteroid of this collision.
     */
    private Asteroid o1;

    /*_____________________________WALL_____________________________*/

    /**
     * Return the wall of this collision.
     */
    @Basic
    private Wall getO2() {
	return o2;
    }

    /**
     * Set the asteroid in the collision.
     * 
     * @param 	o2 
     *			The wall to set.
     * @post	If the given argument is a valid wall, the wall is set to the new given asteroid.
     * 			| if(Wall.isValidWall(o2){
     * 			new.getO1 == o2
     * @throws	IllegalArgumentException
     * 			The given argument is not a valid argument. In other words, the
     * 			argument is either null or not an asteroid.
     * 			| ! Wall.isValidWall(o2)
     */
    private void setO2(Wall o2) {
	if(!Wall.isValidWall(o2)){
	    throw new IllegalArgumentException("Not a valid wall.");
	}
	this.o2 = o2;
    }

    /**  
     * Holds the wall of this collision.
     */
    private Wall o2;

    /*_____________________________METHODS_____________________________*/

    /**
     * Handles the collision between wall and asteroid.
     * 
     * @post	If the asteroid hits the wall, it bounces of in a mirroring direction.
     *		| if(o2.getOrientation().equals("horizontal"))
     *		| 	o1.setVelocity(o1.getVelocity().getVelocityX(), -o1.getVelocity().getVelocityY());
     *		| else
     *		|	o1.setVelocity(-o1.getVelocity().getVelocityX(), o1.getVelocity().getVelocityY());
     */
    @Override
    public void collide() {
	if (o2.getOrientation().equals("horizontal")){
	    o1.setVelocity(o1.getVelocity().getVelocityX(), -o1.getVelocity().getVelocityY());
	    if(o2.getP1().getY() == 0){
		o1.setPosition(o1.getPosition().getX(), o1.getPosition().getY() + 1);
	    }else{
		o1.setPosition(o1.getPosition().getX(), o1.getPosition().getY() - 1);
	    }

	}else{
	    o1.setVelocity(-o1.getVelocity().getVelocityX(), o1.getVelocity().getVelocityY());
	    if(o2.getP1().getX() == 0){
		o1.setPosition(o1.getPosition().getX() + 1, o1.getPosition().getY() );
	    }else{
		o1.setPosition(o1.getPosition().getX() - 1, o1.getPosition().getY());
	    }
	}
    }
}
