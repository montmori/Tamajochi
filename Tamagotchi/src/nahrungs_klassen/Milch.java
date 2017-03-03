package nahrungs_klassen;

import java.util.concurrent.TimeUnit;

import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;
import tamagotchi_klassen.Tamagotchi;

public class Milch extends Nahrung {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9019274140977439311L;

	public Milch(Tamagotchi t) {
		super(t, "Milch");
		
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
		super.tamagotchi.getDurst().veraendereBeduerfnisWert(MILCH);
		super.tamagotchi.getHunger().veraendereBeduerfnisWert(MILCH_H);
		ButtonPanel.enableButtons();
	}


}
