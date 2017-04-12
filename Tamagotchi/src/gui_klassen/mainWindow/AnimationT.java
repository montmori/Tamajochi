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

public class AnimationT implements Runnable{

	private ImageIcon[] bildArrayLebendig; //benutze ImageIcon weil man da den Loadstatus abfragen kann!
	private final int BILDANZAHL = Game.getGame().getTamagotchi().BILDANZAHL;
	private ImageIcon[] bildArrayTot;
	private final int BILDANZAHL_TOT = Game.getGame().getTamagotchi().BILDANZAHL_TOT;

	private boolean rechtsrum = true;
	private int zaehler;
	private int zaehlerTot = 0;
	private boolean lebendig;
	private ScheduledThreadPoolExecutor timer;
	
	private ImageIcon currentBild;

	
	/*
	 * Macht einen ImageIconArray
	 * Holt sich den Bildarray aus dem Tamagotchi und startet sich selbst
	 */
	public AnimationT(){	
		
		this.timer = new ScheduledThreadPoolExecutor(10);

		this.bildArrayLebendig = new ImageIcon[this.BILDANZAHL];
		this.zaehler = this.BILDANZAHL/2;			
		this.bildArrayTot = new ImageIcon[this.BILDANZAHL_TOT];

		this.bildArrayLebendig = Game.getGame().getTamagotchi().getBildArrayLebendig();
		this.currentBild = this.bildArrayLebendig[this.BILDANZAHL/2];
		
		this.bildArrayTot = Game.getGame().getTamagotchi().getBildArrayTot();

		this.timer.scheduleAtFixedRate(this, 100, 100, TimeUnit.MILLISECONDS);	
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
			this.currentBild = this.bildArrayLebendig[zaehler-1];
		}
		else{
			this.zaehler--;
			//System.out.println("negativ " + this.zaehler);
			this.currentBild = this.bildArrayLebendig[zaehler-1];
		}
		
		if(this.zaehler == this.BILDANZAHL || this.zaehler == 1){
			this.rechtsrum = !rechtsrum;
		}

	}
	
	public void changeImageWhileDead(){
		
		this.currentBild = this.bildArrayTot[this.zaehlerTot];
		
		if(this.zaehlerTot != this.BILDANZAHL_TOT - 1){
			this.zaehlerTot++;
		}
	}

	/*
	 *Alle 100 Millisekunden wird das Bild geaendert
	 */
	public void run() {
		this.lebendig = Game.getGame().getTamagotchi().isLebendig();
		if(this.lebendig){
			this.changeImage();
		}
		else{
			this.changeImageWhileDead();
		}
	}
	
	
}