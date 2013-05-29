package asteroids.studentdefined;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import asteroids.CollisionListener;
import asteroids.Util;
import asteroids.collisions.CollisionFactory;
import asteroids.powerups.*;
import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Model;
import be.kuleuven.cs.som.annotate.Raw;
import edu.princeton.cs.algs4.MinPQ;

/** 
 * A class of world involves a screen with a given width and height.
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
		//Add four walls at the borders of the world.
		boundaryWalls.add(new Wall(new Coordinate(0,0), "vertical"));
		boundaryWalls.add(new Wall(new Coordinate(0,0), "horizontal"));
		boundaryWalls.add(new Wall(new Coordinate(width, height), "vertical"));
		boundaryWalls.add(new Wall(new Coordinate(width, height), "horizontal"));

	}

	/*_________________________________________Basic World properties__________________________________________*/
	// These basic properties are expressed in pixels, and each pixel represents a kilometer.

	/**
	 * @return the width of this world.
	 */
	@Raw
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
	@Raw
	public double getHeight() {
		return height;
	}

	/**
	 * Holds the height of this world.
	 */
	private final double height;
	
	/**
	 * Holds the time, how long a powerup lasts in this world in milliseconds.
	 */
	public static final double POWER_UP_LIFE_TIME = Double.POSITIVE_INFINITY;

	/*_________________________________________Add/remove objects__________________________________________*/
	//Methods to add visible Objects to this world that should be drawn.

	/**
	 * Add a ship to the current world.
	 * 
	 * @param 	ship
	 * 			The ship that will be added.
	 */
	public void addShip(Ship ship){
		addSpaceObject(ship);
	}

	/**
	 * Remove a ship in the current world.
	 * 
	 * @param	ship
	 * 			A reference to the ship that needs to be removed.
	 */
	public void removeShip(Ship ship){
		removeSpaceObject(ship);
	}

	/**
	 * Add an asteroid to the current world.
	 * 
	 * @param 	asteroid
	 * 			The asteroid that will be added.
	 */
	public void addAsteroid(Asteroid asteroid){
		addSpaceObject(asteroid);
	}

	/**
	 * Remove an asteroid in the current world.
	 * 
	 * @param	asteroid
	 * 			A reference to the asteroid that needs to be removed.
	 */
	public void removeAsteroid(Asteroid asteroid){
		removeSpaceObject(asteroid);
	}

	/**
	 * Add a bullet to the current world.
	 * 
	 * @param 	bullet
	 * 			The bullet that will be added.
	 */
	public void addBullet(Bullet bullet){
		addSpaceObject(bullet);
	}

	/**
	 * Remove a bullet in the current world.
	 * 
	 * @param	bullet
	 * 			A reference to the bullet that needs to be removed.
	 */
	public void removeBullet(Bullet bullet){
		removeSpaceObject(bullet);
	}

	/**
	 * Returns True if the given SpaceObject is a member of the data structure that contains all SpaceObjects in this world.
	 * @param spaceObject The SpaceObject to be checked.
	 */
	public boolean containsSpaceObject(SpaceObject spaceObject) {
		return visibleObjects().contains(spaceObject);
	}

	/**
	 * Add the given SpaceObject to this world.
	 * @post 	This world contains the given SpaceObject.
	 * 			| this.containsSpaceObject(spaceObject)
	 * @post 	The given SpaceObject references this world as its associated world.
	 * 			| spaceObject.getWorld() == this
	 * @param 	spaceObject
	 * 			The space object to be added to this world.
	 * @throws	IllegalArgumentException
	 * 			This world cannot have the given space object as one of 
	 * 			its visible objects.
	 * 			| !canHaveAsVisibleObject(spaceObject)
	 * @throws	IllegalArgumentException
	 * 			The given space object is already attached to some world.
	 * 			| spaceObject.getWorld() != this
	 */
	public void addSpaceObject(SpaceObject spaceObject) throws IllegalArgumentException {
		if(!canHaveAsVisibleObject(spaceObject)){
			throw new IllegalArgumentException("This world cannot contain the given object");
		}
		if(spaceObject.getWorld() != this && spaceObject.getWorld() != null){
			throw new IllegalArgumentException("The given space object already exists in another world.");
		}
		if(spaceObject instanceof Ship){
			visibleShips.add((Ship)spaceObject);
		}else if(spaceObject instanceof Asteroid){
			visibleAsteroids.add((Asteroid)spaceObject);
		}else if(spaceObject instanceof Bullet){
			visibleBullets.add((Bullet)spaceObject);
		}else if(spaceObject instanceof PowerUp){
			visiblePowerUps.add((PowerUp)spaceObject);
		}
		spaceObject.setWorld(this);
	}

	/**
	 * Remove the given SpaceObject from this world.
	 * @post 	This world no longer contains the given SpaceObject.
	 * 			| !this.containsSpaceObject(spaceObject)
	 * @post 	The given SpaceObject is no longer associated with an effective world.
	 * 			| spaceObject.getWorld() == null
	 * @param 	spaceObject
	 * 			The space object to be removed from this world.
	 */
	public void removeSpaceObject(SpaceObject spaceObject) { 
		if(spaceObject != null){
			if(spaceObject instanceof Ship){
				visibleShips.remove((Ship)spaceObject);
			}else if(spaceObject instanceof Asteroid){
				visibleAsteroids.remove((Asteroid)spaceObject);
			}else if(spaceObject instanceof Bullet){
				visibleBullets.remove((Bullet)spaceObject);
			}else if(spaceObject instanceof PowerUp){
				visiblePowerUps.remove((PowerUp)spaceObject);
			}
			spaceObject.setWorld(null);
		}		
	}

	/**
	 * Return all space objects associated with this world.
	 * @return A collection of all space objects that are currently associated with this world.
	 */


	/*_________________________________________Advance step methods__________________________________________*/

	/**
	 * Evolves the world from its current state to a new state, - more specifically - 
	 * the state that this world is in after the given amount of time has passed from the current state.
	 * @param 	time
	 * 			The time over which the world changes.
	 * @post	If no collision takes place between the moment of calling this method and the given time, all
	 * 			visible objects are moved to their position after this given time has passed.
	 * 			If one or more collision(s) do take place during that time interval, all these collisions are
	 * 			handled, and all visible objects are moved to their position after the given time has passed, and after
	 * 			all collisions that take place during this time interval have been handled.
	 * @throws	IllegalValueException
	 * 			The given time is negative, infinity or not a number.
	 * 			| !((time >= 0) && (time < Double.POSITIVE_INFINITY))
	 */
	public void evolve(double time, CollisionListener collisionListener) throws IllegalValueException {
		if(!(time >= 0) && (time < Double.POSITIVE_INFINITY)){
			throw new IllegalValueException(time);
		}
		
		
		//Find the collision that will happen first
		Collision newCollision = getFirstCollision();
		if(newCollision == null){
			advanceAll(time);
		}else{
			double firstCollisionTime = newCollision.getTime();
			if(firstCollisionTime > time){ // It takes longer than the time of this evolve before the first collision happens
				advanceAll(time);
				if(rndBoolean(POWERUP_CHANCE * time)){ //With the given chance of generating a powerup
					SpaceObject powerUp = generateRandomPowerup();
					if(powerUp != null){
						addSpaceObject(generateRandomPowerup());
					}
				}
			}else{
				advanceAll(firstCollisionTime);
				time -= firstCollisionTime;
				handleCollision(newCollision,collisionListener);
				evolve(time,collisionListener);
			}
		}
	}

	/**
	 * Handles all effects of a collision between two visible objects that are associated with this world.
	 * @param	newCollision	
	 * 			The collision to be handled.
	 * @param 	collisionListener
	 * 			The handler responsible for drawing visual effects of this collision.
	 * @post	The given collision has been resolved.
	 */
	@Model
	private void handleCollision(Collision newCollision,CollisionListener collisionListener) {
		boolean boundarycollision = false;
		if (!(CollisionFactory.collide(newCollision.getObj1(), newCollision.getObj2()) instanceof asteroids.collisions.NoCollision)){
			double xPos,yPos;
			if (newCollision.getObj2() instanceof SpaceObject){
				xPos = newCollision.getObj1().getCollisionPosition((SpaceObject) newCollision.getObj2()).getX();
				yPos = newCollision.getObj1().getCollisionPosition((SpaceObject) newCollision.getObj2()).getY();
			}
			else { // collision with wall.
				boundarycollision = true;
				xPos = newCollision.getObj1().getCollisionPosition((Wall) newCollision.getObj2()).getX();
				yPos = newCollision.getObj1().getCollisionPosition((Wall) newCollision.getObj2()).getY();
			}

			newCollision.collide();

			//Send collision positions to the handler of visual effects.
			if(collisionListener != null)
			{			
				if (boundarycollision)
					collisionListener.boundaryCollision(newCollision.getObj1(), xPos,yPos);
				else
					collisionListener.objectCollision(newCollision.getObj1(), newCollision.getObj2(), xPos,yPos);
			}
		}
	}


	/**
	 * Update the position of each space object in this world.
	 * @param 	time
	 * 			Given time that determines the amount of movement of each object.
	 * @effect	Each Object of this world has an updated position based on the
	 * 			given time.
	 * 			| for each SpaceObject obj in visibleObjects
	 * 			|	obj.move(time)
	 * @throws 	IllegalArgumentException
	 * 			The given time is not a valid time for an advancement.
	 * 			| time <= 0
	 */
	@Model
	private void advanceAll(double time) {
		if (time < 0) //Cannot move over a negative amount of time.
			time = 0;
		
		for (Ship ship : getAllShips()){
			ArrayList<PowerUp> tempPwpActiveList = new ArrayList<PowerUp>();
			//tempList to avoid the ConcurrentmodificationException
			tempPwpActiveList.addAll(ship.getActivePowerUps());
			for(PowerUp pwp : tempPwpActiveList){
				pwp.evaluate();
			}
		}
		for (SpaceObject obj : visibleObjects())
			obj.move(time); // moves objects + updates velocity of ships.
		
		for(Ship ship : getAllShips()){
			if(ship.getProgram() == null)
				continue;
			if(System.currentTimeMillis() - ship.getProgram().getLastRunTime() >= Program.DEFAULT_RUN_FREQUENCY){
				ship.getProgram().run();
				ship.getProgram().setLastRunTime(System.currentTimeMillis());
			}
		}
	}

	/*_________________________________________Powerup generating__________________________________________*/

	/**
	 * generates a random powerup 
	 * @return 	a new object of a random powerup.
	 * 			| new RandomPowerup(randomposX,randomposY, this)
	 */
	@Model
	private PowerUp generateRandomPowerup(){
		Random rnd = new Random();
		double rndX = 0;
		double rndY = 0;
		for(Ship shp : getAllShips()){
			do{
				rndX = rnd.nextInt((int) (getWidth() - 2 * PowerUp.DEFAULT_RADIUS)) + PowerUp.DEFAULT_RADIUS;
				rndY = rnd.nextInt((int) (getHeight() - 2 * PowerUp.DEFAULT_RADIUS)) + PowerUp.DEFAULT_RADIUS;
			}while((shp.getPosition().getDistanceBetween(new Coordinate(rndX,rndY))) - PowerUp.DEFAULT_RADIUS - shp.getRadius()< 0);

		}		
		switch(rnd.nextInt(6)){			
		case 0: return new SmallerShipPowerUp(rndX,rndY,this,null);
		case 1: return new IncreaseBulletSpeedPowerUp(rndX,rndY,this,null);
		case 2: return new BiggerBulletSizePowerUp(rndX,rndY,this,null);
		case 3: return new TriShotBulletsPowerUp(rndX, rndY,this,null);
		case 4: return new ShipShieldPowerUp(rndX,rndY,this,null);
		case 5: return new RadiusAsteroidPushPowerUp(rndX,rndY,this,null);
		default: return null;
		}
	}

	/**
	 * private function, has a given chance of returning true, else returns false.
	 */
	@Model
	private boolean rndBoolean(double chance){
		Random rnd = new Random();
		double rndInt = rnd.nextInt(100);
		if(rndInt < chance){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Percentage of chance that a new powerup spawns in this world each time a step is executed.
	 */
	private static final double POWERUP_CHANCE = 2;

	/*_________________________________________Collision detecting__________________________________________*/

	/**
	 * Get a Collision object with the objects that will collide first.
	 * 
	 * @return 	the first collision that will take place.
	 * 			| updateCollisions()
	 * 			| 	lowestTimeCol = Double.POSITIVE_INFINITY
	 * 			| for each collision in updateCollisions
	 * 			|	if collision.calculateTime() < lowestTimeCol.calculateTime()
	 * 			|		lowestTimeCol = collision
	 * 			| result == lowestTimeCol
	 */
	@Model
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

	/**
	 * Update the list of future collisions, so that every collision that involves a SpaceObject that has a pending velocity change,
	 * is recalculated, while other collisions remain the same.
	 * @post	The data structure of upcoming collisions contains only collisions that involve space objects with no pending
	 * 			velocity change.
	 * 			| for each collision in upcomingCollisions
	 * 			|	collision.getObj1().hasPendingVelocityChange == false && collision.getObj2().hasPendingVelocityChange == false
	 * @post	The data structure of upcoming collisions contains only collisions that involve non-terminated objects.
	 * 			| for each collision in upcomingCollisions
	 * 			|	!( collision.getObj1().isTerminated() || collision.getObj2().isTerminated() )
	 *
	 */
	@Model
	private void updateCollisions() {
		ArrayList<SpaceObject> toBeRecalculatedObj = new ArrayList<SpaceObject>(); //Temp storage for objects with a pending velocity change.
		ArrayList<Collision> toBeRemovedCol = new ArrayList<Collision>(); //Temp storage for collisions to be removed after iterating.

		for (SpaceObject obj : visibleObjects()) {
			if (obj.hasPendingVelocityChange())
				toBeRecalculatedObj.add(obj);
		}
		for (Collision col: upcomingCollisions) {
			// Remove collision involving objects that are already terminated.
			if (col.getObj2() instanceof SpaceObject){
				if (col.getObj1().isTerminated() || ((SpaceObject)col.getObj2()).isTerminated()){
					toBeRemovedCol.add(col);
				}
			}
			else // The collision involves a wall instead of a second SpaceObject
				if (col.getObj1().isTerminated()){
					toBeRemovedCol.add(col);
				}
			//Add all collisions that involve an object with a pending velocity flag to the data set
			//of collisions to be removed and set the flag to false.
			for (SpaceObject recalcObj : toBeRecalculatedObj) {
				if (col.contains(recalcObj)) {
					toBeRemovedCol.add(col);
				}
				recalcObj.setPendingVelocityChange(false);
			}	
		}
		//Remove all collisions that involve a changed object from the list of upcoming collisions.
		for (Collision col: toBeRemovedCol) {
			upcomingCollisions.remove(col);
		}

		//Add new collisions with all other objects, for every SpaceObject that has a pending velocity change.
		for (SpaceObject obj: toBeRecalculatedObj) {
			for (SpaceObject obje : visibleObjects()) {
				if (!obj.equals(obje) && !obj.isTerminated() && !obje.isTerminated()) {
					Collision newCollision = new Collision(obj, obje);
					if(newCollision.getTime() != Double.POSITIVE_INFINITY && newCollision.getTime() != Double.NEGATIVE_INFINITY){
						// don't add collisions that should be ignored
						if (!(CollisionFactory.collide(newCollision.getObj1(), newCollision.getObj2()) instanceof asteroids.collisions.NoCollision)){
							boolean sameCollision = false; // make sure that the same collision isn't added with reversed parameters.
							for (Collision col: upcomingCollisions){
								if (col.getObj1() == obje && col.getObj2() == obj){
									sameCollision = true;
									break;
								}
							}
							if (sameCollision == false)
								upcomingCollisions.add(newCollision);
						}
					}
				}
			}
			//Add collisions with every wall, for every SpaceObject that has a pending velocity change.
			for (Wall wall: boundaryWalls) {
				try {
					Collision newWallCollision = new Collision(obj, wall);
					if(newWallCollision.getTime() != Double.POSITIVE_INFINITY && newWallCollision.getTime() != Double.NEGATIVE_INFINITY){
						//Only add a wall collision if it will take place within the game room(walls are straight infinite lines)
						//Not neccesary, because another wall collision will always happen first and result in a velocity change!!
						//					if (newWallCollision.getObj1().getCollisionPosition(wall).getX() >= 0
						//							&& newWallCollision.getObj1().getCollisionPosition(wall).getX() <= this.getWidth()
						//							&& newWallCollision.getObj1().getCollisionPosition(wall).getY() >= 0
						//							&& newWallCollision.getObj1().getCollisionPosition(wall).getY() <= this.getHeight())
						upcomingCollisions.add(newWallCollision);
					}
				} catch (IllegalArgumentException e) { //Wall is a null reference, ignore this collision
					break;
				}
			}
		}
	}


	/*_________________________________________Data structures associations__________________________________________*/

	//Collections are used to obtain a maximum amount of generality for passing and manipulating these data structures.
	/**
	 * Holds the collisions between all SpaceObjects in this world.
	 * 
	 * @invar	The list of upcoming collisions is effective.
	 * 		| upcomingCollisions != null
	 * @invar	Each element in the collection of upcoming collisions
	 * 		references a collision that is an acceptable collision.
	 * 		| hasProper
	 */
	private Collection<Collision> upcomingCollisions = new ArrayList<Collision>();

	/**
	 * Holds all non-terminated SpaceObjects that are associated with this world.
	 * 
	 * @invar	The list of visible objects is effective.
	 * 		| visibleObjects != null
	 * @invar	Each element in the collection of visible objects
	 * 		references an object that is acceptable as a visible
	 * 		object for this world.
	 * 		| hasProperVisibleObjects()
	 */
	private Collection<SpaceObject> visibleObjects(){
		Collection<SpaceObject> allVisibleObjects = new HashSet<SpaceObject>();
		allVisibleObjects.addAll(getAllShips());
		allVisibleObjects.addAll(getAllAsteroids());
		allVisibleObjects.addAll(getAllBullets());
		allVisibleObjects.addAll(getAllPowerUps());
		return allVisibleObjects;		
	}
	/**
	 * Holds the visible ships in this world.
	 */
	private Collection<Ship> visibleShips = new HashSet<Ship>();
	
	/**
	 * Holds the visible asteroids in this world.
	 */
	private Collection<Asteroid> visibleAsteroids = new HashSet<Asteroid>();
	
	/**
	 * Holds the visible bullets in this world.
	 */
	private Collection<Bullet> visibleBullets = new HashSet<Bullet>();
	
	/**
	 * Holds the visible powerups in this world.
	 */
	private Collection<PowerUp> visiblePowerUps = new HashSet<PowerUp>();
	
	/**
	 * Holds the (4) walls that form the boundary of the game room.
	 */
	private Collection<Wall> boundaryWalls = new ArrayList<Wall>();


	@Raw
	public Collection<SpaceObject> getAllSpaceObjects() {
		Set<SpaceObject> setOfSpaceObjects = new HashSet<SpaceObject>();
		setOfSpaceObjects.addAll(visibleObjects());
		return setOfSpaceObjects;
	}
	
	
	/**
	 * Returns all bullets associated with this world.
	 * @return A collection of all bullets that are currently associated with this world.
	 */
	@Raw
	public Collection<Bullet> getAllBullets() {
		Set<Bullet> setOfBullets = new HashSet<Bullet>();
		setOfBullets.addAll(visibleBullets);
		return setOfBullets;
	}

	/**
	 * Return all ships associated with this world.
	 * @return A collection of all ships that are currently associated with this world.
	 */
	@Raw
	public Collection<Ship> getAllShips() {
		Set<Ship> setOfShips = new HashSet<Ship>();
		setOfShips.addAll(visibleShips);
		return setOfShips;
	}
	/**
	 * Returns all powerups associated with this world.
	 * @return	A collection of all powerups that are currently associated with this world.
	 */
	@Raw
	public Collection<PowerUp> getAllPowerUps(){
		Set<PowerUp> setOfPowerUps = new HashSet<PowerUp>();
		setOfPowerUps.addAll(visiblePowerUps);
		return setOfPowerUps;
	}

	/**
	 * Returns all asteroids associated with this world.
	 * @return A collection of all asteroids that are currently associated with this world.
	 * 
	 */
	@Raw
	public Collection<Asteroid> getAllAsteroids() {
		Set<Asteroid> setOfAsteroids = new HashSet<Asteroid>();
		setOfAsteroids.addAll(visibleAsteroids);
		return setOfAsteroids;
	}
	
	/**
	 * Returns the walls (4) of this world.
	 * @return A collection of all walls in the world.
	 */
	public Collection<Wall> getAllWalls(){
		return boundaryWalls;
	}

	/**
	 * Checks if this world can have the given object as one of its visible objects.
	 *
	 * @param 	o 
	 * 		The object to check.
	 * @return 	False, if the given object is not effective.
	 * 		| if(o == null)
	 * 		|	result == false
	 * 		Otherwise false, if the given object is not a space object.
	 *  	| else if (!(o instanceof SpaceObject))
	 *  	|	result == false
	 *  	Otherwise true, if this world and the given object are not terminated.
	 *  	| else if(!this.isTerminated() && !o.isTerminated())
	 *  	|	result == true
	 *  		
	 */
	public boolean canHaveAsVisibleObject(Object o){
		if(o == null){
			return false;
		}else if(!(o instanceof SpaceObject)){
			return false;
		}else if(this.isTerminated() || ((SpaceObject) o).isTerminated()){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * Checks whether this world has proper visible objects associated with it.
	 * 
	 * @return	True if and only if this world can have each of its visible objects as
	 * 		a visible object.
	 * 		|result == for each object o in visibleObjects
	 * 		|	canHaveAsVisibleObject(o)
	 * 		
	 */
	public boolean hasProperVisibleObjects(){
		for(Object o : visibleObjects()){
			if(!canHaveAsVisibleObject(o)){
				return false;
			}
			if(((SpaceObject)o).getWorld() != this){
				return false;
			}
		}
		return true;
	}

	/*_________________________________________Destruction__________________________________________*/

	/**
	 * Terminate this world.
	 * @post 	This world is terminated.
	 * 			| this.isTerminated()
	 * @post 	No SpaceObjects are attached any longer to this world.
	 * 			| this.visibleObjects.size == 0
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
		this.upcomingCollisions.clear();
		for(SpaceObject o : visibleObjects()){
			o.terminate();
		}
		this.boundaryWalls.clear();
		isTerminated = true;
	}

	/**
	 * Check whether this world is terminated.
	 */
	@Basic @Raw
	public boolean isTerminated() {
		return isTerminated;
	}

	private boolean isTerminated;




}
