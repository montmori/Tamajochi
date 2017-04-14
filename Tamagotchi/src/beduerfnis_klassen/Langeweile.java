/**
 * LangeweileBedürfnis.
 */
package beduerfnis_klassen;

import runnable_klassen.BeduerfnissVerringerungsTask;

public class Langeweile extends Beduerfnis{

	private static final long serialVersionUID = -392813517868554401L;

	
	/**
	 * Konstruktor.
	 * Aufruf SuperKonstruktor.
	 * Erstellt einen BeduerfnissVerringerungsTask über Methodenaufruf.
	 * @param wert	Der Wert, den das Bedürfnis am Anfang haben soll.
	 */
	public Langeweile(int wert) {
		super(wert, BeduerfnisWerte.MAXLANGEWEILE, BeduerfnisWerte.MINLANGEWEILE);
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
		
		int periodTime = BeduerfnisWerte.LANGEWEILEPT;
		int initialDelay = periodTime;
		
		super.startTask(new BeduerfnissVerringerungsTask(this, VerringerungsWerte.LANGEWEILE), initialDelay, periodTime);
	}

}
