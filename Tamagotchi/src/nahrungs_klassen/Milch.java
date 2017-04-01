package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Milch extends Nahrung {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9019274140977439311L;

	public Milch() {
		super("Milch");
		
	}
	
	/*
	 * @see nahrungs_klassen.Nahrung#geben()
	 */
	public void use() {
		beBusy();
		if(!Game.getGame().getAchievements().isErfolg2() && Game.getGame().getAchievements().getErfolg2Bedingung()){
			Game.getGame().getAchievements().setErfolg2();
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
		Game.getGame().getTamagotchi().getDurst().veraendereBeduerfnisWert(MILCH);
		Game.getGame().getTamagotchi().getHunger().veraendereBeduerfnisWert(MILCH_H);
		ButtonPanel.setButtonsEnabled(true);
	}


}
