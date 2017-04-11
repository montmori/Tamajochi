package schlafen_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Boden extends SchlafensOrt{

	private static final long serialVersionUID = -1501068204982203927L;

	public Boden(){
		super("Boden");
		super.setUnlocked(true);
		super.setTimeTillUnlock(BODEN_TTU);
	}

	public void use() {
		this.beBusy();
		if(!Game.getGame().getAchievements().isErfolg2()){
			Game.getGame().getAchievements().resteErfolg2Bedingung();
		}
		if(!Game.getGame().getAchievements().isErfolg3()){
			Game.getGame().getAchievements().resteErfolg3Bedingung();
		}
	}
	
	public void beBusy(){
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, BODENSCHLAFDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		Game.getGame().getTamagotchi().getMuedigkeit().veraendereBeduerfnisWert(BODEN);
		Game.getGame().getTamagotchi().getLangeweile().veraendereBeduerfnisWert(BODEN_M);
		ButtonPanel.setButtonsEnabled(true);
	}


}
