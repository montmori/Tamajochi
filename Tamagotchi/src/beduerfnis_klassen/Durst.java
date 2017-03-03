package beduerfnis_klassen;

import java.io.Serializable;

import runnable_klassen.BeduerfnissVerringerungsTask;

public class Durst extends Beduerfnis implements Serializable{

	private static final long serialVersionUID = -8214169198714957922L;


	public Durst(int wert) {
		super(wert, BeduerfnisWerte.MAXDURST, BeduerfnisWerte.MINDURST);
		this.startTask(this);
	}

	/*
	 * (non-Javadoc)
	 * @see beduerfniss_klassen.Beduerfnis#verringern(int)
	 */

	public int getWert() {	
		return super.wert;
	}
	
	public void startTask(Beduerfnis b){
		
		int periodTime = DURSTPT;
		int initialDelay = periodTime;
		
		super.startTask(new BeduerfnissVerringerungsTask(b, VerringerungsWerte.DURST), initialDelay, periodTime);
	}
}
