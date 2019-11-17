
import model.JumpInGame;
import view.JumpInView;

/**
 * Class containing main that constructs MVC and starts challenge 1.
 * @author Liya Abebe
 */
public class JumpInGameMVC {

	public static void main(String[] args) {
		JumpInGame game = new JumpInGame();
		JumpInView view = new JumpInView(game);
		game.challenge(1);
	}

}
