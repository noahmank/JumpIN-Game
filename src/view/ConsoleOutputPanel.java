package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import model.JumpInGame;

public class ConsoleOutputPanel extends JPanel implements View {
	private JTextField output;
	private JumpInGame g;
	
	public ConsoleOutputPanel(JumpInGame g) {
		super();
		this.g = g;
        output = new JTextField("Game initialized", 60);
        output.setHorizontalAlignment(JTextField.CENTER);
        output.setColumns(30);
        output.setEditable(false);                       	 
        this.add(output, BorderLayout.EAST);
        subscribeToModel();
	}
	
	public void updateView() {
		this.output.setText(g.getConsoleOutput());
	}
	
	public void subscribeToModel() {
		this.g.addView(this);
	}
}
