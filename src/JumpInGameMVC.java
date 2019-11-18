
import model.JumpInGame;
import view.JumpInView;

/**
 * Class containing main that constructs MVC and starts challenge 1.
 * @author Liya Abebe
 */
public class JumpInGameMVC {

	public static void main(String[] args) {
		JumpInGame game = new JumpInGame();
		new JumpInView(game);
		//Need to add Buttons for choosing challenge
		//Select challenge 1 for one
		game.setSelectedChallenge(2);
		game.startChallenge();
	}

}
