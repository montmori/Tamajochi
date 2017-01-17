package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import gui_klassen.ButtonPanel;
import tamagotchi_klassen.Tamagotchi;
import timerTask_klassen.OwnTimer;

public class Wasser extends Nahrung {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9019274140977439311L;

	public Wasser(Tamagotchi t) {
		super(t, "Wasser");
		
	}
	
	/*
	 * @see nahrungs_klassen.Nahrung#geben()
	 */
	public void geben() {
		beBusy();
	}
	

	public void beBusy(){
		ButtonPanel.disableButtons();
		OwnTimer.queueTask(this, ESSDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){		
		super.tamagotchi.getDurst().veraendereBeduerfnisWert(WASSER);
		ButtonPanel.enableButtons();
	}

}
