package modeltests;
import model.*;
/**
* Tests for the Fox class implementation
* @author Adela Tullio
*/
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FoxTest {
	private Fox fox;

	/**
	* Sets up the variables
	* @throws Exception
	*/
	@Before
	public void setUp() throws Exception {
		fox = new Fox(Direction.NORTH, 1);
	}
	
	/**
	* Tear down for the variables
	* @throws Exception
	*/
	@After
	public void tearDown() throws Exception {
		fox = null;
	}
	
	/**
	 * Tests getDirection method
	 */
	@Test
	public void testGetDirection() {
		assertEquals("Fox direction should be 'NORTH' for this fox.", Direction.NORTH, fox.getDirection());
	}	
	
	/**
	 * Tests getNumber method
	 */
	@Test
	public void testGetNumber() {
		assertEquals("Fox number should be 1", 1, fox.getNumber());
	}
	
	/**
	 * tests getting the image for the foxes
	 */
	@Test
	public void testGetSRC() {
		assertEquals("Expecting 'fox.png'", "fox.png", fox.getSrc());
	}
	
	/**
	* Tests the toString method
	*/
	@Test
	public void testToString() {
		assertEquals("Should be 'Fox 1'.", "Fox 1", fox.toString());
	}
	
	
	/**
	 * Test equals method with different foxes
	 */
	@Test
	public void testEqualsMethodWithDifferentFoxes() {
		Fox fox2 = new Fox(Direction.SOUTH, 2);
		assertEquals("Should be 'false'", false, fox.equals(fox2));
	}
	
	/**
	 * Test equals method with foxes 
	 * containing same values
	 */
	@Test
	public void testEqualsMethodWithSameFoxes() {
		Fox fox2 = new Fox(Direction.NORTH, 1);
		assertEquals("Should be 'true'", true, fox.equals(fox2));
	}
	
	/**
	 * Test equals method with
	 * objects of different classes
	 */
	@Test
	public void testEqualsMethodWithDifferentObjects() {
		Mushroom mushroom = new Mushroom();
		assertEquals("Should be 'false'", false, fox.equals(mushroom));
	}

}
