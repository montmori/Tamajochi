/**
 * Subklasse von SchlafensOrt.
 * Bett-SchlafensOrt
 */

package schlafen_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Bett extends SchlafensOrt{

	private static final long serialVersionUID = -1252347912862515929L;

	
	/**
	 * Konstruktor.
	 * Aufruf SuperKonstruktor.
	 * Legt fest, ob dieser SchlafensOrt schon freigeschaltet ist.
	 * Setzt die Zeit, die es braucht, um diesen SchlafensOrt freizuschalten.
	 */
	public Bett(){
		super("Bett");
		super.setUnlocked(false);
		super.setTimeTillUnlock(BETT_TTU);
	}

	
	/**
	 * beBusy-Methode wird aufgerufen.
	 * Achievments werden überprüft und gegebenenfalls zurückgesetzt.
	 */
	public void use() {
		this.beBusy();
		if(!Game.getGame().getAchievements().isErfolg2()){
			Game.getGame().getAchievements().resteErfolg2Bedingung();
		}
		if(!Game.getGame().getAchievements().isErfolg3()){
			Game.getGame().getAchievements().resteErfolg3Bedingung();
		}
	}
	
	
	/**
	 * Solange das Tamagotchi schläft, werden alle Buttons disabled und die run wird einmal nach der Schlafensdauer ausgeführt.
	 */
	public void beBusy(){
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, BETTSCHLAFDAUER, TimeUnit.SECONDS);
	}
	
	
	/**
	 * Bedürfniswerte werden angepasst. 
	 * Buttons werden enabled.
	 */
	public void run(){
		Game.getGame().getTamagotchi().getMuedigkeit().veraendereBeduerfnisWert(BETT_M);
		Game.getGame().getTamagotchi().getLangeweile().veraendereBeduerfnisWert(BETT_L);
		ButtonPanel.setButtonsEnabled(true);
	}
}
