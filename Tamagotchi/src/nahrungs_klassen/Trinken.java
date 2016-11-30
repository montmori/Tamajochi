package nahrungs_klassen;

import tamagotchi_klassen.Tamagotchi;

public class Trinken extends Nahrung {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9019274140977439311L;

	public Trinken(Tamagotchi t) {
		super(NahrungsWerte.TRINKEN, t);
		
	}
	
	/*
	 * @see nahrungs_klassen.Nahrung#geben()
	 */
	public void geben() {
		super.tamagotchi.getDurst().erhoehen(super.wert);
	}

	@Override
	public String toString() {
		return "Trinken";
	}

}
