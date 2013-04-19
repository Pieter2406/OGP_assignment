package asteroids.collisions;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Wall;

/**
 * The Class ShipWallCollision implements CollisionType and handles the collision
 * between an ship and a wall.
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */
public class ShipWallCollision implements CollisionType{



    /**
     * initializes the Ship wall collision with a given ship an given wall.
     *
     * @param 	o1 
     * 			The ship of this collision.
     * @param 	o2 
     * 			The wall of this collision.
     */
    public ShipWallCollision(Ship o1, Wall o2) {
	this.setO1(o1);
	this.setO2(o2);
    }


    /*_____________________________ASTEROID_____________________________*/

    /**
     * Return the ship.
     */
    @Basic @Raw
    private Ship getO1() {
        return o1;
    }
    
    /**
     * Set the ship in the collision.
     * 
     * @param 	o1 
     *			The ship to set.
     * @post	If the given argument is a valid ship, the ship is set to the new given ship.
     * 			| if(Ship.isValidShip(o1){
     * 			new.getO1 == o1
     * @throws	IllegalArgumentException
     * 			The given argument is not a valid argument. In other words, the
     * 			argument is either null or not an ship.
     * 			| ! Ship.isValidShip(o1)
     */
    private void setO1(Ship o1) {
	if(!Ship.isValidShip(o1)){
	    throw new IllegalArgumentException("Not a valid ship.");
	}
	this.o1 = o1;
    }
    
    /** 
     * Holds the ship of this collision.
     */
    private Ship o1;

    /*_____________________________WALL_____________________________*/

    /**
     * Return the wall of this collision.
     */
    @Basic @Raw
    private Wall getO2() {
	return o2;
    }

    /**
     * Set the ship in the collision.
     * 
     * @param 	o2 
     *			The wall to set.
     * @post	If the given argument is a valid wall, the wall is set to the new given ship.
     * 			| if(Wall.isValidWall(o2){
     * 			new.getO1 == o2
     * @throws	IllegalArgumentException
     * 			The given argument is not a valid argument. In other words, the
     * 			argument is either null or not an ship.
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
     * Handles the collision between wall and ship.
     * 
     * @post	If the ship hits the wall, it bounces of in a mirroring direction.
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

