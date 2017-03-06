package schlafen_klassen;

import java.util.concurrent.TimeUnit;

import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;
import tamagotchi_klassen.Tamagotchi;

public class Bett extends SchlafensOrt{

	private static final long serialVersionUID = -1252347912862515929L;

	public Bett(Tamagotchi t){
		super(t, "Bett");
	}

	public void schlafen() {
		this.beBusy();
	}
	
	public void beBusy(){
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, BETTSCHLAFDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		this.tamagotchi.getMuedigkeit().veraendereBeduerfnisWert(BETT);
		this.tamagotchi.getLangeweile().veraendereBeduerfnisWert(BETT_S);
		ButtonPanel.setButtonsEnabled(true);
	}
}
