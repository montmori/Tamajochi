package runnable_klassen;

import java.util.TimerTask;

import beduerfnis_klassen.Beduerfnis;
import beduerfnis_klassen.VerringerungsWerte;

public class BeduerfnissVerringerungsTask extends TimerTask implements VerringerungsWerte{

	private Beduerfnis beduerfnis;
	private int subtraktionswert;
	
	public BeduerfnissVerringerungsTask(Beduerfnis beduerfnis, int subtraktionswert) {
		this.beduerfnis = beduerfnis;
		this.subtraktionswert = subtraktionswert;
	}

	@Override
	public void run() {
		this.beduerfnis.veraendereBeduerfnisWert(this.subtraktionswert);

	}

}
