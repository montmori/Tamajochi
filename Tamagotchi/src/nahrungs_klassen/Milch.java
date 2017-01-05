package nahrungs_klassen;

import tamagotchi_klassen.Tamagotchi;

public class Milch extends Nahrung {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9019274140977439311L;

	public Milch(Tamagotchi t) {
		super(NahrungsWerte.MILCH, t);
		super.setName("Milch");
		
	}
	
	/*
	 * @see nahrungs_klassen.Nahrung#geben()
	 */
	public void geben() {
		super.tamagotchi.getDurst().erhoehen(super.wert);
	}


}
