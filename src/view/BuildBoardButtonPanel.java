package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.*;
/**
* Board Builder button panel
*
*/
public class BuildBoardButtonPanel extends JPanel{
	private JButton buildBoard;
	private JumpInGame game;
	
	/**
	* Constructor for the button panel
	* @param g is the game
	* @param c is the action listener
	*/
	public BuildBoardButtonPanel(JumpInGame g, ActionListener c) {
		this.game = g;
		buildBoard = new JButton("Build New Board");
		buildBoard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildBoardActionPerformed(e);
			}
		});
		this.add(buildBoard);
	}
	
	/**
	* Method to deal with the action performed
	* @param e is the event that was generated from pressing the button
	*/
	public void buildBoardActionPerformed(ActionEvent e) {
		game.solveGame();
		if(game.gameIsSolved()) {
			game.generateNewLevel();
		}
		game.notifyViews();
	}
}
