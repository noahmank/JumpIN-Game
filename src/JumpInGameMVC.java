
import java.io.IOException;

import model.JumpInGame;
import model.SaveLoad;
import view.JumpInView;

/**
 * Class containing main that constructs MVC and starts challenge 1.
 * @author Liya Abebe
 */
public class JumpInGameMVC {

	public static void main(String[] args) {
		JumpInGame game;
		try {
			game = SaveLoad.loadGameDataFromFile("JumpInGame Save.txt");
		} catch(IOException e) {
			System.out.println("No save file found");
			game = new JumpInGame();
		}
		new JumpInView(game);
	}

}
