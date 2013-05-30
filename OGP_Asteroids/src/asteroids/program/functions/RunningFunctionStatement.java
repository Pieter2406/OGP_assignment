package asteroids.program.functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import asteroids.program.ProgramContainer;
import asteroids.program.statements.SequenceStatement;
import asteroids.program.statements.Statement;
import asteroids.program.types.Type;

public class RunningFunctionStatement {
	
	Statement body;
	Map<String, Type> locals = new HashMap<String, Type>();
	List<Argument> actualArguments;
	List<Argument> formalArguments;
	/**
	 * A RunningFunctionStatement is a copy of a FunctionStatement, with the difference that where a FunctionStatement has a number of expected argument types, a RunningFunctionStatement gets its parameters
	 * upon construction and saves them locally.
	 * @param source The source function that will be used as a basis for the creation of this clone.
	 */
	public RunningFunctionStatement(FunctionStatement source ,List<Argument> arguments) {
		this.body = source.getBody();
		actualArguments = arguments;
		formalArguments = source.getFormalArguments();
		loadArguments();
		ProgramContainer.addFunctionLocals(source.getFunctionName(), locals);
		//From the source names, match the given arguments and put them in a map of local variables.
		//TODO: Locals is nu geïnitialiseerd als een map van namen met default values voor hun type, de arguments moeten hier worden ingezet (vanuit een List naar een HashMap)
		//		Gebruikmakende van het feit dat variabelen
	}

	public boolean execute() {
		return this.body.execute();
	}
	
	/**
	 * Combines the formal arguments (which holds the names of the arguments) with the
	 * actual arguments (which holds the values of the arguments).
	 * 
	 * 
	 */
	private void loadArguments(){
		for(int i = 0 ; i < formalArguments.size(); i++){
			locals.put(formalArguments.get(i).getName(), actualArguments.get(i).getType()); 
		}
		/*
		for(Argument fArg : formalArguments){
			for(Argument aArg : actualArguments){
				if(fArg.getIndex() == aArg.getIndex()){
					locals.put(fArg.getName(), aArg.getType());
				}
			}
		}
		*/
	}
	
}
