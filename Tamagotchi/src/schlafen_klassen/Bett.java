package schlafen_klassen;

import tamagotchi_klassen.Tamagotchi;

public class Bett extends SchlafensOrt{

	private static final long serialVersionUID = -1252347912862515929L;

	public Bett(Tamagotchi t){
		super(SchlafensWerte.BETT,t);
		super.setName("Bett");
	}

	public void schlafen() {
		super.tamagotchi.getMuedigkeit().erhoehen(super.wert);
	}
}
