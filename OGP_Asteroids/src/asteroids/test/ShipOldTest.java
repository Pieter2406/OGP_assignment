/*
 * Black-box test case for the class ship using the principles of equivalence testing.
 */

package asteroids.test;
import static org.junit.Assert.*;

import org.junit.*;


import asteroids.Util;
import asteroids.studentdefined.IllegalValueException;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Velocity;

/**
 * A class collecting tests for the class of ships.
 * 
 * @version 1.0
 * @author Kristof Bruyninckx
 * @author Pierter Verlinden
 *
 */

public class ShipOldTest {
	
	/**
	 * Variable referencing a ship
	 */
	private static Ship basicShip;
	private static Ship basicShip2;
	private static Ship basicShip3;
	private static Ship basicShip4;
	
	/**
	 * Variable referencing an immutable ship
	 */
	private static Ship immutableShip;
	
	/**
	 * Set up mutable test fixture
	 * 
	 * @post 	The variable basicShip references a new ship on position (0,0) with a radius of 20,
	 * 			a minimum radius of 10 and and angle of PI.
	 */
	@Before 
	public void setUpMutableFixture(){
		basicShip = new Ship(0,0,1,1,15,0);
		basicShip2 = new Ship(40,40,1,1,15,Math.PI/2); 
		basicShip3 = new Ship(40,0,1,0,10,0);
		basicShip4 = new Ship(0,0,1,0,10,Math.PI); 
	}
	@Test
	public final void extendedConstructor_LegalCase() throws Exception{
		Ship newShip = new Ship(1,2,3,4,10,6);
		assertEquals(1,newShip.getPosition().getX(),Util.EPSILON);
		assertEquals(2,newShip.getPosition().getY(),Util.EPSILON);
		assertEquals(3,newShip.getVelocity().getVelocityX(),Util.EPSILON);
		assertEquals(4,newShip.getVelocity().getVelocityY(),Util.EPSILON);
		assertEquals(10,newShip.getRadius(),Util.EPSILON);
		assertEquals(6,newShip.getAngle(),Util.EPSILON);

	}
	
	@Test
	public void thrust_PositiveInput() {
		basicShip.thrust(20.0);
		assertEquals(20.0, basicShip.getVelocity().computeVelocity(),Util.EPSILON);
	}

	@Test
	public void thrust_NegativeInput() {
		double oldSpeed = basicShip.getVelocity().computeVelocity();
		basicShip.thrust(-10.0);
		assertEquals(oldSpeed, basicShip.getVelocity().computeVelocity(),Util.EPSILON);
	}
	
	@Test
	public void thrust_ExceedSpeedOfLight() {
		basicShip.thrust(300001.0);
		assertEquals(Velocity.SPEED_OF_LIGHT,basicShip.getVelocity().computeVelocity(),Util.EPSILON);
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
	public void turn_LegalInput(){
		basicShip.turn(1.0);
		assertEquals(1.0,basicShip.getRadius(),Util.EPSILON);
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
		basicShip.setAngle(10.0);
		assertEquals(10.0,basicShip.getAngle(),Util.EPSILON);
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
		assertEquals(26.568542,basicShip.getDistanceBetween(basicShip2),Util.EPSILON);
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
		assertFalse(basicShip.overlap(basicShip2));
	}
	
	@Test (expected = IllegalArgumentException.class) 
	public void getTimeToCollision_IllegalArgument(){
		basicShip.getTimeToCollision(null);
	}
	
	@Test 
	public void getTimeToCollision_NotColliding(){
		assertEquals(Double.POSITIVE_INFINITY,basicShip.getTimeToCollision(basicShip2), Util.EPSILON);
	}
	
	@Test 
	public void getTimeToCollision_Colliding(){
		;
		assertEquals(20.0,basicShip3.getTimeToCollision(basicShip4),Util.EPSILON);
	}
	@Test
	public void getCollisionPosition_Colliding(){
		assertEquals(20.0,basicShip3.getCollisionPosition(basicShip4).getX(),Util.EPSILON);
	}
	@Test (expected = IllegalArgumentException.class)
	public void getCollisionPosition_IllegalArgument(){
		basicShip.getCollisionPosition(null);
	}
	@Test
	public void getCollisionPosition_NotColiding(){
		assertEquals(Double.POSITIVE_INFINITY,basicShip.getCollisionPosition(basicShip2).getX(),Util.EPSILON);
	}
	
}
