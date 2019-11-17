package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import model.JumpInGame;

public class ConsoleOutputPanel extends JPanel {
	private JTextField output;
	private JumpInGame g;
	
	public ConsoleOutputPanel(JumpInGame g) {
		super();
		this.g = g;
        output = new JTextField("Game initialized", 60);
        output.setColumns(20);
        output.setEditable(false);                       	 
        this.add(output, BorderLayout.EAST);
	}
}
