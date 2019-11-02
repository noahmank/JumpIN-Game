package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BoardGrid extends JFrame {
	public BoardGrid() {
		setLayout(new GridLayout(5,5));
		for(int i = 0; i < 25; i++) {
			add(new JButton("i"));
		}
	}
}
