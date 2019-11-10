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
	private Direction direction;
	/**
	* Sets up the variables
	* @throws Exception
	*/
	@Before
	public void setUp() throws Exception {
		fox = new Fox(direction.NORTH, 1);
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
		assertEquals("Fox direction should be 'NORTH' for this fox.", direction.NORTH, fox.getDirection());
	}
	
	/**
	 * Tests getNumber method
	 */
	@Test
	public void testGetNumber() {
		assertEquals("Fox number should be 1", 1, fox.getNumber());
	}
	
	
	/**
	* Tests the toString method
	*/
	@Test
	public void testToString() {
		assertEquals("Should be 'Fox 1'.", "Fox 1", fox.toString());
	}
}
