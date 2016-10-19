package beduerfniss_klassen;

public class Hunger extends Beduerfnis{

	public Hunger(int wert, int maxWert, int minWert) {
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
		
		if(super.wert > super.maxWert){
			super.wert = super.maxWert;
		}
	}


	public int getWert() {
		return super.wert;
	}

}
