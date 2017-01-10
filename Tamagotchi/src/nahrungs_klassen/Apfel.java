package nahrungs_klassen;

import tamagotchi_klassen.Tamagotchi;

public class Apfel extends Nahrung{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1381982869897665964L;

	public Apfel(Tamagotchi t) {
		super(NahrungsWerte.APFEL, t);
		super.setName("Apfel");
		
	}

	public void geben() {
		super.tamagotchi.getHunger().erhoehen(super.wert);
		
	}

}
