package nahrungs_klassen;

import tamagotchi_klassen.Tamagotchi;

public class Wasser extends Nahrung {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9019274140977439311L;

	public Wasser(Tamagotchi t) {
		super(NahrungsWerte.WASSER, t);
		super.setName("Wasser");
		
	}
	
	/*
	 * @see nahrungs_klassen.Nahrung#geben()
	 */
	public void geben() {
		super.tamagotchi.getDurst().erhoehen(super.wert);
	}


}
