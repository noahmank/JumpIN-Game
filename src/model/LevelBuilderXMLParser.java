/**
 * 
 */
package model;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Aubin
 *
 */
public class LevelBuilderXMLParser extends DefaultHandler{
	private boolean isAttribute;
	private boolean isColumn;
	private boolean isRow;
	private boolean isNumber;
	
	private GameBoard level = null;
	private String number;
	private String attribute;
	private String column;
	private String row;
	
	
	public void startDocument() {
		level = new GameBoard();
	}
	
	/**	
	 * 
	 */
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch(qName) {
			case "Attribute": isAttribute = true;
			case "Column": isColumn = true;
			case "Row": isRow = true;
			case "Number": isNumber = true;
		}
	}
	
	/**
	 * 
	 */
	public void endElement(String uri, String localName, String qName)  {
		switch(qName) {
			case "Fox": 
				level.addPiece(new Fox(Direction.valueOf(attribute), Integer.parseInt(number)), Integer.parseInt(column), Integer.parseInt(row));
				break;
			case "Rabbit": 
				level.addPiece(new Rabbit(RabbitColor.valueOf(attribute)), Integer.parseInt(column), Integer.parseInt(row));
				break;
			case "Mushroom" : 
				level.addPiece(new Mushroom(), Integer.parseInt(column), Integer.parseInt(row));
				break;
			case "Attribute": isAttribute = false;
			case "Column": isColumn = false;
			case "Row": isRow = false;
			case "Number": isNumber = false;
		}
	}
	
	/**
	 * 
	 */
	public void characters(char[] ch, int start, int length) {
		if(isAttribute) attribute = new String(ch, start, length);
		if(isNumber) number = new String(ch, start, length);
		if(isColumn) column = new String(ch, start, length);
		if(isRow) row = new String(ch, start, length);
	}

}
