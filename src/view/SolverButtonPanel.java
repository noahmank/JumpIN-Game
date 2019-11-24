package view;

import java.awt.event.ActionListener;

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
	private JButton solverButton;
	private SolverButtonController solverController;
	
	/**
	 * Creating a Button labeled 'Solve Board' that will be handled by the SolverButtonController
	 * @param g is the JumpIN Game
	 */
	public SolverButtonPanel(JumpInGame g) {
		super();
		this.game = g;
		solverButton = new JButton("Solve Board");
        this.add(solverButton);
        solverController  = new SolverButtonController(g, this);
	}
	
	public void subscribeToSolverController(ActionListener actionListener) {
		solverButton.addActionListener(actionListener);
	}
}
