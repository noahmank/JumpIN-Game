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
		//assertEquals()
		gameboard.resetBoard();
	}
	
	@Test
	public void testAddingMushroomPiece() {
		gameboard.addPiece(mushroom, 2, 2);
		//assertEquals()
	}
	
	@Test
	public void testAddingFoxPiece() {
		gameboard.addPiece(fox, 3, 5);
	}
	
	@Test
	public void testAddingRabbitPiece() {
		gameboard.addPiece(rabbit, 3, 1);
	}
	
	@Test
	public void testToString() {
		gameboard.toString();
	}
	
	@Test
	public void testMoveFoxPiece() {
		gameboard.moveFoxPiece("F1", direction.NORTH);
	}
	
	@Test
	public void testMoveRabbitPiece() {
		gameboard.moveRabbitPiece("GR", direction.EAST);
	}
	
	@Test
	public void testIsFinished() {
		
	}
}	
