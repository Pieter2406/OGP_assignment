/**
 * 
 */
package asteroids.program.statements;

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
	protected Program sourceProgram;
	@Raw @Model
	protected Statement(int line, int column){
		this.line = line;
		this.column = column;
	}
	public void setSource(Program sourceProgram){
		this.sourceProgram = sourceProgram;
	}
	public int getLine(){
		return line;
	}
	public int getColumn(){
		return column;
	}
	
	public void setProgramLine(){
		sourceProgram.setIC(getLine());
	}
	
	public abstract boolean execute();
	
	public Program getSourceProgram() {
		return sourceProgram;
	}
	
	public abstract boolean typeCheck(); // each statement should be typechecked.
	
}
