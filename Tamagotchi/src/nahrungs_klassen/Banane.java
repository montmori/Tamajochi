package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Banane extends Nahrung{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6772286053916694111L;

	public Banane() {
		super("Banane");
		super.setName("Banane");
	}

	@Override
	public void use() {
		beBusy();
	}
	
	public void beBusy(){
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, ESSDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		Game.getGame().getTamagotchi().getHunger().veraendereBeduerfnisWert(BANANE);
		ButtonPanel.setButtonsEnabled(true);
	}

}
