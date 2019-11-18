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
	private MoveAction move;
	
	/**
	* Sets up the variables
	* @throws Exception
	*/
	@Before
	public void setUp() throws Exception {
		rabbit = new Rabbit(RabbitColor.WHITE);
		moveAction = new MoveAction(rabbit, Direction.SOUTH);
		move = new MoveAction(rabbit, Direction.SOUTH);
	}
	
	/**
	* Tear down for the variables
	* @throws Exception
	*/
	@After
	public void tearDown() throws Exception {
		rabbit = null;
		moveAction = null;
		move = null;
	}
	
	/**
	 * tests alternate constructor
	 */
	@Test
	public void testAlternateConstructor() {
		move = new MoveAction(moveAction);
		assertEquals("Expecting these to be the same", moveAction, move);
	}
	
	/**
	 * tests getOppositeMove
	 */
	@Test
	public void testOppositeMove() {
		move = moveAction.getOppositeMove();
		MoveAction move2 = new MoveAction(rabbit, Direction.NORTH);
		assertEquals("Expecting the rabbit to be NORTH", move2, move);
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
	
	/**
	 * tests the tostring implementation
	 */
	@Test
	public void testToString() {
		assertEquals("Expecting '(White Rabbit, South)'", "(White Rabbit, South)", moveAction.toString());
	}
	
	/**
	 * tests equals method with same coloured rabbits,
	 * different directions
	 */
	@Test
	public void testEqualsMethodSameRabbitDifferentDirection() {
		move = moveAction.getOppositeMove();
		assertEquals("Expecting false", false, moveAction.equals(move));
	}
	
	/**
	 * tests equals method with same coloured rabbits,
	 * same direction
	 */
	@Test
	public void testEqualsMethodSameRabbitsSameDirection() {
		move = new MoveAction(rabbit, Direction.SOUTH);
		assertEquals("Expecting true", true, moveAction.equals(move));
	}
	
	/**
	 * tests equals method with different rabbits,
	 * same direction
	 */
	@Test
	public void testEqualsMethodDifferentRabbitsSameDirection() {
		Rabbit rabbit2 = new Rabbit(RabbitColor.GREY);
		move = new MoveAction(rabbit2, Direction.SOUTH);
		assertEquals("Expecting false", false, moveAction.equals(move));
	}

}

