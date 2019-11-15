package modeltests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.*;

/**
 * Tests the implementation of the BoardTree
 * @author Adela Tullio
 *
 */

public class BoardTreeTest {
	private BoardTree tree;
	private BoardTreeNode root;
	private GameBoard board;
	
	/**
	 * set up variables for tests
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		root = new BoardTreeNode(board, root);
		tree = new BoardTree(root);
	}
	
	/**
	 * take down variables for tests
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		root = null;
		tree = null;
	}

	/**
	 * test addChild method
	 */
	@Test
	public void testAddChild() {
	}
	
	/**
	 * test getRoot method
	 */
	@Test
	public void testGetRoot() {
		assertEquals("Expected root", root, tree.getRoot());
	}

}
