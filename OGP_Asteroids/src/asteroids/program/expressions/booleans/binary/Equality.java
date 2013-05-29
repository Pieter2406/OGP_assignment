package asteroids.program.expressions.booleans.binary;

import asteroids.program.expressions.Expression;
import asteroids.program.expressions.booleans.BinaryComposedBooleanExpression;
import asteroids.program.expressions.booleans.ComposedBooleanExpression;
import asteroids.program.types.BooleanType;
import asteroids.program.types.DoubleType;
import asteroids.program.types.EntityType;
import asteroids.studentdefined.SpaceObject;

public class Equality extends BinaryComposedBooleanExpression {

	public Equality(int line, int column, Expression lhs, Expression rhs) {
		super(line, column, lhs, rhs);
	}

	@Override
	public BooleanType getType() {
		if(lhs.getType() instanceof EntityType || rhs.getType() instanceof EntityType){
			boolean isEqual = ((SpaceObject)lhs.getType().getValue()).equals((SpaceObject) rhs.getType().getValue());
			return new BooleanType(isEqual);
		}else if(lhs.getType() instanceof DoubleType || rhs.getType() instanceof DoubleType){
			return new BooleanType((double)lhs.getType().getValue() == (double)rhs.getType().getValue());
		}else{
			return new BooleanType(false);
		}
	}

}
