package model;


public class Rabbit implements Piece{
	String color;
	
	public Rabbit(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return Character.toString(color.charAt(0)).toUpperCase() + "R";
	}
}
