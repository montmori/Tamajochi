package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import gui_klassen.ButtonPanel;
import tamagotchi_klassen.Tamagotchi;
import timerTask_klassen.OwnTimer;

public class Fleisch extends Nahrung{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8118220751990421966L;

	public Fleisch(Tamagotchi t) {
		super(t, "Fleisch");
	}


	public void geben() {
		beBusy();
	}
	
	
	public void beBusy(){
		ButtonPanel.disableButtons();
		OwnTimer.queueTask(this, ESSDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		super.tamagotchi.getHunger().veraendereBeduerfnisWert(FLEISCH);
		super.tamagotchi.getDurst().veraendereBeduerfnisWert(FLEISCH_T);
		super.tamagotchi.getMuedigkeit().veraendereBeduerfnisWert(FLEISCH_M);
		ButtonPanel.enableButtons();
	}
}
