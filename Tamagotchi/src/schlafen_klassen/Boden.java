package schlafen_klassen;

import java.util.concurrent.TimeUnit;

import gui_klassen.ButtonPanel;
import tamagotchi_klassen.Tamagotchi;
import timerTask_klassen.OwnTimer;

public class Boden extends SchlafensOrt{

	private static final long serialVersionUID = -1501068204982203927L;

	public Boden(Tamagotchi t){
		super(t, "Boden");
	}

	public void schlafen() {
		this.beBusy();
	}
	
	public void beBusy(){
		ButtonPanel.disableButtons();
		OwnTimer.queueTask(this, BODENSCHLAFDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		this.tamagotchi.getMuedigkeit().veraendereBeduerfnisWert(BODEN);
		this.tamagotchi.getLangeweile().veraendereBeduerfnisWert(BODEN_S);
		ButtonPanel.enableButtons();
	}
}
