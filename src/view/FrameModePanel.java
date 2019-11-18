package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.FrameViewController;

public class FrameModePanel extends JPanel {
	private FrameViewController controller;
	
	public FrameModePanel(JumpInView v) {
		this.controller = new FrameViewController(v);
		JButton start = new JButton("Click here to Start Game");
		JButton solve = new JButton("Click here to Solve Game");
		this.add(start);
		this.add(solve);
		solve.addActionListener(controller);
		start.addActionListener(controller);
	}
}
