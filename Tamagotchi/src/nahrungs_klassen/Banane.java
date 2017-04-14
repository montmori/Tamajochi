/**
 * Subklasse von Nahrung.
 * Banane-Nahrung
 */

package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Banane extends Nahrung{

	private static final long serialVersionUID = -6772286053916694111L;

	/**
	 * Konstruktor.
	 * Aufruf SuperKonstruktor.
	 * Legt fest, ob diese Nahrung schon freigeschaltet ist.
	 * Setzt die Zeit, die es braucht, um diese Nahrung freizuschalten.
	 */
	public Banane() {
		super("Banane");
		super.setUnlocked(true);
		super.setTimeTillUnlock(BANANE_TTU);
	}


	/**
	 * beBusy-Methode wird aufgerufen.
	 * Achievments werden überprüft und gegebenenfalls zurückgesetzt.
	 */
	public void use() {
		beBusy();
		if(!Game.getGame().getAchievements().isErfolg2()){
			Game.getGame().getAchievements().resteErfolg2Bedingung();
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
		Game.getGame().getTamagotchi().getHunger().veraendereBeduerfnisWert(BANANE_H);
		ButtonPanel.setButtonsEnabled(true);
	}



}
