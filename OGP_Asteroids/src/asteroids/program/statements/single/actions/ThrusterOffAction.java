package asteroids.program.statements.single.actions;

import asteroids.program.statements.single.ActionStatement;

public class ThrusterOffAction extends ActionStatement {

	public ThrusterOffAction(int line, int column) {
		super(line, column);
	}

	@Override
	public boolean execute() {
		sourceProgram.getSourceShip().getThruster().disable();
		setProgramLine();
		return false;
	}
}
