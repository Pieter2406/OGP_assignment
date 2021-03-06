package persons;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.IllegalOwnerException;
import filters.BigIntegerExtractor;
import filters.FoodAmountExtractor;

import ownings.Car;
import ownings.Dog;
import ownings.Ownable;
import ownings.Painting;

public class PersonTest {

	private Person somePerson, personWithoutOwnings, personWithOwnings,
			terminatedPerson;

	private Ownable someOwnings[];

	private Ownable terminatedOwnable, ownableWithoutOwner;
	private static BigIntegerExtractor theExtractor;

	@BeforeClass public static void setUpBeforeClass() throws Exception {
		theExtractor = new FoodAmountExtractor();
	}

	@Before public void setUp() throws Exception {
		somePerson = new Person();
		personWithoutOwnings = new Person();
		personWithOwnings = new Person();
		terminatedPerson = new Person();
		terminatedPerson.terminate();
		someOwnings = new Ownable[3];
		someOwnings[0] = new Dog(personWithOwnings, BigInteger.ZERO, "Bobby",
			1000);
		someOwnings[1] = new Painting(personWithOwnings, BigInteger.ZERO,
			"Waterfront", new Person());
		someOwnings[2] = new Car(personWithOwnings, BigInteger.ONE, 1500);
		terminatedOwnable = new Dog("Bobby");
		terminatedOwnable.terminate();
		ownableWithoutOwner = new Painting("Water");
	}

	@Test public void testSingleCase() {
		Person thePerson = new Person();
		assertEquals(0, thePerson.getNbOwnings());
		assertFalse(thePerson.isTerminated());
	}

	@Test public void terminate_PersonWithoutOwnings() {
		personWithoutOwnings.terminate();
		assertTrue(personWithoutOwnings.isTerminated());
	}

	@Test public void terminate_PersonWithOwnings() {
		personWithOwnings.terminate();
		assertTrue(personWithOwnings.isTerminated());
		for (Ownable owning : someOwnings)
			assertFalse(owning.hasOwner());
	}

	@Test public void terminate_PersonAlreadyTerminated() {
		terminatedPerson.terminate();
		assertTrue(terminatedPerson.isTerminated());
	}

	@Test public void canHaveAsOwning_AcceptableOwnableOfOwner()
			throws Exception {
		Ownable owningOfSomePerson = new Dog(somePerson, BigInteger.TEN,
			"Bobby", 100);
		assertTrue(somePerson.canHaveAsOwning(owningOfSomePerson));
	}

	@Test public void canHaveAsOwning_AcceptableOwnableOfOtherPerson() {
		assertTrue(somePerson.canHaveAsOwning(someOwnings[0]));
	}

	@Test public void canHaveAsOwning_NonEffectiveOwnable() {
		assertFalse(somePerson.canHaveAsOwning(null));
	}

	@Test public void canHaveAsOwning_NonAcceptableOwnable() {
		someOwnings[0].terminate();
		assertFalse(somePerson.canHaveAsOwning(someOwnings[0]));
	}
	
	@Test public void canHaveAsOwningAt_LegalCase() {
		assertTrue(personWithOwnings.canHaveAsOwningAt(ownableWithoutOwner, 1));
	}
	
	@Test public void canHaveAsOwningAt_NonPositiveIndex() {
		assertFalse(somePerson.canHaveAsOwningAt(someOwnings[0], 0));
	}
	
	@Test public void canHaveAsOwningAt_IndexTooLarge() {
		assertFalse(somePerson.canHaveAsOwningAt(someOwnings[0], somePerson.getNbOwnings()+2));
	}
	
	@Test public void canHaveAsOwningAt_IllegalOwnable() {
		assertFalse(personWithOwnings.canHaveAsOwningAt(terminatedOwnable, 1));
	}
	
	@Test public void canHaveAsOwningAt_OwnableAlreadyAtOtherIndex() {
		assertFalse(personWithOwnings.canHaveAsOwningAt(personWithOwnings.getOwningAt(1), personWithOwnings.getNbOwnings()+1));
	}

	@Test public void hasProperOwnings_OwnerWithOwnings() {
	    assertTrue(personWithOwnings.hasProperOwnings());
	}
    
    @Test public void hasProperOwnings_OwnerWithoutOwnings() {
        assertTrue(personWithoutOwnings.hasProperOwnings());
    }

	// Case in which bindings are not consistent cannot be tested.

	@Test public void getNbOwnings_SingleCase() {
		assertEquals(someOwnings.length, personWithOwnings.getNbOwnings());
	}
	
	@Test public void getAllOwings_PersonWithoutOwnings() {
	    List<Ownable> result = personWithoutOwnings.getAllOwnings();
	    assertNotNull(result);
	    assertEquals(0,result.size());
	}
    
    @Test public void getAllOwings_PersonWitOwnings() {
        List<Ownable> result = personWithOwnings.getAllOwnings();
        assertNotNull(result);
        assertEquals(personWithOwnings.getNbOwnings(),result.size());
        for (int index=0; index<result.size(); index++)
            assertSame(personWithOwnings.getOwningAt(index+1),result.get(index));
    }

	@Test public void getTotalValue_LegalCase() throws Exception {
		Ownable ownings[] = new Ownable[3];
		ownings[0] = new Dog(somePerson, BigInteger.valueOf(500), "Bobby", 1000);
		ownings[1] = new Painting(somePerson, BigInteger.valueOf(6000),
			"Waterfront", new Person());
		ownings[2] = new Car(somePerson, BigInteger.valueOf(7500), 1500);
		assertEquals(BigInteger.valueOf(14000), somePerson.getTotalValue());
	}

	@Test(expected = IllegalStateException.class) public void getTotalValue_IllegalCase()
			throws Exception {
		terminatedPerson.getTotalValue();
	}

