package asteroids.program.statements;

import java.util.List;

import asteroids.program.statements.single.ActionStatement;
import asteroids.studentdefined.Program;

public class SequenceStatement extends Statement {
	private List<Statement> subStatements;
	private int IIC; //internal instruction counter
	public SequenceStatement(int line, int column,List<Statement> subStatements) {
		super(line, column);
		this.subStatements = subStatements;
		this.IIC = 0;
	}
	@Override
	public void setSource(Program sourceProgram){
		for(Statement statement : subStatements){
			statement.setSource(sourceProgram);
		}
		this.sourceProgram = sourceProgram;
	}
	public int getIIC(){
		return IIC;
	}

	@Override
	public boolean execute() {
		boolean success;
		if(subStatements.isEmpty()){
			return true;
		}
		success = subStatements.get(IIC).execute();
		if(success){
			IIC++;
		}
		if(IIC == this.subStatements.size()) {
			IIC = 0;
			return true;
		}else{
			return false;
		}
	}

	/*
		for(Statement statement : subStatements){
			if (statement.getLine() > sourceProgram.getIC() || statement instanceof SequenceStatement){ // ineffecient to traverse all program statements.
				if (statement instanceof ActionStatement){
					statement.execute();
					break; // break when encountering action statement.
				}
				statement.execute();
			}
		}
	 */
}

