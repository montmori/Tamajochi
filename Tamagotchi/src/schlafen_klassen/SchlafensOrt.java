/**
 * Superklasse für die SchlafensOrte.
 */

package schlafen_klassen;

import java.io.Serializable;

import tamagotchi_klassen.TamagotchiUsable;

public abstract class SchlafensOrt implements TamagotchiUsable, SchlafensWerte, Serializable, Runnable{

	private String nameOfClass;
	private static final long serialVersionUID = -7244748013359821828L;
	private int timeTillUnlock;
	private boolean isUnlocked;
	
	
	/**
	 * Konstruktor.
	 * @param nameOfClass	Der String, der auf dem dazugehörigen Button angezeigt werden soll.
	 */
	public SchlafensOrt(String nameOfClass){
		this.nameOfClass = nameOfClass;
	}
	
	
	/**
	 * Muss jede Subklasse besitzen.
	 */
	public abstract void use();
	
	
	/**
	 * @return 	String, der auf dem dazugehörigen Button angezeigt wird.
	 */
	public String toString(){
		return this.nameOfClass;
	}
	
	
	/**
	 * @return 	Zeit, die das Tamagotchi leben muss, damit dieser SchlafensOrt benutzt werden kann.
	 */
	public int getTimeTillUnlock() {
		return this.timeTillUnlock;
	}

	
	/**
	 * @return	true, wenn dieser SchlafensOrt benutzt werden kann.
	 */
	public boolean isUnlocked() {
		return this.isUnlocked;
	}
	
	
	/**
	 * Setzt den Freigeschaltet-Status.
	 * @param isUnlocked	Boolean, der bestimmt, ob dieser SchlafensOrt freigeschaltet ist.
	 */
	public void setUnlocked(boolean isUnlocked){
		this.isUnlocked = isUnlocked;
	}
	
	
	/**
	 * Setzt die Zeit fest, die dieser SchlafensOrt braucht, bis er freigeschaltet wird.
	 * @param timeTillUnlock	Zeit, die dieser SchlafensOrt braucht, bis er freigeschaltet wird.
	 */
	public void setTimeTillUnlock(int timeTillUnlock){
		this.timeTillUnlock = timeTillUnlock;
	}
}
