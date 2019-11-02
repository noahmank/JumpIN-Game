package view;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DirectionButtonGrid extends JFrame {
	public DirectionButtonGrid() {
		setLayout(new GridLayout(1, 4));
		add(new JButton("WEST"));
		add(new JButton("NORTH"));
		add(new JButton("EAST"));
		add(new JButton("SOUTH"));
	}


	public static void main(String[] args) {
		DirectionButtonGrid b = new DirectionButtonGrid();
		b.setVisible(true);
	}
}