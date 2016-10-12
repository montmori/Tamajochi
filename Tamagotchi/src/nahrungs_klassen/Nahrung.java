package nahrungs_klassen;

public abstract class Nahrung {

	protected int wert;
	
	/*
	 * Wert = Wert, welcher, wenn man die Nahrung dem 
	 * 		  Tamagotchi gibt, das jeweils dazugeh�rige 
	 * 		  Bed�rfnissa steigert.
	 */
	
	public Nahrung(int nahrungsWert){
		wert = nahrungsWert;
	}
	
	/*
	 * Diese Methode haben alle Nahrungs-subklassen
	 * Sie soll die Bed�rfnisse beeintr�chtigen
	 */
	public abstract void geben();
}
