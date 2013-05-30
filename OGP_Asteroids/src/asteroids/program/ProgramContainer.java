package asteroids.program;

import java.util.Map;

import asteroids.program.functions.FunctionStatement;
import asteroids.program.types.Type;
import asteroids.studentdefined.Program;
import asteroids.studentdefined.Ship;

public class ProgramContainer {

	private static Program program;
	private static Ship nullShip = new Ship(0,0,0,0,0,null);
	private static final String DEFAULT_SCOPE = "DEFAULT_SCOPE";
	public static String scope;
	public static void setProgram(Program program){
		ProgramContainer.program = program;
		ProgramContainer.scope = DEFAULT_SCOPE;
	}
	public static Program getProgram(){
		return program;
	}
	public static Map<String,Type> getGlobals(){
		if(program != null){
			return program.getGlobals();
		}else{
			return null;
		}
	}
	public static Map<String,FunctionStatement> getFunctions(){
		if(program != null){
			return program.getFunctions();
		}else{
			return null;
		}
	}
	public static Type getGlobal(String name){
		if(!scope.equals(DEFAULT_SCOPE)){
			return program.getLocals().get(scope).get(name);
		}else{
			return program.getGlobals().get(name);
		}
		
	}
	public static void setGlobal(String name, Type type){
		if(getGlobals() != null){
			 getGlobals().put(name, type);
		}
	}
	public static Ship getNullShip(){
		return nullShip;
	}
	
	public static void addFunctionLocals(String functionName, Map<String, Type> locals) {
		program.getLocals().put(functionName, locals);
	}
	
}
