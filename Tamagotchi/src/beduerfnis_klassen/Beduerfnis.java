/**
 * Superklasse der verschiedenen Beduerfnisse.
 */

package beduerfnis_klassen;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import runnable_klassen.OwnTimer;

public abstract class Beduerfnis implements BeduerfnisWerte, Serializable{
	
	
	private static final long serialVersionUID = 7666343660063488766L;
	protected int wert;
	protected int maxWert;
	protected int minWert;
	protected boolean isKilled;
	
	
	
	/**
	 * Konstruktor.
	 * @param wert 		Der aktuelle Wert des Beduerfnis.
	 * @param maxWert 	Der groeste Wert fuer "wert".
	 * @param minWert	Der niedrigste Wert fuer "wert".
	 * ------------------------------------------
	 * maxWert & minWert werden sp�ter f�r der "sterben/game over"- Funktion
	 * des Tamagotchis verwendet.
	 */
	public Beduerfnis (int wert, int maxWert, int minWert){
		this.wert = wert;
		this.maxWert = maxWert;
		this.minWert = minWert;
	}
	
	
	/**
	 * Erstellt einen Task f�r den OwnTimer (Task sollte ein Bed�rfnis sein).
	 * @see java.util.ScheduledThreadPoolExecutor#scheduleAtFixedRate(Runnable, long, long, TimeUnit)
	 */
	protected void startTask(Runnable task, int initialDelay, int periodTime) {
		
		OwnTimer.scheduleAtFixedRate(task, initialDelay, periodTime, TimeUnit.MILLISECONDS);
	}

	
	/**
	 * Soll den aktuellen "wert" um den mitgegebenen Wert ver�ndern.
	 * �berwacht ob der Wert nach der �nderung zu klein bzw. zu gro� ist.
	 * @param wert	Der Wert um den der momentane Wert ver�ndert werden soll.
	 */
	public void veraendereBeduerfnisWert(int wert){
		
		this.wert += wert;
		
		if(this.wert <= this.minWert){
			this.wert = this.minWert;
			this.isKilled = true;
		}
		
		if(this.wert > this.maxWert){
			this.wert = this.maxWert;
		}
	}


	/**
	 * Um in allen Subklassen die aktuellen Werte zu bekommen.
	 * @return	Den aktuellen Bed�rfniswert der Subklasse.
	 */
	public abstract int getWert();
	
	
	/**
	 * Setzt den Momentanwert dieses Bed�rfnisses auf den angegebenen minWert.
	 */
	public void killed(){
		this.wert = this.minWert;
	}
	
	
	/**
	 * @return	true, wenn dieses Bed�rfnis den minWert erreicht hat.
	 */
	public boolean isDead() {
		return isKilled;
	}
}
