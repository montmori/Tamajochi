/**
 * DurstBed�rfnis.
 */
package beduerfnis_klassen;

import java.io.Serializable;

import runnable_klassen.BeduerfnissVerringerungsTask;

public class Durst extends Beduerfnis implements Serializable{

	private static final long serialVersionUID = -8214169198714957922L;

	
	/**
	 * Konstruktor.
	 * Aufruf SuperKonstruktor.
	 * Erstellt einen BeduerfnissVerringerungsTask �ber Methodenaufruf.
	 * @param wert	Der Wert, den das Bed�rfnis am Anfang haben soll.
	 */
	public Durst(int wert) {
		super(wert, BeduerfnisWerte.MAXDURST, BeduerfnisWerte.MINDURST);
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
		
		int periodTime = BeduerfnisWerte.DURSTPT;
		int initialDelay = periodTime;
		
		super.startTask(new BeduerfnissVerringerungsTask(this, VerringerungsWerte.DURST), initialDelay, periodTime);
	}
}
