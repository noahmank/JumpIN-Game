package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.JumpInGame;

public class BuildBoardButtonPanel extends JPanel{
	private JButton buildBoard;
	
	public BuildBoardButtonPanel(JumpInGame g, ActionListener c) {
		buildBoard = new JButton("Build New Board");
		// need to add action listener
		this.add(buildBoard);
	}
}
