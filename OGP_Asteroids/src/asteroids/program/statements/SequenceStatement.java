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
		boolean success = true;
		if(subStatements.isEmpty()){
			return true;
		}
		while(success && IIC < subStatements.size()){
			success = subStatements.get(IIC).execute();
			if(success || (subStatements.get(IIC) instanceof ActionStatement)){
				IIC++;
			}
			
		}			
		if(IIC >= this.subStatements.size()) {
			IIC = 0;
			return success;
		}else{
			return false;
		}
	}

}


