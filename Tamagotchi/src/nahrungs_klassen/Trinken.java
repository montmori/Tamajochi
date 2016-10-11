package nahrungs_klassen;

public class Trinken extends Nahrung {

	
	public Trinken() {
		super(NahrungsWerte.TRINKEN);
		
	}
	
	/*
	 * @see nahrungs_klassen.Nahrung#geben()
	 */
	public void geben() {
		durst.erhoehen(wert);
	}

}
