package model;
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
	* Tests the toString method
	*/
	@Test
	public void testToString() {
		assertEquals("Should be 'F1'.", "F1", fox.toString());
	}
}
