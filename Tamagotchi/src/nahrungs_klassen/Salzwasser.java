package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Salzwasser extends Nahrung {

	public Salzwasser() {
		super("Salzwasser");
	}

	private static final long serialVersionUID = 3531122978200688656L;

	@Override
	public void use() {
		beBusy();
	}
	
	public void beBusy(){
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, ESSDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){		
		Game.getGame().getTamagotchi().getDurst().veraendereBeduerfnisWert(SALZWASSER);
		Game.getGame().getTamagotchi().getHunger().veraendereBeduerfnisWert(SALZWASSER_H);
		ButtonPanel.setButtonsEnabled(true);
	}

}
