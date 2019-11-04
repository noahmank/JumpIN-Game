package model;
/**
* Tests for the BrownHole class 
* @author Adela Tullio
*
*/
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BrownHoleTest {
	private BrownHole bh;
	
	/**
	* Sets up the variables
	* @throws Exception 
	*/
	@Before
	public void setUp() throws Exception {
		bh = new BrownHole();
	}
	
	/**
	* Tear down method
	* @throws Exception
	*/
	@After
	public void tearDown() throws Exception {
		bh = null;
	}
	
	/**
	* Tests the toString method
	*/
	@Test
	public void testToString() {
		assertEquals("String should be 'BH'.", "BH", bh.toString());
	}
}
