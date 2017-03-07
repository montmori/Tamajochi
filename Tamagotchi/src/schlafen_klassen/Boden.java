package schlafen_klassen;

import java.util.concurrent.TimeUnit;

import game.Game;
import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;

public class Boden extends SchlafensOrt{

	private static final long serialVersionUID = -1501068204982203927L;

	public Boden(){
		super("Boden");
	}

	public void use() {
		this.beBusy();
	}
	
	public void beBusy(){
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, BODENSCHLAFDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		Game.getGame().getTamagotchi().getMuedigkeit().veraendereBeduerfnisWert(BODEN);
		Game.getGame().getTamagotchi().getLangeweile().veraendereBeduerfnisWert(BODEN_S);
		ButtonPanel.setButtonsEnabled(true);
	}
}
