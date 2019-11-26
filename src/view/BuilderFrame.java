package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import model.*;
import controller.*;

public class BuilderFrame extends JFrame {
	private BuilderPieceSelectionPanel builderPieceSelectionPanel;
	private BoardGridPanel boardGridPanel;
	//TODO Add constructing button panel
	
	public BuilderFrame(JumpInGame g, JumpInView v) {
		super("Jump-In Builder");
		this.builderPieceSelectionPanel = new BuilderPieceSelectionPanel(g);
		this.boardGridPanel = new BoardGridPanel(g, new BuilderBoardButtonController(g));
		
		this.add(boardGridPanel, BorderLayout.CENTER);
		this.add(builderPieceSelectionPanel, BorderLayout.NORTH);
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
