/**
 * 
 */
package asteroids.collisions;

import asteroids.powerups.SmallerShipPowerUp;
import asteroids.studentdefined.Ship;

/**
 * @author Pieter
 *
 */
public class PowerUp_SmallerShipCollision implements CollisionType {
	private Ship o1;
	private SmallerShipPowerUp o2;
	/**
	 * 
	 */
	public PowerUp_SmallerShipCollision(Ship o1, SmallerShipPowerUp o2) {
		this.o1 = o1;
		this.o2 = o2;
	}


	@Override
	public void collide() {
		//NOT WORKING IN WORLDVIEW
		o2.terminate();
//		if(o1.getRadius() > 30){
//			o1.setRadius(o1.getRadius()/1.5);
//		}
	}

}
