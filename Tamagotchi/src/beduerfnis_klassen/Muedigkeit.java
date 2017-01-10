package beduerfnis_klassen;

import timerTask_klassen.BeduerfnissVerringerungsTask;

public class Muedigkeit extends Beduerfnis{

	private static final long serialVersionUID = 8178768868232126142L;

	public Muedigkeit(int wert) {
		super(wert, BeduerfnisWerte.MAXMUEDIGKEIT, BeduerfnisWerte.MINMUEDIGKEIT);
		this.startTask(this);
	}
	
	/*
	 * (non-Javadoc)
	 * @see beduerfniss_klassen.Beduerfnis#verringern(int)
	 */
	public void verringern(int subtraktionsWert) {
		super.verringern(subtraktionsWert);
	}

	/*
	 * (non-Javadoc)
	 * @see beduerfniss_klassen.Beduerfnis#erhoehen(int)
	 */
	public void erhoehen(int additionsWert) {
		super.erhoehen(additionsWert);
	}


	public int getWert() {
		return super.wert;
	}
	
	public void startTask(Beduerfnis b){
		super.startTask(new BeduerfnissVerringerungsTask(b, VerringerungsWerte.MUEDIGKEIT));
	}

}
