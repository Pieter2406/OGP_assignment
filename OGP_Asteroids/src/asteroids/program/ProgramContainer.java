package asteroids.program;

import java.util.HashMap;
import java.util.Map;

import asteroids.program.types.Type;
import asteroids.studentdefined.Program;

public class ProgramContainer {

	private static Program program;
	
	public static void setProgram(Program program){
		ProgramContainer.program = program;
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
	public static Type getGlobal(String name){
		if(getGlobals() == null){
			return null;
		}else{
			return getGlobals().get(name);
		}
		
	}
	public static void setGlobal(String name, Type type){
		if(getGlobals() != null){
			 getGlobals().put(name, type);
		}
	}
}
