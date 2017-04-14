/**
 * Subklasse von SchlafensOrt.
 * Boden-SchlafensOrt
 */
package schlafen_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Boden extends SchlafensOrt{

	private static final long serialVersionUID = -1501068204982203927L;

	
	/**
	 * Konstruktor.
	 * Aufruf SuperKonstruktor.
	 * Legt fest, ob dieser SchlafensOrt schon freigeschaltet ist.
	 * Setzt die Zeit, die es braucht, um diesen SchlafensOrt freizuschalten.
	 */
	public Boden(){
		super("Boden");
		super.setUnlocked(true);
		super.setTimeTillUnlock(BODEN_TTU);
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
		OwnTimer.queueTask(this, BODENSCHLAFDAUER, TimeUnit.SECONDS);
	}
	
	
	/**
	 * Bedürfniswerte werden angepasst. 
	 * Buttons werden enabled.
	 */
	public void run(){
		Game.getGame().getTamagotchi().getMuedigkeit().veraendereBeduerfnisWert(BODEN_M);
		Game.getGame().getTamagotchi().getLangeweile().veraendereBeduerfnisWert(BODEN_L);
		ButtonPanel.setButtonsEnabled(true);
	}


}
