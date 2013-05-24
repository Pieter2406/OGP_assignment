package asteroids.program.actions;

import asteroids.program.single.ActionStatement;
import asteroids.studentdefined.Program;

public class ShootAction extends ActionStatement {

	public ShootAction(int line, int column) {
		super(line,column);
	}
	
	@Override
	public void execute() {
		sourceProgram.getSourceShip().fireBullet();
		this.setProgramLine();
	}

}
