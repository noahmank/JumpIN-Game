package model;

/**
 * The Hole class is responsible for the various holes that will make up the game board
 * @author Aubin
 *
 */
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
	 * the setIsOccupied method sets if the hole is occupied or not
	 * @param occupied is the true or false value if hole is occupied
	 */
	public void setIsOccupied(Boolean occupied) {
		this.isOccupied = occupied;			
	}
	
	/**
	 * getIsOccupied retrieves the current occupation status of the Hole
	 * @return true or false
	 */
	public Boolean isOccupied() {
		return this.isOccupied;
	}
	
	/**
	 * setPiece assigns a piece (Mushroom, Rabbit, Fox) to a Hole. 
	 * @param piece is the desired piece
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
		this.setIsOccupied(true);
	}
	
	/**
	* This method gets the piece
	* @return returns the piece value 
	*/
	public Piece getPiece() {
		return this.piece;
	}
	
	/**
	 * removePiece removes the piece (Rabbit, Fox) from a Hole. (Only Rabbits and Foxes can me removed in a game)
	 * @param piece is the desired piece
	 */
	public void removePiece(Piece piece) {
		if(!(piece instanceof Mushroom)) {//Mushrooms cannot be moved during a game
			this.piece = null;
			this.setIsOccupied(false);
		}
	}
	
	/**
	 * A text representation of the Hole object
	 * @return returns the piece if the hole is occupied,
	 * otherwise returns an empty hole
	 */
	public String toString() {
		if(this.isOccupied()) {
			return this.getPiece().toString();
		}
		else return "  ";
	}
}
