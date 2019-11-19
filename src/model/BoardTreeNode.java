package model;

import java.awt.Point;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * 
 * @author noahmank
 *
 */
public class BoardTreeNode {
	private GameBoard board;
	private MoveAction action;
	private BoardTreeNode parentNode;
	private LinkedList<BoardTreeNode> childrenNodes;
	
	/**
	 * Constructs a BoardTreeNode containing a parent node (root) and children nodes
	 * @param board is the initial board passed as the one on which actions are performed
	 * @param parent the root node containing the initial board with no actions performed
	 */
	public BoardTreeNode(GameBoard board, MoveAction action, BoardTreeNode parent) {
		this.board = board;
		this.action = action;
		this.childrenNodes = new LinkedList<>();
		this.parentNode = parent;
	}
	
	/**
	 * Adds a child node to the specified node
	 * @param board is the board contained by the previous parent node
	 * @return the child node created
	 */
	public BoardTreeNode addChild(GameBoard board, MoveAction action) { 
		BoardTreeNode child = new BoardTreeNode(board, action, this);
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
	 * Checks to see if this node is the root of its tree
	 * @return boolean based on if the node is the root
	 */
	public boolean isRoot() {
		return (action == null && parentNode == null);
	}
	
	/**
	 * Gets the game board
	 * @return GameBoard Object
	 */
	public GameBoard getBoard() {
		return this.board;
	}
	
	/**
	 * Gets the action taken from the last node (edge)
	 * @return MoveAction taken from last board
	 */
	public MoveAction getAction() {
		return action;
	}
	
	/**
	 * Gets the list of child nodes added to the parent node
	 * @return a linked list containing BoardTreeNode objects
	 */
	public LinkedList<BoardTreeNode> getChildren() {
		return this.childrenNodes;
	}
	
	/**
	* Equals method for the BoardTreeNode class
	* @param o is the object to be compared to
	* @return boolean value whether the objects are
	* equal (true) or not (false)
	*/
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || o.getClass() != this.getClass()) return false;
		BoardTreeNode node = (BoardTreeNode) o;
		return (node.board.equals(this.board));
	}
	
	/**
	 * Populates the next level of child nodes based on possible MoveActions for the contained pieces
	 * @param board the game board from the parent node
	 */
	public void populateChildren() {
		GameBoard parentBoard = this.getBoard();
		GameBoard childBoard;
		LinkedHashMap<MoveablePiece, Point> moveablePieces = new LinkedHashMap<>();
		moveablePieces.putAll(parentBoard.getRabbits());
		moveablePieces.putAll(parentBoard.getFoxes());
		
		for(MoveablePiece p : moveablePieces.keySet()) {
			for(Direction d : Direction.values()) {
				if(parentBoard.canMovePiece(p, d)) {
					childBoard = new GameBoard(parentBoard);
					childBoard = childBoard.applyActionToBoard(p, d);
					this.addChild(childBoard, new MoveAction(p,d));
				}
			}
		}
	}
}
