/**
 * 
 */
package asteroids.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import asteroids.Util;
import asteroids.studentdefined.*;

/**
 * Test case for World class.
 * @author Kristof Bruyninckx
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 * @version 1.1
 * */

public class WorldTest {
	static World testworld;
	static Ship testship;
	@Before
	public void setUpMutableFixture(){
		testworld = new World(1000,1000);
		testship = new Ship(90, 100, 10, 0, 10, 0, 10, testworld);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addSpaceObject_IllegalCase() throws IllegalArgumentException{
		testworld.addSpaceObject(null);
	}
	
	@Test
	public void add_RemoveSpaceObject_LegalCase(){
		testworld.addSpaceObject(testship);
		assertTrue(testworld.getAllSpaceObjects().contains(testship));
		testworld.removeSpaceObject(testship);
		assertFalse(testworld.getAllSpaceObjects().contains(testship));
	}
		
	@Test(expected = IllegalValueException.class)
	public void evolve_NegativeTime(){
		testworld.evolve(-1, null);
	}
	
	@Test
	public void evolve_PositiveTime(){
		Ship shiptest = new Ship(100,400,50, 0, 0, 0, 0, testworld);
		Program program = new Program();
		Bullet bullettest = new Bullet(200, 400, shiptest, testworld, 1, 1, 0);
		Asteroid asteroidtest = new Asteroid(450, 400, 0, 0, 29, null);
		testworld.addShip(shiptest);
		testworld.addAsteroid(asteroidtest);
		testworld.addBullet(bullettest);
		testworld.evolve(2,null);
		assertTrue(shiptest.getProgram().getLastRunTime() > 0);
		assertEquals(200,shiptest.getPosition().getX(),Util.EPSILON);
		assertEquals(400,shiptest.getPosition().getY(),Util.EPSILON);
		testworld.evolve(2, null);
		assertEquals(0,testworld.getAllAsteroids().size());
		assertEquals(0,testworld.getAllBullets().size());
		assertTrue(testworld.getAllShips().contains(shiptest));
		
	}
	
	@Test
	public void containsSpaceObject_LegalCase(){
		Ship shiptest = new Ship(100,400,50, 0, 0, 0, 0, null);
		testworld.addSpaceObject(shiptest);
		assertTrue(testworld.containsSpaceObject(shiptest));
	}
	@Test
	public void containsSpaceObject_IllegalCase(){
		assertFalse(testworld.containsSpaceObject(null));
	}
	
}
