package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import gui_klassen.ButtonPanel;
import tamagotchi_klassen.Tamagotchi;
import timerTask_klassen.OwnTimer;

public class Banane extends Nahrung{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6772286053916694111L;

	public Banane(Tamagotchi t ) {
		super(t, "Banane");
		super.setName("Banane");
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
		super.tamagotchi.getHunger().veraendereBeduerfnisWert(BANANE);
		ButtonPanel.enableButtons();
	}

}
