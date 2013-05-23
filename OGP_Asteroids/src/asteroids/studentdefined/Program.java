package asteroids.studentdefined;

import java.util.ArrayList;
import java.util.Map;

import asteroids.program.ProgramConstructor;
import asteroids.program.Statement;
import asteroids.program.Type;
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
	private ArrayList<Statement> instructions;
	public static final long DEFAULT_RUN_FREQUENCY = 200;
	private Ship sourceShip;
	private ProgramConstructor programConstructor;
	private Map<String, Type> globals;
	private Statement statement;
	
	public Program(){
		this.instructions = new ArrayList<Statement>();
		this.programConstructor = new ProgramConstructor(this);
	}
	
	
	public Program(Map<String, Type> globals, Statement statement) {
		this.instructions = new ArrayList<Statement>();
		this.programConstructor = new ProgramConstructor(this);
		this.globals = globals;
		this.statement = statement;
	}

	public Ship getSourceShip() {
		return sourceShip;
	}

	public ProgramConstructor getProgramConstructor(){
		return this.programConstructor;
	}

	public void run() {
		// TODO Write run method in program
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
}
