package asteroids.studentdefined;

import java.util.HashMap;
import java.util.Map;

import asteroids.program.ProgramContainer;
import asteroids.program.functions.FunctionStatement;
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
	public static final long DEFAULT_RUN_FREQUENCY = 200;
	private Ship sourceShip;
	private Map<String, Type> globals;
	private Map<String, FunctionStatement> functions;
	private Map<String, Map<String,Type>> locals;
	private Statement statement;
	private boolean hasFinished = false;
	@Deprecated
	private int currentInstruction; // keep track of the current instruction, so that the program continues at the right spot.
	
	public Program(){
	}	
	
	public Program(Map<String, Type> map, Statement statement) {
		this.globals = map;
		this.statement = statement;
		this.functions = new HashMap<String, FunctionStatement>();
		statement.setSource(this);
		currentInstruction = 0;
		ProgramContainer.setProgram(this);
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
	public Map<String, FunctionStatement> getFunctions(){
		return functions;
	}
	public Map<String, Map<String,Type>> getLocals(){
		return locals;
	}
	public boolean typeCheck(){
		return statement.typeCheck();
	}
	
}
