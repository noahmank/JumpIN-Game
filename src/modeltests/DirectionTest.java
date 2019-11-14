package modeltests;

import static org.junit.Assert.*;

import org.junit.Test;
import model.Direction;

/**
 * Test class for the Direction Enumeration class
 * @author Adela Tullio
 *
 */
public class DirectionTest {

	/**
	 * Tests getting the X coordinate for the directions
	 */
	@Test
	public void testGetXDirection() {
		assertEquals("Expected to be 0.", 0, Direction.NORTH.getX());
		assertEquals("Expected to be 1.", 1, Direction.EAST.getX());
		assertEquals("Expected to be 0.", 0, Direction.SOUTH.getX());
		assertEquals("Expected to be -1.", -1, Direction.WEST.getX());
	}
	
	/**
	 * Tests getting the Y coordinate for the directions
	 */
	@Test
	public void testGetYDirection() {
		assertEquals("Expected to be -1.", -1, Direction.NORTH.getY());
		assertEquals("Expected to be 0.", 0, Direction.EAST.getY());
		assertEquals("Expected to be 1.", 1, Direction.SOUTH.getY());
		assertEquals("Expected to be 0.", 0, Direction.WEST.getY());
	}
	
	/**
	 * Tests getting the src value of the directions
	 */
	@Test
	public void testGetSrc() {
		assertEquals("Expected to be 'upArrow.png'", "upArrow.png", Direction.NORTH.getSrc());
		assertEquals("Expected to be 'rightArrow.png'", "rightArrow.png", Direction.EAST.getSrc());
		assertEquals("Expected to be 'downArrow.png'", "downArrow.png", Direction.SOUTH.getSrc());
		assertEquals("Expected to be 'leftArrow.png'", "leftArrow.png", Direction.WEST.getSrc());
	}
	
	/**
	 * Tests getting the opposite direction of the directions
	 */
	@Test
	public void testgetOpposite() {
		assertEquals("Expected to be SOUTH", Direction.SOUTH, Direction.NORTH.getOpposite());
		assertEquals("Expected to be WEST", Direction.WEST, Direction.EAST.getOpposite());
		assertEquals("Expected to be NORTH", Direction.NORTH, Direction.SOUTH.getOpposite());
		assertEquals("Expected to be EAST", Direction.EAST, Direction.WEST.getOpposite());
	}

}
