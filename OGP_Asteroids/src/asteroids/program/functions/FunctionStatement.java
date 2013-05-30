package asteroids.program.functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.MultiMap;

import asteroids.program.statements.SequenceStatement;
import asteroids.program.statements.Statement;
import asteroids.program.types.Type;

public class FunctionStatement {
	
//TODO: de parameter requiredArguments kan mogelijk niet als Map worden doorgegeven, omdat de volgorde van argumenten gekend en bewaard moet blijven.

	/**
	 * @pre	The requiredArguments parameter contains a non null List of Types that represents the required arguments for this function, in the sequence they appear in the input file.
	 */
	public FunctionStatement(int line, int col,String name, Statement sequence, List<Argument> formalArguments) {
		this.body =  sequence;
		this.name = name;
		/*
		for(String key : requiredArguments.keySet()){
			argumentTypes.add(requiredArguments.get(key).getIndex(), requiredArguments.get(key).getType());
		}
		*/	 //Store argument types in the order they appear in the given Map for validity checking.
		
		this.formalArguments = formalArguments; //List of variable names with types that contain their default value.
	}

	private Statement body;
	private String name;
	//private List<Type> argumentTypes = new ArrayList<Type>();
	private List<Argument> formalArguments;
	
	/**
	 * Returns the subStatements of this function.
	 * @return
	 */
	public Statement getBody() {
		return body;
	}
	
	public List<Argument> getFormalArguments(){
		return this.formalArguments;
	}
	
	public String getFunctionName(){
		return this.name;
	}
	/*
	public Map<String, Integer> getArguments() {
		Map<String,Integer> arguments = new HashMap<String,Integer>();
		for(String key : formalArguments.keySet()){
			arguments.put(key, formalArguments.get(key).getIndex());
		}
		return arguments;
	}
	*/
	/**
	 * @return True if the given argument types match the ones defined in this function definition.
	 */
	public boolean checkArguments(List<Argument> tocheck) {
		try {
			if (tocheck.size() != formalArguments.size())
				return false; // Argument counts do not match
			for (int i = 0; i < tocheck.size(); i++) {
				if (formalArguments.get(i).getType().getClass() != tocheck.get(i).getType().getClass())
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
