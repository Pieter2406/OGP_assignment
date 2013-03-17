/*
 * Black-box test case for the class ship using the principles of equivalence testing.
 */

package asteroids.studentdefined;
import static org.junit.Assert.*;

import org.junit.*;


import asteroids.Util;

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
	 * Variable referencing a ship
	 */
	private static Ship basicShip;
	
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
		basicShip = new Ship(0,0,20,20,10,Math.PI);
	}
	/**
	 * Set up immutable test fixture
	 * 
	 * @post 	The variable basicShip references a new ship on position (0,0) with a radius of 20,
	 * 			a minimum radius of 10 and and angle of PI.
	 */
	@BeforeClass // set up immutable test fixture
	public static void setUpImmutableFixture(){
		immutableShip = new Ship(20,15,10,10,10,0);
	}
	@Test
	public void thrust_PositiveInput() {
		basicShip.thrust(20);
		assertEquals(20, basicShip.getVelocity().computeVelocity(),Util.EPSILON);
	}

	@Test
	public void thrust_NegativeInput() {
		double oldSpeed = basicShip.getVelocity().computeVelocity();
		basicShip.thrust(-10);
		assertEquals(oldSpeed, basicShip.getVelocity().computeVelocity(),Util.EPSILON);
	}
	
	@Test
	public void thrust_ExceedSpeedOfLight() {
		basicShip.thrust(300001);
		assertEquals(Velocity.SPEED_OF_LIGHT,basicShip.getVelocity().computeVelocity(),Util.EPSILON);
	}
	
	@Test
	public void move_PositiveTime() {
		basicShip.move(10);
		//assertEquals();
	}
	
	@Test
	public void move_NegativeTime() {
	}
		


}
