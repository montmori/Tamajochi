package nahrungs_klassen;

import tamagotchi_klassen.Tamagotchi;

public class Trinken extends Nahrung {

	
	public Trinken() {
		super(NahrungsWerte.TRINKEN);
		
	}
	
	/*
	 * @see nahrungs_klassen.Nahrung#geben()
	 */
	public void geben() {
		Tamagotchi.durst.erhoehen(super.wert);
	}

}
