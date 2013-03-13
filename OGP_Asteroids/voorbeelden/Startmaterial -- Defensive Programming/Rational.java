import be.kuleuven.cs.som.annotate.*;

/**
 * A class of rational numbers involving a numerator and a
 * denominator.
 *
 * @author  bachelor informatica et al.
 * @version 1.0
 */
public class Rational {
	
	/**
	 * Return the numerator (Dutch "teller") of this rational number.
	 */
	@Basic @Raw
	public long getNumerator() {
		return this.numerator;
	}
	
	/**
	 * Variable storing the numerotor of this rational number.
	 */
	private long numerator;

	/**
	 * Return the denominator (Dutch "teller") of this rational number.
	 */
	@Basic @Raw
	public long getDenominator() {
		return this.denominator;
	}
	
	/**
	 * Variable storing the numerotor of this rational number.
	 */
	private long denominator;

}
