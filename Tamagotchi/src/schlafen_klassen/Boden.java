package schlafen_klassen;

import tamagotchi_klassen.Tamagotchi;

public class Boden extends SchlafensOrt{

	private static final long serialVersionUID = -1501068204982203927L;

	public Boden(Tamagotchi t){
		super(SchlafensWerte.BODEN,t);
		super.setName("Boden");
	}

	public void schlafen() {
		super.tamagotchi.getMuedigkeit().erhoehen(super.wert);
	}
	
}
