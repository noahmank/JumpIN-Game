package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import model.Direction;
import model.RabbitColor;


/**
 * Class that displays piece selection and add/remove buttons in Game builder
 * @author Noah Mank
 *
 */
public class BuilderPieceSelectionPanel extends JPanel implements JumpInGameListener {
	JComboBox<String> rabbitProperty;
	JComboBox<String> foxProperty;
	JComboBox<String> property;
	public BuilderPieceSelectionPanel() {
		super(new GridLayout(2, 2));
		
		// Piece type selection box
		String[] pieceTypes = {"Fox", "Rabbit", "Mushroom"};
		JComboBox<String> pieceSelect = new JComboBox<>(pieceTypes);
		pieceSelect.setSelectedIndex(-1);
		// TODO Add ActionListener
		
		// Piece property selection box
		// Initialize JComboBox for rabbit properties (color)
		rabbitProperty = new JComboBox<>();
		for(RabbitColor c : RabbitColor.values()) {
			rabbitProperty.addItem(c.toString());
		}
		rabbitProperty.setSelectedIndex(-1);
		// Initialize JComboBox for fox properties (direction)
		foxProperty = new JComboBox<>();
		for(Direction d : Direction.values()) {
			foxProperty.addItem(d.toString());
		}
		
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
