/*
 * Diese Klasse ist hauptsaechlich fuer die Grafik.
 * Erstellt einen Bildarray und befuellt diesen. 
 * Der Array wird spaeter an die AnimationT durchgegeben, wenn ein Viech erstellt werden sollte.
 * Grund: Erweiterungen!
 */

package tamagotchi_klassen;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import debugInterface.Debugable;
import game.Game;


public class Viech extends Tamagotchi {

	private static final long serialVersionUID = 839775627097813343L;
	
	private ImageIcon[] bildArray;
	private final int BILDANZAHL = 3;
	
	public Viech(String name){
		super(name);
		super.BILDANZAHL = this.BILDANZAHL;
		this.fillBildArray();
	}
	
	private void fillBildArray(){
		
		int userWidth = Game.getGame().getUserSize().getWidth() == 600 ? 400 :(int)(Game.getGame().getUserSize().getWidth() - 320);
		int userHeight = (int)(Game.getGame().getUserSize().getHeight() - 180);
		this.bildArray = new ImageIcon[this.BILDANZAHL];
		
		try {
			for(int i = 0; i < this.BILDANZAHL; i++){
				Image temp = ImageIO.read(new File("Images/tamagotchiNormal" + i + ".png"));
				temp = temp.getScaledInstance(userWidth, userHeight, Image.SCALE_SMOOTH);
				this.bildArray[i] = new ImageIcon(temp);
			}
			
		} catch (IOException e) {
			if(Debugable.DEBUG_GUI){
				System.out.println("Keine Bilder fuer Animation gefunden! Fehler in Klasse Viech");
			}
		}
		
	}
	
	
	public ImageIcon[] getBildArray(){
		return this.bildArray;
	}	
}
