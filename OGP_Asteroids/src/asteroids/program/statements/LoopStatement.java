package asteroids.program.statements;

public abstract class LoopStatement extends Statement {
	protected Statement body;
	public LoopStatement(int line, int column, Statement body) {
		super(line, column);
		this.body = body;
	}
	
	@Override
	public boolean typeCheck() {
		// Note that our foreach loop supports action statements, this does not need to be checked and each loop has the same typeCheck.
		if (!body.typeCheck())
			return false; // if a statement of the body is type incorrect return false, if none is found return true.
		return true;
	}
}
