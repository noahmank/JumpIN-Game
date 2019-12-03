package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.GameBoardButtonController;
import model.JumpInGame;

public class GameFrame extends GeneralFrame {
	private DirectionButtonPanel arrowPanel;
	private BoardGridPanel gridPanel;
	private ConsoleOutputPanel consoleOutputPanel;
	private GameMenuBar menuBar;
	private JumpInGame game;
	
	public GameFrame(JumpInGame game, JumpInView view) {
		super("Jump-In Game", game);
		
    	this.gridPanel = new BoardGridPanel(game, new GameBoardButtonController(game));
        this.arrowPanel = new DirectionButtonPanel(game);
        this.consoleOutputPanel = new ConsoleOutputPanel(game);
        this.menuBar = new GameMenuBar(game, view);
        
        this.setJMenuBar(menuBar);
        this.add(arrowPanel, BorderLayout.SOUTH);	
    	this.add(gridPanel, BorderLayout.CENTER);
    	this.add(consoleOutputPanel, BorderLayout.NORTH);    		
    	
	}
}
