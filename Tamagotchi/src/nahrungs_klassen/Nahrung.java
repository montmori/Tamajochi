package nahrungs_klassen;

import java.io.Serializable;

import tamagotchi_klassen.Tamagotchi;

public abstract class Nahrung implements NahrungsWerte, Serializable{


	private String nameOfClass;
	private static final long serialVersionUID = 4220515769542454659L;
	protected int wert;
	protected Tamagotchi tamagotchi;
	
	/*
	 * Wert = Wert, welcher, wenn man die Nahrung dem 
	 * 		  Tamagotchi gibt, das jeweils dazugehörige 
	 * 		  Bedürfniss steigert.
	 */
	
	public Nahrung(int nahrungsWert, Tamagotchi tamagotchi){
		this.wert = nahrungsWert;
		this.tamagotchi = tamagotchi; 
	}
	
	/*
	 * Diese Methode haben alle Nahrungs-subklassen
	 * Sie soll die Bedürfnisse beeinträchtigen
	 */
	public abstract void geben();
	
	public String toString(){
		return this.nameOfClass;
	}
	
	public void setName(String nameOfClass){
		this.nameOfClass = nameOfClass;
	}
	

}
