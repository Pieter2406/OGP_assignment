package asteroids.program.actions;

import asteroids.program.single.ActionStatement;
import asteroids.studentdefined.Program;

public class ShootAction extends ActionStatement {

	public ShootAction(int line, int column, Program source) {
		super(line,column, source);
	}
	
	
	public void execute() {
		sourceProgram.getSourceShip().fireBullet();
	}

}
