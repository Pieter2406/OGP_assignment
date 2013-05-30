package asteroids.program.statements.single.actions;

import asteroids.program.statements.single.ActionStatement;

public class SkipAction extends ActionStatement {

	public SkipAction(int line, int column) {
		super(line, column);
	}

	@Override
	public boolean execute(){
		setProgramLine();
		return false;
	}

	@Override
	public boolean typeCheck() {
		return true; // the action skip is always type correct.
	}

	@Override
	public String toString() {
		return "SkipAction [line=" + line + ", column=" + column + "]";
	}

}
