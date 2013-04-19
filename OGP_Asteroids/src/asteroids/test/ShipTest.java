/*
 * Black-box test case for the class ship using the principles of equivalence testing.
 */

package asteroids.test;
import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Set;

import org.junit.*;


import asteroids.Util;
import asteroids.studentdefined.Bullet;
import asteroids.studentdefined.Coordinate;
import asteroids.studentdefined.IllegalValueException;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.Thruster;
import asteroids.studentdefined.Velocity;
import asteroids.studentdefined.Wall;
import asteroids.studentdefined.World;

/**
 * A class collecting tests for the class of ships.
 * 
 * @version 1.0
 * @author Kristof Bruyninckx
 * @author Pierter Verlinden
 *
 */

public class ShipTest {
	/**
	 * Variable referencing a world.
	 */
	private static World world;
	/**
	 * Variables referencing a ship.
	 */
	private static Ship ship_Origin_1Vel;
	private static Ship ship_VertCol;
	private static Ship ship_HorCol;
	private static Ship ship_HorCol_Slowdown;
	
	/**
	 * Set up mutable test fixture
	 * 
	 * @post 	The variable ship_Origin_1Vel references a new ship on position (0,0) with a radius of 15,
	 * 			an angle of 0, a mass of 10 and does not belong to a world.
	 */
	@Before 
	public void setUpMutableFixture(){
		world = new World(100, 100);
		ship_Origin_1Vel = new Ship(0,0,1,1,15,0, 10, null);
		ship_VertCol = new Ship(86,50,1,0,10,0, 1, null);
		ship_HorCol = new Ship(50,86,0,1,10,Math.PI/2, 1, null);
		ship_HorCol_Slowdown = new Ship(50,16,0,-4,10,Math.PI/2, 1, null);
		world.addShip(ship_Origin_1Vel);
		world.addShip(ship_VertCol);
		world.addShip(ship_HorCol);
		world.addShip(ship_HorCol_Slowdown);
	}

	@Test
	public void setAngle_NoModulus(){
		ship_Origin_1Vel.turn(1.0);
		assertEquals(1.0,ship_Origin_1Vel.getAngle(),Util.EPSILON);
	}
	
	@Test
	public void setAngle_Modulus(){
		ship_Origin_1Vel.turn(4*Math.PI);
		assertEquals(0,ship_Origin_1Vel.getAngle(),Util.EPSILON);
	}
	
	@Test
	public void turn_LegalInput(){
		ship_Origin_1Vel.turn(1.0);
		assertEquals(1.0,ship_Origin_1Vel.getAngle(),Util.EPSILON);
	}
	
	@Test
	public void move_NoAccel_PositiveTime() {
		ship_Origin_1Vel.move(10.0);
		assertEquals(10.0,ship_Origin_1Vel.getPosition().getX(),Util.EPSILON);
		assertEquals(10.0,ship_Origin_1Vel.getPosition().getY(),Util.EPSILON);
	}
	
	@Test
	public void move_Accel_PositiveTime() {
		ship_Origin_1Vel.enableThruster();
		ship_Origin_1Vel.move(10.0);
		double accel = ship_Origin_1Vel.getThruster().getForce()/10;
		double expected = 10 + accel*100/2; // x = x0 + vt +at^2/2
		assertEquals(expected,ship_Origin_1Vel.getPosition().getX(),Util.EPSILON);
		assertEquals(10,ship_Origin_1Vel.getPosition().getY(),Util.EPSILON);
	}
	
	@Test (expected = IllegalValueException.class) // if this exception is thrown the test succeeds
	public void move_NegativeTime() throws IllegalValueException{
		ship_Origin_1Vel.move(-10.0);
	}
	
	@Test
	public void enableThruster(){
		ship_Origin_1Vel.enableThruster();
		assertTrue(ship_Origin_1Vel.getThruster().isEnabled());
	}
	
	@Test
	public void disableThruster(){
		ship_Origin_1Vel.disableThruster();
		assertTrue(!ship_Origin_1Vel.getThruster().isEnabled());
	}
	
	@Test
	public void fireBullet_SingleShot(){
		ship_Origin_1Vel.fireBullet();
		Set<Bullet> bullets = (Set<Bullet>) world.getAllBullets();
		for (Bullet bullet : bullets){
		    assertEquals(15,bullet.getPosition().getX(),Util.EPSILON);
		    assertEquals(0,bullet.getPosition().getY(),Util.EPSILON);
		    assertEquals(ship_Origin_1Vel.getAngle(),bullet.getAngle(),Util.EPSILON);
		}
	}
	
