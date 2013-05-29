package asteroids.program.functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import asteroids.program.statements.SequenceStatement;
import asteroids.program.types.Type;

public class RunningFunctionStatement {
	
	SequenceStatement body;
	Map<String, Type> locals = new HashMap<String, Type>();
	
	/**
	 * A RunningFunctionStatement is a copy of a FunctionStatement, with the difference that where a FunctionStatement has a number of expected argument types, a RunningFunctionStatement gets its parameters
	 * upon construction and saves them locally.
	 * @param source The source function that will be used as a basis for the creation of this clone.
	 */
	public RunningFunctionStatement(FunctionStatement source ,List<Type> arguments) {
		this.body = source.getBody();
		//From the source names, match the given arguments and put them in a map of local variables.
		locals = source.getArguments();
		//TODO: Locals is nu geïnitialiseerd als een map van namen met default values voor hun type, de arguments moeten hier worden ingezet (vanuit een List naar een HashMap)
		//		Gebruikmakende van het feit dat variabelen
	}

	public boolean execute() {
		return this.body.execute();
	}

}
