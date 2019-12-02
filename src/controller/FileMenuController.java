package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import model.JumpInGame;
import model.Save_Load;
import view.JumpInView;

/**
 * Controller for the FileMenu
 * @author RunTime Terror
 *
 */
public class FileMenuController implements ActionListener {
	private JumpInView view;
	private JumpInGame game;
	
	/**
	 * Instantiates the 'File' menu handler
	 * @param view is the JumpIn game view
	 */
	public FileMenuController(JumpInGame game, JumpInView view) {
		this.view = view;
		this.game = game;
	}
	
	/**
	* Method to deal with the action to happen when the button is pressed
	* @param e is the action event that triggered it
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem) e.getSource();
		if (source.getText().equals("Home")) {
			this.game.resetChallenge();
			this.view.toInstructionsFrame();
		} else if (source.getText().equals("Save")) {
			try {
				Save_Load.saveGameDataToFile(game, "save.txt");
			} catch (Exception x) {

				x.printStackTrace();
			}
		} else if (source.getText().contentEquals("Open")) {
			try {
				this.game = (JumpInGame) Save_Load.loadGameDataFromFile("save.txt");
			} catch (Exception x) {

				x.printStackTrace();
			}
		}
	}

}