	@Test
	public void fireBullet_TripleShot(){
		ship_Origin_1Vel.fireBullet();
		Set<Bullet> bullets = (Set<Bullet>) world.getAllBullets();
		for (Bullet bullet : bullets){
		    assertEquals(15,bullet.getPosition().getX(),Util.EPSILON);
		    assertEquals(0,bullet.getPosition().getY(),Util.EPSILON);
		    assertTrue(Util.fuzzyEquals(bullet.getAngle() - ship_Origin_1Vel.getAngle(), 0) || Util.fuzzyEquals(bullet.getAngle() - ship_Origin_1Vel.getAngle() + Ship.TRIPLE_ANGLE_OFFSET, 0) 
		    		|| Util.fuzzyEquals(bullet.getAngle() - ship_Origin_1Vel.getAngle() - Ship.TRIPLE_ANGLE_OFFSET, 0));
		    
		}
	}
	
	@Test 
	public void setBulletSpeedMultiplier_ValidArgument(){
		ship_Origin_1Vel.setBulletSpeedMultiplier(2);
		assertEquals(2,ship_Origin_1Vel.getBulletSpeedMultiplier(),Util.EPSILON);
	}
	
	@Test 
	public void setBulletSpeedMultiplier_InValidArgument(){
		ship_Origin_1Vel.setBulletSpeedMultiplier(-1);
		assertEquals(1,ship_Origin_1Vel.getBulletSpeedMultiplier(),Util.EPSILON);
	}
	
	@Test 
	public void setBulletScaleMultiplier_ValidArgument(){
		ship_Origin_1Vel.setBulletSpeedMultiplier(2);
		assertEquals(2,ship_Origin_1Vel.getBulletSpeedMultiplier(),Util.EPSILON);
	}
	
	@Test (expected = IllegalValueException.class)
	public void setBulletScaleMultiplier_InValidArgument() throws IllegalValueException{
		ship_Origin_1Vel.setBulletScaleMultiplier(-1);
	}
	
	@Test
	public void toggleTriShotBullets(){
		ship_Origin_1Vel.toggleTriShotBullets(true);
		assertTrue(ship_Origin_1Vel.isTriShotBulletsActivated());
	}
	
	@Test
	public void incShield_LegalInput(){
		ship_Origin_1Vel.incShield();
		assertEquals(1,ship_Origin_1Vel.getShield());
	}
	
	@Test
	public void incShield_HigherThenMax(){
		while(ship_Origin_1Vel.getShield() < Ship.MAX_SHIELDS)
			ship_Origin_1Vel.incShield(); // increase shields one more then maximum allowed.
		ship_Origin_1Vel.incShield();
		assertEquals(Ship.MAX_SHIELDS,ship_Origin_1Vel.getShield());
	}
	
	@Test
	public void decShield_NegativeResult(){
		ship_Origin_1Vel.decShield(); // minimum value is zero.
		assertEquals(0,ship_Origin_1Vel.getShield());
	}
	
// note: the tests for a disabled thruster belong into a SpaceObject testcase	

	@Test
	public void getTimeToCollision_Vertical_Collision(){
		Wall rightwall = new Wall(new Coordinate(100,100), "vertical");
		ship_VertCol.setThruster(new Thruster(ship_VertCol, 1));
		ship_VertCol.enableThruster();
		assertEquals(2,ship_VertCol.getTimeToCollision(rightwall),Util.EPSILON);
	}
	
	@Test
	public void getTimeToCollision_Vertical_Infinite(){
		Wall leftwall = new Wall(new Coordinate(0,0), "vertical");
		ship_VertCol.enableThruster();
		assertEquals(Double.POSITIVE_INFINITY,ship_VertCol.getTimeToCollision(leftwall),Util.EPSILON);
	}
	
	@Test
	public void getTimeToCollision_Horizontal_Collision(){
		Wall topwall = new Wall(new Coordinate(100,100), "horizontal");
		ship_HorCol.setThruster(new Thruster(ship_HorCol, 1));
		ship_HorCol.enableThruster();
		assertEquals(2,ship_HorCol.getTimeToCollision(topwall),Util.EPSILON);
	}
	
	@Test
	public void getTimeToCollision_Horizontal_infinite(){
		Wall bottomwall = new Wall(new Coordinate(0,0), "horizontal");
		ship_HorCol.enableThruster();
		assertEquals(Double.POSITIVE_INFINITY,ship_HorCol.getTimeToCollision(bottomwall),Util.EPSILON);
	}
	@Test
	public void getTimeToCollision_Horizontal_SlowdownCol(){
		Wall bottomwall = new Wall(new Coordinate(0,0), "horizontal");
		ship_HorCol_Slowdown.setThruster(new Thruster(ship_HorCol_Slowdown, 1));
		ship_HorCol_Slowdown.enableThruster();
		assertEquals(2,ship_HorCol_Slowdown.getTimeToCollision(bottomwall),Util.EPSILON);
	}
}