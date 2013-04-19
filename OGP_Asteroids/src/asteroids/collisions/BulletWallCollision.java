package asteroids.collisions;

import be.kuleuven.cs.som.annotate.Basic;
import asteroids.studentdefined.Bullet;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Wall;

/**
 * The Class BulletWallCollision implements CollisionType and handles the collision
 * between an bullet and a wall.
 * 
 * @invar	The collision is always between an bullet and a wall. The first object needs to be an bullet
 * 			and the second object needs to be a ship.
 * 			| Bullet.isValidBullet(getO1())
 * 			| Wall.isValidWall(getO2())
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */
public class BulletWallCollision implements CollisionType{



	/**
	 * initializes the Bullet wall collision with a given bullet an given wall.
	 *
	 * @param 	o1 
	 * 			The bullet of this collision.
	 * @param 	o2 
	 * 			The wall of this collision.
	 */
	public BulletWallCollision(Bullet o1, Wall o2) {
		this.setO1(o1);
		this.setO2(o2);
	}


	/*_____________________________BULLET_____________________________*/

	/**
	 * Return the bullet.
	 */
	@Basic
	private Bullet getO1() {
		return o1;
	}

	/**
	 * Set the bullet in the collision.
	 * 
	 * @param 	o1 
	 *			The bullet to set.
	 * @post	If the given argument is a valid bullet, the bullet is set to the new given bullet.
	 * 			| if(Bullet.isValidBullet(o1){
	 * 			new.getO1 == o1
	 * @throws	IllegalArgumentException
	 * 			The given argument is not a valid argument. In other words, the
	 * 			argument is either null or not an bullet.
	 * 			| ! Bullet.isValidBullet(o1)
	 */
	private void setO1(Bullet o1) {
		if(!Bullet.isValidBullet(o1)){
			throw new IllegalArgumentException("Not a valid bullet.");
		}
		this.o1 = o1;
	}

	/** 
	 * Holds the bullet of this collision.
	 */
	private Bullet o1;

	/*_____________________________WALL_____________________________*/

	/**
	 * Return the wall of this collision.
	 */
	@Basic
	private Wall getO2() {
		return o2;
	}

	/**
	 * Set the bullet in the collision.
	 * 
	 * @param 	o2 
	 *			The wall to set.
	 * @post	If the given argument is a valid wall, the wall is set to the new given bullet.
	 * 			| if(Wall.isValidWall(o2){
	 * 			new.getO1 == o2
	 * @throws	IllegalArgumentException
	 * 			The given argument is not a valid argument. In other words, the
	 * 			argument is either null or not an bullet.
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
     * Handles the collision between wall and bullet.
     * 
     * @post	If the bullet hits the wall, it bounces of in a mirroring direction.
     * 			If it hits the wall for a second time, the bullet will be destroyed.
     * 			| if(o1.getHasHitWall())
     * 			|		o1.terminate()
     * 			| else
     *			|	 if(o2.getOrientation().equals("horizontal"))
     *			| 		o1.setVelocity(o1.getVelocity().getVelocityX(), -o1.getVelocity().getVelocityY());
     *			| 	else
     *			|		o1.setVelocity(-o1.getVelocity().getVelocityX(), o1.getVelocity().getVelocityY());
     */
	@Override
	public void collide() {
		if(o1.getHasHitWall()){
			o1.terminate();
		}else{
			o1.setHasHitWall(true);
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
}
