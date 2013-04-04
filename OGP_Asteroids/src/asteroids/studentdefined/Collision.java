package asteroids.studentdefined;

/**
 * A class of Collision extends to SpaceObject and involves a position and a velocity.
 * 
 * TODO: write @invar (if necessary)
 * 
 * @version 1.1
 * 
 * @author Kristof Bruynincks
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 */

public class Collision implements Comparable<Collision> {

	//TODO: Write contracts
	
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

	public double getTime() {
		calculateTime();
		return time;
	}
	
	private void calculateTime() {
		time = o1.getTimeToCollision(o2);
	}

	private SpaceObject o1, o2;
	private double time;
	@Override
	public int compareTo(Collision other) {
		if (this.time > other.getTime()){
			return 1;
		}else if(this.time < other.getTime()){
			return -1;
		}else{
			return 0;
		}
	}

	public SpaceObject getObj1() {
		return o1;
	}

	public SpaceObject getObj2() {
		return o2;
	}
	
	public boolean contains(SpaceObject obj) {
		if (getObj1().equals(obj) || getObj2().equals(obj))
			return true;
		else
			return false;
	}

	public boolean collidesWithSource(){
		Bullet tempBullet = null;
		SpaceObject other = null;
		if(getObj1() instanceof Bullet){
			tempBullet = (Bullet) getObj1();
			other = getObj2();
		}else if(getObj2() instanceof Bullet){
			tempBullet = (Bullet) getObj2();
			other = getObj1();
		}else{
			return false;
		}
		return (tempBullet.getSource().equals(other));
	}
	
	public boolean permittedCollision(){
		return false;
		//TODO: write permittedCollision
	}
}
