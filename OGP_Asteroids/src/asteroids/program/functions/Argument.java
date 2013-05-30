package asteroids.program.functions;

import asteroids.program.types.Type;

public class Argument {

	private final int index;
	private final Type type;
	private final String name;
	public Argument(String name, Type type, int index) {
		this.index = index;
		this.type = type;
		this.name = name;
	}
	public Argument(Type type, int index){
		this("",type,index);
	}
	public Argument(String name,int index){
		this(name,null,index);
	}

	public int getIndex() {
		return index;
	}
	public Type getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return type + " " + name;
	}


}
