package beduerfniss_klassen;

public class Durst extends Beduerfnis{

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
