package asteroids.program.statements.single;

import asteroids.program.ProgramContainer;
import asteroids.program.expressions.Expression;
import asteroids.program.statements.SingleStatement;

public class AssignmentStatement extends SingleStatement {
	private String name;
	private Expression rhs;
	public AssignmentStatement(int line, int column, String name, Expression rhs) {
		super(line, column);
		this.name = name;
		this.rhs = rhs;
	}

	@Override
	public boolean execute() {
		ProgramContainer.getGlobals().put(name, rhs.getType());
		return true;
	}

	@Override
	public boolean typeCheck() {
		if (ProgramContainer.getGlobal(name) == null)
			return false; // variable must exist!
		// make sure that the type of the expression corresponds with the type from the list of global variables.
		return (rhs.isTypeCorrect() && rhs.getType().getClass() == ProgramContainer.getGlobal(name).getClass());
	}
}
