package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import model.*;
import controller.*;
/**
* Builder frame
*/
public class BuilderFrame extends GeneralFrame {
	private BuilderPieceSelectionPanel builderPieceSelectionPanel;
	private BoardGridPanel boardGridPanel;
	private BuildBoardButtonPanel buildBoardButtonPanel;
	private DefaultMenuBar solverMenuBar; // Need to rename this class to generalize
	private JumpInGame game;
	
	/**
	* Constructor for the builder frame
	* @param g is the game
	* @param v is the view
	*/
	public BuilderFrame(JumpInGame g, JumpInView v) {
		super("Jump-In Builder", g);
		this.builderPieceSelectionPanel = new BuilderPieceSelectionPanel(g);
		this.boardGridPanel = new BoardGridPanel(g, new BuilderBoardButtonController(g));
		this.buildBoardButtonPanel = new BuildBoardButtonPanel(g, null);
		this.solverMenuBar = new DefaultMenuBar(g, v);
		
		this.add(boardGridPanel, BorderLayout.CENTER);
		this.add(builderPieceSelectionPanel, BorderLayout.NORTH);
		this.add(buildBoardButtonPanel, BorderLayout.SOUTH);
		this.setJMenuBar(solverMenuBar);
	}
}
