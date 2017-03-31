 package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Apfel extends Nahrung{

	private static final long serialVersionUID = -1381982869897665964L;

	public Apfel() {
		super("Apfel");		
	}

	public void use() {
		beBusy();
	}
	
	public void beBusy(){
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, ESSDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		Game.getGame().getTamagotchi().getHunger().veraendereBeduerfnisWert(APFEL);
		Game.getGame().getTamagotchi().getDurst().veraendereBeduerfnisWert(APFEL_T);
		ButtonPanel.setButtonsEnabled(true);
	}

}
