package modeltests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.MoveAction;
import model.Rabbit;
import model.RabbitColor;
import model.Direction;

/**
 * Test class for the MoveAction class implementation
 * @author Adela Tullio
 *
 */
public class MoveActionTest {
	private MoveAction moveAction;
	private Rabbit rabbit;
	
	/**
	* Sets up the variables
	* @throws Exception
	*/
	@Before
	public void setUp() throws Exception {
		rabbit = new Rabbit(RabbitColor.WHITE);
		moveAction = new MoveAction(rabbit, Direction.SOUTH);
	}
	
	/**
	* Tear down for the variables
	* @throws Exception
	*/
	@After
	public void tearDown() throws Exception {
		rabbit = null;
		moveAction = null;
	}
	
	/**
	 * tests the getDirection method
	 */
	@Test
	public void testGetDirection() {
		assertEquals("Expected output to be SOUTH", Direction.SOUTH, moveAction.getDirection());
	}
	
	/**
	 * tests the getPiece method
	 */
	@Test
	public void testGetPiece() {
		assertEquals("Expected output to be 'White Rabbit'", "White Rabbit", moveAction.getPiece().toString());
	}

}
