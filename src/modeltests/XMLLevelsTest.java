package modeltests;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Direction;
import model.Fox;
import model.GameBoard;
import model.Mushroom;
import model.Rabbit;
import model.RabbitColor;
import model.XMLLevel;

/**
 * tests the XMLLevels class
 * 
 * @author Adela Tullio and  Liya Abebe
 *
 */
public class XMLLevelsTest {
	private GameBoard board;
	private String fileName;
	private XMLLevel xml;

	/**
	 * sets up the private variables for the tests
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		fileName = "test.txt";
		board = new GameBoard();
		xml = new XMLLevel(fileName, board);

		board.addPiece(new Fox(Direction.NORTH, 2), 1, 2);
		board.addPiece(new Rabbit(RabbitColor.BROWN), 4, 1);
		board.addPiece(new Mushroom(), 2, 4);
	}

	/**
	 * tears down the private variables after the tests
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		fileName = null;
		xml = null;
		board = null;

	}

	/**
	 * tests level one to XML Format
	 */
	@Test
	public void testExportBoardLevelOneToXML() {
		String xmlBoard = "\n<GameBoard>\n" + "\t<Fox>\n" + "\t\t<Number>" + "2" + "</Number>\n" + "\t\t<Attribute>"
				+ "NORTH" + "</Attribute>\n" + "\t\t<Column>" + "1" + "</Column>\n" + "\t\t<Row>" + "2" + "</Row>\n"
				+ "\t</Fox>\n" + "\t<Rabbit>\n" + "\t\t<Attribute>" + "Brown" + "</Attribute>\n" + "\t\t<Column>" + "4"
				+ "</Column>\n" + "\t\t<Row>" + "1" + "</Row>\n" + "\t</Rabbit>\n" + "\t<Mushroom>\n" + "\t\t<Column>"
				+ "2" + "</Column>\n" + "\t\t<Row>" + "4" + "</Row>\n" + "\t</Mushroom>\n" + "</GameBoard>\n";

		xml.exportBoardlevelToXML();

		BufferedReader reader = null;
		String xmlFromMethod = null;
		String line;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			while ((line = reader.readLine()) != null) {
				xmlFromMethod = xmlFromMethod + "\n" + line;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("Expected to be same", xmlBoard, xmlFromMethod);
	}

}
