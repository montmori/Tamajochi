package spielen_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Ball extends Spielmoeglichkeit {

	private static final long serialVersionUID = 1042772169194270806L;

	public Ball(){
		super("Ball");
	}
	
	public void use() {
		beBusy();
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
