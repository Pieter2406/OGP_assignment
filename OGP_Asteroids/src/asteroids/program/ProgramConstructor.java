package asteroids.program;

import java.util.List;


import asteroids.model.programs.parsing.ProgramFactory;
import asteroids.program.expressions.*;
import asteroids.program.expressions.booleans.BooleanExpression;
import asteroids.program.expressions.booleans.LiteralBooleanExpression;
import asteroids.program.expressions.booleans.binary.Conjunction;
import asteroids.program.expressions.booleans.binary.Disjunction;
import asteroids.program.expressions.booleans.binary.Equality;
import asteroids.program.expressions.booleans.binary.GreaterThan;
import asteroids.program.expressions.booleans.binary.GreaterThanOrEqualTo;
import asteroids.program.expressions.booleans.binary.InEquality;
import asteroids.program.expressions.booleans.binary.LessThan;
import asteroids.program.expressions.booleans.binary.LessThanOrEqualTo;
import asteroids.program.expressions.booleans.unary.Not;
import asteroids.program.expressions.doubles.LiteralDoubleExpression;
import asteroids.program.expressions.doubles.binary.*;
import asteroids.program.expressions.doubles.property.*;
import asteroids.program.expressions.doubles.unary.*;
import asteroids.program.expressions.entities.SelfEntityExpression;
import asteroids.program.statements.SequenceStatement;
import asteroids.program.statements.Statement;
import asteroids.program.statements.loops.ForEachLoopStatement;
import asteroids.program.statements.loops.WhileLoopStatement;
import asteroids.program.statements.single.*;
import asteroids.program.statements.single.actions.*;
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
		return new SelfEntityExpression(line,column);
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
		return new GetRadius(line, column, e);
	}

	@Override
	public Expression createVariable(int line, int column, String name) {
		return new VariableExpression(line,column,name);
	}

	@Override
	public Expression createLessThan(int line, int column, Expression e1, Expression e2) {
		return new LessThan(line,column,e1,e2);
	}

	@Override
	public Expression createGreaterThan(int line, int column, Expression e1, Expression e2) {
		return new GreaterThan(line,column,e1,e2);
	}

	@Override
	public Expression createLessThanOrEqualTo(int line, int column, Expression e1, Expression e2) {
		return new LessThanOrEqualTo(line,column,e1,e2);
	}

	@Override
	public Expression createGreaterThanOrEqualTo(int line, int column, Expression e1, Expression e2) {
		return new GreaterThanOrEqualTo(line,column,e1,e2);
	}

	@Override
	public Expression createEquality(int line, int column, Expression e1, Expression e2) {
		return new Equality(line,column,e1,e2);
	}

	@Override
	public Expression createInequality(int line, int column, Expression e1, Expression e2) {
		return new InEquality(line,column,e1,e2);
	}

	@Override
	public Expression createAdd(int line, int column, Expression e1, Expression e2) {
		return new Addition(line, column, e1, e2);
	}

	@Override
	public Expression createSubtraction(int line, int column, Expression e1, Expression e2) {
		return new Subtraction(line, column, e1, e2);
	}

	@Override
	public Expression createMul(int line, int column, Expression e1, Expression e2) {
		return new Multiplication(line, column, e1, e2);
	}

	@Override
	public Expression createDivision(int line, int column, Expression e1, Expression e2) {
		return new Division(line, column, e1, e2);
	}

	@Override
	public Expression createSqrt(int line, int column, Expression e) {
		return new Sqrt(line,column,e);
	}

	@Override
	public Expression createGetDirection(int line, int column) {
		return new getDirection(line,column);
	}

	@Override
	public Expression createSin(int line, int column, Expression e) {
		return new Sin(line,column,e);
	}

	@Override
	public Expression createCos(int line, int column, Expression e) {
		return new Cos(line,column,e);
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
		return new AssignmentStatement(line,column,variable,rhs);
	}

	@Override
	public Statement createIf(int line, int column, Expression condition, Statement then, Statement otherwise) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement createWhile(int line, int column, Expression condition, Statement body) {
		return new WhileLoopStatement(line, column, condition, body);
	}

	@Override
	public Statement createForeach(int line, int column, asteroids.model.programs.parsing.ProgramFactory.ForeachType type,
			String variableName, Statement body) {
		return new ForEachLoopStatement(line, column,type,variableName,body);
		
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
