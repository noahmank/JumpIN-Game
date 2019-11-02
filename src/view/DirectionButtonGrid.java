package view;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DirectionButtonGrid extends JFrame {
	DirectionButtonGrid() {
		setLayout(new GridLayout(1, 4));
		add(new JButton("WEST"));
		add(new JButton("NORTH"));
		add(new JButton("EAST"));
		add(new JButton("SOUTH"));
	}
}
