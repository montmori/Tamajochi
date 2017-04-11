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
	
	protected void startTask(Runnable task, int initialDelay, int periodTime) {
		
		OwnTimer.scheduleAtFixedRate(task, initialDelay, periodTime, TimeUnit.MILLISECONDS);
	}

	/*
	 * soll den aktuellen "wert" um den mitgegebenen Wert verändern
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


	
	public abstract int getWert();
	
	
	public void killed(){
		this.wert = this.minWert;
	}
	
	public boolean isDead() {
		
		return isKilled;
	}
}
