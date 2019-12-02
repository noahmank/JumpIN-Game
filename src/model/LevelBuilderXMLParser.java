/**
 * 
 */
package model;

import java.awt.Point;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Aubin
 *
 */
public class LevelBuilderXMLParser extends DefaultHandler{
	
	private GameBoard level = null;
	private Fox fox;
	private Rabbit rabbit;
	private Mushroom mushroom;
	private String number;
	private String direction;
	private String location;
	private String color;
	
		
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		level = new GameBoard();
		number = "";
		direction = "";
		location = "";
		color = "";
	}
		
	public void endElement(String uri, String localName, String qName)  {
		switch(qName) {
			case "Fox": Direction dr = (direction == "EAST")? Direction.EAST : (direction == "WEST")? Direction.WEST : 
						(direction == "NORTH")? Direction.NORTH : (direction == "SOUTH")? Direction.SOUTH : null;
						//fox = new Fox(dr,Integer.parseInt(number));
						//level.addPiece(fox, location.x, location.y);
				case "Rabbit": rabbit = new Rabbit(color);
						level.addPiece(rabbit, location.x, location.y);
				case "Mushroom" : mushroom = new Mushroom();
						level.addPiece(mushroom, location.x, location.y);
			}
		}
	
	public void characters(char[] ch, int start, int length) {
		
	}

}
