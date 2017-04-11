package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Salzwasser extends Nahrung {

	public Salzwasser() {
		super("Salzwasser");
		super.setUnlocked(false);
		super.setTimeTillUnlock(SALZWASSER_TTU);
	}

	private static final long serialVersionUID = 3531122978200688656L;

	@Override
	public void use() {
		beBusy();
		if(!Game.getGame().getAchievements().isErfolg2()){
			Game.getGame().getAchievements().resteErfolg2Bedingung();
		}
		if(!Game.getGame().getAchievements().isErfolg3()){
			Game.getGame().getAchievements().setErfolg3Bedingung();
		}
	}
	
	public void beBusy(){
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, ESSDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){		
		Game.getGame().getTamagotchi().getDurst().veraendereBeduerfnisWert(SALZWASSER_T);
		Game.getGame().getTamagotchi().getHunger().veraendereBeduerfnisWert(SALZWASSER_H);
		ButtonPanel.setButtonsEnabled(true);
	}

}
