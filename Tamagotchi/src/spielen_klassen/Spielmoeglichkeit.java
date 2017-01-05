package spielen_klassen;

import java.io.Serializable;
import tamagotchi_klassen.Tamagotchi;

public abstract class Spielmoeglichkeit implements SpielWerte, Serializable{

	private String nameOfClass;
	private static final long serialVersionUID = -6945839844092394815L;
	protected int wert;
	protected Tamagotchi tamagotchi;
	
	public Spielmoeglichkeit(int nahrungsWert, Tamagotchi tamagotchi){
		this.wert = nahrungsWert;
		this.tamagotchi = tamagotchi; 
	}
	
	public abstract void spielen();
	
	public String toString(){
		return this.nameOfClass;
	}
	
	public void setName(String nameOfClass){
		this.nameOfClass = nameOfClass;
	}
}
