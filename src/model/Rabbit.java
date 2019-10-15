package model;

public class Rabbit extends MoveablePiece{
	public Rabbit(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
}
