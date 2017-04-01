package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Keks extends Nahrung{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5466869746428915883L;

	public Keks() {
		super("Keks");
	}

	@Override
	public void use() {
		beBusy();
		if(!Game.getGame().getAchievements().isErfolg2()){
			Game.getGame().getAchievements().setErfolg2Bedingung();
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
		Game.getGame().getTamagotchi().getHunger().veraendereBeduerfnisWert(KEKS);
		Game.getGame().getTamagotchi().getDurst().veraendereBeduerfnisWert(KEKS_T);
		ButtonPanel.setButtonsEnabled(true);
	}
	

}
