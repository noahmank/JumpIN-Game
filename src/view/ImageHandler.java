package view;

import java.awt.Image;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public final class ImageHandler {
	public static URL getImageURL(String imageName) {
		return JumpInView.class.getResource("/images/" + imageName);
	}
	
	/**
	 * @param icon is the image of the icon
	 * @param resizedWidth is the new width you wish to change it to
	 * @param resizedHeight is the new height you wish to change it to
	 * @return the resized image icon to the specified dimensions
	 */
	public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }	
}
