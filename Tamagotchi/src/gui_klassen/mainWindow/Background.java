/**
 * Hintergrund für das gesamte Fenster.
 */

package gui_klassen.mainWindow;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Background {

	private ImageIcon background;
	
	
	/**
	 * Konstruktor.	
	 * Läd den Hintergrund und skaliert diesen.
	 * @param d		Dimension die das ganze Fenster hat.
	 */
	public Background(Dimension d){
		
		Image bild;
		
		int width = (int)d.getWidth() - 1;
		int height = (int)d.getHeight() - 1;
		
		try {
			bild = ImageIO.read(Background.class.getResource("/Images/background.png"));
			
			bild = bild.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			
			this.background = new ImageIcon(bild);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @return	den Hintergrund als ImageIcon.
	 */
	public ImageIcon getBackground(){
		return this.background;
	}

}