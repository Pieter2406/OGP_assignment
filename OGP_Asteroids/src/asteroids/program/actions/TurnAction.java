package asteroids.program.actions;

import asteroids.program.single.ActionStatement;
import asteroids.studentdefined.Program;

public class TurnAction extends ActionStatement {

	public TurnAction(int line, int column) {
		super(line, column);
	}

	public void execute() {
		this.setProgramLine();
	}

}
