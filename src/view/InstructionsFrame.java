package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.FrameViewController;

public class InstructionsFrame extends JFrame {
	private FrameViewController controller;
	
	public InstructionsFrame(JumpInView v) {
		super("Welcome to Jump-In Game");
		this.controller = new FrameViewController(v);
		JButton start = new JButton("Click here to Start Game");
		start.addActionListener(controller);
		
    	JLabel ruleText = new JLabel("<html>Welcome to The JumpIn Game.<br/><br/>GAME RULES<br/> "    			
    			+ "1) The Objective of the game is to move the rabbits and foxes around the gameboard until all of the rabbits are safe in brown holes.<br/> "
    			+ "2) To move a rabbit or a fox, select one of them first then click the direction you want to move them in from the direction buttons at the bottom of the screen <br/><html/>"
    			+ "3) You have found a solution when all of the rabbits are inside brown holes!<br/><html/>");       	    	
    	ruleText.setPreferredSize(new Dimension(400,200));
    	this.add(ruleText);
    	 
		this.add(start, BorderLayout.SOUTH);
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
