
import model.JumpInGame;
import view.JumpInView;
import controller.JumpInController;

public class JumpInGameMVC {

	public static void main(String[] args) {
		JumpInGame game = new JumpInGame();
		JumpInView view = new JumpInView(game,5,5);
		view.init();
		JumpInController controller = new JumpInController(game,view);	
		//game.start();
		game.challenge(1);
	}

}
