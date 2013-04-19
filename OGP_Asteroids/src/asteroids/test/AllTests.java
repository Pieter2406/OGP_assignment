/**
 * 
 */
package asteroids.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Kristof Bruynincks
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 */
@RunWith(Suite.class)
@SuiteClasses({ ShipTest.class, SpaceObjectTest.class, VelocityTest.class, WorldTest.class })
public class AllTests {

}
