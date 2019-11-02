package model;
/**
* Tests for the Mushroom class implementation
* @author Adela Tullio
*/
import static org.junit.Assert.*;

public class MushroomTest {

	private Mushroom mushroom;
	
	/**
	* Sets up the variables
	* @throws Exception
	*/
	@Before
	public void setUp() throws Exception {
		mushroom = new Mushroom();
	}
	
	/**
	* Tears down the variables
	* @throws Exception
	*/
	@After
	public void tearDown() throws Exception {
		mushroom = null;
	}
	/**
	* Tests the toString method in the Mushroom class
	*/
	@Test
	public void testToString() {
		assertEquals("Should be 'MS'.", "MS", mushroom.toString());
	}

}
