/**
 * Subklasse von Nahrung.
 * Milch-Nahrung
 */

package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Milch extends Nahrung {

	private static final long serialVersionUID = 9019274140977439311L;

	/**
	 * Konstruktor.
	 * Aufruf SuperKonstruktor.
	 * Legt fest, ob diese Nahrung schon freigeschaltet ist.
	 * Setzt die Zeit, die es braucht, um diese Nahrung freizuschalten.
	 */
	public Milch() {
		super("Milch");
		super.setUnlocked(false);
		super.setTimeTillUnlock(MILCH_TTU);
	}
	
	
	/**
	 * beBusy-Methode wird aufgerufen.
	 * Achievments werden überprüft und gegebenenfalls zurückgesetzt, bzw. gesetzt.
	 */
	public void use() {
		beBusy();
		if(!Game.getGame().getAchievements().isErfolg2() && Game.getGame().getAchievements().getErfolg2Bedingung()){
			Game.getGame().getAchievements().setErfolg2();
		}
		if(!Game.getGame().getAchievements().isErfolg3()){
			Game.getGame().getAchievements().resteErfolg3Bedingung();
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
		Game.getGame().getTamagotchi().getDurst().veraendereBeduerfnisWert(MILCH_T);
		Game.getGame().getTamagotchi().getHunger().veraendereBeduerfnisWert(MILCH_H);
		ButtonPanel.setButtonsEnabled(true);
	}


}
