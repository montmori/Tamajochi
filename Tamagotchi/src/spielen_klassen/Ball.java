package spielen_klassen;

import tamagotchi_klassen.Tamagotchi;

public class Ball extends Spielmoeglichkeit {

	private static final long serialVersionUID = 1042772169194270806L;

	public Ball(Tamagotchi t){
		super(SpielWerte.Ball,t);
		super.setName("Ball");
	}
	
	public void spielen() {
		super.tamagotchi.getLangeweile().erhoehen(super.wert);
	}

}
