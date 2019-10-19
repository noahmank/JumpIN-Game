package model;

/**
* Represents the BrownHoles the rabbits will jump into
* @author Adela Tullio
*/
public class BrownHole extends RaisedHole {
	/**
	* Constructor calls the constructor
	* of the superclass
	*/
	public BrownHole() {
		super();
	}
	
	/**
	* Represents the BrownHole as a string
	* @returns BrownHole string value
	*/
	@Override
	public String toString() {
		if(this.getIsOccupied()) {
			return this.getPiece().toString();
		}
		else return "BH";
	}
}
