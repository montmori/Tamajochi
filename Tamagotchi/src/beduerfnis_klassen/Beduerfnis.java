package beduerfnis_klassen;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import timerTask_klassen.OwnTimer;

public abstract class Beduerfnis implements BeduerfnisWerte, Serializable{
	
	
	private static final long serialVersionUID = 7666343660063488766L;
	protected int wert;
	protected int maxWert;
	protected int minWert;
	protected boolean isKilled;
	
	/*
	 * wert = der aktuelle Wert des Beduerfnis
	 * maxWert = der groeste Wert fuer "wert"
	 * minWert = der niedrigste Wert fuer "wert"
	 * ------------------------------------------
	 * maxWert & minWert werden später für der "sterben/game over" - Funktion
	 * des Tamagotchis verwendet
	 */
	public Beduerfnis (int wert, int maxWert, int minWert){
		this.wert = wert;
		this.maxWert = maxWert;
		this.minWert = minWert;
	}
	
	protected void startTask(Runnable task) {
		
		final int initialDelay = 2000;    	//HIER DIE WERTE EINTRAGEN, UM DIE 
		final int periodTime = 1000;		//BEDÜRFNISREDUZIERUNG ANZUPASSEN
		
		OwnTimer.queueTask(task, initialDelay, periodTime, TimeUnit.MILLISECONDS);
	}

	/*
	 * soll den aktuellen "wert" um den mitgegebenen Wert verringern
	 */
	public void verringern(int subtraktionsWert){
		this.wert -= subtraktionsWert;
		
		if(this.wert < this.minWert){
			this.wert = this.minWert;
			this.isKilled = true;
		}
	}
	
	/*
	 * soll den aktuellen "wert" um den mitgegebenen Wert erhöhen
	 */
	public void erhoehen(int additionsWert){
		this.wert += additionsWert;
		
		if(this.wert > this.maxWert){
			this.wert = this.maxWert;
		}
	}
	
	public abstract int getWert();
	
	
	public void killed(){
		this.wert = this.minWert;
	}
	
	public boolean isDead() {
		
		return isKilled;
	}
}
