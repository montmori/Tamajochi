package spielen_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Faden extends Spielmoeglichkeit {

	private static final long serialVersionUID = 8272997277366389335L;

	public Faden(){
		super("Faden");
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
		Game.getGame().getTamagotchi().getLangeweile().veraendereBeduerfnisWert(FADEN);
		Game.getGame().getTamagotchi().getMuedigkeit().veraendereBeduerfnisWert(FADEN_M);
		Game.getGame().getTamagotchi().getDurst().veraendereBeduerfnisWert(FADEN_T);
		Game.getGame().getTamagotchi().getHunger().veraendereBeduerfnisWert(FADEN_H);
		ButtonPanel.setButtonsEnabled(true);
	}
	
}
