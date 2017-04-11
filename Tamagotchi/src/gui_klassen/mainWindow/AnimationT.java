/*
 * Klasse fuer die Animationen.
 * Aufgaben: 
 * - Laed BilderArray aus dem instanzierten Tamagotchi (Grund: erweiterbar!)
 * - Wechselt jede 100 Millisekunden das Bild und suggeriert so eine Bewegung.
 * 
 */

package gui_klassen.mainWindow;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;

import game.Game;
import runnable_klassen.OwnTimer;

public class AnimationT implements Runnable{

	private ImageIcon[] bildArray; //benutze ImageIcon weil man da den Loadstatus abfragen kann!
	private final int BILDANZAHL = Game.getGame().getTamagotchi().BILDANZAHL;

	private boolean rechtsrum = true;
	private int zaehler;
	
	private ImageIcon currentBild;

	
	/*
	 * Macht einen ImageIconArray
	 * Holt sich den Bildarray aus dem Tamagotchi und startet sich selbst
	 */
	public AnimationT(){		
	
		this.bildArray = new ImageIcon[this.BILDANZAHL];
		this.zaehler = this.BILDANZAHL/2;		

		this.bildArray = Game.getGame().getTamagotchi().getBildArray();
		this.currentBild = this.bildArray[this.BILDANZAHL/2];

		OwnTimer.queueTask(this, 100, 100, TimeUnit.MILLISECONDS);	
	}
	
	/*
	 * Gibt das Momentanbild zurueck.
	 */
	public ImageIcon getCurrentBild(){
		return this.currentBild;
	}
	
	
	/*
	 * Aendert die Bilder indem der Array von vorne nach hinten und dann von hinten nach vorne durchlaufen wird.
	 */
	public void changeImage(){
		
		if(rechtsrum){
			this.zaehler++;
			//System.out.println("positiv " + this.zaehler);
			this.currentBild = this.bildArray[zaehler-1];
		}
		else{
			this.zaehler--;
			//System.out.println("negativ " + this.zaehler);
			this.currentBild = this.bildArray[zaehler-1];
		}
		
		if(this.zaehler == this.BILDANZAHL || this.zaehler == 1){
			this.rechtsrum = !rechtsrum;
		}

	}

	/*
	 *Alle 100 Millisekunden wird das Bild geaendert
	 */
	public void run() {
		this.changeImage();
	}
	
	
}