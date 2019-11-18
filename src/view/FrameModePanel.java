package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.FrameViewController;
import model.JumpInGame;

/**
 * 
 * @author RunTime Terror
 *
 */
public class FrameModePanel extends JPanel {
	
	private FrameViewController controller;
	
	/**
	 * Creating the 'start' and 'solve' buttons
	 * @param g is the JumpIn game model
	 * @param v is the JumpIn game view
	 */
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
