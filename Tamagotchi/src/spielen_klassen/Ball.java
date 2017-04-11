package spielen_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Ball extends Spielmoeglichkeit {

	private static final long serialVersionUID = 1042772169194270806L;

	public Ball(){
		super("Ball");
		super.setUnlocked(false);
		super.setTimeTillUnlock(BALL_TTU);
	}
	
	public void use() {
		beBusy();
		if(!Game.getGame().getAchievements().isErfolg2()){
			Game.getGame().getAchievements().resteErfolg2Bedingung();
		}
		if(!Game.getGame().getAchievements().isErfolg3()){
			Game.getGame().getAchievements().resteErfolg3Bedingung();
		}
	}

	public void beBusy(){
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, FADENSPIELDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		Game.getGame().getTamagotchi().getLangeweile().veraendereBeduerfnisWert(BALL);
		Game.getGame().getTamagotchi().getMuedigkeit().veraendereBeduerfnisWert(BALL_M);
		Game.getGame().getTamagotchi().getDurst().veraendereBeduerfnisWert(BALL_T);
		Game.getGame().getTamagotchi().getHunger().veraendereBeduerfnisWert(BALL_H);
		ButtonPanel.setButtonsEnabled(true);
	}
}
