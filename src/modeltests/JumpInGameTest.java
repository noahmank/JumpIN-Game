package modeltests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.*;

/**
 * Test class to test the implementation of JumpInGame
 * @author Adela Tullio
 *
 */

public class JumpInGameTest {
	private JumpInGame game;
	private GameBoard board;
	private Mushroom mushroom;
	private Rabbit rabbit;
	private Fox fox;
	
	/**
	 * Sets up variables for tests
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		game = new JumpInGame();
		board = game.getBoard();
		mushroom = new Mushroom();
		rabbit = new Rabbit(RabbitColor.GREY);
		fox = new Fox(Direction.NORTH, 1);
	}
	
	/**
	 * Tears down variables for tests
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		game = null;
	}
	
	/**
	 * Tests the movePiece method
	 */
	@Test
	public void testMovePiece() {
		game.addPieceToBoard(rabbit, 3, 0);
		game.addPieceToBoard(mushroom, 3, 1);
		game.movePiece(rabbit, Direction.SOUTH);
		assertEquals("Expected grey rabbit at this location", "Grey Rabbit", board.getHole(3, 2).toString());
	}
	
	/**
	 * Test movePiece method by moving a piece to an occupied spot
	 */
	@Test
	public void testMovePieceToInvalidSpot() {
		game.addPieceToBoard(rabbit, 3, 0);
		game.addPieceToBoard(mushroom, 3, 1);
		game.addPieceToBoard(mushroom, 3, 2);
		game.movePiece(rabbit, Direction.SOUTH);
		assertEquals("Expected mushroom at this location", "MS", board.getHole(3, 2).toString());
	}
	
	/**
	 * Test movePiece method by moving a piece to an out of bounds spot
	 */
	@Test 
	public void testMovePieceOutOfBounds() {
		game.addPieceToBoard(rabbit, 3, 1);
		game.addPieceToBoard(mushroom, 3, 0);
		game.movePiece(rabbit, Direction.NORTH);
		assertEquals("Expecting Rabbit in the same spot", "Grey Rabbit", board.getHole(3, 1).toString());
	}
	
	/**
	 * Tests addNewPieceToBoard method
	 * with a mushroom
	 */
	@Test
	public void testAddNewMushroomToBoard() {
	   game.addPieceToBoard(mushroom, 2, 1);
	   assertEquals("Expected Mushroom at (2, 1).", mushroom.toString(), board.getHole(2, 1).toString());
	}
	
	/**
	 * Tests challenge method
	 * with challenge one
	 */
	@Test
	public void testChallengeOne() {
		game.setSelectedChallenge(1);
		game.startChallenge();
		assertEquals("Expected Mushroom at (3, 1)", "MS", board.getHole(3, 1).toString());
		assertEquals("Expected Mushroom at (2, 4)", "MS", board.getHole(2, 4).toString());
		assertEquals("Expected Grey Rabbit at (3, 0)", "Grey Rabbit", board.getHole(3, 0).toString());
		assertEquals("Expected White Rabbit at (4, 2)", "White Rabbit", board.getHole(4, 2).toString());
		assertEquals("Expected Brown Rabbit at (1, 4)", "Brown Rabbit", board.getHole(1, 4).toString());
		assertEquals("Expected Fox 1 at (1, 0)", "Fox 1", board.getHole(1, 0).toString());
		assertEquals("Expected Fox 2 at (3, 3)", "Fox 2", board.getHole(3, 3).toString());	
	}
	
	/**
	 * Tests undo method
	 */
	@Test
	public void testUndo() {
		Fox fox = new Fox(Direction.EAST, 1);
		game.addPieceToBoard(rabbit, 3, 0);
		game.addPieceToBoard(mushroom, 3, 1);
		game.addPieceToBoard(fox, 3, 3);
		game.movePiece(rabbit, Direction.SOUTH);
		game.movePiece(rabbit, Direction.SOUTH);
		game.undoMoveAction();
		assertEquals("Expecting Grey Rabbit at (3, 2)", "Grey Rabbit", board.getHole(3, 2).toString());
	}
	
	/**
	 * Tests redo method
	 */
	@Test
	public void testRedo() {
		Fox fox = new Fox(Direction.EAST, 1);
		game.addPieceToBoard(rabbit, 3, 0);
		game.addPieceToBoard(mushroom, 3, 1);
		game.addPieceToBoard(fox, 3, 3);
		game.movePiece(rabbit, Direction.SOUTH);
		game.movePiece(rabbit, Direction.SOUTH);
		game.undoMoveAction();
		game.undoMoveAction();
		game.redoMoveAction();
		assertEquals("Expecting Grey Rabbit at (3, 2)", "Grey Rabbit", board.getHole(3, 2).toString());
		game.redoMoveAction();
		assertEquals("Expecting Grey Rabbit at (3, 4)", "Grey Rabbit", board.getHole(3, 4).toString());
	}
	
	/**
	 * Test setPiece method
	 */
	@Test
	public void testSetPiece() {
		game.setPiece(rabbit);
		assertEquals("Expecting Grey Rabbit", "Grey Rabbit", game.getPiece().toString());
		
	}
	/**
	 * Test getPiece method
	 */
	@Test
	public void testGetPiece() {
		game.addPieceToBoard(rabbit, 3, 2);
		assertEquals("Expecting Grey Rabbit", "Grey Rabbit", board.getHole(3,2).getPiece().toString());
	}
	/**
	 * Test getDirection method
	 */
	@Test
	public void testGetDirection() {
		fox = new Fox(Direction.NORTH, 1);
		assertEquals("Expecting NORTH", Direction.NORTH, fox.getDirection());
	}

}
