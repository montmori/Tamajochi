package nahrungs_klassen;

import tamagotchi_klassen.Tamagotchi;

public class Banane extends Nahrung{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6772286053916694111L;

	public Banane(Tamagotchi t ) {
		super(NahrungsWerte.BANANE, t);
		super.setName("Banane");
	}

	@Override
	public void geben() {
		super.tamagotchi.getHunger().erhoehen(super.wert);
		
	}

}
