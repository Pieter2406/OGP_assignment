package asteroids.studentdefined;

/**********************************************************************************
 * 								GENERAL TODO LIST:		              			  *
 **********************************************************************************
 *		- public static double massDensity = 2,65E12 kg/km³						  *	
 *		- minimumRadius = 0														  *
 **********************************************************************************/

/**
 * A class of Asteroid extends to SpaceObject and involves a position, a mass, a minimumradius and a velocity.
 * 
 * TODO: Write @invar (if necessary) in Asteroid class
 * 
 * @version 1.1
 * 
 * @author Kristof Bruynincks
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 */
public class Asteroid extends SpaceObject {

    /**
     * Initialize this new asteroid with a given position , a given velocity and a given radius.
     * @param 	x
     * 			The position on the x axis for this new asteroid.
     * @param 	y
     * 			The position on the y axis for this new asteroid.
     * @param 	velocityX
     * 			the velocity on the x axis for this new asteroid.
     * @param 	velocityY
     * 			the velocity on the y axis for this new asteroid.
     * @param 	radius
     * 			The given radius for this new asteroid.
     * @param	world
     * 			The source world wherein this asteroid exists.
     * @effect 	This asteroid is initialized as a spaceobject with the given parameters.
     */
    public Asteroid(double x, double y, double velocityX, double velocityY, double radius, World world){
	super(x, y, velocityX, velocityY, radius, 0, Mass.computeCircularMass(MASS_DENSITY, radius), world);

    }

    private final static double MASS_DENSITY = 2.65E12;

    /**
     * Checks if the given object is a valid asteroid.
     *
     * @param 	o 
     * 		The object to check.
     * @return 	True, if the given object is a valid asteroid.
     */
    public static boolean isValidAsteroid(Object o){
	if(o == null || !(o instanceof Asteroid)){
	    return false;
	}else{
	    return true;
	}
    }
}
