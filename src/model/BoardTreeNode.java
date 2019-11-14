package model;

import java.util.LinkedList;


public class BoardTreeNode {
	private GameBoard boardState;
	private MoveAction action;
	private BoardTreeNode parentNode; // Edit this visibility
	private LinkedList<BoardTreeNode> childrenNodes;
	
	public BoardTreeNode(GameBoard boardState, MoveAction action, BoardTreeNode parent) {
		this.boardState = boardState;
		this.action = action;
		this.childrenNodes = new LinkedList<>();
		this.parentNode = parent;
	}
	
	// Might want to change return type to void? Nah
	public BoardTreeNode addChild(GameBoard boardState, MoveAction action) { 
		BoardTreeNode child = new BoardTreeNode(boardState, action, this);
		this.childrenNodes.add(child);
		return child;
	}
	
	public BoardTreeNode getParent() {
		return this.parentNode;
	}
	
	public LinkedList<BoardTreeNode> getChildren() {
		return this.childrenNodes;
	}
}
