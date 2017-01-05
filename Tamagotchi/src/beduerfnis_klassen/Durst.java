package beduerfnis_klassen;

import java.io.Serializable;

import timerTask_klassen.BeduerfnissVerringerungsTask;

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
		super.startTask(new BeduerfnissVerringerungsTask(b, VerringerungsWerte.DURST));
	}
}
