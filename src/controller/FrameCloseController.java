package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import model.JumpInGame;
import model.Save_Load;
import view.GeneralFrame;

public class FrameCloseController extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		GeneralFrame frame = (GeneralFrame) e.getSource();
		JumpInGame game = frame.getGame();
		Save_Load.saveGameDataToFile(frame.getGame(), "JumpInGame Save.txt");
		frame.dispose();
		System.exit(0);
	}
}
