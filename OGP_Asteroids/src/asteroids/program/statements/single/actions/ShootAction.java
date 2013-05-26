package asteroids.program.statements.single.actions;

import asteroids.program.statements.single.ActionStatement;

public class ShootAction extends ActionStatement {

	public ShootAction(int line, int column) {
		super(line,column);
	}
	
	@Override
	public boolean execute() {
		sourceProgram.getSourceShip().fireBullet();
		setProgramLine();
		return true;
	}

}
