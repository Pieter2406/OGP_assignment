package expressions;

import static org.junit.Assert.*;

import org.junit.*;

public class UnaryExpressionTest {

	private static UnaryExpression someUnaryExpression;

	@BeforeClass public static void setUpBeforeClass() throws Exception {
		someUnaryExpression = new Negation(new IntegerLiteral(1));
	}

	@Test public void getNbOperands_SingleCase() {
		assertEquals(1, someUnaryExpression.getNbOperands());
	}

	@Test public void getOperandAt_LegalCase() throws Exception {
		Expression operand = new IntegerLiteral(10);
		UnaryExpression theUnaryExpression = new Negation(operand);
		assertSame(operand, theUnaryExpression.getOperandAt(1));
	}

	@Test(expected = IndexOutOfBoundsException.class) public void getOperandAt_IndexTooLow()
			throws Exception {
		someUnaryExpression.getOperandAt(0);
	}

	@Test(expected = IndexOutOfBoundsException.class) public void getOperandAt_IndexTooHigh() {
		someUnaryExpression.getOperandAt(2);
	}
	@Test public void canHaveAsOperandAt_TrueCase() {
		assertTrue(someUnaryExpression.canHaveAsOperandAt(new IntegerLiteral(10),1));
	}
	
	@Test public void canHaveAsOperandAt_NonEffectiveOperand() {
		assertFalse(someUnaryExpression.canHaveAsOperandAt(null,1));
	}
	
	@Test public void canHaveAsOperand_CyclicOperand() throws Exception {
		ComposedExpression moreComposedExpression = new Addition(someUnaryExpression,new IntegerLiteral(50));
		assertFalse(someUnaryExpression.canHaveAsOperandAt(moreComposedExpression,1));
	}
	
	@Test public void canHaveAsOperandAt_NonPositiveIndex() {
		assertFalse(someUnaryExpression.canHaveAsOperandAt(new IntegerLiteral(12),0));
	}
		
	@Test public void canHaveAsOperandAt_IndexTooHigh() {
		assertFalse(someUnaryExpression.canHaveAsOperandAt(new IntegerLiteral(12),2));
	}

	@Test public void setOperandAt_SingleCase() throws Exception {
		Expression newOperand = new IntegerLiteral(20);
		someUnaryExpression.setOperandAt(1, newOperand);
		assertSame(newOperand, someUnaryExpression.getOperandAt(1));
	}

	@Test public void toString_SimpleExpression() throws Exception {
		UnaryExpression simpleExpression = new Negation(new IntegerLiteral(10));
		assertEquals("-10", simpleExpression.toString());
	}

	@Test public void toString_ComposedExpression() throws Exception {
		UnaryExpression composedExpression = new Negation(new Negation(
			new IntegerLiteral(20)));
		assertEquals("-(-20)", composedExpression.toString());
	}

}
