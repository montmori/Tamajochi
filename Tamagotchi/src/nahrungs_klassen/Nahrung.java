package nahrungs_klassen;

public abstract class Nahrung {

	protected int wert;
	
	/*
	 * Wert = Wert, welcher, wenn man die Nahrung dem 
	 * 		  Tamagotchi gibt, das jeweils dazugehörige 
	 * 		  Bedürfnissa steigert.
	 */
	
	public Nahrung(int nahrungsWert){
		wert = nahrungsWert;
	}
	
	/*
	 * Diese Methode haben alle Nahrungs-subklassen
	 * Sie soll die Bedürfnisse beeinträchtigen
	 */
	public abstract void geben();
}