	@Test public void getTotalFoodAmount_LegalCase() throws Exception {
		Ownable[] ownings = new Ownable[5];
		ownings[0] = new Dog(somePerson, BigInteger.valueOf(500), "Bobby", 1000);
		ownings[1] = new Painting(somePerson, BigInteger.valueOf(6000),
			"Waterfront", new Person());
		ownings[2] = new Dog(somePerson, BigInteger.valueOf(500), "Bessy", 400);
		ownings[3] = new Car(somePerson, BigInteger.valueOf(7500), 1500);
		ownings[4] = new Dog(somePerson, BigInteger.valueOf(500), "Lassy", 100);
		assertEquals(BigInteger.valueOf(4500), somePerson.getTotalFoodAmount(3));
	}

	@Test(expected = IllegalArgumentException.class) public void getTotalFoodAmount_NegativeNumberOfDays()
			throws Exception {
		somePerson.getTotalFoodAmount(-1);
	}

	@Test(expected = IllegalStateException.class) public void getTotalFoodAmount_PersonAlreadyTerminated()
			throws Exception {
		terminatedPerson.getTotalFoodAmount(3);
	}

	@Test public void getMostPowerfulCar_LegalCase() throws Exception {
		Ownable[] ownings = new Ownable[6];
		ownings[0] = new Car(somePerson, BigInteger.valueOf(3500), 1000);
		ownings[1] = new Dog(somePerson, BigInteger.valueOf(500), "Bobby", 1000);
		ownings[2] = new Car(somePerson, BigInteger.valueOf(5500), 1200);
		ownings[3] = new Car(somePerson, BigInteger.valueOf(7500), 800);
		ownings[4] = new Painting(somePerson, BigInteger.valueOf(6000),
			"Waterfront", new Person());
		ownings[5] = new Car(somePerson, BigInteger.valueOf(7500), 1500);
		assertSame(ownings[5], somePerson.getMostPowerfulCar());
	}

	@Test(expected = NoSuchElementException.class) public void getMostPowerfulCar_IllegalCase()
			throws Exception {
		personWithoutOwnings.getMostPowerfulCar();
	}

	@Test(expected = IllegalStateException.class) public void getMostPowerfulCar_PersonAlreadyTerminated()
			throws Exception {
		terminatedPerson.getMostPowerfulCar();
	}

	public void getPaintingBy_LegalCase() throws Exception {
		Person thePainter = new Person();
		Ownable[] ownings = new Ownable[4];
		ownings[0] = new Painting(somePerson, BigInteger.valueOf(6000),
			"Waterfront", new Person());
		ownings[1] = new Dog(somePerson, BigInteger.valueOf(500), "Bobby", 1000);
		ownings[2] = new Painting(somePerson, BigInteger.valueOf(6000),
			"Landscape", new Person());
		ownings[3] = new Painting(somePerson, BigInteger.valueOf(6000),
			"Portrait", thePainter);
		assertSame(ownings[3], somePerson.getPaintingBy(thePainter));
	}

	@Test(expected = NoSuchElementException.class) public void getPaintingBy_PersonWithoutPaintingsByThePainter()
			throws Exception {
		personWithoutOwnings.getPaintingBy(somePerson);
	}

	@Test(expected = IllegalStateException.class) public void getPaintingBy_TerminatedPerson()
			throws Exception {
		terminatedPerson.getPaintingBy(somePerson);
	}
	
	@Test public void getTotalFor_LegalCase() throws Exception {
			Person thePerson = new Person();
			Ownable ownings[] = new Ownable[5];
			ownings[0] = new Dog(thePerson, BigInteger.valueOf(500), "Bobby", 1000);
			ownings[1] = new Painting(thePerson, BigInteger.valueOf(6000),
				"Waterfront", new Person());
			ownings[2] = new Dog(thePerson, BigInteger.valueOf(500), "Bessy", 400);
			ownings[3] = new Car(thePerson, BigInteger.valueOf(7500), 1500);
			ownings[4] = new Dog(thePerson, BigInteger.valueOf(500), "Lassy", 100);
			assertEquals(BigInteger.valueOf(1500), thePerson
				.getTotalFor(theExtractor));
	}

	@Test(expected=IllegalArgumentException.class) public void getTotalFor_NonEffectiveExtractor() throws Exception {
			somePerson.getTotalFor(null);
	}

	@Test(expected=IllegalStateException.class) public void getTotalFor_PersonAlreadyTerminated() throws Exception {
			terminatedPerson.getTotalFor(theExtractor);
	}
    
    @Test public void getTotalFrom_LegalCase() throws Exception {
            Person thePerson = new Person();
            Ownable ownings[] = new Ownable[5];
            ownings[0] = new Dog(thePerson, BigInteger.valueOf(500), "Bobby", 1000);
            ownings[1] = new Painting(thePerson, BigInteger.valueOf(6000),
                "Waterfront", new Person());
            ownings[2] = new Dog(thePerson, BigInteger.valueOf(500), "Bessy", 400);
            ownings[3] = new Car(thePerson, BigInteger.valueOf(7500), 1500);
            ownings[4] = new Dog(thePerson, BigInteger.valueOf(500), "Lassy", 100);
            assertEquals(BigInteger.valueOf(1500), thePerson
                .getTotalFrom(Dog.class.getMethod("getDailyFoodAmount")));
    }

    @Test public void getTotalFrom_NonEffectiveExtractor() throws Exception {
    	assertEquals(BigInteger.ZERO,somePerson.getTotalFrom(null));
    }

    @Test(expected=IllegalStateException.class) public void getTotalFrom_PersonAlreadyTerminated() throws Exception {
            terminatedPerson.getTotalFrom(Dog.class.getMethod("getDailyFoodAmount"));
    }

}
