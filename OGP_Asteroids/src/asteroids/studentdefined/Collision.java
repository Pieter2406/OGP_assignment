package asteroids.studentdefined;

import be.kuleuven.cs.som.annotate.Basic;
import asteroids.collisions.CollisionFactory;
import asteroids.collisions.CollisionType;

/**
 * A class of Collision extends to SpaceObject and involves a position and a velocity.
 * 
 * @author Kristof Bruynincks
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 * @version 1.0
 * 
 * @invar	If a collision is between a SpaceObject and a Wall, the Wall is always the second object, and the SpaceObject is the first 
 * 			object.
 * @invar	The two objects of a collision must always be associated with the same world.
 * 			| o1.getWorld().containsSpaceObject(o2) || o1.getWorld().boundaryWalls.contains(o2) 
 * 
 */

public class Collision implements Comparable<Collision> {


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

	/**
	 * Initialize a collision between a space object and a wall.
	 * @param 	o1
	 * 			A given space object involved in a collision.
	 * @param 	o2
	 * 			A given wall involved in a collision.
	 * @throws 	IllegalArgumentException
	 * 			If one of the given objects is not a space object or a wall.
	 * 			| 
	 */
	public Collision(SpaceObject o1, Wall wall) {
		this.o1 = o1;
		this.o2 = wall;
		this.time = o1.getTimeToCollision(wall);
	}

	 /*_____________________________ASTEROID_____________________________*/
	
	/**
	 * Return the time of this collision.
	 */
	@Basic
	public double getTime() {
		calculateTime();
		return time;
	}
	/**
	 * Holds the time that passes before the collision happens.
	 */
	private double time;

	/**
	 * Calculates the time that passes before the collision happens.
	 * @effect	If the second object us a wall, the time to collision
	 * 			is calculated between a spaceobject and a wall.
	 * 			otherwise it is calculated between two spaceobjects.
	 * 			| if(o2 instanceof Wall)
	 * 			|	new.getTime == o1.getTimeToCollision((Wall) o2)
	 * 			| else
	 * 			|	new.getTime == o1.getTimeToCollision((SpaceObject)o2)
	 */
	private void calculateTime() {
		if (o2 instanceof Wall)
			time = ((SpaceObject)o1).getTimeToCollision((Wall)o2);
		else
			time = ((SpaceObject)o1).getTimeToCollision((SpaceObject)o2);
	}

	
	
	
	
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
	
	private SpaceObject o1;

	public Object getObj2() {
		return o2;
	}
	private Object o2;
	
	/**
	 * Check whether the collision contains a given object.
	 * 	
	 * @param 	o
	 * 			The object to check whether is exists in this collision.
	 * @return	True if this collision contains the given object.
	 */
	public boolean contains(Object o) {
		if (getObj1().equals(o) || getObj2().equals(o))
			return true;
		else
			return false;
	}
	
	/**
	 * Handle the collision between the two objects in this collision.
	 * 
	 * @effect	The collisionfactory returns the type of collision
	 * 			and this collision holds a collide function which
	 * 			executes the collisioneffect between the two objects.
	 * 			| CollisionType c = CollisionFactory.collide(getObj1(), getObj2())
	 * 			| c.collide()
	 */
	public void collide(){
		CollisionType c = CollisionFactory.collide(getObj1(), getObj2());
		c.collide();
	}
}
