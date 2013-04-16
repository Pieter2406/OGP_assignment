package asteroids.studentdefined;

import asteroids.collisions.CollisionFactory;
import asteroids.collisions.CollisionType;

/**
 * A class of Collision extends to SpaceObject and involves a position and a velocity.
 * 
 * TODO: Write @invar (if necessary) in Collision class
 * @author Kristof Bruynincks
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 * @version 1.0
 * @invar If a collision is between a SpaceObject and a Wall, the Wall is always the second object, and the SpaceObject is the first 
 * object.
 * 
 */

public class Collision implements Comparable<Collision> {

	//TODO: Write contracts in Collision class
	
	/**
	 * Initialize a collision between 2 space objects.
	 * @param 	o1
	 * 			A first given object involved in a collision.
	 * @param 	o2
	 * 			A second given object involved in a collision.
	 * @throws 	IllegalArgumentException
	 * 			If one of the given space objects is not a space object.
	 * 			| 
	 */
	public Collision(SpaceObject o1, SpaceObject o2) {
		this.o1 = o1;
		this.o2 = o2;
		this.time = o1.getTimeToCollision(o2);
	}
	
	public Collision(SpaceObject o1, Wall wall) {
		this.o1 = o1;
		this.o2 = wall;
		this.time = o1.getTimeToCollision(wall);
	}

	public double getTime() {
		calculateTime();
		return time;
	}
	
	
	private void calculateTime() {
		if (o2 instanceof Wall)
			time = ((SpaceObject)o1).getTimeToCollision((Wall)o2);
		else
			time = ((SpaceObject)o1).getTimeToCollision((SpaceObject)o2);
	}

	private SpaceObject o1;
	private Object o2;
	private double time;
	@Override
	public int compareTo(Collision other) {
		if (this.getTime() > other.getTime()){
			return 1;
		}else if(this.getTime() < other.getTime()){
			return -1;
		}else{
			return 0;
		}
	}

	public SpaceObject getObj1() {
		return o1;
	}

	public Object getObj2() {
		return o2;
	}
	
	public boolean contains(Object obj) {
		if (getObj1().equals(obj) || getObj2().equals(obj))
			return true;
		else
			return false;
	}
	public void collide(){
		CollisionType c = CollisionFactory.collide(getObj1(), getObj2());
		c.collide();
	}
//	public boolean collidesWithSource(){
//		Bullet tempBullet = null;
//		SpaceObject other = null;
//		if(getObj1() instanceof Bullet){
//			tempBullet = (Bullet) getObj1();
//			other = getObj2();
//		}else if(getObj2() instanceof Bullet){
//			tempBullet = (Bullet) getObj2();
//			other = getObj1();
//		}else{
//			return false;
//		}
//		return (tempBullet.getSource().equals(other));
//	}
//	
//	public boolean permittedCollision(){
//		return false;
//	}
}
