package asteroids.studentdefined;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;
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
 * @invar 	visibleObjects only contains every SpaceObject that is visible
 * 			in this world.
 * 			| for each SpaceObject o1 in World:
 * 			|	containsSpaceObject(o1);
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
		// if (troll == true)
		//	new sonicBoom(supernova);
		
		/* check wich objects collide:
		 * 		bullet - boundary
		 * 		bullet - asteroid
		 * 		bullet - ship
		 * 		asteroid - asteroid
		 * 		asteroid - ship
		 * 		asteroid - boundary
		 * 		ship - boundary
		 * 
		 * 		toekomstig:
		 * 		ship - powerups
		 * 
		 * Geen instanceof!! zie boek p499
		 */
		
		
	}

	/**
	 * Update the position of each spaceobject in this world.
	 * @param 	time
	 * 			Given time that determines the amount of movement of each object.
	 * @effect	Each Object of this world has an updated position based on the
	 * 			given time.
	 * 			| for each spaceobject obj in visibleobjects
	 * 			|	obj.move(time)
	 * @throws 	IllegalArgumentException
	 * 			The given time is not a valid time for an advancement.
	 * 			| time <= 0
	 */
	private void advanceAll(double time) throws IllegalArgumentException{
		if (time <= 0)
			throw new IllegalArgumentException("Time is not effective"); 
		for (SpaceObject obj : visibleObjects)
			obj.move(time);
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
		for(Collision col : upcomingCollisions){
			collisionPQ.insert(col);

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


	//Collections are used to obtain a maximum amount of generality for passing and manipulating these data structures.
	/**
	 * Holds the collisions between all SpaceObjects in this world.
	 */
	private Collection<Collision> upcomingCollisions = new ArrayList<Collision>();
	/**
	 * Holds all non-terminated SpaceObjects that are associated with this world.
	 */
	private Collection<SpaceObject> visibleObjects = new ArrayList<SpaceObject>();


/**
 * Returns True if the given SpaceObject is a member of the data structure that contains all SpaceObjects in this world.
 * @param spaceObject The SpaceObject to be checked.
 */
	public boolean containsSpaceObject(SpaceObject spaceObject) {
		// TODO Auto-generated method stub
		return visibleObjects.contains(spaceObject);
	}
	
	/**
	 * Adds the given SpaceObject to this world.
	 * @post 	This world contains the given SpaceObject.
	 * 			| this.containsSpaceObject(spaceObject)
	 * @post 	The given SpaceObject referenced this world as its associated world.
	 * 			| spaceObject.getWorld() == this
	 * @param spaceObject
	 */
	public void addSpaceObject(SpaceObject spaceObject) {
		
	}
	
	/**
	 * Removes the given SpaceObject from this world.
	 * @post 	This world no longer contains the given SpaceObject.
	 * 			| !this.containsSpaceObject(spaceObject)
	 * @post 	The given SpaceObject is no longer associated with an effective world.
	 * 			| spaceObject.getWorld() == null
	 * @param 	spaceObject
	 */
	public void removeSpaceObject(SpaceObject spaceObject) {
		
	}
	
	/**
	 * Returns all bullets associated with this world.
	 * @return A collection of all bullets that are currently associated with this world.
	 */
	public Collection<Bullet> getBullets() {
		
	}
	
	/**
	 * Return all ships associated with this world.
	 * @return A collection of all ships that are currently associated with this world.
	 */
	public Collection<Ship> getShips() {
		
	}
	
	/**
	 * Returns all asteroids associated with this world.
	 * @return A collection of all asteroids that are currently associated with this world.
	 */
	public Collection<Asteroid> getAsteroids() {
		
	}
	
	/**
	 * Terminate this world.
	 * @post 	This world is terminated.
	 * 			| this.isTerminated()
	 * @post 	No SpaceObjects are attached any longer to this world.
	 * 			| this.getNbSpaceObjects() == 0
	 * @effect 	Each non-terminated SpaceObject in this world no longer has a reference to this world.
	 * 			| for each spaceobject in getAllSpaceObjects()
	 * 			|	if (! spaceobject.isTerminated())
	 * 			|		then spaceobject.setWorld(null)
	 * @effect 	Each non-terminated SpaceObject in this world is removed from this world.
	 * 			| for each spaceobject in getAllSpaceObjects()
	 * 			|	if (! spaceobject.isTerminated())
	 * 			|		then this.removeAsSpaceObject(spaceobject)
	 */
	public void terminate() {
		
	}

	/**
	 * Check whether this world is terminated.
	 */
	@Basic @Raw
	public boolean isTerminated() {
		return isTerminated;
	}
	
	public boolean isTerminated;

}
