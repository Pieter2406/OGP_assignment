package asteroids.studentdefined;

/**
 * An enumeration for different units of mass, currently supports kilogram, pound, carat, stone and newton.
 * @author 	Kristof Bruyninckx
 * 			Pieter Verlinden
 * 			Wouter Bruyninckx
 * @version 1.0
 */

enum MassUnit {
	KG, POUND, CARAT, STONE, NEWTON;

	/**
	 * Matrix containing exchange factors between different units.
	 */
	private static Double exchangeFactor[][] = new Double[5][5]; 
	
	/**
	 * initialization of exchange rates.
	 */
	static {
		exchangeFactor[KG.ordinal()][KG.ordinal()] = (double) 1;
		exchangeFactor[KG.ordinal()][POUND.ordinal()] = 2.205;
		exchangeFactor[KG.ordinal()][CARAT.ordinal()] = (double) 5000;
		exchangeFactor[KG.ordinal()][STONE.ordinal()] = 0.1575;
		exchangeFactor[KG.ordinal()][NEWTON.ordinal()] = 9.807;
		exchangeFactor[POUND.ordinal()][POUND.ordinal()] = (double) 1;
		exchangeFactor[POUND.ordinal()][CARAT.ordinal()] = (double) 2268;
		exchangeFactor[POUND.ordinal()][STONE.ordinal()] = 0.07143;
		exchangeFactor[POUND.ordinal()][NEWTON.ordinal()] = 4.448;
		exchangeFactor[CARAT.ordinal()][CARAT.ordinal()] = (double) 1;
		exchangeFactor[CARAT.ordinal()][STONE.ordinal()] = 0.00003149;
		exchangeFactor[CARAT.ordinal()][NEWTON.ordinal()] = 0.001961;
		exchangeFactor[STONE.ordinal()][STONE.ordinal()] = (double) 1;
		exchangeFactor[STONE.ordinal()][NEWTON.ordinal()] = 62.28;
		exchangeFactor[NEWTON.ordinal()][NEWTON.ordinal()] = (double) 1;
	}
	
	/**
	 * Returns the rate of exchange between this MassUnit and another MassUnit.
	 * @param 	other
	 * 			MassUnit to compare this unit with.
	 * @return	if this MassUnit is equal to the given MassUnit return 1.
	 * 			| if (this == other)
	 * 			|	result == 1;
     * @return	if this MassUnit is not equal to the given MassUnit return the exchange rate this 
     * 			MassUnit and the given MassUnit as defined in the exchange rates table. If the requested 
     * 			rate is not present in the exchange rates table return the inverse of the exchange rate 
     * 			between the other MassUnit and this MassUnit. 
     * 			| if (exchangeRates[this][other] == null)
     * 			| 	return 1 / exchangeRates[other][this]
     * 			| else
     * 			|	return exchangeRates[this][other]
	 * @throws 	IllegalArgumentException
	 * 			The given MassUnit is not effective.
	 * 			| (other == null)
	 */
	public double getExchangeFactor(MassUnit other) throws IllegalArgumentException{
		if (other == null)
			throw new IllegalArgumentException("Given MassUnit is not effective");
		if (exchangeFactor[this.ordinal()][other.ordinal()] == null)
			exchangeFactor[this.ordinal()][other.ordinal()] = 1 / exchangeFactor[other.ordinal()][this.ordinal()];
		return exchangeFactor[this.ordinal()][other.ordinal()];
	}
}
