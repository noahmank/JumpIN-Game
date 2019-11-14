package model;

import java.util.LinkedList;


public class BoardTreeNode {
	private GameBoard boardState;
	private BoardTreeNode parentNode; // Edit this visibility
	private LinkedList<BoardTreeNode> childrenNodes;
	
	public BoardTreeNode(GameBoard boardState, BoardTreeNode parent) {
		this.boardState = boardState;
		this.childrenNodes = new LinkedList<>();
		this.parentNode = parent;
	}
	
	// Might want to change return type to void? Nah
	public BoardTreeNode addChild(GameBoard boardState) { 
		BoardTreeNode child = new BoardTreeNode(boardState, this);
		this.childrenNodes.add(child);
		return child;
	}
	
	public BoardTreeNode getParent() {
		return this.parentNode;
	}
	
	public LinkedList<BoardTreeNode> getChildren() {
		return this.childrenNodes;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || o.getClass() != this.getClass()) return false;
		BoardTreeNode node = (BoardTreeNode) o;
		return (node.boardState == this.boardState);
	}
}
