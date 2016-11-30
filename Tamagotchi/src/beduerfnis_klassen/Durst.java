package beduerfnis_klassen;

import java.io.Serializable;

public class Durst extends Beduerfnis implements Serializable{

	private static final long serialVersionUID = -8214169198714957922L;


	public Durst(int wert) {
		super(wert, BeduerfnisWerte.MAXDURST, BeduerfnisWerte.MINDURST);
	}

	/*
	 * (non-Javadoc)
	 * @see beduerfniss_klassen.Beduerfnis#verringern(int)
	 */
	public void verringern(int subtraktionsWert) {
		super.wert -= subtraktionsWert;
	}

	/*
	 * (non-Javadoc)
	 * @see beduerfniss_klassen.Beduerfnis#erhoehen(int)
	 */
	public void erhoehen(int additionsWert) {
		super.wert += additionsWert;
		
		if(super.wert > super.maxWert){
			super.wert = super.maxWert;
		}
	}


	public int getWert() {	
		return super.wert;
	}


}
