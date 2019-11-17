package view;

import javax.swing.JMenuBar;
import model.JumpInGame;

public class GameMenuBar extends JMenuBar {
	public GameMenuBar(JumpInGame game, JumpInView view) {
		//Creating menu bar
        super();
        this.add(new FileMenu(game, view));
        this.add(new EditMenu(game));
	}
}
