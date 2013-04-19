package asteroids.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asteroids.Util;
import asteroids.studentdefined.Asteroid;
import asteroids.studentdefined.Bullet;
import asteroids.studentdefined.Coordinate;
import asteroids.studentdefined.IllegalValueException;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.World;

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
	Ship leftShip, rightShip, separatedShip, basicShip, basicShip2, basicShip3, basicShip4;
	Asteroid leftAsteroid, rightAsteroid;
	Bullet leftBullet, rightBullet;
	
	@Before
	public void setupMutableFixture() {
		world = new World(1000, 1000);
		leftShip = new Ship(100, 100, 100, 0,  radius, leftangle, 100, world);
		rightShip = new Ship(400, 100, -100, 0, radius, rightangle, 100, world);
		basicShip = new Ship(0,0,1,1,radius,leftangle,100,world);
		basicShip2 = new Ship(40,40,1,1,15,Math.PI/2, 100, world); 
		basicShip3 = new Ship(40,0,1,0,10,0, 100, world);
		basicShip4 = new Ship(0,0,1,0,10,Math.PI,100, world);
		separatedShip = new Ship(700, 700, 300, 300, radius, rightangle, 100, world);
		leftAsteroid = new Asteroid(100, 100, 100, 0, radius, world);
		rightAsteroid = new Asteroid(400, 100, -100, 0, radius, world);
		leftBullet = new Bullet(47, 100, leftShip, world, 1, 1, leftShip.getAngle());
		rightBullet = new Bullet(553, 100, rightShip, world,1,1,rightShip.getAngle());
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
	
	@Test
	public void move_PositiveTime() {
		basicShip.move(10.0);
		assertEquals(10.0,basicShip.getPosition().getX(),Util.EPSILON);
		assertEquals(10.0,basicShip.getPosition().getY(),Util.EPSILON);
	}
	
	@Test (expected = IllegalValueException.class) // if this exception is thrown the test succeeds
	public void move_NegativeTime() throws Exception{
		basicShip.move(-10.0);
	}
	
	@Test 
	public void isValidAngle_LegalInput() {
		assertTrue(Ship.isValidAngle(2.0));
	}
	
	@Test 
	public void isValidAngle_IllegalInput() {
		assertFalse(Ship.isValidAngle(Double.NaN));
	}
	
	@Test 
	public void setAngle_LegalInput() {
		basicShip.setAngle(Math.PI/2.0);
		assertEquals(Math.PI/2,basicShip.getAngle(),Util.EPSILON);
	}

	@Test
	public void isValidMinimumRadius_PositiveRadius(){
		assertTrue(Ship.isValidMinimumRadius(10));
	}
	
	@Test
	public void isValidMinimumRadius_NegativeRadius(){
		assertFalse(Ship.isValidMinimumRadius(-10));
	}
	
	@Test
	public void isValidMinimumRadius_IllegalInput(){
		assertFalse(Ship.isValidMinimumRadius(Double.NaN));
	}
	
	@Test
	public void isValidRadius_IllegalInput(){
		assertFalse(basicShip.isValidRadius(Double.NaN));
	}
	
	@Test
	public void isValidRadius_smallerThenMinimum(){
		assertFalse(basicShip.isValidRadius(9)); // minimumradius -1
	}
	
	@Test
	public void isValidRadius_higherThenMinimum(){
		assertTrue(basicShip.isValidRadius(20));
	}
	
	@Test 
	public void setPosition_LegalInput(){
		basicShip.setPosition(10.0, 10.0);
		assertEquals(10.0, basicShip.getPosition().getX(),Util.EPSILON);
		assertEquals(10.0, basicShip.getPosition().getY(),Util.EPSILON);
	}
	@Test (expected = IllegalValueException.class) 
	public void setPosition_IllegalLeftArgument(){
		basicShip.setPosition(Double.NaN, 10);
	}
	
	@Test (expected = IllegalValueException.class) 
	public void setPosition_IllegalRightArgument(){
		basicShip.setPosition(Double.NaN, 10);
	}
	
	@Test
	public void getDistanceBetween_legalInput(){
		assertEquals(100,leftShip.getDistanceBetween(rightShip),Util.EPSILON);
	}
	
	@Test (expected = IllegalArgumentException.class) 
	public void getDistanceBetween_IllegalInput(){
		basicShip.getDistanceBetween(null);
	}
	
	@Test (expected = IllegalArgumentException.class) 
	public void overlap_IllegalArgument(){
		basicShip.overlap(null);
	}
	
	@Test 
	public void overlap_Overlapping(){
		assertTrue(basicShip.overlap(basicShip3));
	}
	
	@Test 
	public void overlap_NotOverlapping(){
		assertFalse(rightShip.overlap(basicShip4));
	}
	
	
}
