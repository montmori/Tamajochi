package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Fleisch extends Nahrung{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8118220751990421966L;

	public Fleisch() {
		super("Fleisch");
	}


	public void use() {
		beBusy();
	}
	
	
	public void beBusy(){
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, ESSDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		Game.getGame().getTamagotchi().getHunger().veraendereBeduerfnisWert(FLEISCH);
		Game.getGame().getTamagotchi().getDurst().veraendereBeduerfnisWert(FLEISCH_T);
		Game.getGame().getTamagotchi().getMuedigkeit().veraendereBeduerfnisWert(FLEISCH_M);
		ButtonPanel.setButtonsEnabled(true);
	}
}
