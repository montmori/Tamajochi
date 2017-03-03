package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;
import tamagotchi_klassen.Tamagotchi;

public class Keks extends Nahrung{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5466869746428915883L;

	public Keks(Tamagotchi t) {
		super(t, "Keks");
	}

	@Override
	public void geben() {
		beBusy();
	}
	
	public void beBusy(){
		ButtonPanel.disableButtons();
		OwnTimer.queueTask(this, ESSDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		super.tamagotchi.getHunger().veraendereBeduerfnisWert(KEKS);
		super.tamagotchi.getDurst().veraendereBeduerfnisWert(KEKS_T);
		ButtonPanel.enableButtons();
	}
	

}
