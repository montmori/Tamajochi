package nahrungs_klassen;

import tamagotchi_klassen.Tamagotchi;

public class Fleisch extends Nahrung{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8118220751990421966L;

	public Fleisch(Tamagotchi t) {
		super(NahrungsWerte.FLEISCH, t);
	}


	public void geben() {
		super.tamagotchi.getHunger().erhoehen(super.wert);
		
	}

	public String toString() {
		return "Fleisch";
	}
}
