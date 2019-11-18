package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import model.JumpInGame;

/**
 * 
 * @author RunTime Terror
 *
 */
public class ConsoleOutputPanel extends JPanel implements JumpInGameListener {
	
	private JTextField output;
	private JumpInGame g;
	
	/**
	 * Constructs a output panel to display the status of the game
	 * @param g is the JumpIn game model
	 */
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
	
	/**
	 * Updates the solver button
	 */
	public void updateView() {
		this.output.setText(g.getConsoleOutput());
	}
	
	/**
	 * Subscribes the output panel to the JumpIn game model
	 */
	public void subscribeToModel() {
		this.g.addView(this);
	}
}
