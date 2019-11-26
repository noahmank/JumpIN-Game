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
		board = null;
		mushroom = null;
		rabbit = null;
		fox = null;
	}
	
	/**
	 * Tests the movePiece method
	 */
	@Test
	public void testMovePiece() {
		game.startChallenge();
		game.savePieceToMove(3, 0);
		game.setDirection(Direction.SOUTH);
		game.movePiece();
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
		game.savePieceToMove(3, 0);
		game.setDirection(Direction.SOUTH);
		game.movePiece();
		assertEquals("Expected mushroom at this location", "MS", board.getHole(3, 2).toString());
	}
	
	/**
	 * Test movePiece method by moving a piece to an out of bounds spot
	 */
	@Test 
	public void testMovePieceOutOfBounds() {
		game.addPieceToBoard(rabbit, 3, 1);
		game.addPieceToBoard(mushroom, 3, 0);
		game.savePieceToMove(3, 1);
		game.setDirection(Direction.NORTH);
		game.movePiece();
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
	 * Tests challenge method
	 * with challenge two
	 */
	@Test
	public void testChallengeTwo() {
		game.setSelectedChallenge(2);
		game.startChallenge();
		assertEquals("Expected Mushroom at (0, 1)", "MS", board.getHole(0, 1).toString());
		assertEquals("Expected Mushroom at (0, 2)", "MS", board.getHole(0, 2).toString());
		assertEquals("Expected Mushroom at (0, 4)", "MS", board.getHole(0, 4).toString());
		assertEquals("Expected Grey Rabbit at (1, 0)", "Grey Rabbit", board.getHole(1, 0).toString());
		assertEquals("Expected White Rabbit at (4, 1)", "White Rabbit", board.getHole(4, 1).toString());
		assertEquals("Expected Brown Rabbit at (3, 0)", "Brown Rabbit", board.getHole(3, 0).toString());
		assertEquals("Expected Fox 1 at (1, 2)", "Fox 1", board.getHole(1, 2).toString());
		assertEquals("Expected Fox 2 at (2, 3)", "Fox 2", board.getHole(2, 3).toString());	
	}
	
	/**
	 * Tests challenge method
	 * with challenge three
	 */
	@Test
	public void testChallengeThree() {
		game.setSelectedChallenge(3);
		game.startChallenge();
		assertEquals("Expected Mushroom at (3, 0)", "MS", board.getHole(3, 0).toString());
		assertEquals("Expected Mushroom at (2, 2)", "MS", board.getHole(2, 2).toString());
		assertEquals("Expected Mushroom at (4, 4)", "MS", board.getHole(4, 4).toString());
		assertEquals("Expected Grey Rabbit at (0, 3)", "Grey Rabbit", board.getHole(0, 3).toString());
		assertEquals("Expected White Rabbit at (3, 1)", "White Rabbit", board.getHole(3, 1).toString());
		assertEquals("Expected Brown Rabbit at (4, 2)", "Brown Rabbit", board.getHole(4, 2).toString());
		assertEquals("Expected Fox 1 at (0, 1)", "Fox 1", board.getHole(0, 1).toString());
		assertEquals("Expected Fox 2 at (3, 3)", "Fox 2", board.getHole(3, 3).toString());
	}
	
	
	/**
	 * Tests undo method
	 */
	@Test
	public void testUndo() {
		game.startChallenge();
		game.savePieceToMove(3, 0);
		game.setDirection(Direction.SOUTH);
		game.movePiece();
		game.movePiece();
		game.undoMoveAction();
		assertEquals("Expecting Grey Rabbit at (3, 2)", "Grey Rabbit", game.getBoard().getPieceFromGrid(3, 2).toString());
	}
	
	/**
	 * Tests redo method
	 */
	@Test
	public void testRedo() {
		game.startChallenge();
		game.savePieceToMove(3, 0);
		game.setDirection(Direction.SOUTH);
		game.movePiece();
		game.movePiece();
		game.undoMoveAction();
		game.undoMoveAction();
		game.redoMoveAction();
		assertEquals("Expecting Grey Rabbit at (3, 2)", "Grey Rabbit", board.getHole(3, 2).toString());
		game.redoMoveAction();
		assertEquals("Expecting Grey Rabbit at (3, 4)", "Grey Rabbit", board.getHole(3, 4).toString());
	}
	
	/**
	 * Test get Board
	 */
	@Test
	public void testGetBoard() {
		assertEquals("Expecting the board to be the same", board, game.getBoard());
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
	 * Test set direction
	 */
	@Test
	public void testSetDirection() {
		game.setDirection(Direction.NORTH);
		assertEquals("Expecting NORTH", Direction.NORTH, game.getDirection());
	}
	
	/**
	 * Test getDirection method
	 */
	@Test
	public void testGetDirection() {
		fox = new Fox(Direction.NORTH, 1);
		assertEquals("Expecting NORTH", Direction.NORTH, fox.getDirection());
	}
		
	/**
	 * test set console output
	 */
	@Test
	public void testSetAndGetConsoleOutput() {
		game.setConsoleOutput("Rabbit moved South");
		assertEquals("Expecting 'Rabbit moved South'", "Rabbit moved South", game.getConsoleOutput());
	}
	
	
	
	/**
	 * test next move from solution
	 * and solve game method
	 */
	@Test
	public void testDoNextMoveFromSolutionChallengeOne() {
		
	}
	
	
	/**
	 * test get selected challenge
	 */
	@Test
	public void testSetAndGetSelectedChallenge() {
		game.setSelectedChallenge(1);
		assertEquals("Expecting 1", 1, game.getSelectedChallenge());
		game.setSelectedChallenge(2);
		assertEquals("Expecting 2", 2, game.getSelectedChallenge());
		game.setSelectedChallenge(3);
		assertEquals("Expecting 3", 3, game.getSelectedChallenge());
	}
	
	/**
	 * test get number challenges
	 */
	@Test
	public void testGetNumChallenges() {
		assertEquals("Expecting 3 so far", 3, game.getNumChallenges());
	}
	
	/**
	 * test save piece to move
	 */
	@Test
	public void testSavePieceToMove() {
		game.startChallenge();
		game.savePieceToMove(3, 0);
		assertEquals("Expecting Grey Rabbit", "Grey Rabbit", game.getPiece().toString());
	}
	
	/**
	 * test start builder
	 */
	@Test
	public void testStartBuilder() {
		
	}
	
	/**
	 * test start builder
	 */
	@Test
	public void testGetBuilder() {
		
	}

}
