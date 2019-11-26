package view;

import javax.swing.JMenuBar;
import model.JumpInGame;

/**
 * 
 * @author RunTime Terror
 *
 */
public class DefaultMenuBar extends JMenuBar {
	
	/**
	 * Creating a menu bar constructor suited for the solver
	 * @param game is the JumpIN game model
	 * @param view is the JumpIN game view
	 */
	public DefaultMenuBar(JumpInGame game, JumpInView view) {
		//Creating menu bar
        super();
        this.add(new FileMenu(game, view));
	}
}
