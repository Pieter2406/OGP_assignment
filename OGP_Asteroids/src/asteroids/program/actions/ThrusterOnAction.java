package asteroids.program.actions;

import asteroids.program.single.ActionStatement;
import asteroids.studentdefined.Program;

public class ThrusterOnAction extends ActionStatement {

	public ThrusterOnAction(int line, int collumn) {
		super(line, collumn);
	}

	@Override
	public void execute() {
		sourceProgram.getSourceShip().getThruster().enable();
		setProgramLine();
	}

}
