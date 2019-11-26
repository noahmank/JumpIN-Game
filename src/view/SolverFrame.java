package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import model.JumpInGame;

/**
 * 
 * @author Runtime Terror
 *
 */
public class SolverFrame extends JFrame {
	private BoardGridPanel gridPanel;
	private SolverButtonPanel solverButtonPanel;
	private ConsoleOutputPanel consoleOutputPanel;
	private DefaultMenuBar menuBar;
	
	/**
	 * Populating the Solver frame 
	 * @param game is the JumpIN game Model
	 * @param view is the JumpIN game view
	 */
	public SolverFrame(JumpInGame game, JumpInView view) {
		super("Jump-In Solver");
		this.gridPanel = new BoardGridPanel(game, null);
		this.solverButtonPanel = new SolverButtonPanel(game);
		this.consoleOutputPanel = new ConsoleOutputPanel(game);
		this.menuBar = new DefaultMenuBar(game, view);
		
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
