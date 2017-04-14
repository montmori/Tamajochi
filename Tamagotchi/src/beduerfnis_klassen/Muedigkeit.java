/**
 * M�digkeitBed�rfnis.
 */
package beduerfnis_klassen;

import runnable_klassen.BeduerfnissVerringerungsTask;

public class Muedigkeit extends Beduerfnis{

	private static final long serialVersionUID = 8178768868232126142L;

	
	/**
	 * Konstruktor.
	 * Aufruf SuperKonstruktor.
	 * Erstellt einen BeduerfnissVerringerungsTask �ber Methodenaufruf.
	 * @param wert	Der Wert, den das Bed�rfnis am Anfang haben soll.
	 */
	public Muedigkeit(int wert) {
		super(wert, BeduerfnisWerte.MAXMUEDIGKEIT, BeduerfnisWerte.MINMUEDIGKEIT);
		this.startTask();
	}

	
	/**
	 * @return	den momentanen Wert dieses Bed�rfnisses.
	 */
	public int getWert() {
		return super.wert;
	}
	
	
	/**
	 * Startet einen BeduerfnissVerringerungsTask f�r dieses Bed�rfnis.
	 * @see beduerfniss_klassen.Beduerfnis#startTask(Runnable, int, int)
	 */
	public void startTask(){
		
		int periodTime = BeduerfnisWerte.MUEDIGKEITPT;
		int initialDelay = periodTime;
		
		super.startTask(new BeduerfnissVerringerungsTask(this, VerringerungsWerte.MUEDIGKEIT), initialDelay, periodTime);
	}

}
