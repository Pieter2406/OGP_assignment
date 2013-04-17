/**
 * 
 */
package asteroids.collisions;

import asteroids.studentdefined.Bullet;
import asteroids.studentdefined.Wall;

/**
 * @author Pieter
 *
 */
public class BulletWallCollision implements CollisionType {
	private Bullet o1;
	private Wall o2;
	/**
	 * 
	 */
	public BulletWallCollision(Bullet o1, Wall o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

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
