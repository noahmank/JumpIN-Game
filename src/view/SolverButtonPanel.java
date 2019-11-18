package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.SolverButtonController;
import model.JumpInGame;

public class SolverButtonPanel extends JPanel {
	private JumpInGame game;
	
	public SolverButtonPanel(JumpInGame g) {
		super();
		this.game = g;
		JButton solveButton = new JButton("Solve Board");
        this.add(solveButton);
        solveButton.addActionListener(new SolverButtonController(this.game));
	}
}
