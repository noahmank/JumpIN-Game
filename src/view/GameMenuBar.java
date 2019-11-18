package view;

import javax.swing.JMenuBar;
import model.JumpInGame;

/**
 * 
 * @author RunTime Terror
 *
 */
public class GameMenuBar extends JMenuBar {
	
	/**
	 * 
	 * @param game is the JumpIn game model
	 * @param view is the JumpIn game view
	 */
	public GameMenuBar(JumpInGame game, JumpInView view) {
		//Creating menu bar
        super();
        this.add(new FileMenu(game, view));
        this.add(new EditMenu(game));
	}
}
