package nahrungs_klassen;

public class Essen extends Nahrung{

	
	public Essen() {
		super(NahrungsWerte.ESSEN);
		
	}


	/*
	 * @see nahrungs_klassen.Nahrung#geben()
	 */
	public void geben() {
		hunger.erhoehen();
		
	}

}
