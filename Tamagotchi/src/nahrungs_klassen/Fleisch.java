/**
 * Subklasse von Nahrung.
 * Fleisch-Nahrung
 */

package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Fleisch extends Nahrung{

	private static final long serialVersionUID = -8118220751990421966L;

	/**
	 * Konstruktor.
	 * Aufruf SuperKonstruktor.
	 * Legt fest, ob diese Nahrung schon freigeschaltet ist.
	 * Setzt die Zeit, die es braucht, um diese Nahrung freizuschalten.
	 */
	public Fleisch() {
		super("Fleisch");
		super.setUnlocked(false);
		super.setTimeTillUnlock(FLEISCH_TTU);
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
		Game.getGame().getTamagotchi().getHunger().veraendereBeduerfnisWert(FLEISCH_H);
		Game.getGame().getTamagotchi().getDurst().veraendereBeduerfnisWert(FLEISCH_T);
		Game.getGame().getTamagotchi().getMuedigkeit().veraendereBeduerfnisWert(FLEISCH_M);
		ButtonPanel.setButtonsEnabled(true);
	}
}
