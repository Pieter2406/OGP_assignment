package asteroids.program.actions;

import asteroids.program.single.ActionStatement;
import asteroids.studentdefined.Program;

public class ThrusterOffAction extends ActionStatement {

	public ThrusterOffAction(int line, int column) {
		super(line, column);
	}

	@Override
	public void execute() {
		sourceProgram.getSourceShip().getThruster().disable();
		this.setProgramLine();
	}
}
