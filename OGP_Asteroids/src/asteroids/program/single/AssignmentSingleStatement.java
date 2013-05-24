package asteroids.program.single;

import asteroids.program.SingleStatement;
import asteroids.program.expression.Expression;

public class AssignmentSingleStatement extends SingleStatement {
	private String name;
	private Expression rhs;
	public AssignmentSingleStatement(int line, int column, String name, Expression rhs) {
		super(line, column);
		this.name = name;
		this.rhs = rhs;
	}

	@Override
	public void execute() {
		sourceProgram.getGlobals().put(name, rhs.getType());
	}

}
