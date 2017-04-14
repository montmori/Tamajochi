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
	 * maxWert & minWert werden später für der "sterben/game over"- Funktion
	 * des Tamagotchis verwendet.
	 */
	public Beduerfnis (int wert, int maxWert, int minWert){
		this.wert = wert;
		this.maxWert = maxWert;
		this.minWert = minWert;
	}
	
	
	/**
	 * Erstellt einen Task für den OwnTimer (Task sollte ein Bedürfnis sein).
	 * @see java.util.ScheduledThreadPoolExecutor#scheduleAtFixedRate(Runnable, long, long, TimeUnit)
	 */
	protected void startTask(Runnable task, int initialDelay, int periodTime) {
		
		OwnTimer.scheduleAtFixedRate(task, initialDelay, periodTime, TimeUnit.MILLISECONDS);
	}

	
	/**
	 * Soll den aktuellen "wert" um den mitgegebenen Wert verändern.
	 * Überwacht ob der Wert nach der Änderung zu klein bzw. zu groß ist.
	 * @param wert	Der Wert um den der momentane Wert verändert werden soll.
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
	 * @return	Den aktuellen Bedürfniswert der Subklasse.
	 */
	public abstract int getWert();
	
	
	/**
	 * Setzt den Momentanwert dieses Bedürfnisses auf den angegebenen minWert.
	 */
	public void killed(){
		this.wert = this.minWert;
	}
	
	
	/**
	 * @return	true, wenn dieses Bedürfnis den minWert erreicht hat.
	 */
	public boolean isDead() {
		return isKilled;
	}
}
