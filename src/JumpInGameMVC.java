
import model.JumpInGame;
import view.JumpInView;
import controller.JumpInController;

public class JumpInGameMVC {

	public static void main(String[] args) {
		JumpInGame game = new JumpInGame();
		JumpInView view = new JumpInView(game,5,5);
		JumpInController controller = new JumpInController(game,view);		
	}

}
