package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import model.*;
import controller.*;
/**
* Builder frame
*/
public class BuilderFrame extends JFrame {
	private BuilderPieceSelectionPanel builderPieceSelectionPanel;
	private BoardGridPanel boardGridPanel;
	private BuildBoardButtonPanel buildBoardButtonPanel;
	private DefaultMenuBar solverMenuBar; // Need to rename this class to generalize
	
	/**
	* Constructor for the builder frame
	* @param g is the game
	* @param v is the view
	*/
	public BuilderFrame(JumpInGame g, JumpInView v) {
		super("Jump-In Builder");
		this.builderPieceSelectionPanel = new BuilderPieceSelectionPanel(g);
		this.boardGridPanel = new BoardGridPanel(g, new BuilderBoardButtonController(g));
		this.buildBoardButtonPanel = new BuildBoardButtonPanel(g, null);
		this.solverMenuBar = new DefaultMenuBar(g, v);
		
		this.add(boardGridPanel, BorderLayout.CENTER);
		this.add(builderPieceSelectionPanel, BorderLayout.NORTH);
		this.add(buildBoardButtonPanel, BorderLayout.SOUTH);
		this.setJMenuBar(solverMenuBar);
		
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
