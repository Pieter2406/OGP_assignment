package asteroids.studentdefined;

import java.util.ArrayList;
import edu.princeton.cs.algs4.MinPQ;;
/******************************************************************************************
 * 								GENERAL TODO LIST:		              			          *
 ******************************************************************************************
 *		- Attributen:															          *
 *			- width																		  *
 *			- height																	  *
 *			- maxWidthHeight = Double.MAX_VALUE											  *	
 *		- Methodes:																		  *	
 *			- addShip(Coordinate initLocation, Velocity initVelocity, Double angle)		  *	
 *			- removeShip(Ship remShip)													  *		
 *			- addAsteroid(Coordinate initLocation, Velocity initVelocity, Double angle)	  *	
 *			- removeAsteroid(Asteroid remAsteroid)										  *	
 *			- addBullet(Coordinate initLocation, Velocity initVelocity, Double angle)	  *
 *			- removeBullet(Bullet remBullet)	 										  *
 *			- evolve(double time) (zie p7 voor uitwerking)					  	 	 	  *
 *		- Methodes voor powerUps														  *
 ******************************************************************************************/	

/** 
 * A class of world involves a screen with a given width and height.
 * 
 * 
 * @version 1.1
 * 
 * @invar 	The arraylist visibleObjects only contains every SpaceObject that is visible
 * 			in this world.
 * 			| for each SpaceObject o1 in World:
 * 			|	visibleObjects.contains(o1);
 * 
 * @author Kristof Bruynincks
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 */
public class World {

	/**
	 * Initialize a new world with a given width and given height.
	 * 
	 * @param 	width
	 * 			The given width of the new world in km.
	 * @param 	height
	 * 			The given height of the new world in km.
	 * @post	The width and height of this new world are set to the given
	 * 			width and height.
	 * 			|new.width = width
	 * 			|new.height = height	
	 */	
	public World(double width, double height){
		this.width = width;
		this.height = height;
	}


	/**
	 * @return the width of this world.
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Holds the width of this world.
	 */
	private final double width;



	/**
	 * @return the height of this world.
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Holds the height of this world.
	 */
	private final double height;

	/**
	 * Add a ship to the current world.
	 * 
	 * @param 	ship
	 * 			The given ship that will be added.
	 */
	public void addShip(Ship ship){
		visibleObjects.add(ship);
	}

	/**
	 * Remove a ship in the current world.
	 * 
	 * @param	ship
	 * 			A reference to the ship that needs to be removed.
	 */
	public void removeShip(Ship ship){
		visibleObjects.remove(ship);
	}

	/**
	 * Add an asteroid to the current world.
	 * 
	 * @param 	asteroid
	 * 			The given asteroid that will be added.
	 */
	public void addAsteroid(Asteroid asteroid){
		visibleObjects.add(asteroid);
	}

	/**
	 * Remove an asteroid in the current world.
	 * 
	 * @param	asteroid
	 * 			A reference to the asteroid that needs to be removed.
	 */
	public void removeAsteroid(Asteroid asteroid){
		visibleObjects.remove(asteroid);
	}

	/**
	 * Add a bullet to the current world.
	 * 
	 * @param 	bullet
	 * 			The given bullet that will be added.
	 */
	public void addBullet(Bullet bullet){
		visibleObjects.add(bullet);
	}

	/**
	 * Remove a bullet in the current world.
	 * 
	 * @param	bullet
	 * 			A reference to the bullet that needs to be removed.
	 */
	public void removeBullet(Bullet bullet){
		visibleObjects.remove(bullet);
	}

	/**
	 * Evolves the world from its current state to a new state, - more specifically - 
	 * the state that this world is in after the given amount of time has passed from the current state.
	 * @param 	time
	 * 			The time over which the world changes.
	 * 
	 * TODO: write full contract
	 */
	public void evolve(double time) {
		Collision newCollision = getFirstCollision();
		double firstCollisionTime = newCollision.getTime();
		if(firstCollisionTime > time){
			advanceAll(time);
		}else{
			advanceAll(firstCollisionTime);
			handleCollision(newCollision);
			time -= firstCollisionTime;
			evolve(time);

		}
	}

	/**
	 * 
	 * @param newCollision
	 */
	private void handleCollision(Collision newCollision) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @param time
	 */
	private void advanceAll(double time) {
		// TODO Auto-generated method stub

	}

	/**
	 * Get a Collision object with the objects that will collide first.
	 * 
	 * @return the first collision that will take place.
	 */
	private Collision getFirstCollision() {

		/*
		 * Construct minPQ that contains all future collisions between objects.
		 * Extract the minimum value (Collision) of the PQ and return it.
		 */
		updateCollisions();
		MinPQ<Collision> collisionPQ = new MinPQ<Collision>();
		for(Collision cololol : upcomingCollisions){
			collisionPQ.insert(cololol);

		}
		return collisionPQ.min();
	}
	//TODO: fix it
	/**
	 * Update the list of future collisions, so that every collision that involves a SpaceObject that has a pending velocity change,
	 * is recalculated, while other collisions remain the same.
	 *
	 */
	private void updateCollisions() {
		ArrayList<SpaceObject> temp = new ArrayList<SpaceObject>();
		ArrayList<Collision> tempcol = new ArrayList<Collision>();

		for (SpaceObject obj : visibleObjects) {
			if (obj.hasPendingVelocityChange())
				temp.add(obj);
		}
		for (Collision col: upcomingCollisions) {
			//Recalculate all collisions that involve an object with a pending velocity change and set the flag to false.
			for (SpaceObject ob : temp) {
				if (col.contains(ob)) {
					tempcol.add(col);
				}
				ob.setPendingVelocityChange(false);
			}	
		}
		//Remove all collisions that involve a changed object from the list of upcoming collisions.
		for (Collision col: tempcol) {
			upcomingCollisions.remove(tempcol);
		}

		//Add new collisions with all other objects, for every SpaceObject that has a pending velocity change.
		for (SpaceObject obj: temp) {
			for (SpaceObject obje : visibleObjects) {
				if (!obj.equals(obje)) {
					Collision newCollision = new Collision(obj, obje);
					if(newCollision.getTime() != Double.POSITIVE_INFINITY && newCollision.getTime() != Double.NEGATIVE_INFINITY)
						upcomingCollisions.add(newCollision);
				}
			}
		}
	}

	/**
	 * Holds the spaceobjects in the world.
	 */


	private ArrayList<Collision> upcomingCollisions = new ArrayList<Collision>();
	private ArrayList<SpaceObject> visibleObjects = new ArrayList<SpaceObject>();


}
