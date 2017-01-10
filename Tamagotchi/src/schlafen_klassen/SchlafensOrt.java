package schlafen_klassen;

import java.io.Serializable;
import tamagotchi_klassen.Tamagotchi;

public abstract class SchlafensOrt implements SchlafensWerte,Serializable{

	private String nameOfClass;
	private static final long serialVersionUID = -7244748013359821828L;
	protected int wert;
	protected Tamagotchi tamagotchi;
	
	public SchlafensOrt(int nahrungsWert, Tamagotchi tamagotchi){
		this.wert = nahrungsWert;
		this.tamagotchi = tamagotchi; 
	}
	
	public abstract void schlafen();
	
	public String toString(){
		return this.nameOfClass;
	}
	
	public void setName(String nameOfClass){
		this.nameOfClass = nameOfClass;
	}
}
