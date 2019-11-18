package model;

/**
 * This class represents a fox piece of the JumpIn Game
 * @author Liya Abebe
 * @version 1.0
*/
public class Fox implements MoveablePiece {
	private Direction direction;
	private int number;
	private static final String src = "fox.png"; // Is this too much to know?
		
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
	
	/**
	* gets the image url for the foxes
	* @return the image url
	*/
	@Override
	public String getSrc() {
		return Fox.src;
	}
	
	
	/** Returns a string representation of the fox
	 * 
	 * @return A string containing the fox number
	 */
	@Override
	public String toString() {
		return "Fox " + this.getNumber();
	}
	
	/**
	* method to determine if two objects of foxes are equal or not
	* @param obj is the object to be compared
	* @return true or false whether it is equal or not
	*/
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || obj.getClass() != this.getClass()) return false;
		Fox fox = (Fox) obj;
		return (fox.getDirection() == this.getDirection()) && (fox.getNumber() == this.getNumber());
	}
}

