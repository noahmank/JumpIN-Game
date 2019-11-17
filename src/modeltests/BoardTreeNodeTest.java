package modeltests;


import static org.junit.Assert.*;
import java.util.LinkedList;

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
	private BoardTreeNode root;
	private GameBoard board;
	private Rabbit rabbit;
	private MoveAction action;
	private BoardTreeNode node;
	private LinkedList<BoardTreeNode> list;
	/**
	 * sets up the variables for the tests
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		board = new GameBoard();
		rabbit = new Rabbit(RabbitColor.GREY);
		action = new MoveAction(rabbit, Direction.SOUTH);
		root = new BoardTreeNode(board, null, null);
		node = new BoardTreeNode(board, action, root);
		list = new LinkedList<>();
	}

	/**
	 * tears down the variables afterwards
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		board = null;
		root = null;
		rabbit = null;
		action = null;
		node = null;
	}

	/**
	 * tests addChild method to add to the tree
	 */
	@Test
	public void testAddChild() {
		root.addChild(board, action);
		list.add(0, node);
		assertEquals("Expecting node", list, root.getChildren());
		
	}
	
	/**
	 * tests getParent method to get the parent node
	 */
	@Test
	public void testGetParent() {
		assertEquals("Expecting root", root, node.getParent());
	}
	
	/**
	 * tests the isRoot method
	 */
	@Test
	public void testIsRoot() {
		//testing if root is a root (should be)
		assertEquals("Expecting true", true, root.isRoot());
		//testing if a regular node with an action and parent would pass as a root
		assertEquals("Expecting false", false, node.isRoot());
	}
	
	/**
	 * tests the getBoard method
	 */
	@Test
	public void testGetBoard() {
		assertEquals("Expecting gameboard", board, root.getBoard());
	}
	
	/**
	 * tests the getAction method
	 */
	@Test
	public void testGetAction() {
		assertEquals("Expecting action", action, node.getAction());
	}
	
	/**
	 * tests getting the children nodes within the tree
	 */
	@Test
	public void testGetChildren() {
		MoveAction newAction = new MoveAction(rabbit, Direction.WEST);
		BoardTreeNode node2 = new BoardTreeNode(board, newAction, root);
		root.addChild(board, action);
		root.addChild(board, newAction);
		list.add(0, node);
		list.add(1, node2);
		assertEquals("Expected list of children", list, root.getChildren()); 
		
	}
	
	/**
	 * tests the equals method
	 */
	@Test
	public void testEquals() {
		BoardTreeNode node2 = new BoardTreeNode(board, action, root);
		assertEquals("Expecting true", true, node.equals(node2));
		
		node = null;
		assertEquals("Expecting false", false, node2.equals(node));
	}
	
	/**
	 * tests populateChildren method
	 */
	@Test
	public void testPopulateChildren() {
		root.populateChildren();
	}

}
