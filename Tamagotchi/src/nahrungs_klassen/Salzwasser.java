/**
 * Subklasse von Nahrung.
 * Salzwasser-Nahrung
 */

package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Salzwasser extends Nahrung {

	private static final long serialVersionUID = 3531122978200688656L;
	
	/**
	 * Konstruktor.
	 * Aufruf SuperKonstruktor.
	 * Legt fest, ob diese Nahrung schon freigeschaltet ist.
	 * Setzt die Zeit, die es braucht, um diese Nahrung freizuschalten.
	 */
	public Salzwasser() {
		super("Salzwasser");
		super.setUnlocked(false);
		super.setTimeTillUnlock(SALZWASSER_TTU);
	}


	/**
	 * beBusy-Methode wird aufgerufen.
	 * Achievments werden überprüft und gegebenenfalls zurückgesetzt, bzw. gesetzt.
	 */
	public void use() {
		beBusy();
		if(!Game.getGame().getAchievements().isErfolg2()){
			Game.getGame().getAchievements().resteErfolg2Bedingung();
		}
		if(!Game.getGame().getAchievements().isErfolg3()){
			Game.getGame().getAchievements().setErfolg3Bedingung();
		}
	}
	
	
	/**
	 * Solange das Tamagotchi konsumiert, werden alle Buttons disabled und die run wird einmal nach der Essensdauer ausgeführt.
	 */
	public void beBusy(){
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, ESSDAUER, TimeUnit.SECONDS);
	}
	
	
	/**
	 * Bedürfniswerte werden angepasst. 
	 * Buttons werden enabled.
	 */
	public void run(){		
		Game.getGame().getTamagotchi().getDurst().veraendereBeduerfnisWert(SALZWASSER_T);
		Game.getGame().getTamagotchi().getHunger().veraendereBeduerfnisWert(SALZWASSER_H);
		ButtonPanel.setButtonsEnabled(true);
	}

}
