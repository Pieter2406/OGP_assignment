package asteroids.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asteroids.Util;
import asteroids.studentdefined.Velocity;

/**
 * Test case for testing the Velocity class.
 * @author Kristof Bruyninckx
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 * @version 1.1
 *
 */
//TODO: Complete VelocityTest
public class VelocityTest {

	private double velocityX;
	private double velocityY;
	private double maxVelocity;
	private Velocity legalVelocity1, legalVelocity2, legalVelocity3;
	private Velocity illegalVelocity1, illegalVelocity2;
	public static final double SPEED_OF_LIGHT = 299792.458;
	@Before
	public void setUpMutableFixture(){
		// X = 100, Y = 200, Max = 300
		legalVelocity1 = new Velocity(100,200,300);
		// X = 300, Y = 400, Max = SPEED_OF_LIGHT
		legalVelocity2 = new Velocity(300,400,SPEED_OF_LIGHT );
		// X = 300, Y = 400, Max = 400
		legalVelocity3 = new Velocity(300,400,400);
		// X = 100, Y = 100, Max = SPEED_OF_LIGHT + 1
		illegalVelocity1 = new Velocity(100,100,SPEED_OF_LIGHT + 1);
		// X = 300000, Y = 400000, Max = SPEED_OF_LIGHT
		illegalVelocity2 = new Velocity(300000,400000,SPEED_OF_LIGHT);
	}
	
	@Test
	public final void extendedConstructor_LegalCase() {
		velocityX = 100;
		velocityY = 200;
		maxVelocity = SPEED_OF_LIGHT;
		Velocity newVelocity = new Velocity(velocityX, velocityY, maxVelocity);
		assertEquals(100,newVelocity.getVelocityX(),Util.EPSILON);
		assertEquals(200, newVelocity.getVelocityY(), Util.EPSILON);
		assertEquals(SPEED_OF_LIGHT, newVelocity.getMaxVelocity(),Util.EPSILON);
	}
	@Test
	public final void extendedConstructor_IllegalCase(){
		velocityX = 100;
		velocityY = 200;
		maxVelocity = SPEED_OF_LIGHT;
	}

	@Test
	public final void getVelocityX_RegularCase() {
		assertEquals("Regular getter for velocityX", 100, legalVelocity1.getVelocityX(),Util.EPSILON);
	}

	@Test
	public final void getVelocityY_RegularCase() {
		assertEquals("Regular getter for velocityY", 200, legalVelocity1.getVelocityY(),Util.EPSILON);
	}

	@Test
	public final void getMaxVelocity_RegularCase() {
		assertEquals("Regular getter for the maxVelocity", 300, legalVelocity1.getMaxVelocity(),Util.EPSILON);
	}

	@Test
	public final void computeVelocity_LegalCase() {
		assertEquals("Legal case test for computing the velocity", 500,Velocity.computeVelocity(legalVelocity2.getVelocityX(), legalVelocity2.getVelocityY()),Util.EPSILON);
	}
	
	public final void computeVelocity_IllegalCase() {
		assertEquals("Illegal case test for computing the velocity", 0,Velocity.computeVelocity(100,Double.NaN),Util.EPSILON);
	}
	
}
