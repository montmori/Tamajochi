package schlafen_klassen;

import java.util.concurrent.TimeUnit;

import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;
import tamagotchi_klassen.Tamagotchi;

public class Boden extends SchlafensOrt{

	private static final long serialVersionUID = -1501068204982203927L;

	public Boden(Tamagotchi t){
		super(t, "Boden");
	}

	public void schlafen() {
		this.beBusy();
	}
	
	public void beBusy(){
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, BODENSCHLAFDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		this.tamagotchi.getMuedigkeit().veraendereBeduerfnisWert(BODEN);
		this.tamagotchi.getLangeweile().veraendereBeduerfnisWert(BODEN_S);
		ButtonPanel.setButtonsEnabled(true);
	}
}
