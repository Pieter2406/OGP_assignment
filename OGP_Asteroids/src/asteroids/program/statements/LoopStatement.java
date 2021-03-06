package asteroids.program.statements;

public abstract class LoopStatement extends Statement {
	protected Statement body;
	public LoopStatement(int line, int column, Statement body) {
		super(line, column);
		this.body = body;
	}
	
	@Override
	public String toString() {
		return "LoopStatement [body=" + body + ", line=" + line + ", column="
				+ column + "]";
	}
	
	
}
