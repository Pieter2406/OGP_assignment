/**
 * 
 */
package asteroids.program;

import asteroids.studentdefined.Program;
import be.kuleuven.cs.som.annotate.*;


/**
 * @author Kristof Bruyninckx
 * @author Wouter Bruyninckx
 * @author Pieter Verlinden
 * @version 1.2
 *
 */
public abstract class Statement {
	protected final int line;
	protected final int column;
	protected final Program sourceProgram;
	@Raw @Model
	protected Statement(int line, int column, Program source){
		this.line = line;
		this.column = column;
		this.sourceProgram = source;
	}
	
	public int getLine(){
		return line;
	}
	public int getCollumn(){
		return column;
	}
	
}
