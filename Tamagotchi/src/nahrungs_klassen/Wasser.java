package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;
import tamagotchi_klassen.Tamagotchi;

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
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, ESSDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){		
		super.tamagotchi.getDurst().veraendereBeduerfnisWert(WASSER);
		ButtonPanel.setButtonsEnabled(true);
	}

}
