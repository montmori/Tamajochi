package beduerfnis_klassen;

import runnable_klassen.BeduerfnissVerringerungsTask;

public class Hunger extends Beduerfnis{

	
	private static final long serialVersionUID = -771761267724331525L;
	
	public Hunger(int wert) {
		super(wert, BeduerfnisWerte.MAXHUNGER, BeduerfnisWerte.MINHUNGER);
		this.startTask(this);
	}

	public int getWert() {
		return super.wert;
	}
	
	public void startTask(Beduerfnis b){
		
		int periodTime = HUNGERPT;
		int initialDelay = periodTime;
		
		super.startTask(new BeduerfnissVerringerungsTask(b, VerringerungsWerte.HUNGER), initialDelay, periodTime);
	}

	

}
