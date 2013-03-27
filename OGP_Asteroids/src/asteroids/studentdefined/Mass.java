package asteroids.studentdefined;

import be.kuleuven.cs.som.annotate.*;

/** 
 * A class of Mass involves an acceleration resistance, a collision effect and a mass.
 * 
 * @invar	The mass of each object must be a legal mass.
 * 			| isValidMass(getMass())
 * 
 * @version 1.1
 * 
 * @author Kristof Bruynincks
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 * 
 */
public class Mass {

	/**
	 * Initializes the mass with a given mass density and a given radius.
	 * 
	 * @param 	massDensity
	 * 			The mass density of an object.
	 * @param 	radius
	 * 			The radius of a (round) object.
	 * @post	The mass is calculated in terms of the given mass density and the radius.
	 * 			| new.getMass() = computeMass(massDensity, radius)
	 * @throws	IllegalValueException
	 * 			The new computed mass is not a valid mass.
	 * 			| !isValidMass(computeMass(massDensity, radius))
	 */
	public Mass(double massDensity,double radius){
		double tempMass = computeMass(massDensity, radius);
		if(!isValidMass(tempMass)){
			throw new IllegalValueException(tempMass);
		}else{
			this.mass = tempMass;
		}
	}
	/**
	 * Initializes the mass with a given mass.
	 * 
	 * @param 	mass
	 * 			The mass of an object.
	 * @post	The value of this new mass equals the given mass.
	 * 			|new.mass = mass
	 * @throws	IllegalValueException
	 * 			The given mass is not a valid mass.
	 * 			| !isValidMass(mass)
	 */
	public Mass(double mass){
		if(!isValidMass(mass)){
			throw new IllegalValueException(mass);
		}else{
			this.mass = mass;
		}
	}
	
	/**
	 * Initializes the mass with zero.
	 * 
	 * @effect 	This new mass is initialized with zero.
	 * 			|this(0) 
	 */
	public Mass(){
		this(0);
	}
	
	/**
	 * Compute the mass in terms of a given mass density and a given radius.
	 * 
	 * @param 	massDensity
	 * 			The given mass density.
	 * @param 	radius
	 * 			The given radius
	 * @return	The computed mass.
	 * 			| result == (4/3) * Math.PI * Math.pow(radius, 3) * massDensity;
	 * @throws	IllegalValueException
	 * 			The given mass density is an illegal value.
	 * 			| massDensity < 0 && massDensity > Double.POSITIVE_INFINITY && Double.isNaN(massDensity) 
	 * @throws	IllegalValueException
	 * 			The given radius is an illegal value.
	 * 			| radius < 0 && radius > Double.POSITIVE_INFINITY && Double.isNaN(radius)
	 */
	public static double computeMass(double massDensity, double radius){
		if(massDensity > 0 && massDensity < Double.POSITIVE_INFINITY && !Double.isNaN(massDensity)){
			if(radius > 0 && radius < Double.POSITIVE_INFINITY && !Double.isNaN(radius)){
				return (4/3) * Math.PI * Math.pow(radius, 3) * massDensity;
			}else{
				throw new IllegalValueException(radius);
			}
		}else{
			throw new IllegalValueException(massDensity);
		}
		
	}

	/**
	 * Set the current mass to the given mass.
	 * 
	 * @param 	newMass
	 * 			The value for the new mass.
	 * @post 	If the given mass is a valid mass, the current mass is set to the 
	 * 			new given mass.
	 * 			| if(isValidMass(newMass)
	 * 			| 	new.getMass() == newMass
	 * @throws	IllegalValueException
	 * 			The given mass is not a valid mass
	 * 			| !isValidMass(newMass)
	 */
	public void setMass(double newMass){
		if(isValidMass(newMass)){
			this.mass = newMass;
		}else{
			throw new IllegalValueException(newMass);
		}
		
	}

	/**
	 * 
	 * @return	The mass of the object.
	 */
	@Basic @Raw @Immutable
	public double getMass(){return mass;}

	/**
	 * Holds the mass of the object.
	 */
	private double mass;

	/**
	 * Check whether the given mass is a valid mass.
	 * @param	mass
	 * 			The given mass that needs to be checked.
	 * @return	True if and only if the given mass is positive or equal to zero, is 
	 * 			not infinity and is a number.
	 * 			|result == (mass >= 0 && mass < DOUBLE.POSITIVE_INFINITY && !Double.isNaN(mass))
	 */
	public boolean isValidMass(double mass){
		return (mass >= 0 && mass < Double.POSITIVE_INFINITY && !Double.isNaN(mass));
	}

	//	/**
	//	 * @return the accelResistance
	//	 */
	//	public double getAccelResistance() {
	//		return accelResistance;
	//	}
	//	
	//	/**
	//	 * @param 	accelResistance 
	//	 * 			The new value for the acceleration resistance.
	//	 */
	//	public void setAccelResistance(double accelResistance) {
	//		this.accelResistance = accelResistance;
	//	}
	//	
	//	/**
	//	 * Holds the acceleration resistance.
	//	 */
	//	private double accelResistance;
	//	
	//	/**
	//	 * @return the collisionEffect
	//	 */
	//	public double getCollisionEffect() {
	//		return collisionEffect;
	//	}
	//	
	//	/**
	//	 * @param 	collisionEffect 
	//	 * 			The new value for the collision effect.
	//	 */
	//	public void setCollisionEffect(double collisionEffect) {
	//		this.collisionEffect = collisionEffect;
	//	}
	//	
	//	/**
	//	 * Holds the value for collision effect.
	//	 */
	//	private double collisionEffect;

}
