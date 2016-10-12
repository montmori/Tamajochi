package nahrungs_klassen;

import tamagotchi_klassen.Tamagotchi;

public class Essen extends Nahrung{

	
	public Essen() {
		super(NahrungsWerte.ESSEN);
		
	}


	/*
	 * @see nahrungs_klassen.Nahrung#geben()
	 */
	public void geben() {
		Tamagotchi.hunger.erhoehen(super.wert);
		
	}

}
