package nahrungs_klassen;

import tamagotchi_klassen.Tamagotchi;

public class Banane extends Nahrung{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6772286053916694111L;

	public Banane(Tamagotchi t ) {
		super(NahrungsWerte.BANANE, t);
	}

	@Override
	public void geben() {
		super.tamagotchi.getHunger().erhoehen(super.wert);
		
	}

	@Override
	public String toString() {
		return "Banane";
	}

}
