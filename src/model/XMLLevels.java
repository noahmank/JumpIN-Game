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
		// Save all foxes
		for(Fox fox : board.getFoxes().keySet()) {
			Point p = board.getFoxes().get(fox);
			boardXML += "\t<Fox>\n";
			boardXML += "\t\t<Number>" + fox.getNumber() + "</Number>\n";
			boardXML += "\t\t<Attribute>" + fox.getDirection() + "</Attribute>\n";
			boardXML += "\t\t<Column>" + p.x + "</Column>\n";
			boardXML += "\t\t<Row>" + p.y + "</Row>\n";
			boardXML += "\t</Fox>\n";
		}
		for(Rabbit rabbit : board.getRabbits().keySet()) {
			Point p = board.getRabbits().get(rabbit);
			boardXML += "\t<Rabbit>\n";
			boardXML += "\t\t<Attribute>" + rabbit.getColor() + "</Attribute>\n";
			boardXML += "\t\t<Column>" + p.x + "</Column>\n";
			boardXML += "\t\t<Row>" + p.y + "</Row>\n";
			boardXML += "\t</Rabbit>\n";
		}
		for(Mushroom mushroom : board.getMushrooms().keySet()) {
			Point p = board.getMushrooms().get(mushroom);
			boardXML += "\t<Mushroom>\n";
			boardXML += "\t\t<Column>" + p.x + "</Column>\n";
			boardXML += "\t\t<Row>" + p.y + "</Row>\n";
			boardXML += "\t</Mushroom>\n";
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