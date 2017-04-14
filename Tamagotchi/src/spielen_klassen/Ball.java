/**
 * Subklasse von Spielmoeglichkeit.
 * Ball-Spielm�glichkeit
 */

package spielen_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Ball extends Spielmoeglichkeit {

	private static final long serialVersionUID = 1042772169194270806L;

	
	/**
	 * Konstruktor.
	 * Aufruf SuperKonstruktor.
	 * Legt fest, ob diese Spielm�glichkeit schon freigeschaltet ist.
	 * Setzt die Zeit, die es braucht, um diese Spielm�glichkeit freizuschalten.
	 */
	public Ball(){
		super("Ball");
		super.setUnlocked(false);
		super.setTimeTillUnlock(BALL_TTU);
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
	 * Solange das Tamagotchi spielt, werden alle Buttons disabled und die run wird einmal nach der Spieldauer ausgef�hrt.
	 */
	public void beBusy(){
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, FADENSPIELDAUER, TimeUnit.SECONDS);
	}
	
	
	/**
	 * Bed�rfniswerte werden angepasst. 
	 * Buttons werden enabled.
	 */
	public void run(){
		Game.getGame().getTamagotchi().getLangeweile().veraendereBeduerfnisWert(BALL_L);
		Game.getGame().getTamagotchi().getMuedigkeit().veraendereBeduerfnisWert(BALL_M);
		Game.getGame().getTamagotchi().getDurst().veraendereBeduerfnisWert(BALL_T);
		Game.getGame().getTamagotchi().getHunger().veraendereBeduerfnisWert(BALL_H);
		ButtonPanel.setButtonsEnabled(true);
	}
}
