package asteroids.studentdefined;

import static org.junit.Assert.*;

import org.junit.Before;
import asteroids.Util;
import org.junit.*;

/**
 * Test case for testing the SpaceObject class.
 * @author Pieter Verlinden
 * @author Wouter Bruyninckx
 * @author Kristof Bruyninckx
 * @version 1.1
 */
public class SpaceObjectTest {

	double radius = 100;
	double leftangle = 0;
	double rightangle = Math.PI;
	World world;
	Ship leftShip, rightShip, separatedShip;
	Asteroid leftAsteroid, rightAsteroid;
	Bullet leftBullet, rightBullet;
	
	@Before
	public void setupMutableFixture() {
		world = new World(1000, 1000);
		leftShip = new Ship(100, 100, 100, 0,  radius, leftangle, 100, world);
		rightShip = new Ship(400, 100, -100, 0, radius, rightangle, 100, world);
		separatedShip = new Ship(700, 700, 300, 300, radius, rightangle, 100, world);
		leftAsteroid = new Asteroid(100, 100, 100, 0, radius, world);
		rightAsteroid = new Asteroid(400, 100, -100, 0, radius, world);
		leftBullet = new Bullet( 47, 100, leftShip, world);
		rightBullet = new Bullet(553, 100, rightShip, world);
		
	}
	
	@Test
	public void getCollisiontime_twoships_regular() {
		assertEquals("Regular collision time left-right ship-ship", 0.5, leftShip.getTimeToCollision(rightShip), Util.EPSILON);
	}
	
	@Test
	public void getCollisiontime_twoships_infinite() {
		assertEquals("No collision", Double.POSITIVE_INFINITY, leftShip.getTimeToCollision(separatedShip), Util.EPSILON);
	}
	
	@Test
	public void getCollisiontime_ship_bullet_regular() {
		assertEquals("Regular collision time ship-bullet left-right", 1, rightBullet.getTimeToCollision(leftShip), Util.EPSILON);
	}
	
	@Test
	public void getCollisiontime_twoasteroids_regular() {
		assertEquals("Regular collision time left-right asteroid-asteroid", 0.5, leftAsteroid.getTimeToCollision(rightAsteroid), Util.EPSILON);
	}
	
	@Test
	public void getCollisiontime_self() {
		assertEquals("Collision with self", Double.POSITIVE_INFINITY, leftAsteroid.getTimeToCollision(leftAsteroid), Util.EPSILON);
	}
	
	@Test
	public void getCollisiontime_equivalenceTest() {
		double a = leftAsteroid.getTimeToCollision(rightAsteroid);
		double b = rightAsteroid.getTimeToCollision(leftAsteroid);
		assertEquals("Equivalence test swap prime object", a, b, Util.EPSILON);
	}
	
	@Test
	public void getCollisionPosition_twoships_regular() {
		Coordinate position = leftShip.getCollisionPosition(rightShip);
		assertEquals("Position ship-ship X", 250, position.getX(), Util.EPSILON);
		assertEquals("Position ship-ship Y", 100, position.getY(), Util.EPSILON);
	}
	
	@Test
	public void getCollisionPosition_shipbullet_regular() {
		Coordinate position = leftAsteroid.getCollisionPosition(rightBullet);
		assertEquals("Position ship-bullet X", 300, position.getX(), Util.EPSILON);
		assertEquals("Position ship-bullet Y", 100, position.getY(), Util.EPSILON);
	}
	
	@Test
	public void getCollisionPosition_twoasteroids_regular() {
		Coordinate position = leftAsteroid.getCollisionPosition(rightAsteroid);
		assertEquals("Position ship-ship X", 250, position.getX(), Util.EPSILON);
		assertEquals("Position ship-ship Y", 100, position.getY(), Util.EPSILON);
	}
	
	@Test
	public void getCollisionPosition_infinite() {
		Coordinate position = leftAsteroid.getCollisionPosition(separatedShip);
		assertNull("Position never collide", position);
	}

}
