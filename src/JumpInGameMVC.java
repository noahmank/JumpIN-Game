
import model.JumpInGame;
import view.JumpInView;

/**
 * Class containing main that constructs MVC and starts challenge 1.
 * @author Liya Abebe
 */
public class JumpInGameMVC {

	public static void main(String[] args) {
		new JumpInView(new JumpInGame());
		System.out.println("Aubin");
	}

}
