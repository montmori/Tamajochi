/**
 * Superklasse für die Spielemöglichkeiten
 */

package spielen_klassen;

import java.io.Serializable;

import tamagotchi_klassen.TamagotchiUsable;

public abstract class Spielmoeglichkeit implements TamagotchiUsable, SpielWerte, Serializable, Runnable{

	private String nameOfClass;
	private static final long serialVersionUID = -6945839844092394815L;
	private int timeTillUnlock;
	private boolean isUnlocked;
	
	
	/**
	 * Konstruktor.
	 * @param nameOfClass	Der String, der auf dem dazugehörigen Button angezeigt werden soll.
	 */
	public Spielmoeglichkeit(String nameOfClass){
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
	 * @return 	Zeit, die das Tamagotchi leben muss, damit diese Spielmöglichkeit benutzt werden kann.
	 */
	public int getTimeTillUnlock() {
		return this.timeTillUnlock;
	}

	
	/**
	 * @return	true, wenn diese Spielmöglichkeit benutzt werden kann.
	 */
	public boolean isUnlocked() {
		return this.isUnlocked;
	}
	
	
	/**
	 * Setzt den Freigeschaltet-Status.
	 * @param 	Boolean, der bestimmt, ob diese Spielmöglichkeit freigeschaltet ist.
	 */
	public void setUnlocked(boolean isUnlocked){
		this.isUnlocked = isUnlocked;
	}
	
	
	/**
	 * Setzt die Zeit fest, die diese Spielmöglichkeit braucht, bis sie freigeschaltet wird.
	 * @param	Zeit, die diese Spielmöglichkeit braucht, bis sie freigeschaltet wird.
	 */
	public void setTimeTillUnlock(int timeTillUnlock){
		this.timeTillUnlock = timeTillUnlock;
	}
}
