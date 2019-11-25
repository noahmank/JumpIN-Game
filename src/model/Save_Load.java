package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Save_Load {

	public void saveGameDataToFile(File file) throws IOException {

		FileOutputStream fileStream = new FileOutputStream(file);
		ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

		// objectStream.writeObject(objects to be added);

		try {
			objectStream.close();
			fileStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// JOptionPane.showConfirmDialog(frame, "Save game state successfully.", "Snake
		// Game",
		// JOptionPane.DEFAULT_OPTION);

	}

	public void loadGameDataFromFile(File file) throws ClassNotFoundException {

		try {
			FileInputStream fileStream = new FileInputStream(file);
			ObjectInputStream objectStream = new ObjectInputStream(fileStream);

		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// svaedobject = (int[][]) objectStream.readObject();

	}
}
