package schlafen_klassen;

import java.io.Serializable;
import java.util.TimerTask;

import tamagotchi_klassen.TamagotchiUsable;

public abstract class SchlafensOrt extends TimerTask implements TamagotchiUsable,SchlafensWerte,Serializable{

	private String nameOfClass;
	private static final long serialVersionUID = -7244748013359821828L;
	private int timeTillUnlock;
	private boolean isUnlocked;
	
	public SchlafensOrt(String nameOfClass){
		setName(nameOfClass);
	}
	
	public abstract void use();
	
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
