package beduerfniss_klassen;

public class Durst extends Beduerfnis{

	public Durst(int wert, int maxWert, int minWert) {
		super(wert, maxWert, minWert);
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
	}


	public int getWert() {	
		return super.wert;
	}


}
