package nahrungs_klassen;

import tamagotchi_klassen.Tamagotchi;

public class Cola extends Nahrung {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9019274140977439311L;

	public Cola(Tamagotchi t) {
		super(NahrungsWerte.COLA, t);
		super.setName("Cola");
		
	}
	
	/*
	 * @see nahrungs_klassen.Nahrung#geben()
	 */
	public void geben() {
		super.tamagotchi.getDurst().erhoehen(super.wert);
	}

}
