package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import model.JumpInGame;
import model.SaveLoad;
import view.GeneralFrame;

public class FrameCloseController extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		GeneralFrame frame = (GeneralFrame) e.getSource();
		JumpInGame game = frame.getGame();
		SaveLoad.saveGameDataToFile(frame.getGame(), "JumpInGame Save.txt");
		frame.dispose();
		System.exit(0);
	}
}
