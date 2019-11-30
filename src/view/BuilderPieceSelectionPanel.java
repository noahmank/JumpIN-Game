package view;

import java.awt.GridLayout;

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
	private JComboBox<String> rabbitProperty;
	private JComboBox<String> foxProperty;
	private JComboBox<String> property;
	
	
	public BuilderPieceSelectionPanel(JumpInGame g) {
		super(new GridLayout(2, 2));
		property = new JComboBox<>();
		
		// Piece type selection box
		String[] pieceTypes = {"Fox", "Rabbit", "Mushroom"};
		JComboBox<String> pieceSelect = new JComboBox<>(pieceTypes);
		pieceSelect.setSelectedIndex(-1);
		new PieceSelectController(g.getBuilder(), pieceSelect);
		
		// Piece property selection box
		// Initialize JComboBox for rabbit properties (color)
		rabbitProperty = new JComboBox<>();
		for(RabbitColor c : RabbitColor.values()) {
			rabbitProperty.addItem(c.toString());
		}
		rabbitProperty.setSelectedIndex(-1);
		new AttributeSelectController(g.getBuilder(), rabbitProperty);
		
		// Initialize JComboBox for fox properties (direction)
		foxProperty = new JComboBox<>();
		for(Direction d : Direction.values()) {
			foxProperty.addItem(d.toString());
		}
		foxProperty.setSelectedIndex(-1);
		new AttributeSelectController(g.getBuilder(), foxProperty);
		
		// Add piece button
		JButton addPiece = new JButton("Add"); // Might need to set bounds
		// TODO Add ActionListener
		
		// Remove piece button
		JButton removePiece = new JButton("Remove"); // Might need to set bounds
		// TODO Add ActionListener
		
		this.add(pieceSelect);
		this.add(property);
		this.add(addPiece);
		this.add(removePiece);
	}
	
	@Override
	public void updateView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subscribeToModel() {
		// TODO Auto-generated method stub
		
	}

}
