/**
 * 
 */
package model;

import java.awt.Point;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import jdk.internal.org.xml.sax.helpers.DefaultHandler;

/**
 * @author Aubin
 *
 */
public class LevelBuilderXMLParser extends DefaultHandler{
	
	GameBoard level = null;
	Fox fox;
	Rabbit rabbit;
	Mushroom mushroom;
	int number = 0;
	Direction direction = null;
	Point location = null;
	RabbitColor color = null;
	
		
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		level = new GameBoard();
		number = -1;
		direction = null;
		location = null;
		color = null;
	}
		
	public void endElement(String uri, String localName, String qName) {
		switch(qName) {
			case "Fox": fox = new Fox(direction,number);
						level.addPiece(fox, location.x, location.y);
				case "Rabbit": rabbit = new Rabbit(color);
						level.addPiece(rabbit, location.x, location.y);
				case "Mushroom" : mushroom = new Mushroom();
						level.addPiece(mushroom, location.x, location.y);
			}
		}

}
