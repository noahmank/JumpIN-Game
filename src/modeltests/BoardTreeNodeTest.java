package modeltests;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.*;

/**
 * Tests the implementation of the BoardTreeNode
 * @author Adela Tullio
 *
 */
public class BoardTreeNodeTest {
	private BoardTreeNode node;
	private GameBoard gameboard;
	/**
	 * sets up the variables for the tests
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		gameboard = new GameBoard();
		node = new BoardTreeNode(gameboard, node);
	}

	/**
	 * tears down the variables afterwards
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		gameboard = null;
		node = null;
	}

	/**
	 * tests addChild method to add to the tree
	 */
	@Test
	public void testAddChild() {
		
	}
	
	/**
	 * tests getParent method to get the parent node
	 */
	@Test
	public void testGetParent() {
	}
	
	/**
	 * tests the getBoard method
	 */
	@Test
	public void testGetBoard() {
		assertEquals("Expecting gameboard", gameboard, node.getBoard());
	}
	
	/**
	 * tests getting the children nodes within the tree
	 */
	@Test
	public void testGetChildren() {
		
	}
	
	/**
	 * tests the equals method
	 */
	@Test
	public void testEquals() {
		
	}

}
