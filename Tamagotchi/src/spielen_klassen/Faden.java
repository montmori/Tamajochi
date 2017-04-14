/**
 * Subklasse von Spielmoeglichkeit.
 * Faden-Spielmöglichkeit
 */

package spielen_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Faden extends Spielmoeglichkeit {

	private static final long serialVersionUID = 8272997277366389335L;

	
	/**
	 * Konstruktor.
	 * Aufruf SuperKonstruktor.
	 * Legt fest, ob diese Spielmöglichkeit schon freigeschaltet ist.
	 * Setzt die Zeit, die es braucht, um diese Spielmöglichkeit freizuschalten.
	 */
	public Faden(){
		super("Faden");
		super.setUnlocked(true);
		super.setTimeTillUnlock(FADEN_TTU);
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
	 * Solange das Tamagotchi spielt, werden alle Buttons disabled und die run wird einmal nach der Spieldauer ausgeführt.
	 */
	public void beBusy(){
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, FADENSPIELDAUER, TimeUnit.SECONDS);
	}
	
	
	/**
	 * Bedürfniswerte werden angepasst. 
	 * Buttons werden enabled.
	 */
	public void run(){
		Game.getGame().getTamagotchi().getLangeweile().veraendereBeduerfnisWert(FADEN_L);
		Game.getGame().getTamagotchi().getMuedigkeit().veraendereBeduerfnisWert(FADEN_M);
		Game.getGame().getTamagotchi().getDurst().veraendereBeduerfnisWert(FADEN_T);
		Game.getGame().getTamagotchi().getHunger().veraendereBeduerfnisWert(FADEN_H);
		ButtonPanel.setButtonsEnabled(true);
	}
	
}
