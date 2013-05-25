package asteroids.program.statements.single.actions;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.doubles.LiteralDoubleExpression;
import asteroids.program.statements.single.ActionStatement;
import asteroids.studentdefined.Program;

public class TurnAction extends ActionStatement {
	private LiteralDoubleExpression angle;
	public TurnAction(int line, int column, Expression angle) {
		super(line, column);
		this.angle = (LiteralDoubleExpression) angle;
	}

	public boolean execute() {
		this.sourceProgram.getSourceShip().setAngle(angle.getType().getValue());
		setProgramLine();
		return true;
	}

}
