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
		// if (rhs instanceof PropertyDoubleExpression) // Can't be checked the same way because the program does not belong to a ship / world when typechecking.
		//	return (rhs.isTypeCorrect() && ProgramContainer.getGlobal(name) instanceof DoubleType);
		// Selse
			return (rhs.isTypeCorrect() && rhs.getType().getClass() == ProgramContainer.getGlobal(name).getClass());
	}

	@Override
	public String toString() {
		return "AssignmentStatement [name=" + name + ", rhs=" + rhs + ", line="
				+ line + ", column=" + column + "]";
	}
	
}

