package asteroids.collisions;

import asteroids.studentdefined.*;

/**
 * @author Pieter
 *
 */
public final class CollisionFactory {

	public static CollisionType collide(Object o1, Object o2){
		//AsteroidAsteroidCollision
		if(o1 instanceof Asteroid && o2 instanceof Asteroid)
			return new AsteroidAsteroidCollision((Asteroid) o1,(Asteroid) o2);
		//AsteroidBulletCollision
		if((o1 instanceof Asteroid && o2 instanceof Bullet) || (o2 instanceof Asteroid && o1 instanceof Bullet)){
			if(o1 instanceof Asteroid)
				return new AsteroidBulletCollision((Asteroid) o1,(Bullet) o2);
			else
				return new AsteroidBulletCollision((Asteroid) o2, (Bullet) o1);
		}
		//AsteroidShipCollision
		if((o1 instanceof Asteroid && o2 instanceof Ship) || (o2 instanceof Ship && o1 instanceof Asteroid)){
			if(o1 instanceof Asteroid)
				return new AsteroidShipCollision((Asteroid) o1,(Ship) o2);
			else
				return new AsteroidShipCollision((Asteroid) o2, (Ship) o1);
		}
		//ShipBulletCollision
		if((o1 instanceof Ship && o2 instanceof Bullet) || (o2 instanceof Ship && o1 instanceof Bullet)){
			if(o1 instanceof Ship){
				if (((Bullet) o2).getSource() != o1) // if a ship collides with its own bullets there is no collision.
					return new ShipBulletCollision((Ship) o1,(Bullet) o2);
				else 
					return new NoCollision();
			}
			else {
				if (((Bullet) o1).getSource() != o2)
					return new ShipBulletCollision((Ship) o2, (Bullet) o1);
				else 
					return new NoCollision();
			}
		}
		//BUlletBulletCollision
		if(o1 instanceof Bullet && o2 instanceof Bullet)
			return new BulletBulletCollision((Bullet) o1, (Bullet) o2);
		//ShipWallCollision
		if(o1 instanceof Ship && o2 instanceof Wall)
			return new ShipWallCollision((Ship) o1,(Wall) o2);
		//AsteroidWallCollision
		if(o1 instanceof Asteroid && o2 instanceof Wall)
			return new AsteroidWallCollision((Asteroid) o1, (Wall) o2);
		return new NoCollision();
	}
}
