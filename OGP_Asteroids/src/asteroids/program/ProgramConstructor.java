package asteroids.program;

import java.util.List;

import asteroids.model.programs.parsing.ProgramFactory;
import asteroids.program.actions.*;
import asteroids.program.expression.*;
import asteroids.program.expression.binary.*;
import asteroids.program.expression.property.*;
import asteroids.program.expression.unary.*;
import asteroids.program.single.*;
import asteroids.program.types.*;


public class ProgramConstructor implements ProgramFactory<Expression, Statement, Type> {

	public ProgramConstructor(){
		
	}

	@Override
	public Expression createDoubleLiteral(int line, int column, double d) {
		return new LiteralDoubleExpression(line,column,d);
	}

	@Override
	public Expression createBooleanLiteral(int line, int column, boolean b) {
		return new LiteralBooleanExpression(line,column,b);
	}

	@Override
	public Expression createAnd(int line, int column, Expression e1, Expression e2) {
		return new Conjunction(line,column,e1,e2);
	}

	@Override
	public Expression createOr(int line, int column, Expression e1, Expression e2) {
		return new Disjunction(line,column,e1,e2);
	}

	@Override
	public Expression createNot(int line, int column, Expression e) {
		return new Not(line,column,e);
	}

	@Override
	public Expression createNull(int line, int column) {
		return new EntityExpression(line,column);
	}

	@Override
	public Expression createSelf(int line, int column) {
		return null;
	}

	@Override
	public Expression createGetX(int line, int column, Expression e) {
		return new GetX(line,column, e);
	}

	@Override
	public Expression createGetY(int line, int column, Expression e) {
		return new GetY(line, column, e);
	}

	@Override
	public Expression createGetVX(int line, int column, Expression e) {
		return new GetVx(line, column,e);
	}

	@Override
	public Expression createGetVY(int line, int column, Expression e) {
		return new GetVy(line,column,e);
	}

	@Override
	public Expression createGetRadius(int line, int column, Expression e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression createVariable(int line, int column, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression createLessThan(int line, int column, Expression e1, Expression e2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression createGreaterThan(int line, int column, Expression e1, Expression e2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression createLessThanOrEqualTo(int line, int column, Expression e1, Expression e2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression createGreaterThanOrEqualTo(int line, int column, Expression e1, Expression e2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression createEquality(int line, int column, Expression e1, Expression e2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression createInequality(int line, int column, Expression e1, Expression e2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression createAdd(int line, int column, Expression e1, Expression e2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression createSubtraction(int line, int column, Expression e1, Expression e2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression createMul(int line, int column, Expression e1, Expression e2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression createDivision(int line, int column, Expression e1, Expression e2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression createSqrt(int line, int column, Expression e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression createGetDirection(int line, int column) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression createSin(int line, int column, Expression e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression createCos(int line, int column, Expression e) {
		// TODO Auto-generated method stub
		return null;
	}

	/*___________________________________________________________________*/
	
	@Override
	public Statement createEnableThruster(int line, int column) {
		return new ThrusterOnAction(line,column);
	}

	@Override
	public Statement createDisableThruster(int line, int column) {
		return new ThrusterOffAction(line,column);
	}

	@Override
	public Statement createFire(int line, int column) {
		ActionStatement shoot = new ShootAction(line, column); 
		return shoot;
	}

	@Override
	public Statement createTurn(int line, int column, Expression angle) {
		return new TurnAction(line, column, angle);
	}

	@Override
	public Statement createAssignment(int line, int column, String variable, Expression rhs) {
		return new AssignmentSingleStatement(line,column,variable,rhs);
	}

	@Override
	public Statement createIf(int line, int column, Expression condition, Statement then, Statement otherwise) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement createWhile(int line, int column, Expression condition, Statement body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement createForeach(int line, int column,
			asteroids.model.programs.parsing.ProgramFactory.ForeachType type,
			String variableName, Statement body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement createSkip(int line, int column) {
		return new SkipAction(line,column);
	}

	@Override
	public Statement createSequence(int line, int column, List<Statement> statements) {
		return new SequenceStatement(line,column,statements);
	}

	@Override
	public Statement createPrint(int line, int column, Expression e) {
		return new PrintSingleStatement(line,column,e);
	}

	@Override
	public Type createDoubleType() {
		return new DoubleType();
	}

	@Override
	public Type createBooleanType() {
		return new BooleanType();
	}

	@Override
	public Type createEntityType() {
		return new EntityType();
	}

}
