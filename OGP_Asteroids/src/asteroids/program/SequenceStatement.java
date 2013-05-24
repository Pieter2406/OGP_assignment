package asteroids.program;

import java.util.List;

import asteroids.program.single.ActionStatement;
import asteroids.studentdefined.Program;

public class SequenceStatement extends Statement {
	private List<Statement> subStatements;
	public SequenceStatement(int line, int column,List<Statement> subStatements) {
		super(line, column);
		this.subStatements = subStatements;
	}
	@Override
	public void setSource(Program sourceProgram){
		for(Statement statement : subStatements){
			statement.setSource(sourceProgram);
		}
		this.sourceProgram = sourceProgram;
	}
	
	@Override
	public void execute() {
		for(Statement statement : subStatements){
			if (statement.getLine() > sourceProgram.getIC()){ // ineffecient to traverse all program statements.
				if (statement instanceof ActionStatement){
					statement.execute();
					break; // break when encountering action statement.
				}
				statement.execute();
			}
		}	
	}
}
