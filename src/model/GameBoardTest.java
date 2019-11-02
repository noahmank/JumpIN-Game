package model;

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
	
	@Before
	public void setUp() throws Exception {
		gameboard = new GameBoard();
		mushroom = new Mushroom();
		fox = new Fox(direction.NORTH, 1);
		rabbit = new Rabbit("Grey");
	}

	@After
	public void tearDown() throws Exception {
		gameboard = null;
		rabbit = null;
		direction = null;
		mushroom = null;
		fox = null;
	}

	
	@Test
	public void testResetBoard() {
		gameboard.resetBoard();
		assertEquals("Expected 'BH'", "BH", gameboard.getHoleContent(4, 4).toString());
		assertEquals("Expected '  '", "  ", gameboard.getHoleContent(1, 2).toString());
		assertEquals("Expected 'RH'", "RH", gameboard.getHoleContent(4, 2).toString());
	}
	
	@Test
	public void testAddingMushroomPiece() {
		gameboard.addPiece(mushroom, 2, 1);
		assertEquals("Expecting 'MS' in column 2, row 2", "MS", gameboard.getHoleContent(2, 1).toString());
	}
	
	@Test
	public void testAddingFoxPiece() {
		gameboard.addPiece(fox, 3, 2);
		assertEquals("Expecting 'F1'", "F1", gameboard.getHoleContent(3, 2).toString());
	}
	
	@Test
	public void testAddingRabbitPiece() {
		gameboard.addPiece(rabbit, 0, 2);
		assertEquals("Expecting 'GR'", "GR", gameboard.getHoleContent(0,  2).toString());
	}
	
	@Test
	public void testMoveFoxPiece() {
		gameboard.addPiece(fox, 3, 2);
		gameboard.moveFoxPiece("F1", direction.NORTH);
		assertEquals("Expecting 'F1'", "F1", gameboard.getHoleContent(3, 0).toString());
		
	}
	
	@Test
	public void testMoveRabbitPiece() {
		gameboard.addPiece(mushroom, 1, 2);
		gameboard.addPiece(rabbit, 0, 2);
		gameboard.moveRabbitPiece("GR", direction.EAST);
		assertEquals("Expecting 'GR'.", "GR", gameboard.getHoleContent(2, 2).toString());
	}
	
	@Test
	public void testIsFinished() {
		Rabbit rabbit2 = new Rabbit("Brown");
		Rabbit rabbit3 = new Rabbit("White");
		
		gameboard.addPiece(rabbit, 0, 0);
		gameboard.addPiece(rabbit2, 4, 0);
		gameboard.addPiece(rabbit3, 0, 4);
		
		assertEquals("Expecting a value true.", true, gameboard.isFinished());
	}
}	
