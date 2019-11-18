package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.SolverButtonController;
import model.JumpInGame;

/**
 * 
 * @author RunTime Terror
 *
 */
public class SolverButtonPanel extends JPanel {
	
	private JumpInGame game;
	
	/**
	 * Creating a Button labeled 'Solve Board' that will be handled by the SolverButtonController
	 * @param g is the JumpIN Game
	 */
	public SolverButtonPanel(JumpInGame g) {
		super();
		this.game = g;
		JButton solveButton = new JButton("Solve Board");
        this.add(solveButton);
        solveButton.addActionListener(new SolverButtonController(this.game));
	}
}
