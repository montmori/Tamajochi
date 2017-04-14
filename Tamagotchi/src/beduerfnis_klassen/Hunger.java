/**
 * HungerBedürfnis.
 */
package beduerfnis_klassen;

import runnable_klassen.BeduerfnissVerringerungsTask;

public class Hunger extends Beduerfnis{

	
	private static final long serialVersionUID = -771761267724331525L;
	
	
	/**
	 * Konstruktor.
	 * Aufruf SuperKonstruktor.
	 * Erstellt einen BeduerfnissVerringerungsTask über Methodenaufruf.
	 * @param wert	Der Wert, den das Bedürfnis am Anfang haben soll.
	 */
	public Hunger(int wert) {
		super(wert, BeduerfnisWerte.MAXHUNGER, BeduerfnisWerte.MINHUNGER);
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
		
		int periodTime = BeduerfnisWerte.HUNGERPT;
		int initialDelay = periodTime;
		
		super.startTask(new BeduerfnissVerringerungsTask(this, VerringerungsWerte.HUNGER), initialDelay, periodTime);
	}

	

}
