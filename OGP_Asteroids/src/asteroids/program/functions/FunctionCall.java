package asteroids.program.functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import asteroids.program.*;
import asteroids.program.statements.SingleStatement;
import asteroids.program.types.Type;

/**
 * A function call is a statement that can be called from a sequence of statements. When called, if a RunningFunctionStatement is attached, it will continue its execution. If not, a RunningFunctionStatement
 * will be created based on the programs map of FunctionStatements if a match is found, with the given parameter(s). When a function has succesfully executed completely, the association is broken and its 
 * RunningFunctionStatement is terminated. On a next call, a new copy based on the current values of the parameters will be created.
 *
 */
public class FunctionCall extends SingleStatement {

	private Map<String, Type> locals = new HashMap<String, Type>();
	private RunningFunctionStatement runningCopy;
	private boolean success = false;
	private String name;
	private List<Type> arguments;
	
	/**
	 * 
	 * @param name 		The name of the function to be called.
	 * @param arguments	The arguments that should be passed with this function call.
	 */
	public FunctionCall(int line, int column, String name, List<Type> arguments) {
		super(line, column);
		runningCopy = null;
		this.name = name;
		this.arguments = arguments;
	}


	@Override
	public boolean execute() {
		// First check if a runningCopy is attached
		if (runningCopy != null) {
			success = runningCopy.execute(); //Continue its execution
			if (success) {//Finished function call, clean up now
				this.runningCopy = null;
				return true;
			}
			else
				return false;
		}
		else { //Not currently executing, attach a new runningCopy
			
			//Find the corresponding function body in the programs list and verify if the given arguments match. If so, attach a RunningFunctionStatement based on the found result.
			if (sourceProgram.functions.get(name).checkArguments(this.arguments)) {
				this.runningCopy = new RunningFunctionStatement(sourceProgram.functions.get(name), this.arguments);
				return this.execute();
			} else
				throw new RuntimeException("Function not found."); //Throw error when the given function cannot be recognized, should never happen if functions are typechecked.
		}
	}

}
