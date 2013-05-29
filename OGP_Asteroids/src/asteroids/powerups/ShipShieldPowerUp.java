/**
 * 
 */
package asteroids.powerups;

import java.util.ArrayList;
import java.util.List;

import asteroids.studentdefined.PowerUp;
import asteroids.studentdefined.Ship;
import asteroids.studentdefined.World;

/**
 * A class of ship shield powerup holds an object in the world
 * that powerups the ship. It extends from the superclass PowerUp.
 * 
 * @author	Kristof Bruyninckx
 * @author 	Wouter Bruyninckx
 * @author 	Pieter Verlinden
 *
 * @version 1.0
 */

public class ShipShieldPowerUp extends PowerUp {
	public final static int TYPE = 1;
	public final static double MAXIMUM_LIFE_TIME = Double.POSITIVE_INFINITY;
	/**
	 * @param 	x
	 * 			The x coordinate of this powerup in the world.
	 * @param 	y
	 * 			The u coordinate of this powerup in the world.
	 * @param	world
	 * 			The world where this powerup is effective.
	 * @param	sourceShip
	 * 			The ship where this powerup is active.
	 * @effect	The powerup is initialized with
	 * 			an x coordinate, an y coordinate, a default radius,
	 * 			0 velocity, a world and a source ship.
	 * 
	 */
	public ShipShieldPowerUp(double x, double y, World world, Ship sourceShip) {
		super(x, y, world, TYPE, sourceShip);
	}
	
	@Override
	protected boolean hasPassedActiveLifeTime() {
		return(this.getActiveLifeTime() > MAXIMUM_LIFE_TIME);
	}
	/**
	 * Activates this powerups effects on the source ship.
	 * The ship sets up a shield or if there alraidy is a shield,
	 * it gains an extra shield upto the maximum of shields.
	 * @effect	The shield of the source ship is increased.
	 * 			| sourceShip.incShield();
	 * @effect	The active life time of this powerup is set to the current system time.
	 */
	@Override
	public void activate() {
		this.setActiveLifeTime();
		sourceShip.incShield();
	}
	/**
	 * Evaluates this powerups lifetima and removes its effects on the source if 
	 * its lifetime is exceeded. As this powerups lifetime is infinite it will never
	 * be terminated. Except if the active shields in the sourceship are lower
	 * than the amount of ship shield powerups active in the sourceShip.
	 * @post	If the amount of active shields on the source ship is lower then the
	 * 			amount of ship shield powerups in the sourceship terminate this one;
	 */
	@Override
	public void evaluate() {
		int activeShieldPowerups = 0;
		for(PowerUp active : sourceShip.getActivePowerUps()){
			if(active instanceof ShipShieldPowerUp){
				activeShieldPowerups++;
			}
		}
		if(sourceShip.getShield() < activeShieldPowerups){
			this.terminate();
		}
		
	}

}
