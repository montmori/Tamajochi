package beduerfniss_klassen;

public class Hunger extends Beduerfnis{

	public Hunger(int wert, int maxWert, int minWert) {
		super(wert, maxWert, minWert);
	}

	/*
	 * (non-Javadoc)
	 * @see beduerfniss_klassen.Beduerfnis#verringern(int)
	 */
	protected void verringern(int subtraktionsWert) {
		super.wert -= subtraktionsWert;
	}

	/*
	 * (non-Javadoc)
	 * @see beduerfniss_klassen.Beduerfnis#erhoehen(int)
	 */
	protected void erhoehen(int additionsWert) {
		super.wert += additionsWert;
	}

}
