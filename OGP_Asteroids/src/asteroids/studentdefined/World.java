package asteroids.studentdefined;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import asteroids.CollisionListener;
import asteroids.Util;
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
 * 
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
		ship.setWorld(this);
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
		asteroid.setWorld(this);
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
		bullet.setWorld(this);
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
	 * TODO: Write full contract for evolve in World.
	 */
	public void evolve(double time, CollisionListener collisionListener) {
		Collision newCollision = getFirstCollision();
		if(newCollision == null){
			advanceAll(time);
		}else{
			if(!newCollision.getObj1().overlap(newCollision.getObj2())){
				advanceAll(time);
			}else{
				handleCollision(newCollision,collisionListener);
			}
			/*
			 * Misschien is dit een gemakkelijkere oplossing ge moet ma zien.
			 * 
			 */
//			double firstCollisionTime = newCollision.getTime();
//			if(firstCollisionTime > time){
//				advanceAll(time);
//			}else{
//				advanceAll(firstCollisionTime);
//				//TODO: collisionlistener stuff
//				handleCollision(newCollision,collisionListener);
//				time -= firstCollisionTime;
//				evolve(time,collisionListener);
//			}
		}
	}

	/**
	 * TODO: Write contract for handleCollision in World
	 * @param newCollision
	 */
	private void handleCollision(Collision newCollision,CollisionListener collisionListener) {
		newCollision.collide();
		double xPos = newCollision.getObj1().getCollisionPosition(newCollision.getObj2()).getX();
		double yPos = newCollision.getObj1().getCollisionPosition(newCollision.getObj2()).getY();
		collisionListener.objectCollision(newCollision.getObj1(), newCollision.getObj2(), xPos,yPos);
		

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
		if (time < 0)
			//throw new IllegalArgumentException("Time is not effective");
			time = 0;
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
		if(collisionPQ.isEmpty()){
			return null;
		}else{
			return collisionPQ.min();
		}

	}
	//TODO: Fix collisions in world.
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
				if (col.contains(ob) || col.getObj1().isTerminated() || col.getObj2().isTerminated()) {
					tempcol.add(col);
				}
				ob.setPendingVelocityChange(false);
			}	
		}
		//Remove all collisions that involve a changed object from the list of upcoming collisions.
		for (Collision col: tempcol) {
			upcomingCollisions.remove(col);
		}

		//Add new collisions with all other objects, for every SpaceObject that has a pending velocity change.
		for (SpaceObject obj: temp) {
			for (SpaceObject obje : visibleObjects) {
				if (!obj.equals(obje) && !obj.isTerminated()) {
					Collision newCollision = new Collision(obj, obje);
					if(newCollision.getTime() != Double.POSITIVE_INFINITY && newCollision.getTime() != Double.NEGATIVE_INFINITY){
						upcomingCollisions.add(newCollision);
					}

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
		updateCollisions();
		this.visibleObjects.remove(spaceObject);
	}

	/**
	 * Returns all bullets associated with this world.
	 * @return A collection of all bullets that are currently associated with this world.
	 */
	public Collection<Bullet> getBullets() {
		Set<Bullet> setOfBullets = new HashSet<Bullet>();
		for(SpaceObject blt : visibleObjects){
			if(blt instanceof Bullet){
				setOfBullets.add((Bullet) blt);
			}
		}
		return setOfBullets;
	}

	/**
	 * Return all ships associated with this world.
	 * @return A collection of all ships that are currently associated with this world.
	 */
	public Collection<Ship> getShips() {
		Set<Ship> setOfShips = new HashSet<Ship>();
		for(SpaceObject shp : visibleObjects){
			if(shp instanceof Ship){
				setOfShips.add((Ship) shp);
			}
		}
		return setOfShips;
	}

	/**
	 * Returns all asteroids associated with this world.
	 * @return A collection of all asteroids that are currently associated with this world.
	 */
	public Collection<Asteroid> getAsteroids() {
		Set<Asteroid> setOfAsteroids = new HashSet<Asteroid>();
		for(SpaceObject ast : visibleObjects){
			if(ast instanceof Asteroid){
				setOfAsteroids.add((Asteroid) ast);
			}
		}
		return setOfAsteroids;
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
