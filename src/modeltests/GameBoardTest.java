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
		fox = new Fox(Direction.NORTH, 1);
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
		mushroom = null;
		fox = null;
	}
	
	/**
	 * tests applyActionToBoard method
	 */
	@Test
	public void testApplyActionToBoard() {
		GameBoard newBoard = new GameBoard();
		gameboard.addPiece(rabbit, 3, 0);
		gameboard.addPiece(mushroom, 3, 1);
		newBoard = gameboard.applyActionToBoard(rabbit, Direction.SOUTH);
		assertEquals("Expecting 'Grey Rabbit' at new location", "Grey Rabbit", newBoard.getHole(3, 2).toString());
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
	 * Tests getNumColumns method
	 */
	@Test
	public void testGetNumColumns() {
		assertEquals("Expecting 5 for the number of columns of the default board", 5, gameboard.getNumColumns());
	}
	
	/**
	 * Tests getNumRows method
	 */
	@Test
	public void testGetNumRows() {
		assertEquals("Expecting 5 for the number of rows of the default board", 5, gameboard.getNumRows());
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
	 * Tests the getHole Method
	 */
	@Test
	public void testGetHoleMethod() {
		Hole hole = new Hole();
		hole = gameboard.getHole(2, 2);
		assertEquals("Expected 'BH'", "BH", hole.toString());
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
		assertEquals("Expecting 'Fox 1'", "Fox 1", gameboard.getHole(3, 2).toString());
	}
	
	/**
	* Tests the addPiece method with rabbit pieces specifically
	*/
	@Test
	public void testAddingRabbitPiece() {
		gameboard.addPiece(rabbit, 0, 2);
		assertEquals("Expecting 'Grey Rabbit'", "Grey Rabbit", gameboard.getHole(0,  2).toString());
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
	
	/**
	 * Tests the toString representation of the gameboard
	 */
	@Test
	public void testToString() {
		String string = "  |  0 |  1 |  2 |  3 |  4 |  \n" + 
						"0 | BH |    | RH |    | BH | \n" + 
						"1 |    |    |    |    |    | \n" + 
						"2 | RH |    | BH |    | RH | \n" + 
						"3 |    |    |    |    |    | \n" + 
						"4 | BH |    | RH |    | BH | \n";
		assertEquals("Expecting string representation of the board", string, gameboard.toString());
	}
	
	/**
	 * Tests checkValidFoxMove
	 */
	@Test
	public void testCheckValidFoxMove() {
		assertEquals("Expecting False", false, gameboard.canMoveFox(fox, Direction.NORTH));
	}
	
	/**
	 * Tests checkValidRabbitMove
	 */
	@Test
	public void testCheckValidRabbitMove() {
		assertEquals("Expecting false", false, gameboard.canMoveRabbit(rabbit, Direction.SOUTH));
	}
	
	/**
	*Tests getting the Mushrooms
	*/
	@Test
	public void testGetMushrooms() {
	}
	
	/**
	* Tests getting the Rabbits
	*/
	@Test
	public void testGetRabbits() {
	}
	
	/**
	* Tests getting the Foxes
	*/
	@Test
	public void testGetFoxes() {
		
	}
	
	/**
	*Tests setting the Mushrooms
	*/
	@Test
	public void testSetMushrooms() {
	}
	
	/**
	* Tests setting the Rabbits
	*/
	@Test
	public void testSetRabbits() {
	}
	
	/**
	* Tests setting the Foxes
	*/
	@Test
	public void testSetFoxes() {
		
	}
	
	/**
	 * tests getting the grid
	 */
	@Test
	public void testGetGrid() {
		
	}
	
	/**
	 * tests setting the grid
	 */
	@Test
	public void testSetGrid() {
		
	}
}	

