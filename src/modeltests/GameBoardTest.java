package modeltests;
import model.*;
/**
* Tests for the GameBoard class implementation
* @author Adela Tullio
*/
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameBoardTest {
	
	private GameBoard gameboard;
	private Direction direction;
	private Mushroom mushroom;
	private Fox fox;
	private Rabbit rabbit;
	
	/**
	* Sets up the variables
	* @throws Exception
	*/
	@Before
	public void setUp() throws Exception {
		gameboard = new GameBoard();
		mushroom = new Mushroom();
		fox = new Fox(direction.NORTH, 1);
		rabbit = new Rabbit(RabbitColor.GREY);
	}
	
	/**
	* Tear down for the variables
	* @throws Exception
	*/
	@After
	public void tearDown() throws Exception {
		gameboard = null;
		rabbit = null;
		direction = null;
		mushroom = null;
		fox = null;
	}

	/**
	* Tests the ResetBoard method
	*/
	@Test
	public void testResetBoard() {
		gameboard.resetDefaultBoard();
		assertEquals("Expected 'BH'", "BH", gameboard.getHole(4, 4).toString());
		assertEquals("Expected '  '", "  ", gameboard.getHole(1, 2).toString());
		assertEquals("Expected 'RH'", "RH", gameboard.getHole(4, 2).toString());
	}
	
	/**
	 * Tests initializeBrownHoles method
	 */
	@Test
	public void testInitializeBrownHole() {
		gameboard.initializeBrownHole(2, 2);
		assertEquals("Expected 'BH'", "BH", gameboard.getHole(2, 2).toString());
	}
	
	/**
	 * Tests initializeRaisedHole method
	 */
	@Test
	public void testInitializeRaisedHole() {
		gameboard.initializeRaisedHole(2, 2);
		assertEquals("Expected 'RH'", "RH", gameboard.getHole(2, 2).toString());
	}
	
	/**
	* Tests the addPiece method with mushrooms specifically
	*/
	@Test
	public void testAddingMushroomPiece() {
		gameboard.addPiece(mushroom, 2, 1);
		assertEquals("Expecting 'MS' in column 2, row 2", "MS", gameboard.getHole(2, 1).toString());
	}
	
	/**
	* Tests the addPiece method with fox pieces specifically
	*/
	@Test
	public void testAddingFoxPiece() {
		gameboard.addPiece(fox, 3, 2);
		assertEquals("Expecting 'F1'", "F1", gameboard.getHole(3, 2).toString());
	}
	
	/**
	* Tests the addPiece method with rabbit pieces specifically
	*/
	@Test
	public void testAddingRabbitPiece() {
		gameboard.addPiece(rabbit, 0, 2);
		assertEquals("Expecting 'GR'", "GR", gameboard.getHole(0,  2).toString());
	}
	
	/**
	* Tests the moveFoxPiece method
	*/
	@Test
	public void testMoveFoxPiece() {
		gameboard.addPiece(fox, 3, 2);
		gameboard.moveFoxPiece(fox, Direction.NORTH);
		assertEquals("Expecting 'Fox 1'", "Fox 1", gameboard.getHole(3, 0).toString());
	}
	
	/**
	* Tests the moveRabbitPiece method
	*/
	@Test
	public void testMoveRabbitPiece() {
		gameboard.addPiece(mushroom, 1, 2);
		gameboard.addPiece(rabbit, 0, 2);
		gameboard.moveRabbitPiece(rabbit, Direction.EAST);
		assertEquals("Expecting 'Grey Rabbit'.", "Grey Rabbit", gameboard.getHole(2, 2).toString());
	}
	
	/**
	* Tests the isFinished method
	*/
	@Test
	public void testIsFinished() {
		Rabbit rabbit2 = new Rabbit(RabbitColor.BROWN);
		Rabbit rabbit3 = new Rabbit(RabbitColor.WHITE);
		gameboard.addPiece(rabbit, 0, 0);
		gameboard.addPiece(rabbit2, 4, 0);
		gameboard.addPiece(rabbit3, 0, 4);
		assertEquals("Expecting a value true.", true, gameboard.isFinished());
	}
}	
