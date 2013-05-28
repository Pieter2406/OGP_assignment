package asteroids.program.statements.single.actions;

import asteroids.program.expressions.Expression;
import asteroids.program.statements.single.ActionStatement;

public class TurnAction extends ActionStatement {
	private Expression angle;
	public TurnAction(int line, int column, Expression angle) {
		super(line, column);
		this.angle = angle;
	}

	public boolean execute() {
		this.sourceProgram.getSourceShip().setAngle((double)angle.getType().getValue());
		setProgramLine();
		return false;
	}

}
