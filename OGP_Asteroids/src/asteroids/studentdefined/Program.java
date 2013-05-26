package asteroids.studentdefined;

import java.util.Map;

import asteroids.program.ProgramContainer;
import asteroids.program.statements.Statement;
import asteroids.program.types.Type;
/**
 * 
 * @author 	Kristof Bruyninckx
 * @author  Wouter Bruyninckx
 * @author  Pieter Verlinden
 * 
 * @version 1.2
 *
 */
public class Program {
	public static final long DEFAULT_RUN_FREQUENCY = 20;
	private Ship sourceShip;
	private Map<String, Type> globals;
	private Statement statement;
	private boolean hasFinished = false;
	@Deprecated
	private int currentInstruction; // keep track of the current instruction, so that the program continues at the right spot.
	
	public Program(){
	}	
	
	public Program(Map<String, Type> map, Statement statement) {
		this.globals = map;
		this.statement = statement;
		statement.setSource(this);
		ProgramContainer.setProgram(this);
		currentInstruction = 0;
	}

	public Ship getSourceShip() {
		return sourceShip;
	}
	public void attachShip(Ship ship){
		sourceShip = ship;
	}

	public void run() {
		if(!hasFinished){
			hasFinished = statement.execute();
		}
		
	}

	public long getLastRunTime() {
		return lastRunTime;
	}

	public void setLastRunTime(long time){
		if(isValidTime(time)){
			this.lastRunTime = time;
		}
	}

	private long lastRunTime;


	private boolean isValidTime(long time) {
		return(time > 0 && time < Long.MAX_VALUE);
	}

	public void setIC(int line) {
		currentInstruction = line;
	}
	
	public int getIC(){
		return currentInstruction;
	}
	public Map<String,Type> getGlobals(){
		return globals;
	}
}
