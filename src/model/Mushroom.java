package model;
/**
* Mushroom class that initializes a mushroom
* @author Noah Mank
*/
public class Mushroom implements Piece{
	private static final String src = "mushroom.png";
	/**
	* Default constructor
	*/
	public Mushroom() {
		
	}
	
	public static String getSrc() {
		return Mushroom.src;
	}
	
	/**
	* Method that converts the mushroom to a string
	* @return string representation of mushroom
	*/
	@Override
	public String toString() {
		return "MS";
	}
}
