package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import gui_klassen.ButtonPanel;
import tamagotchi_klassen.Tamagotchi;
import timerTask_klassen.OwnTimer;

public class Salzwasser extends Nahrung {

	public Salzwasser(Tamagotchi tamagotchi) {
		super(tamagotchi, "Salzwasser");
	}

	private static final long serialVersionUID = 3531122978200688656L;

	@Override
	public void geben() {
		beBusy();
	}
	
	public void beBusy(){
		ButtonPanel.disableButtons();
		OwnTimer.queueTask(this, ESSDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){		
		super.tamagotchi.getDurst().veraendereBeduerfnisWert(SALZWASSER);
		super.tamagotchi.getHunger().veraendereBeduerfnisWert(SALZWASSER_H);
		ButtonPanel.enableButtons();
	}

}