package asteroids.program.expressions;

import asteroids.program.types.EntityType;


public class EntityExpression extends Expression{
	public EntityExpression(int line, int column, EntityType entity) {
		super(line,column);
		this.type = entity;
	}
	
	@Override
	public EntityType getType(){
		return (EntityType) this.type;
	}
	
}


