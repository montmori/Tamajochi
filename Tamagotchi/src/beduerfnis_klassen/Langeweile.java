/**
 * LangeweileBed�rfnis.
 */
package beduerfnis_klassen;

import runnable_klassen.BeduerfnissVerringerungsTask;

public class Langeweile extends Beduerfnis{

	private static final long serialVersionUID = -392813517868554401L;

	
	/**
	 * Konstruktor.
	 * Aufruf SuperKonstruktor.
	 * Erstellt einen BeduerfnissVerringerungsTask �ber Methodenaufruf.
	 * @param wert	Der Wert, den das Bed�rfnis am Anfang haben soll.
	 */
	public Langeweile(int wert) {
		super(wert, BeduerfnisWerte.MAXLANGEWEILE, BeduerfnisWerte.MINLANGEWEILE);
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
		
		int periodTime = BeduerfnisWerte.LANGEWEILEPT;
		int initialDelay = periodTime;
		
		super.startTask(new BeduerfnissVerringerungsTask(this, VerringerungsWerte.LANGEWEILE), initialDelay, periodTime);
	}

}
