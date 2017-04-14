/**
 * Superklasse für die Nahrung; Essen und Trinken.
 */

package nahrungs_klassen;

import java.io.Serializable;

import tamagotchi_klassen.TamagotchiUsable;

public abstract class Nahrung implements TamagotchiUsable, NahrungsWerte, Serializable, Runnable{


	private String nameOfClass;
	private static final long serialVersionUID = 4220515769542454659L;
	protected int wert;  // Wert, um den das Bedürfnis verändert werden soll.
	private int timeTillUnlock;
	private boolean isUnlocked;
	
	
	/**
	 * Konstruktor.
	 * @param nameOfClass	Der String, der auf dem dazugehörigen Button angezeigt werden soll.
	 */
	public Nahrung(String nameOfClass){
		this.nameOfClass = nameOfClass;
	}
	
	
	/**
	 * @return 	String, der auf dem dazugehörigen Button angezeigt wird.
	 */
	public String toString(){
		return this.nameOfClass;
	}
	
	
	/**
	 * @return 	Zeit, die das Tamagotchi leben muss, damit die Nahrung benutzt werden kann.
	 */
	public int getTimeTillUnlock() {
		return this.timeTillUnlock;
	}

	
	/**
	 * @return	true, wenn diese Nahrung benutzt werden kann.
	 */
	public boolean isUnlocked() {
		return this.isUnlocked;
	}
	
	
	/**
	 * Setzt den Freigeschaltet-Status.
	 * @param isUnlocked 	Boolean, der bestimmt, ob diese Nahrung freigeschaltet ist.
	 */
	public void setUnlocked(boolean isUnlocked){
		this.isUnlocked = isUnlocked;
	}
	
	
	/**
	 * Setzt die Zeit fest, die diese Nahrung braucht, bis sie freigeschaltet wird.
	 * @param timeTillUnlock	Zeit, die diese Nahrung braucht, bis sie freigeschaltet wird.
	 */
	public void setTimeTillUnlock(int timeTillUnlock){
		this.timeTillUnlock = timeTillUnlock;
	}

}
