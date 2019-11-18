package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import view.JumpInView;

/**
 * 
 * @author RunTime Terror
 *
 */
public class FileMenuController implements ActionListener {
	
	private JumpInView view;
	
	/**
	 * Instantiates the 'File' menu handler
	 * @param view is the JumpIn game view
	 */
	public FileMenuController(JumpInView view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem) e.getSource();
		if(source.getText().equals("Home")) {
			this.view.toInstructionsFrame();
		} 
	}

}
