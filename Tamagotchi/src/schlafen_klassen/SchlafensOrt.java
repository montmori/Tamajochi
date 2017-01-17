package schlafen_klassen;

import java.io.Serializable;
import java.util.TimerTask;

import tamagotchi_klassen.Tamagotchi;

public abstract class SchlafensOrt extends TimerTask implements SchlafensWerte,Serializable{

	private String nameOfClass;
	private static final long serialVersionUID = -7244748013359821828L;
	protected Tamagotchi tamagotchi;
	
	public SchlafensOrt(Tamagotchi tamagotchi, String nameOfClass){
		this.tamagotchi = tamagotchi; 
		setName(nameOfClass);
	}
	
	public abstract void schlafen();
	
	public String toString(){
		return this.nameOfClass;
	}
	
	public void setName(String nameOfClass){
		this.nameOfClass = nameOfClass;
	}
}
