/**
 * Diese Klasse ist hauptsaechlich fuer die Grafik.
 * Erstellt einen Bildarray und befuellt diesen. 
 * Der Array wird spaeter an die AnimationT durchgegeben, wenn ein Viech erstellt werden sollte.
 * Grund: Erweiterungen!
 */

package tamagotchi_klassen;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import debugInterface.Debugable;
import game.Game;


public class Viech extends Tamagotchi {

	private static final long serialVersionUID = 839775627097813343L;
	
	private ImageIcon[] bildArrayLebendig;
	private ImageIcon[] bildArrayTot;
	private final int BILDANZAHL = 3;
	private final int BILDANZAHL_TOT = 2;
	
	/**
	 * Konstruktor
	 * Gibt alle wichtigen Informationen zur Superklasse
	 * @param name	Name des Tamagotchis.
	 */
	public Viech(String name){
		super(name);
		super.BILDANZAHL = this.BILDANZAHL;
		super.BILDANZAHL_TOT = this.BILDANZAHL_TOT;
		this.fillBildArrays();
	}
	
	
	/**
	 * Befüllt die beiden ImageIcon Arrays, damit sie für die Animation verwendet werden können.
	 */
	private void fillBildArrays(){
		
		int userWidth = Game.getGame().getUserSize().getWidth() == 600 ? 400 :(int)(Game.getGame().getUserSize().getWidth() - 320);
		int userHeight = (int)(Game.getGame().getUserSize().getHeight() - 180);
		this.bildArrayLebendig = new ImageIcon[this.BILDANZAHL];
		this.bildArrayTot = new ImageIcon[this.BILDANZAHL_TOT];
		
		try {
			for(int i = 0; i < this.BILDANZAHL; i++){
				Image temp = ImageIO.read(this.getClass().getResource("/Images/tamagotchiNormal" + i + ".png"));
				temp = temp.getScaledInstance(userWidth, userHeight, Image.SCALE_SMOOTH);
				this.bildArrayLebendig[i] = new ImageIcon(temp);
			}
			
		} catch (IOException e) {
			if(Debugable.DEBUG_GUI){
				System.out.println("Keine Bilder fuer Animation gefunden! Fehler in Klasse Viech");
			}
		}
		
		try {
			for(int i = 0; i < this.BILDANZAHL_TOT; i++){
				Image temp = ImageIO.read(this.getClass().getResource("/Images/tamagotchiDead" + i + ".png"));
				temp = temp.getScaledInstance(userWidth, userHeight, Image.SCALE_SMOOTH);
				this.bildArrayTot[i] = new ImageIcon(temp);
			}
			
		} catch (IOException e) {
			if(Debugable.DEBUG_GUI){
				System.out.println("Keine Bilder fuer Animation TOT gefunden! Fehler in Klasse Viech");
			}
		}
		
	}
	
	
	/**
	 * @return Referenz auf den ImageIcon Array für die Lebendanimation.
	 */
	public ImageIcon[] getBildArrayLebendig(){
		return this.bildArrayLebendig;
	}
	

	/**
	 * @return Referenz auf den ImageIcon Array für die Todesanimation.
	 */
	public ImageIcon[] getBildArrayTot() {
		return this.bildArrayTot;
	}	
}
