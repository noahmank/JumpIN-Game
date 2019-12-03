package model;

import java.io.Serializable;

/**
* Mushroom class that initializes a mushroom
* @author Noah Mank
*/
public class Mushroom implements Piece, Serializable{
	private static final String src = "mushroom.png";
	
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
