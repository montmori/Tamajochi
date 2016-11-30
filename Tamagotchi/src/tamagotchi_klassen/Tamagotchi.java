package tamagotchi_klassen;

import java.io.Serializable;

import beduerfnis_klassen.*;
import nahrungs_klassen.*;

/*
 * Zu vervollstaendigen!
 * Das abstrakte Tamagotchi
 */
public abstract class Tamagotchi implements Serializable{

	private static final long serialVersionUID = 7102825756447706790L;
	private String name;
	private Hunger hunger;
	private Durst durst;
	private Nahrung[] essenArray;
	private Nahrung[] trinkenArray;
	private Nahrung[][] nahrungsArray;
	
	/*
	 * Tamagotchi wird erstellt und benannt.
	 * Hunger und Durst werden auf ein Default von 100Prozent gesetzt.
	 */
	public Tamagotchi(String name){
		this.name = name;
		this.hunger = new Hunger(50);
		this.durst = new Durst(50);
		essenArray = new Nahrung[]{new Apfel(this), new Banane(this), new Fleisch(this), new Keks(this)};
		trinkenArray = new Nahrung[]{new Trinken(this)};
		nahrungsArray = new Nahrung[][]{ essenArray, trinkenArray };
	}
	
	/*
	 * Hier wird von der Nahrung aus auf Hunger und Durst zugegriffen und
	 * erhoeht.
	 */
	public static void naehren(Nahrung n){
		n.geben();
	}
	
	public String toString(){
		
		return "Essen: " + this.hunger.getWert() + "\n Trinken: " + this.durst.getWert();
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hunger getHunger() {
		return hunger;
	}

	public Durst getDurst() {
		return durst;
	}

	public Nahrung[][] getNahrungsArray() {
		return nahrungsArray;
	}
}
