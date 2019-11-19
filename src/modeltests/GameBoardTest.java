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

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
	 * testing constructor of gameboard
	 */
	@Test
	public void testGameBoardConstructor() {
		GameBoard newBoard = new GameBoard(gameboard);
		assertEquals("Expecting GameBoards to be the same", newBoard, gameboard);
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
	 * tests reset all pieces
	 */
	@Test
	public void testResetAllPieces() {
		LinkedHashMap<Rabbit, Point> rabbits = new LinkedHashMap<>();
		LinkedHashMap<Fox, Point> foxes = new LinkedHashMap<>();
		HashMap<Mushroom, Point> mushrooms = new HashMap<>();
		
		gameboard.resetAllPieces();
		assertEquals("Expecting no rabbits", rabbits, gameboard.getRabbits());
		assertEquals("Expecting no foxes", foxes, gameboard.getFoxes());
		assertEquals("Expecting no mushrooms", mushrooms, gameboard.getMushrooms());
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
	* Tests the addPiece method with fox pieces specifically adding fox to a hill
	*/
	@Test
	public void testAddingFoxPieceOnHill() {
		gameboard.addPiece(fox, 2, 0);
		assertEquals("Expecting 'RH'", "RH", gameboard.getHole(2,0).toString());
	}
	
	/**
	* Tests the addPiece method with fox pieces specifically adding fox to space already occupied
	*/
	@Test
	public void testAddingFoxPieceOnOccupiedSpace() {
		gameboard.addPiece(mushroom, 2, 0);
		gameboard.addPiece(fox, 2, 0);
		assertEquals("Expecting 'MS'", "MS", gameboard.getHole(2,0).toString());
	}
	
	/**
	* Tests the addPiece method with fox pieces specifically adding fox to a Brown hole
	*/
	@Test
	public void testAddingFoxPieceOnBronHole() {
		gameboard.addPiece(fox, 0, 0);
		assertEquals("Expecting 'BH'", "BH", gameboard.getHole(0,0).toString());
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
		gameboard.addPiece(mushroom, 3, 1);
		assertEquals("Expecting MS", "{MS=java.awt.Point[x=3,y=1]}", gameboard.getMushrooms().toString());
	}
	
	/**
	* Tests getting the Rabbits
	*/
	@Test
	public void testGetRabbits() {
		gameboard.addPiece(rabbit, 3, 1);
		assertEquals("Expecting Grey Rabbit", "{Grey Rabbit=java.awt.Point[x=3,y=1]}", gameboard.getRabbits().toString());
	}
	
	/**
	* Tests getting the Foxes
	*/
	@Test
	public void testGetFoxes() {
		gameboard.addPiece(fox, 3, 1);
		assertEquals("Expecting Fox 1", "{Fox 1=java.awt.Point[x=3,y=1]}", gameboard.getFoxes().toString());
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
		//Adding fox  with head on a brown hole
		assertEquals("Expecting false", false, gameboard.canAddFox(fox, 0, 1));
		
		//Adding a fox with head out of bounds
		assertEquals("Expecting false", false, gameboard.canAddFox(fox, 0, 0));
		
		//Adding fox with head on a rabbit piece
		assertEquals("Expecting false", false, gameboard.canAddFox(fox, 3, 0));
		
		//Adding fox in a valid Place
		assertEquals("Expecting true", true, gameboard.canAddFox(fox, 1, 1));
		
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

