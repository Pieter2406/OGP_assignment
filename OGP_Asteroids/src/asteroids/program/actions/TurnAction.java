package asteroids.program.actions;

import asteroids.program.expression.Expression;
import asteroids.program.expression.LiteralDoubleExpression;
import asteroids.program.single.ActionStatement;
import asteroids.studentdefined.Program;

public class TurnAction extends ActionStatement {
	private LiteralDoubleExpression angle;
	public TurnAction(int line, int column, Expression angle) {
		super(line, column);
		this.angle = (LiteralDoubleExpression) angle;
	}

	public void execute() {
		this.sourceProgram.getSourceShip().setAngle(angle.getType().getValue());
		setProgramLine();
	}

}
