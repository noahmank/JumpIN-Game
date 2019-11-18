package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import model.JumpInGame;

public class SolverFrame extends JFrame {
	private GridPanel gridPanel;
	private SolverButtonPanel solverButtonPanel;
	private ConsoleOutputPanel consoleOutputPanel;
	private SolverMenuBar menuBar;
	
	public SolverFrame(JumpInGame game, JumpInView view) {
		super("Jump-In Solver");
		this.gridPanel = new GridPanel(game, null);
		this.solverButtonPanel = new SolverButtonPanel(game);
		this.consoleOutputPanel = new ConsoleOutputPanel(game);
		this.menuBar = new SolverMenuBar(game, view);
		
		this.add(gridPanel, BorderLayout.CENTER);
		this.add(solverButtonPanel, BorderLayout.SOUTH);
		this.add(consoleOutputPanel, BorderLayout.NORTH);
		this.setJMenuBar(menuBar);
		
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
