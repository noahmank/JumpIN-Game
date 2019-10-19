package model;

public class Hole {
	private Boolean isOccupied;
	private Piece piece;
	
	/**
	 * The hole constructor creates a Hole object, initializes the occupation of the Hole to false
	 * and initializes piece object to null, assuming that there is no piece on there yet.
	 */
	public Hole() {
		
		this.isOccupied = false;
		this.piece = null;
		
	}
	
	/**
	 * the toggleIsOccupied method switches between a Hole being occupied or not occupied,
	 * upon a piece landing on a Hole or leaving a Hole.
	 */
	public void toggleIsOccupied() {
		
		if(this.piece != null & this.isOccupied == false) { //if a piece has landed on a hole, update the hole
			this.isOccupied = true;
		}
		
		else if(this.piece == null & this.isOccupied == true) {// if a piece has left a hole, update the hole 
			this.isOccupied = false;
		}
		
	}
	
	/**
	 * getIsOccupied retrieves the current occupation status of the Hole
	 * @return true or false
	 */
	public Boolean getIsOccupied() {
		return this.isOccupied;
	}
	
	/**
	 * setPiece assigns a piece (Mushroom, Rabbit, Fox) to a Hole. 
	 * @param piece is the desired piece
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	/**
	 * removePiece removes the piece (Rabbit, Fox) from a Hole. (Only Rabbits and Foxes can me removed in a game)
	 * @param piece is the desired piece
	 */
	public void removePiece(Piece piece) {
		if(!(piece instanceof Mushroom)) {//Mushrooms cannot be moved during a game
			this.piece = null;
		}
	}
	
	/**
	 * A text representation of the Hole object
	 */
	public String toString() {
		
		if(this instanceof RaisedHole & this.isOccupied == true) {
			return "RH";
		}
		else if(this instanceof BrownHole & this.isOccupied == true) {
			return "BR";
		}
		else return "EH";
	}
}
