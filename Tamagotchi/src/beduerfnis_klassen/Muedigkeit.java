/**
 * MüdigkeitBedürfnis.
 */
package beduerfnis_klassen;

import runnable_klassen.BeduerfnissVerringerungsTask;

public class Muedigkeit extends Beduerfnis{

	private static final long serialVersionUID = 8178768868232126142L;

	
	/**
	 * Konstruktor.
	 * Aufruf SuperKonstruktor.
	 * Erstellt einen BeduerfnissVerringerungsTask über Methodenaufruf.
	 * @param wert	Der Wert, den das Bedürfnis am Anfang haben soll.
	 */
	public Muedigkeit(int wert) {
		super(wert, BeduerfnisWerte.MAXMUEDIGKEIT, BeduerfnisWerte.MINMUEDIGKEIT);
		this.startTask();
	}

	
	/**
	 * @return	den momentanen Wert dieses Bedürfnisses.
	 */
	public int getWert() {
		return super.wert;
	}
	
	
	/**
	 * Startet einen BeduerfnissVerringerungsTask für dieses Bedürfnis.
	 * @see beduerfniss_klassen.Beduerfnis#startTask(Runnable, int, int)
	 */
	public void startTask(){
		
		int periodTime = BeduerfnisWerte.MUEDIGKEITPT;
		int initialDelay = periodTime;
		
		super.startTask(new BeduerfnissVerringerungsTask(this, VerringerungsWerte.MUEDIGKEIT), initialDelay, periodTime);
	}

}
