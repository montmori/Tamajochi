package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;
import tamagotchi_klassen.Tamagotchi;

public class Apfel extends Nahrung{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1381982869897665964L;

	public Apfel(Tamagotchi t) {
		super(t, "Apfel");		
	}

	public void geben() {
		beBusy();
	}
	
	public void beBusy(){
		ButtonPanel.disableButtons();
		OwnTimer.queueTask(this, ESSDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		super.tamagotchi.getHunger().veraendereBeduerfnisWert(APFEL);
		super.tamagotchi.getDurst().veraendereBeduerfnisWert(APFEL_T);
		ButtonPanel.enableButtons();
	}

}
