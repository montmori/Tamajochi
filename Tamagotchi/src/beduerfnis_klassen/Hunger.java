package beduerfnis_klassen;

public class Hunger extends Beduerfnis{

	
	private static final long serialVersionUID = -771761267724331525L;
	
	public Hunger(int wert) {
		super(wert, BeduerfnisWerte.MAXHUNGER, BeduerfnisWerte.MINHUNGER);
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
