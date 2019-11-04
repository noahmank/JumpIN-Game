package model;
/**
* Tests the Hole class implementation
* @author Adela Tullio
*/
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HoleTest {
	private Hole hole;
	
	/**
	* Set up method for variables
	* @throws Exception
	*/
	@Before
	public void setUp() throws Exception {
		hole = new Hole();
	}
	
	/**
	* Tear down method for variables
	* @throws Exception
	*/
	@After
	public void tearDown() throws Exception {
		hole = null;
	}
	
	/**
	* Tests the toString method within Hole
	*/
	@Test
	public void testToString() {
		assertEquals("Should be '  '", "  ", hole.toString());
	}

}
