package modeltests;
import model.*;
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
	private Mushroom mushroom;
	
	
	/**
	* Set up method for variables
	* @throws Exception
	*/
	@Before
	public void setUp() throws Exception {
		hole = new Hole();
		mushroom = new Mushroom();
	}
	
	/**
	* Tear down method for variables
	* @throws Exception
	*/
	@After
	public void tearDown() throws Exception {
		hole = null;
		mushroom = null;
	}
	
	/**
	 * Tests the setIsOccupied method
	 */
	@Test
	public void testSetIsOccupied() {
		hole.setIsOccupied(false);
		assertEquals("Expecting 'false'", false, hole.isOccupied());
	}
	
	/**
	 * Tests the getIsOccupied method
	 */
	@Test
	public void testGetIsOccupied() {
		assertEquals("Expecting 'false' upon initiating", false, hole.isOccupied());
	}
	
	/**
	 * Tests the setPiece method
	 */
	@Test
	public void testSetPiece() {
		hole.setPiece(mushroom);
		assertEquals("Expecting 'true' that hole is occupied", true, hole.isOccupied());
	}
	
	/**
	 * Tests the getPiece method
	 */
	@Test
	public void testGetPiece() {
		hole.setPiece(mushroom);
		assertEquals("Expecting 'mushroom'", mushroom, hole.getPiece());
	}
	
	/**
	 * Test the removePiece method
	 * with special case Mushroom
	 */
	@Test
	public void testRemoveMushroomPiece() {
		hole.setPiece(mushroom);
		hole.removePiece(mushroom);
		assertEquals("Expecting 'true' as you cannot remove a mushroom", true, hole.isOccupied());
	}
	
	/**
	 * Test the removePiece method
	 * with a regular rabbit
	 */
	@Test
	public void testRemoveRabbitPiece() {
		Rabbit rabbit = new Rabbit(RabbitColor.GREY);
		hole.setPiece(rabbit);
		hole.removePiece(rabbit);
		assertEquals("Expecting 'false' as the space is free after removal", false, hole.isOccupied());
	}
	
	/**
	* Tests the toString method within Hole
	*/
	@Test
	public void testToStringEmptyHole() {
		assertEquals("Should be '  '", "  ", hole.toString());
	}
	
	/**
	 * Tests the toString method
	 * if it is occupied
	 */
	@Test
	public void testToStringOccupiedHole() {
		hole.setPiece(mushroom);
		assertEquals("Should be 'MS'", "MS", hole.toString());
	}

}
