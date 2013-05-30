package asteroids.program.functions;

import java.util.ArrayList;
import java.util.List;

import asteroids.program.ProgramConstructor;
import asteroids.program.statements.SequenceStatement;
import asteroids.program.statements.Statement;

/**
 * Test for verifying the correct handling of functions in a program. This test is set up in such a way that a program that contains a function can be loaded onto a ship, without requiring the parser
 * to send the parsing information. The methods in the ProgramFactory are directly called for constructing in-memory representations.
 *
 */
public class FunctionTester {
	

	public static void loadFunction() {
		String name = "test";
		List<Argument> arguments = new ArrayList<Argument>();
		List<Argument> formalArguments = new ArrayList<Argument>();
		List<Statement> subStatements = new ArrayList<Statement>();
		Statement sequence = new SequenceStatement(0, 0, subStatements);
		
		
		ProgramConstructor c = new ProgramConstructor();
		c.createFunctionCall(0, 0, name,arguments);
		c.createFunctionStatement(1, 0, name, sequence, formalArguments);
	}
}
