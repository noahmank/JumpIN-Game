package model;

/**
 * 
 * @author noahmank
 *
 */
public class BoardTree {
	private BoardTreeNode root;
	
	/**
	 * Constructs a BoardTree object containing a root BoardTreeNode
	 * @param root the top parent node
	 */
	public BoardTree(BoardTreeNode root) {
		this.root = root;

	}
	
	/**
	 * Gets the root node of a BoardTree
	 * @return returns the root node
	 */
	public BoardTreeNode getRoot() {
		return this.root;
	}
	
}
