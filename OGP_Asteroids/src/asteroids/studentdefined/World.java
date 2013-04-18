package asteroids.studentdefined;

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
import be.kuleuven.cs.som.annotate.Raw;
import edu.princeton.cs.algs4.MinPQ;
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
	 * Returns 	True if the given SpaceObject is a member of the data structure that contains all SpaceObjects in this world.
	 * @param 	spaceObject 
	 * 			The space object to be checked.
	 * @return	| return == visibleObjects.contains(spaceObject)
	 */
	public boolean containsSpaceObject(SpaceObject spaceObject) {
		return visibleObjects.contains(spaceObject);
	}

	/**
	 * Add the given SpaceObject to this world.
	 * @post 	This world contains the given SpaceObject.
	 * 			| this.containsSpaceObject(spaceObject)
	 * @post 	The given SpaceObject references this world as its associated world.
	 * 			| spaceObject.getWorld() == this
	 * @param 	spaceObject
	 * 		The space object to be added to this world.
	 * @throws	IllegalArgumentException
	 * 		This world cannot have the given space object as one of 
	 * 		its visible objects.
	 * 		| !canHaveAsVisibleObject(spaceObject)
	 * @throws	IllegalArgumentException
	 * 		The given space object is already attached to some world.
	 * 		| spaceObject.getWorld() != this
	 */
	public void addSpaceObject(SpaceObject spaceObject) throws IllegalArgumentException {
		if(!canHaveAsVisibleObject(spaceObject)){
			throw new IllegalArgumentException("This world cannot contain the given object");
		}
		if(spaceObject.getWorld() != this && spaceObject.getWorld() != null){
			throw new IllegalArgumentException("The given space object already exists in another world.");
		}
		this.visibleObjects.add(spaceObject);
		spaceObject.setWorld(this);
	}

	/**
	 * Remove the given SpaceObject from this world.
	 * @post 	This world no longer contains the given SpaceObject.
	 * 			| !this.containsSpaceObject(spaceObject)
	 * @post 	The given SpaceObject is no longer associated with an effective world.
	 * 			| spaceObject.getWorld() == null
	 * @param 	spaceObject
	 * 		The space object to be removed from this world.
	 */
	public void removeSpaceObject(SpaceObject spaceObject) { 
		this.visibleObjects.remove(spaceObject);
		spaceObject.setWorld(null);
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
		for(Object o : visibleObjects){
			if(!canHaveAsVisibleObject(o)){
				return false;
			}
			if(((SpaceObject)o).getWorld() != this){
				return false;
			}
		}
		return true;
	}

	/*_________________________________________Advance step methods__________________________________________*/

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
			double firstCollisionTime = newCollision.getTime();
			if(firstCollisionTime > time){
				advanceAll(time);
				if(rndBoolean(POWERUP_CHANCE * time)){
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
	 * TODO: Write contract for handleCollision in World
	 * @param	newCollision	
	 * 			The collision to be handled.
	 * @param 	collisionListener
	 * 			The handler responsible for drawing visual effects of this collision.
	 */
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
			if (boundarycollision)
				collisionListener.boundaryCollision(newCollision.getObj1(), xPos,yPos);
			else
				collisionListener.objectCollision(newCollision.getObj1(), newCollision.getObj2(), xPos,yPos);
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
	private void advanceAll(double time) {
		if (time < 0)
			//throw new IllegalArgumentException("Time is not effective");
			time = 0;
		for (SpaceObject obj : visibleObjects)
			obj.move(time);
	}

	/*_________________________________________Powerup generating__________________________________________*/

	/**
	 * TODO: Write generateRandomePowerup contract
	 * @return
	 */
	private PowerUp generateRandomPowerup(){
		final double RADIUS = 30;
		Random rnd = new Random();
		double rndX = rnd.nextInt((int) (getWidth() - 2 * RADIUS)) + RADIUS;
		double rndY = rnd.nextInt((int) (getHeight() - 2 * RADIUS)) + RADIUS;
		switch(rnd.nextInt(6)){			
		case 0: return new SmallerShipPowerUp(rndX,rndY,RADIUS, 0,this);
		case 1: return new IncreaseBulletSpeedPowerUp(rndX,rndY,RADIUS, 0,this);
		case 2: return new BiggerBulletSizePowerUp(rndX,rndY,RADIUS,0,this);
		case 3: return new TriShotBulletsPowerUp(rndX, rndY, RADIUS,0,this);
		case 4: return new ShipShieldPowerUp(rndX,rndY,RADIUS,0,this);
		case 5: return new RadiusAsteroidPushPowerUp(rndX,rndY,RADIUS,0,this);
		default: return null;
		}
	}

	/**
	 * TODO: Write rndBoolean contract.
	 */
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
		ArrayList<SpaceObject> temp = new ArrayList<SpaceObject>(); //Temp storage for objects with a pending velocity change.
		ArrayList<Collision> tempcol = new ArrayList<Collision>(); //Temp storage for collisions to be removed after iterating.

		for (SpaceObject obj : visibleObjects) {
			if (obj.hasPendingVelocityChange())
				temp.add(obj);
		}
		for (Collision col: upcomingCollisions) {
			// Remove collision involving objects that are already terminated.
			if (col.getObj2() instanceof SpaceObject){
				if (col.getObj1().isTerminated() || ((SpaceObject)col.getObj2()).isTerminated()){
					tempcol.add(col);
				}
			}
			else
				if (col.getObj1().isTerminated()){
					tempcol.add(col);
				}
			//Recalculate all collisions that involve an object with a pending velocity change and set the flag to false.
			for (SpaceObject ob : temp) {
				if (col.contains(ob)) { // make sure collisions are not added twice.
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
	private Collection<SpaceObject> visibleObjects = new ArrayList<SpaceObject>();

	/**
	 * Holds the (4) walls that form the boundary of the game room.
	 */
	private Collection<Wall> boundaryWalls = new ArrayList<Wall>();




	/*_________________________________________Associated Object inspectors__________________________________________*/

	/**
	 * Return all space objects associated with this world.
	 * @return 	A collection of all space objects that are currently associated with this world.
	 */
	public Collection<SpaceObject> getAllSpaceObjects() {
		Set<SpaceObject> setOfSpaceObjects = new HashSet<SpaceObject>();
		setOfSpaceObjects.addAll(visibleObjects);
		return setOfSpaceObjects;
	}

	/**
	 * Returns all bullets associated with this world.
	 * @return 	A collection of all bullets that are currently associated with this world.
	 */
	public Collection<Bullet> getAllBullets() {
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
	 * @return 	A collection of all ships that are currently associated with this world.
	 */
	public Collection<Ship> getAllShips() {
		Set<Ship> setOfShips = new HashSet<Ship>();
		for(SpaceObject shp : visibleObjects){
			if(shp instanceof Ship){
				setOfShips.add((Ship) shp);
			}
		}
		return setOfShips;
	}
	/**
	 * Returns all powerups associated with this world.
	 * @return	A collection of all powerups that are currently associated with this world.
	 */
	public Collection<PowerUp> getAllPowerUps(){
		Set<PowerUp> setOfPowerUps = new HashSet<PowerUp>();
		for(SpaceObject pwrUp : visibleObjects){
			if(pwrUp instanceof PowerUp){
				setOfPowerUps.add((PowerUp)pwrUp);
			}
		}
		return setOfPowerUps;
	}

	/**
	 * Returns all asteroids associated with this world.
	 * @return 	A collection of all asteroids that are currently associated with this world.
	 * 
	 */
	public Collection<Asteroid> getAllAsteroids() {
		Set<Asteroid> setOfAsteroids = new HashSet<Asteroid>();
		for(SpaceObject ast : visibleObjects){
			if(ast instanceof Asteroid){
				setOfAsteroids.add((Asteroid) ast);
			}
		}
		return setOfAsteroids;
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
		for(SpaceObject o : visibleObjects){
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
