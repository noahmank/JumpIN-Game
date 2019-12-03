package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import view.GeneralFrame;

public class FrameCloseController extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		GeneralFrame frame = (GeneralFrame) e.getSource();
		//frame.getGame().save();
		frame.dispose();
		System.exit(0);
	}
}
