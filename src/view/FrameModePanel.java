package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.FrameViewController;
import model.JumpInGame;

public class FrameModePanel extends JPanel {
	private FrameViewController controller;
	
	public FrameModePanel(JumpInGame g, JumpInView v) {
		this.controller = new FrameViewController(g, v);
		JButton start = new JButton("Click here to Start Game");
		JButton solve = new JButton("Click here to Solve Game");
		this.add(start);
		this.add(solve);
		solve.addActionListener(controller);
		start.addActionListener(controller);
	}
}
