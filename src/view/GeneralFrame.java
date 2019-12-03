package view;

import javax.swing.JFrame;

import controller.FrameCloseController;
import model.JumpInGame;

public class GeneralFrame extends JFrame {
	private JumpInGame game;
	
	public GeneralFrame(String frameName, JumpInGame game) {
		super(frameName);
		this.game = game;
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new FrameCloseController());
	}
	
	public JumpInGame getGame() {
		return this.game;
	}
}
