package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Wasser extends Nahrung {

	private static final long serialVersionUID = 9019274140977439311L;

	public Wasser() {
		super("Wasser");
		super.setUnlocked(true);
		super.setTimeTillUnlock(WASSER_TTU);
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
		OwnTimer.queueTask(this, ESSDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){		
		Game.getGame().getTamagotchi().getDurst().veraendereBeduerfnisWert(WASSER_T);
		ButtonPanel.setButtonsEnabled(true);
	}

}
