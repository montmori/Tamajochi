package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Cola extends Nahrung {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9019274140977439311L;

	public Cola() {
		super("Cola");
	}
	
	/*
	 * @see nahrungs_klassen.Nahrung#geben()
	 */
	public void use() {
		beBusy();
	}
	
	public void beBusy(){
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, ESSDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		Game.getGame().getTamagotchi().getDurst().veraendereBeduerfnisWert(COLA);
		Game.getGame().getTamagotchi().getHunger().veraendereBeduerfnisWert(COLA_H);
		Game.getGame().getTamagotchi().getMuedigkeit().veraendereBeduerfnisWert(COLA_M);
		ButtonPanel.setButtonsEnabled(true);
	}

}
