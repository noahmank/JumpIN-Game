package model;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.*;

public class BoardTreeNode implements TreeNode {
	private GameBoard boardState;
	private MoveAction action;
	private BoardTreeNode parentNode; // Edit this visibility
	private List<BoardTreeNode> childrenNodes;
	
	public BoardTreeNode(GameBoard boardState, MoveAction action, BoardTreeNode parent) {
		this.boardState = boardState;
		this.action = action;
		this.childrenNodes = new LinkedList<>();
		this.parentNode = parent;
	}
	
	// Might want to change return type to void?
	public BoardTreeNode addChild(GameBoard boardState, MoveAction action) { 
		BoardTreeNode child = new BoardTreeNode(boardState, action, this);
		child.parentNode = this;
		this.childrenNodes.add(child);
		return child;
	}
	
	@Override
	public Enumeration children() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndex(TreeNode arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

}
