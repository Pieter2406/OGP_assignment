package asteroids.collisions;

public class NoCollision implements CollisionType {

	/**
	 * A class of NoCollision implements CollisionType and exists to handle
	 * the case where there is an undetermined collision.
	 * 
	 * @author	Kristof Bruyninckx
	 * @author 	Wouter Bruyninckx
	 * @author 	Pieter Verlinden
	 *
	 * @version 1.0
	 */
	
	/**
	 * Initializes a NoCollision object.
	 */
	public NoCollision() {}
	
	/**
	 * When a NoCollision exists nothing will be handled.
	 */
	@Override
	public void collide() {
				
	}

}
