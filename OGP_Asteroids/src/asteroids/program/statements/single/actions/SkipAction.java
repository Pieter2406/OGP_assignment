package asteroids.program.statements.single.actions;

import asteroids.program.statements.single.ActionStatement;
import asteroids.studentdefined.Program;

public class SkipAction extends ActionStatement {

	public SkipAction(int line, int column) {
		super(line, column);
	}

	@Override
	public boolean execute(){
		setProgramLine();
		return true;
	}

}