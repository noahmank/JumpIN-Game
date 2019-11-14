package model;

import java.util.LinkedList;

public class BoardTree {
	private BoardTreeNode root;
	private LinkedList<BoardTreeNode> childrenNodes;
	
	public BoardTree(BoardTreeNode root) {
		this.root = root;
		this.childrenNodes = new LinkedList<>();
	}
	
	public BoardTreeNode addChild(GameBoard boardState, MoveAction action) { 
		BoardTreeNode child = new BoardTreeNode(boardState, action, this.root);
		this.childrenNodes.add(child);
		return child;
	}
}
