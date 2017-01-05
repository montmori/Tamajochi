package spielen_klassen;

import tamagotchi_klassen.Tamagotchi;

public class Faden extends Spielmoeglichkeit {

	private static final long serialVersionUID = 8272997277366389335L;

	public Faden(Tamagotchi t){
		super(SpielWerte.Faden,t);
		super.setName("Faden");
	}
	
	public void spielen() {
		super.tamagotchi.getLangeweile().erhoehen(super.wert);
	}

}
