package model;

import java.util.LinkedList;

/**
 * 
 * @author noahmank
 *
 */
public class BoardTreeNode {
	private GameBoard board;
	private BoardTreeNode parentNode; // Edit this visibility
	private LinkedList<BoardTreeNode> childrenNodes;
	
	/**
	 * Constructs a BoardTreeNode containing a parent node (root) and children nodes
	 * @param board is the initial board passed as the one on which actions are performed
	 * @param parent the root node containing the initial board with no actions performed
	 */
	public BoardTreeNode(GameBoard board, BoardTreeNode parent) {
		this.board = board;
		this.childrenNodes = new LinkedList<>();
		this.parentNode = parent;
	}
	
	/**
	 * Adds a child node to the specified node
	 * @param board is the board contained by the previous parent node
	 * @return the child node created
	 */
	public BoardTreeNode addChild(GameBoard board) { 
		BoardTreeNode child = new BoardTreeNode(board, this);
		this.childrenNodes.add(child);
		return child;
	}
	
	/**
	 * Gets the top parent node
	 * @return the top parent node
	 */
	public BoardTreeNode getParent() {
		return this.parentNode;
	}
	
	/**
	 * Gets the game board
	 * @return GameBoard Object
	 */
	public GameBoard getBoard() {
		return this.board;
	}
	
	/**
	 * Gets the list of child nodes added to the parent node
	 * @return a linked list containing BoardTreeNode objects
	 */
	public LinkedList<BoardTreeNode> getChildren() {
		return this.childrenNodes;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;

		
		
		if(o == null || o.getClass() != this.getClass()) return false;
		BoardTreeNode node = (BoardTreeNode) o;
		return (node.board == this.board);
	}
}
