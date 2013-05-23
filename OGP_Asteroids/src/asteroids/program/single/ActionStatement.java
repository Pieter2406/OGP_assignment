package asteroids.program.single;

import asteroids.program.SingleStatement;
import asteroids.studentdefined.Program;

public abstract class ActionStatement extends SingleStatement {

	protected ActionStatement(int line, int collumn, Program source) {
		super(line, collumn, source);
	}
	
	//Each action statement must have an execute method to perform actions on the ship.
	public abstract void execute();
}
