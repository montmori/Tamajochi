package beduerfnis_klassen;

import timerTask_klassen.BeduerfnissVerringerungsTask;

public class Muedigkeit extends Beduerfnis{

	private static final long serialVersionUID = 8178768868232126142L;

	public Muedigkeit(int wert) {
		super(wert, BeduerfnisWerte.MAXMUEDIGKEIT, BeduerfnisWerte.MINMUEDIGKEIT);
		this.startTask(this);
	}

	public int getWert() {
		return super.wert;
	}
	
	public void startTask(Beduerfnis b){
		
		int periodTime = MUEDIGKEITPT;
		int initialDelay = periodTime;
		
		super.startTask(new BeduerfnissVerringerungsTask(b, VerringerungsWerte.MUEDIGKEIT), initialDelay, periodTime);
	}

}
