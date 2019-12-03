package model;

import java.io.Serializable;

/**
* Class for an action of a moveable piece in a certain direction, involving getters and setters of the piece
* as well as direction
*/
public class MoveAction implements Serializable {
	private MoveablePiece piece;
	private Direction direction;
	
	/**
	* constructor to initialize piece and direction
	* @param piece the moveable piece 
	* @param direction the specified direction
	*/
	public MoveAction(MoveablePiece piece, Direction direction) {
		this.piece = piece;
		this.direction = direction;
	}
	
	/**
	* constructor to initialize piece and direction, it is 
	* a constructor that is passed an instance of itself
	* @param move includes the move action 
	*/
	public MoveAction(MoveAction move) {
		this.piece = move.getPiece();
		this.direction = move.getDirection();
	}
	
	/**
	* gets a new move action the opposite way of the specified direction
	* with a moveable piece
	* @return new instance of move action with opposite direction
	*/
	public MoveAction getOppositeMove() {
		return new MoveAction(piece, direction.getOpposite());
	}
	
	/**
	* gets the direction
	* @return direction
	*/
	public Direction getDirection() {
		return this.direction;
	}
	
	/**
	* gets the piece
	* @return piece
	*/
	public MoveablePiece getPiece() {
		return this.piece;
	}
	
	/**
	* creates a string implementation of the move action
	*/
	@Override
	public String toString() {
		return "(" + this.piece.toString() + ", " + this.direction.toString() + ")";
	}
	
	/**
	* compares two objects to determine if they are equals
	* @param obj is the object to be compared
	* @return true or false if the objects are equals or not
	*/
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || obj.getClass() != this.getClass()) return false;
		MoveAction moveAction = (MoveAction) obj;
		return (moveAction.getPiece().equals(this.piece)) && (moveAction.getDirection().equals(this.direction)); 
	}
}
