package spielen_klassen;

import java.util.concurrent.TimeUnit;

import gui_klassen.mainWindow.ButtonPanel;
import runnable_klassen.OwnTimer;
import tamagotchi_klassen.Tamagotchi;

public class Faden extends Spielmoeglichkeit {

	private static final long serialVersionUID = 8272997277366389335L;

	public Faden(Tamagotchi t){
		super(t, "Faden");
	}
	
	public void spielen() {
		beBusy();
	}

	public void beBusy(){
		ButtonPanel.setButtonsEnabled(false);
		OwnTimer.queueTask(this, FADENSPIELDAUER, TimeUnit.SECONDS);
	}
	
	public void run(){
		super.tamagotchi.getLangeweile().veraendereBeduerfnisWert(FADEN);
		super.tamagotchi.getMuedigkeit().veraendereBeduerfnisWert(FADEN_M);
		super.tamagotchi.getDurst().veraendereBeduerfnisWert(FADEN_T);
		super.tamagotchi.getHunger().veraendereBeduerfnisWert(FADEN_H);
		ButtonPanel.setButtonsEnabled(true);
	}
	
}
