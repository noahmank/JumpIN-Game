package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import model.*;
import view.*;

public class UndoRedoButtonController implements ActionListener {
	private JumpInGame game;
	
	public UndoRedoButtonController(JumpInGame game, JumpInView view) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem) e.getSource();
		if(source.getText().equals("Undo")) {
			game.undoMoveAction();
		} 
		else if(source.getText().equals("Redo")) {
			game.redoMoveAction();
		}
	}
}
