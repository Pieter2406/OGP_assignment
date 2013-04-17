/**
 * 
 */
package asteroids.collisions;

import asteroids.powerups.BiggerBulletSizePowerUp;
import asteroids.studentdefined.Ship;

/**
 * @author Pieter
 *
 */
public class PowerUp_BiggerBulletSizeCollision implements CollisionType {
private Ship o1;
private BiggerBulletSizePowerUp o2;
	/**
	 * 
	 */
	public PowerUp_BiggerBulletSizeCollision(Ship o1, BiggerBulletSizePowerUp o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	@Override
	public void collide() {
		double scale;
		if(o1.getBulletScaler() < 4){
			scale = o1.getBulletScaler() + 1;
		}else{
			scale = o1.getBulletScaler();
		}
		o1.setBulletScaler(scale);
		o2.terminate();
	}

}
