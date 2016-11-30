package nahrungs_klassen;

import tamagotchi_klassen.Tamagotchi;

public class Keks extends Nahrung{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5466869746428915883L;

	public Keks(Tamagotchi t) {
		super(NahrungsWerte.KEKS, t);
	}

	@Override
	public void geben() {
		super.tamagotchi.getHunger().erhoehen(super.wert);
		
	}

	public String toString() {
		return "Keks";
	}
}
