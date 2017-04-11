package schlafen_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Bett extends SchlafensOrt{

	private static final long serialVersionUID = -1252347912862515929L;

	public Bett(){
		super("Bett");
		super.setUnlocked(false);
		super.setTimeTillUnlock(BETT_TTU);
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
		OwnTimer.queueTask(this, BETTSCHLAFDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		Game.getGame().getTamagotchi().getMuedigkeit().veraendereBeduerfnisWert(BETT);
		Game.getGame().getTamagotchi().getLangeweile().veraendereBeduerfnisWert(BETT_S);
		ButtonPanel.setButtonsEnabled(true);
	}
}
