package asteroids.program.statements.single.actions;

import asteroids.program.expressions.Expression;
import asteroids.program.statements.single.ActionStatement;
import asteroids.program.types.DoubleType;

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

	@Override
	public boolean typeCheck() {
		return angle.isTypeCorrect() && angle.getType() instanceof DoubleType; // angle must be a double expression
	}

	@Override
	public String toString() {
		return "TurnAction [angle=" + angle + ", line=" + line + ", column="
				+ column + "]";
	}

}
