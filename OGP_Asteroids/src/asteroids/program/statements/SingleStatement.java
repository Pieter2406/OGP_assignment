package asteroids.program.statements;

import asteroids.studentdefined.Program;

public class SingleStatement extends Statement {

	public SingleStatement(int line, int column) {
		super(line, column);
	}

	
	@Override
	public boolean execute() {
		return false;		
	}
	

}
