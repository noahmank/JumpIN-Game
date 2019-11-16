package model;

import java.util.LinkedList;

/**
 * 
 * @author noahmank
 *
 */
public class BoardTree {
	private BoardTreeNode root;
	private LinkedList<BoardTreeNode> childrenNodes;
	
	/**
	 * Constructs a BoardTree object containing a root BoardTreeNode
	 * @param root the top parent node
	 */
	public BoardTree(BoardTreeNode root) {
		this.root = root;
		this.childrenNodes = new LinkedList<>();
	}
	
	/**
	 * Adds a child node to the root BoardTreeNode 
	 * @param board is the board contained in the child node
	 * @return returns the child node created
	 */
	public BoardTreeNode addChild(GameBoard board, MoveAction action) { 
		BoardTreeNode child = new BoardTreeNode(board, action, this.root);
		this.childrenNodes.add(child);
		return child;
	}
	
	/**
	 * Gets the root node of a BoardTree
	 * @return returns the root node
	 */
	public BoardTreeNode getRoot() {
		return this.root;
	}
}
