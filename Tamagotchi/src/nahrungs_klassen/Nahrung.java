package nahrungs_klassen;

import java.io.Serializable;
import java.util.TimerTask;

import tamagotchi_klassen.TamagotchiUsable;

public abstract class Nahrung extends TimerTask implements TamagotchiUsable, NahrungsWerte, Serializable{


	private String nameOfClass;
	private static final long serialVersionUID = 4220515769542454659L;
	protected int wert;
	private int timeTillUnlock;
	private boolean isUnlocked;
	
	/*
	 * Wert = Wert, welcher, wenn man die Nahrung dem 
	 * 		  Tamagotchi gibt, das jeweils dazugehörige 
	 * 		  Bedürfniss steigert.
	 */
	
	public Nahrung(String nameOfClass){
		this.setName(nameOfClass);
	}
	
	/*
	 * Diese Methode haben alle Nahrungs-subklassen
	 * Sie soll die Bedürfnisse beeinträchtigen
	 */
	
	public String toString(){
		return this.nameOfClass;
	}
	
	public void setName(String nameOfClass){
		this.nameOfClass = nameOfClass;
	}
	
	public int getTimeTillUnlock() {
		return this.timeTillUnlock;
	}

	public boolean isUnlocked() {
		return this.isUnlocked;
	}
	
	public void setUnlocked(boolean isUnlocked){
		this.isUnlocked = isUnlocked;
	}
	
	public void setTimeTillUnlock(int timeTillUnlock){
		this.timeTillUnlock = timeTillUnlock;
	}

}
