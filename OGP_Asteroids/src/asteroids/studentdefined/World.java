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
		boundaryWalls.add(new Wall(new Coordinate(0,0), "vertical"));
		boundaryWalls.add(new Wall(new Coordinate(0,0), "horizontal"));
		boundaryWalls.add(new Wall(new Coordinate(width, height), "vertical"));
		boundaryWalls.add(new Wall(new Coordinate(width, height), "horizontal"));

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
		//		
		//		if(newCollision == null){
		//			advanceAll(time);
		//		}else{
		//			if(newCollision.getObj1().overlap(newCollision.getObj2())){
		//				handleCollision(newCollision,collisionListener);
		//				advanceAll(time);
		//			}else{
		//				advanceAll(time);
		//			}
		//		}
		/*
		 * Misschien is dit een gemakkelijkere oplossing ge moet ma zien.
		 * 
		 */
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
	 * @param newCollision
	 */
	private void handleCollision(Collision newCollision,CollisionListener collisionListener) {
		if (!(CollisionFactory.collide(newCollision.getObj1(), newCollision.getObj2()) instanceof asteroids.collisions.NoCollision)){
			double xPos,yPos;
			if (newCollision.getObj2() instanceof SpaceObject){
				xPos = newCollision.getObj1().getCollisionPosition((SpaceObject) newCollision.getObj2()).getX();
				yPos = newCollision.getObj1().getCollisionPosition((SpaceObject) newCollision.getObj2()).getY();
			}
			else { // collision with wall.
				xPos = newCollision.getObj1().getCollisionPosition((Wall) newCollision.getObj2()).getX();
				yPos = newCollision.getObj1().getCollisionPosition((Wall) newCollision.getObj2()).getY();
			}

			newCollision.collide();
			collisionListener.objectCollision(newCollision.getObj1(), newCollision.getObj2(), xPos,yPos); // in factory?
		}
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
			//throw new IllegalArgumentException("Time is not effective"); // wie zet dit in commentaar en waarom?
			time = 0;
		for (SpaceObject obj : visibleObjects)
			obj.move(time);
	}

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
	 * Holds the (4) walls that form the boundary of the game room.
	 */
	private Collection<Wall> boundaryWalls = new ArrayList<Wall>();


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
		this.visibleObjects.add(spaceObject);
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
		this.visibleObjects.remove(spaceObject);
		spaceObject.setWorld(null);
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
	public Collection<PowerUp> getPowerUps(){
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

	private boolean isTerminated;

	private static final double POWERUP_CHANCE = 2;

}
