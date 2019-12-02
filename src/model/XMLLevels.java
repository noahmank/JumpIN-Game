/**
 * 
 */
package model;

import java.awt.Point;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Aubin
 *
 */
public class XMLLevels {
	
	private GameBoard board;
	private FileWriter fileWriter;
	
	
	/**
	 * Constructing a file containing a level
	 * @param fileName is the name of the file
	 */
	public XMLLevels(String fileName, GameBoard board) {
		
		try {
			fileWriter = new FileWriter(fileName);
		}
		catch(IOException exc){
			System.out.println("Filename not available");
		}
		this.board = board;
		
	}
	
	/**
	 * Converts the Gameboard in XML format
	 * @return
	 */
	public String boardToXML() {
		
		String boardXML = "<GameBoard>\n";
		
		//Looping through the given board
		for(int i = 0; i <= this.board.getNumColumns(); i++) {
			for(int j = 0; j <= this.board.getNumRows(); j++) {
				
				if(this.board.getPieceFromGrid(i, j) instanceof Fox) {
					Fox fox = (Fox) this.board.getPieceFromGrid(i, j);
					boardXML += "	<Fox>\n";
					boardXML += "		<Number>" + fox.getNumber() + "</Number>";
					boardXML += "		<Direction>" + fox.getDirection() + "</Direction>";
					boardXML += "		<Location>" + new Point(i,j) + "</Location>";//might need to change this format
					boardXML += "	</Fox>\n";
				}
				else if(this.board.getPieceFromGrid(i, j) instanceof Rabbit) {
					Rabbit rabbit = (Rabbit) this.board.getPieceFromGrid(i, j);
					boardXML += "	<Rabbit>\n";
					boardXML += "		<Color>" + rabbit.getColor() + "</Color>";
					boardXML += "		<Location>" + new Point(i,j) + "</Location>";//might need to change this format
					boardXML += "	</Rabbit>\n";
				}
				else if(this.board.getPieceFromGrid(i, j) instanceof Mushroom) {
					boardXML += "	<Mushroom>\n";
					boardXML += "		<Location>" + new Point(i,j) + "</Location>";//might need to change this format
					boardXML += "	</Mushroom>\n";
				}
			}
		}
		
		boardXML += "</GameBoard>\n";
		
		return boardXML;
	}
	
	/**
	 * Adds the level to in XML format into the file
	 * @param XMLlevel is the XML gameboard format to write on the file created
	 */
	public void exportBoardlevelToXML(String XMLlevel) {
		
		try {
			fileWriter.write(XMLlevel);
			fileWriter.close();
		}
		catch(IOException exc) {
			System.out.println("XML gameboard format is was not provided");
		}
		
	}
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static GameBoard importFromXML(String fileName) {
		 return new GameBoard(); //WIP
	}
}