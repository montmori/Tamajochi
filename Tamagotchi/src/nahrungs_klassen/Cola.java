/**
 * Subklasse von Nahrung.
 * Cola-Nahrung
 */

package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Cola extends Nahrung {

	
	private static final long serialVersionUID = 9019274140977439311L;

	/**
	 * Konstruktor.
	 * Aufruf SuperKonstruktor.
	 * Legt fest, ob diese Nahrung schon freigeschaltet ist.
	 * Setzt die Zeit, die es braucht, um diese Nahrung freizuschalten.
	 */
	public Cola() {
		super("Cola");
		super.setUnlocked(false);
		super.setTimeTillUnlock(COLA_TTU);
	}
	

	/**
	 * beBusy-Methode wird aufgerufen.
	 * Achievments werden �berpr�ft und gegebenenfalls zur�ckgesetzt.
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
	 * Solange das Tamagotchi konsumiert, werden alle Buttons disabled und die run wird einmal nach der Essensdauer ausgef�hrt.
	 */
	public void beBusy(){
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, ESSDAUER, TimeUnit.SECONDS);
	}
	
	
	/**
	 * Bed�rfniswerte werden angepasst. 
	 * Buttons werden enabled.
	 */
	public void run(){
		Game.getGame().getTamagotchi().getDurst().veraendereBeduerfnisWert(COLA_T);
		Game.getGame().getTamagotchi().getHunger().veraendereBeduerfnisWert(COLA_H);
		Game.getGame().getTamagotchi().getMuedigkeit().veraendereBeduerfnisWert(COLA_M);
		ButtonPanel.setButtonsEnabled(true);
	}

}
