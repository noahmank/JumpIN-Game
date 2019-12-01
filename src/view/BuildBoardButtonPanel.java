package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.JumpInGame;

public class BuildBoardButtonPanel extends JPanel{
	private JButton buildBoard;
	private JumpInGame game;
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
	
	public void buildBoardActionPerformed(ActionEvent e) {
		// TODO
	}
}
