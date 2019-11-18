package view;

import javax.swing.JMenuBar;
import model.JumpInGame;

public class SolverMenuBar extends JMenuBar {
	
	public SolverMenuBar(JumpInGame game, JumpInView view) {
		//Creating menu bar
        super();
        this.add(new FileMenu(game, view));
	}
}
