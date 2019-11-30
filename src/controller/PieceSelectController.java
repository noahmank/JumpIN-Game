package controller;

import java.awt.event.*;
import javax.swing.JComboBox;
import model.*;


public class PieceSelectController implements ActionListener {
	private BoardBuilder builder;
	
	public PieceSelectController(BoardBuilder builder, JComboBox<String> b) {
		this.builder = builder;
		b.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<String> box = (JComboBox<String>) e.getSource();
		String s = (String) box.getSelectedItem();
		this.builder.setPieceName(s);
	}
}
