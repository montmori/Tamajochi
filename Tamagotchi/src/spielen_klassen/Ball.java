package spielen_klassen;

import java.util.concurrent.TimeUnit;

import gui_klassen.ButtonPanel;
import tamagotchi_klassen.Tamagotchi;
import timerTask_klassen.OwnTimer;

public class Ball extends Spielmoeglichkeit {

	private static final long serialVersionUID = 1042772169194270806L;

	public Ball(Tamagotchi t){
		super(t, "Ball");
	}
	
	public void spielen() {
		beBusy();
	}

	public void beBusy(){
		ButtonPanel.disableButtons();
		OwnTimer.queueTask(this, FADENSPIELDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		super.tamagotchi.getLangeweile().veraendereBeduerfnisWert(BALL);
		super.tamagotchi.getMuedigkeit().veraendereBeduerfnisWert(BALL_M);
		super.tamagotchi.getDurst().veraendereBeduerfnisWert(BALL_T);
		super.tamagotchi.getHunger().veraendereBeduerfnisWert(BALL_H);
		ButtonPanel.enableButtons();
	}
}
