package asteroids.program.statements.single.actions;

import asteroids.program.statements.single.ActionStatement;

public class ThrusterOnAction extends ActionStatement {

	public ThrusterOnAction(int line, int collumn) {
		super(line, collumn);
	}

	@Override
	public boolean execute() {
		sourceProgram.getSourceShip().getThruster().enable();
		setProgramLine();
		return true;
	}

}
