package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;
import tamagotchi_klassen.Tamagotchi;

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
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, ESSDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		super.tamagotchi.getHunger().veraendereBeduerfnisWert(BANANE);
		ButtonPanel.setButtonsEnabled(true);
	}

}
