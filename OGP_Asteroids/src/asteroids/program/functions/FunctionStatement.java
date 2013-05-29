package asteroids.program.functions;

import java.util.List;
import java.util.Map;

import asteroids.program.statements.SequenceStatement;
import asteroids.program.statements.Statement;
import asteroids.program.types.Type;

public class FunctionStatement {
	
//TODO: de parameter requiredArguments kan mogelijk niet als Map worden doorgegeven, omdat de volgorde van argumenten gekend en bewaard moet blijven.

	/**
	 * @pre	The requiredArguments parameter contains a non null List of Types that represents the required arguments for this function, in the sequence they appear in the input file.
	 */
	public FunctionStatement(int line, int col, List<Statement> sequence, Map<String, Type> requiredArguments) {
		this.body = new SequenceStatement(line, col, sequence);
		this.argumentTypes = (List<Type>) requiredArguments; //Store argument types in the order they appear in the given Map for validity checking.
		this.formalArguments = requiredArguments; //Map of variable names with types that contain their default value.
	}

	private SequenceStatement body;
	private List<Type> argumentTypes;
	private Map<String, Type> formalArguments;
	
	/**
	 * Returns the subStatements of this function.
	 * @return
	 */
	public SequenceStatement getBody() {
		return body;
	}
	
	public Map<String, Type> getArguments() {
		return this.formalArguments;
	}
	
	/**
	 * @return True if the given argument types match the ones defined in this function definition.
	 */
	public boolean checkArguments(List<Type> tocheck) {
		try {
			if (tocheck.size() != argumentTypes.size())
				return false; // Argument counts do not match
			for (int i = 0; i < tocheck.size(); i++) {
				if (argumentTypes.get(i).getClass() != tocheck.get(i).getClass())
					return false;
			}
			return true; 
		}
		catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

}
