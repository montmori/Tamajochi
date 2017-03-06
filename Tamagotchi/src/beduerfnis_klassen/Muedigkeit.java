package beduerfnis_klassen;

import runnable_klassen.BeduerfnissVerringerungsTask;

public class Muedigkeit extends Beduerfnis{

	private static final long serialVersionUID = 8178768868232126142L;

	public Muedigkeit(int wert) {
		super(wert, BeduerfnisWerte.MAXMUEDIGKEIT, BeduerfnisWerte.MINMUEDIGKEIT);
		this.startTask();
	}

	public int getWert() {
		return super.wert;
	}
	
	public void startTask(){
		
		int periodTime = BeduerfnisWerte.MUEDIGKEITPT;
		int initialDelay = periodTime;
		
		super.startTask(new BeduerfnissVerringerungsTask(this, VerringerungsWerte.MUEDIGKEIT), initialDelay, periodTime);
	}

}
