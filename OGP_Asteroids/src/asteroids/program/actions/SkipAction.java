package asteroids.program.actions;

import asteroids.program.single.ActionStatement;
import asteroids.studentdefined.Program;

public class SkipAction extends ActionStatement {

	public SkipAction(int line, int column) {
		super(line, column);
	}

	@Override
	public void execute(){
		setProgramLine();
	}

}
