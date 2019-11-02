package view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import model.*;

public class GameFrame extends JFrame{
	private JumpInGame game;
	private DirectionButtonGrid directions;
	private BoardGrid board;
	private GameRules rules;
	
	public GameFrame(DirectionButtonGrid d, BoardGrid b, GameRules r) {
		JFrame frame = new JFrame("Level 1");
		this.directions = d;
		this.board = b;
		this.rules = r;
		frame.add(this.directions, BorderLayout.SOUTH);
		frame.add(this.board, BorderLayout.CENTER);
		frame.add(this.rules, BorderLayout.NORTH);
	}
	public void update() {
		//Do something
	}
}
