package model;

/**
 * This class represents a fox piece of the JumpIn Game
 * @author Liya Abebe
 * @version 1.0
*/
public class Fox implements Piece {
	private Direction direction;
	private int number;
		
	/** Constructor of a fox piece
	 * 	 
	 * @param direction The direction the fox 
	 * @param number The identifier number of the fox
	 */
	public Fox(Direction direction, int number) {		
		this.direction = direction;
		this.number = number;
	}
	
	
	/** Returns the direction where the fox is facing
	 * 
	 * @return direction The direction of the fox
	 */
	public Direction getDirection() {
		return this.direction;
	}
	
	
	/** Returns the identifier number of the fox
	 * 
	 * @return number The identifier number of the fox
	 */
	public int getNumber() {
		return this.number;
	}
	
	
	/** Returns a string representation of the fox
	 * 
	 * @return A string containing the fox number
	 */
	public String toString() {
		return "F" + this.getNumber();
	}
}

