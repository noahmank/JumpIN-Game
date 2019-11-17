package modeltests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.*;
/**
 * Tests the implementation of the BoardSolver
 * @author Adela Tullio
 *
 */
public class BoardSolverTest {
	private GameBoard gameboard;
	private BoardSolver solver;
	private Rabbit greyRabbit;
	private Rabbit whiteRabbit;
	private Rabbit brownRabbit;
	private Fox fox1;
	private Fox fox2;
	
	/**
	 * sets up variables for the tests
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		gameboard = new GameBoard();
		gameboard.addPiece(greyRabbit, 3, 0);
		gameboard.addPiece(whiteRabbit, 4, 2);
		gameboard.addPiece(brownRabbit, 1, 4);
		gameboard.addPiece(fox1, 1, 0);
		gameboard.addPiece(fox2, 3, 3);
		gameboard.addPiece(new Mushroom(), 3, 1);
		gameboard.addPiece(new Mushroom(), 2, 4);
		
		solver = new BoardSolver(gameboard);
		
		greyRabbit = new Rabbit(RabbitColor.GREY);
		whiteRabbit = new Rabbit(RabbitColor.WHITE);
		brownRabbit = new Rabbit(RabbitColor.BROWN);
		
		fox1 = new Fox(Direction.SOUTH, 1);
		fox2 = new Fox(Direction.EAST, 2);
	}
	
	/**
	 * tears down the variables afterwards
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		gameboard = null;
		solver = null;
		greyRabbit = null;
		whiteRabbit = null;
		brownRabbit = null;
		fox1 = null;
		fox2 = null;
	}

	/**
	 * tests solving the board 
	 */
	@Test
	public void testSolveBoardAndGetNextActionToSolve() {
		gameboard = solver.getSolvedBoard();
		
		//the first step to solving
		MoveAction actual = solver.getNextActionToSolve();
		MoveAction expected = new MoveAction(greyRabbit, Direction.SOUTH);
		assertEquals("Expecting grey rabbit south", expected, actual);
		
		//second step to solving
		actual = solver.getNextActionToSolve();
		expected = new MoveAction(whiteRabbit, Direction.WEST);
		assertEquals("Expecting white rabbit jump west", expected, actual);
		
		//third step to solving
		actual = solver.getNextActionToSolve();
		expected = new MoveAction(greyRabbit, Direction.SOUTH);
		assertEquals("Expecting grey rabbit jump south", expected, actual);
		
		//fourth step to solving
		actual = solver.getNextActionToSolve();
		expected = new MoveAction(brownRabbit, Direction.EAST);
		assertEquals("Expecting brown rabbit jump east", expected, actual);
		
		//fifth step to solving
		actual = solver.getNextActionToSolve();
		expected = new MoveAction(fox1, Direction.SOUTH);
		assertEquals("Expecting Fox 1 to slide south", expected, actual);
		
		//sixth step
		actual = solver.getNextActionToSolve();
		expected = new MoveAction(fox1, Direction.SOUTH);
		assertEquals("Expecting Fox 1 to slide south", expected, actual);
		
		//seventh step
		actual = solver.getNextActionToSolve();
		expected = new MoveAction(fox1, Direction.SOUTH);
		assertEquals("Expecting Fox 1 to slide south", expected, actual);
		
		//final step
		actual = solver.getNextActionToSolve();
		expected = new MoveAction(greyRabbit, Direction.WEST);
		assertEquals("Expecting grey rabbit jump west", expected, actual);
		
	}
	
	/**
	 * tests getSolvedBoard method
	 */
	@Test
	public void testGetSolvedBoard() {
		gameboard = solver.getSolvedBoard();
		assertEquals("Expecting for a solved board", true,  gameboard.isFinished());
	}

}
