package modeltests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.*;

/**
 * 
 * @author adelatullio
 *
 */
public class BoardBuilderTest {
	private BoardBuilder boardBuilder;
	private GameBoard board;
	private Mushroom mushroom;
	
	/**
	 * sets up variables for testing
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		board = new GameBoard();
		boardBuilder = new BoardBuilder(board);
		mushroom = new Mushroom();
	}

	/**
	 * tears down variables after testing
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		board = null;
		boardBuilder = null;
		mushroom = null;
	}

	/**
	 * tests the setter and getter for piece name
	 */
	@Test
	public void testSetAndGetPieceName() {
		boardBuilder.setPieceName("Rabbit");
		assertEquals("Expecting 'Rabbit'", "Rabbit", boardBuilder.getPieceName());
	}
	
	/**
	 * tests the setter and getter for piece attribute
	 */
	@Test
	public void testSetAndGetPieceAttribute() {
		boardBuilder.setPieceAttribute("Grey");
		assertEquals("Expecting 'Grey'", "Grey", boardBuilder.getPieceAttribute());
	}
	
	/**
	 * tests the setter and getter for column
	 */
	@Test
	public void testSetAndGetColumn() {
		boardBuilder.setColumn(5);
		assertEquals("Expecting 5", 5, boardBuilder.getColumn());
	}
	
	/**
	 * tests the setter and getter for row
	 */
	@Test
	public void testSetAndGetRow() {
		boardBuilder.setRow(5);
		assertEquals("Expecting 5", 5, boardBuilder.getRow());
	}
	
	/**
	 * tests add piece to board method
	 */
	@Test
	public void testAddPieceToBoard() {
		boardBuilder.setColumn(2);
		boardBuilder.setRow(1);
		boardBuilder.setPieceName("Mushroom");
		boardBuilder.constructSelectedPiece();
		board = boardBuilder.getBoardToBuild();
		assertEquals("Expecting mushroom at Column 2, Row 1", "MS", board.getHole(2, 1).toString());
	}
	
	/**
	 * tests remove piece from board method
	 */
	@Test
	public void testRemovePieceFromBoard() {
		boardBuilder.setColumn(2);
		boardBuilder.setRow(1);
		boardBuilder.setPieceName("Mushroom");
		boardBuilder.constructSelectedPiece();
		boardBuilder.setColumn(2);
		boardBuilder.setRow(1);
		boardBuilder.setPieceName("Mushroom");
		boardBuilder.removePieceFromBoard();
		board = boardBuilder.getBoardToBuild();
		assertEquals("Expecting mushroom at Column 2, Row 1", "  ", board.getHole(2, 1).toString());
	}
}
