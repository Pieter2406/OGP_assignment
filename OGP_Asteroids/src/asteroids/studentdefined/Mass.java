package asteroids.studentdefined;

import asteroids.Util;
import be.kuleuven.cs.som.annotate.*;

/** 
 * A class of Mass involves an acceleration resistance, a mass and a MassUnit.
 * 
 * @invar	The mass of each object must be a legal mass.
 * 			| isValidMass(getMass())
 * @invar	The unit of each mass must be legal.
 * 			| isValidUnit(getUnit())
 * 
 * @version 1.1
 * 
 * @author Kristof Bruynincks
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 * 
 */
@Value
public class Mass implements Comparable<Mass>{
	
	/**
	 * Initializes the mass with a given mass density and a given radius, the unit of this mass is kilogram
	 * because the mass density is in defined in kilograms.
	 * 
	 * @param 	massDensity
	 * 			The mass density of an object.
	 * @param 	radius
	 * 			The radius of a (round) object.
	 * @effect	The mass is calculated in terms of the given mass density and the radius.
	 * 			| new.getValue() = computeMass(massDensity, radius)
	 * @throws	IllegalValueException
	 * 			The new computed mass is not a valid mass.
	 * 			| !isValidMass(computeMass(massDensity, radius))
	 */
	public Mass(double massDensity,double radius){ 
		double tempMass = computeCircularMass(massDensity, radius);
		if(!isValidMass(tempMass)){
			throw new IllegalValueException(tempMass);
		}else{
			this.mass = tempMass;
		}
		this.unit = MassUnit.KG;
	}
	
	/**
	 * Initializes the mass with a given mass and a given unit.
	 * @param 	mass
	 * 			The given value for this mass.
	 * @param	unit
	 * 			The given unit for this mass
	 * @post	The value of this new mass equals the given mass.
	 * 			| (this new).getValue() == mass
	 * @post	The unit of this new mass is equal to the given unit.
	 * 			| (new this).getUnit() == unit
	 * @throws	IllegalValueException
	 * 			The given mass is not a valid mass.
	 * 			| !isValidMass(mass)
	 */
	public Mass(double mass, MassUnit unit){
		if(!isValidMass(mass)){
			throw new IllegalValueException(mass);
		}else{
			this.mass = mass;
		}
		this.unit = unit;
	}
	
	/**
	 * Initializes the mass with a given mass.
	 * 
	 * @effect	This mass is initialized as a new mass with kilograms as the given unit.
	 * 			| super(mass,MassUnit.KG)
	 */
	public Mass(double mass){
		this(mass,MassUnit.KG);
	}
	
	/**
	 * Initializes the mass with zero and a given unit.
	 * 
	 * @effect 	This new mass is initialized with zero.
	 * 			|this(0,) 
	 */
	public Mass(){
		this(0);
	}
	
	/*____________________________METHODS____________________________*/
	
	/**
	 * Compute the mass in terms of a given mass density and a given radius. A circular mass is computed in kg.
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
	public static double computeCircularMass(double massDensity, double radius){
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
	/*____________________________MASS____________________________*/
	
	/**
	 * Set the current mass to the given value.
	 * 
	 * @param 	newMass
	 * 			The value for the new mass.
	 * @post 	If the given mass is a valid mass, the current mass is set to the 
	 * 			new given mass.
	 * 			| if(isValidMass(newMass)
	 * 			| 	new.getValue() == newMass
	 * @throws	IllegalValueException
	 * 			The given mass is not a valid mass
	 * 			| !isValidMass(newMass)
	 */
	public void setValue(double newMass){
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
	public double getValue(){return mass;}

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
	public static boolean isValidMass(double mass){
		return (mass >= 0 && mass < Double.POSITIVE_INFINITY && !Double.isNaN(mass));
	}
	
	
	
	/**
	 * Check wether a given MassUnit is valid for any mass.
	 * @param 	unit
	 * 			The given unit to be checked.
	 * @return	True if the given unit is valid.
	 * 			| result == (unit != null)
	 */
	public boolean isValidUnit(MassUnit unit){
		return unit != null;
	}
	
	@Basic @Raw @Immutable
	public MassUnit getMassUnit(){
		return unit;
	}
	
	/**
	 * The unit for this mass.
	 */
	private final MassUnit unit;
	
	// Value class methods
	//_________________________________________________________________________
	
	@Override
	public int compareTo(Mass other) {
		double factor = getMassUnit().getExchangeFactor(other.getMassUnit());
		if (other == null)
			throw new IllegalArgumentException("Mass is not effective"); ;
		if (Util.fuzzyEquals(getValue(),other.getValue() / factor))
			return 0;
		if (getValue() < other.getValue() / factor)
			return -1;
		else
			return 1;
	}
	
	@Override
	public int hashCode(){
		Double mass = ((Double)getValue());
		return mass.hashCode() + getMassUnit().hashCode();
	}
	
	@Override
	public String toString(){
		return getValue() + "" + getMassUnit();
	}
	
}
