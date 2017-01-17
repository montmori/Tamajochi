package spielen_klassen;

import java.io.Serializable;
import java.util.TimerTask;

import tamagotchi_klassen.Tamagotchi;

public abstract class Spielmoeglichkeit extends TimerTask implements SpielWerte, Serializable{

	private String nameOfClass;
	private static final long serialVersionUID = -6945839844092394815L;
	protected Tamagotchi tamagotchi;
	
	public Spielmoeglichkeit(Tamagotchi tamagotchi, String nameOfClass){
		this.tamagotchi = tamagotchi; 
		this.setName(nameOfClass);
	}
	
	public abstract void spielen();
	
	public String toString(){
		return this.nameOfClass;
	}
	
	public void setName(String nameOfClass){
		this.nameOfClass = nameOfClass;
	}
}
