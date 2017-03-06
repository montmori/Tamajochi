package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;
import tamagotchi_klassen.Tamagotchi;

public class Cola extends Nahrung {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9019274140977439311L;

	public Cola(Tamagotchi t) {
		super(t, "Cola");
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
		super.tamagotchi.getDurst().veraendereBeduerfnisWert(COLA);
		super.tamagotchi.getHunger().veraendereBeduerfnisWert(COLA_H);
		super.tamagotchi.getMuedigkeit().veraendereBeduerfnisWert(COLA_M);
		ButtonPanel.setButtonsEnabled(true);
	}

}
