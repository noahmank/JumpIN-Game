package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Save_Load {

	public static void saveGameDataToFile(JumpInGame game, String Filename) throws IOException {

		FileOutputStream fileStream = new FileOutputStream(Filename);
		ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

		objectStream.writeObject(game);

		objectStream.close();
		fileStream.close();

	}

	public static Object loadGameDataFromFile(String filename) throws ClassNotFoundException, IOException {

		File file = new File(filename);
		FileInputStream fileStream = new FileInputStream(file);
		ObjectInputStream objectStream = new ObjectInputStream(fileStream);

		return objectStream.readObject();

	}
}
