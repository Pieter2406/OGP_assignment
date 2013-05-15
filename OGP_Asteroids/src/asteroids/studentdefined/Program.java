package asteroids.studentdefined;

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

	
	/**
	 * @param ship
	 */
	public Program(Ship ship) {
		// TODO Write constructor for Program
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
