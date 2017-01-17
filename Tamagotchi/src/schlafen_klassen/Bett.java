package schlafen_klassen;

import java.util.concurrent.TimeUnit;

import gui_klassen.ButtonPanel;
import tamagotchi_klassen.Tamagotchi;
import timerTask_klassen.OwnTimer;

public class Bett extends SchlafensOrt{

	private static final long serialVersionUID = -1252347912862515929L;

	public Bett(Tamagotchi t){
		super(t, "Bett");
	}

	public void schlafen() {
		this.beBusy();
	}
	
	public void beBusy(){
		ButtonPanel.disableButtons();
		OwnTimer.queueTask(this, BETTSCHLAFDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		this.tamagotchi.getMuedigkeit().veraendereBeduerfnisWert(BETT);
		this.tamagotchi.getLangeweile().veraendereBeduerfnisWert(BETT_S);
		ButtonPanel.enableButtons();
	}
}
