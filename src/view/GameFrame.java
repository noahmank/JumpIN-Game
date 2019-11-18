package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.GameBoardButtonController;
import model.JumpInGame;

public class GameFrame extends JFrame {
	private ArrowButtonPanel arrowPanel;
	private BoardGrid gridPanel;
	private ConsoleOutputPanel consoleOutputPanel;
	private GameMenuBar menuBar;
	
	public GameFrame(JumpInGame game, JumpInView view) {
		super("Jump-In Game");
		
    	this.gridPanel = new BoardGrid(game, new GameBoardButtonController(game));
        this.arrowPanel = new ArrowButtonPanel(game);
        this.consoleOutputPanel = new ConsoleOutputPanel(game);
        this.menuBar = new GameMenuBar(game, view);
        
        this.setSize(700, 700);
        this.setLocationRelativeTo(null);
        this.setJMenuBar(menuBar);
        this.add(arrowPanel, BorderLayout.SOUTH);	
    	this.add(gridPanel, BorderLayout.CENTER);
    	this.add(consoleOutputPanel, BorderLayout.NORTH);    	
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
}
