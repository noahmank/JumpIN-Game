package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
* Save and Load class Implementation
*/
public class Save_Load {
	
	/**
	* A method that saves the Game state to a file
	* @param game is the game to be saved
	* @param Filename is the name of the file the game will be saved to
	* @throws IOException 
	*/
	public static void saveGameDataToFile(JumpInGame game, String Filename) throws IOException {

		FileOutputStream fileStream = new FileOutputStream(Filename);
		ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

		objectStream.writeObject(game);

		objectStream.close();
		fileStream.close();

	}
	
	/**
	* A method that loads the Game state
	* @param filename is the filename to load data from
	* @return Object of the loaded gane data
	* @throws ClassNotFoundException, IOException
	*/
	public static Object loadGameDataFromFile(String filename) throws ClassNotFoundException, IOException {

		File file = new File(filename);
		FileInputStream fileStream = new FileInputStream(file);
		ObjectInputStream objectStream = new ObjectInputStream(fileStream);

		return objectStream.readObject();

	}
}
