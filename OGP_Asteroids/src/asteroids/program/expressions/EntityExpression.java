package asteroids.program.expressions;

import asteroids.program.types.EntityType;


public class EntityExpression extends Expression{
	private EntityType entity;
	public EntityExpression(int line, int column, EntityType entity) {
		super(line,column);
		this.entity = entity;
	}
	public EntityExpression(int line, int column){
		super(line,column);
		this.entity = null;
	}
	
	@Override
	public EntityType getType(){
		return entity;
	}
	
}


