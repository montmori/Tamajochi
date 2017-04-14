/**
 * Haelt die Spielzeit fest, fuer Anzeige und Achievements.
 */

package game;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import runnable_klassen.OwnTimer;

public class Timestamp implements Serializable,Runnable {

	private static final long serialVersionUID = 726945156398220291L;

	private int time;
	private boolean isStarted;
	
	/**
	 * Konstruktor
	 * Setzt die Zeit zurück und sorgt dafür, dass der Timer nicht sofort loszählt.
	 */
	public Timestamp(){
		this.setTime(0);
		this.isStarted = false;
		OwnTimer.scheduleAtFixedRate(this, 1, 1, TimeUnit.SECONDS);
	}
	
	/**
	 * Nach einem Neustart wird der gespeicherte Timer wieder fortgeführt. 
	 */
	public void resumeAfterShutdown(){
		OwnTimer.scheduleAtFixedRate(this, 1, 1, TimeUnit.SECONDS);
		this.isStarted = true;
	}
	
	
	/**
	 * Startet den Zählvorgang.
	 * Setzt den Boolean der dem Timer erlaubt hochzuzählen true.
	 */
	public void start(){
		this.isStarted = true;
	}

	
	/**
	 * Stoppt den Zählvorgang.
	 * Setzt den Boolean der dem Timer erlaubt hochzuzählen false.
	 */
	public void stop(){
		this.isStarted = false;
	}
	
	
	/**
	 * Setzt den Timestamp auf 0 zurück.
	 */
	public void reset(){
		this.setTime(0);
	}
	
	
	/**
	 * @return Die vergangene Zeit in Sekunden.
	 */
	public int getTimeSeconds() {
		return time;
	}

	
	/**
	 * Ist dafür da um den Timer einzustellen. (Wird eigentlich nicht so wirklich gebraucht)
	 * @param time	Auf die der Timer gesetzt werden soll.
	 */
	public void setTime(int time) {
		this.time = time;
	}
	
	

	/**
	 * Zählt den Timer hoch falls gestartet.
	 */
	public void run() {
		if(this.isStarted){
			this.time++;
		}
	}
}
