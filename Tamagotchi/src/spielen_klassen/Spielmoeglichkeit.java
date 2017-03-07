package spielen_klassen;

import java.io.Serializable;
import java.util.TimerTask;

import tamagotchi_klassen.TamagotchiUsable;

public abstract class Spielmoeglichkeit extends TimerTask implements TamagotchiUsable,SpielWerte, Serializable{

	private String nameOfClass;
	private static final long serialVersionUID = -6945839844092394815L;
	
	public Spielmoeglichkeit(String nameOfClass){
		this.setName(nameOfClass);
	}
	
	public abstract void use();
	
	public String toString(){
		return this.nameOfClass;
	}
	
	public void setName(String nameOfClass){
		this.nameOfClass = nameOfClass;
	}
}
