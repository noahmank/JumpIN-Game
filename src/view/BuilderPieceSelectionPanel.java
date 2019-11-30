package view;

import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import controller.*;
import model.Direction;
import model.JumpInGame;
import model.RabbitColor;


/**
 * Class that displays piece selection and add/remove buttons in Game builder
 * @author Noah Mank
 *
 */
public class BuilderPieceSelectionPanel extends JPanel implements JumpInGameListener {
	private JumpInGame game;
	JComboBox<String> pieceSelect;
	private JComboBox<String> rabbitProperty;
	private JComboBox<String> foxProperty;
	private JComboBox<String> property;
	
	
	public BuilderPieceSelectionPanel(JumpInGame g) {
		super(new GridLayout(2, 2));
		this.game = g;
		property = new JComboBox<>();
		
		// Piece type selection box
		String[] pieceTypes = {"Fox", "Rabbit", "Mushroom"};
		pieceSelect = new JComboBox<>(pieceTypes);
		pieceSelect.setSelectedIndex(-1);
		new PieceSelectController(g.getBuilder(), pieceSelect);
		pieceSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pieceSelectActionPerformed(e);
			}
		});
		
		// Add piece button
		JButton addPiece = new JButton("Add"); // Might need to set bounds
		new AddButtonController(g.getBuilder(), addPiece);
		// Remove piece button
		JButton removePiece = new JButton("Remove"); // Might need to set bounds
		new RemoveButtonController(g.getBuilder(), removePiece);
		
		this.add(pieceSelect);
		this.add(property);
		this.add(addPiece);
		this.add(removePiece);
	}
	
	private void pieceSelectActionPerformed(ActionEvent e) {
		property.removeAllItems();
		if(pieceSelect.getSelectedItem().equals("Rabbit")) {
			for(RabbitColor c : RabbitColor.values()) {
				property.addItem(c.toString());
			}
		}
		if(pieceSelect.getSelectedItem().equals("Fox")) {
			for(Direction d : Direction.values()) {
				property.addItem(d.toString());
			}
		}
		property.setSelectedIndex(-1);
	}
	
	@Override
	public void updateView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subscribeToModel() {
		this.game.addView(this);
		
	}
	

}
