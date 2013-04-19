package asteroids.collisions;


/**
 * The interface CollisionType, is an interface for a type of collision between two objects.
 * 
 * @version 1.1
 * 
 * @author Kristof Bruynincks
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 */

public interface CollisionType {
	/**
	 * Handle the collision between the two types in this collision.
	 */
	public void collide();
}
