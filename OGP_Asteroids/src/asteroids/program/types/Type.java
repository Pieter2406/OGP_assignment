package asteroids.program.types;

public abstract class Type<Value> {
	protected Value value;
	
	protected Type() {
	}
	protected Type(Value value){
		this.value = value;
	}
	
	public Value getValue(){
		return value;
	}
	public void setValue(Value value){
		this.value = value;
	}
	
	@Override
	public String toString(){
		return value.toString();
	}
}
