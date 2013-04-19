
package asteroids.collisions;

import asteroids.studentdefined.Bullet;
import asteroids.studentdefined.Bullet;
import asteroids.studentdefined.Facade;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Velocity;
import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;

import java.util.Random;


/**
 * A class of BulletBulletCollision implements CollisionType and handles the collision
 * between a bullet and a bullet in the world.
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */
public class BulletBulletCollision implements CollisionType {

	/**
	 * Instantiates a new bullet bullet collision.
	 * 
	 * @param 	o1
	 *          A given Bullet.
	 * @param 	o2
	 *          A given bullet.
	 * @effect	The first bullet is set with the given bullet.
	 * 			| setO1(o1)
	 * @effect 	The second bullet is set with the given bullet.
	 * 			| setO2(o2)
	 */
	public BulletBulletCollision(Bullet o1, Bullet o2) {
		this.setO1(o1);
		this.setO2(o2);
	}

	/*_____________________________FIRST_BULLET_____________________________*/

	/**
	 * @return the first bullet.
	 */
	@Basic @Raw
	private Bullet getO1() {
		return o1;
	}

	/**
	 * Set the first bullet in the collision.
	 * 
	 * @param 	o1 
	 *		The new Bullet to set.
	 * @post	If the given argument is a valid Bullet, the Bullet is set to the given Bullet.
	 * 		|new.getO1() == o1
	 * @throws	IllegalArgumentException
	 * 		The given argument is not a valid argument. in other words,
	 * 		the argument is either null or not an Bullet.
	 * 		|! Bullet.isValidBullet()
	 */
	private void setO1(Bullet o1) throws IllegalArgumentException{
		if(!Bullet.isValidBullet(o1)){
			throw new IllegalArgumentException("Not a valid Bullet");
		}
		this.o1 = o1;
	}

	/**  
	 * Holds the first bullet.
	 */
	private Bullet o1;

	/*_____________________________SECOND_BULLET_____________________________*/

	/**
	 * @return the second bullet.
	 */
	@Basic @Raw
	private Bullet getO2() {
		return o2;
	}

	/**
	 * Set the second bullet in the collision.
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
	 * The second bullet in the collision.
	 */
	private Bullet o2;

	/*_____________________________METHODS_____________________________*/

	/**
	 * Handle the collision between a bullet and another bullet.
	 * 
	 * @post	The two bullets are terminated.
	 * 			| o1.terminate()
	 * 			| o2.terminate()
	 */
	@Override
	public void collide() {
		o1.terminate();
		o2.terminate();
	}

}
