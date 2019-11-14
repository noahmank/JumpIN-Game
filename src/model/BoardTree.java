package model;

import java.util.LinkedList;

public class BoardTree {
	private BoardTreeNode root;
	private LinkedList<BoardTreeNode> childrenNodes;
	
	public BoardTree(BoardTreeNode root) {
		this.root = root;
		this.childrenNodes = new LinkedList<>();
	}
	
	public BoardTreeNode addChild(GameBoard boardState) { 
		BoardTreeNode child = new BoardTreeNode(boardState, this.root);
		this.childrenNodes.add(child);
		return child;
	}
	
	public BoardTreeNode getRoot() {
		return this.root;
	}
}
