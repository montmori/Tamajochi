package tamagotchi_klassen;

import beduerfnis_klassen.Durst;
import beduerfnis_klassen.Hunger;
import nahrungs_klassen.Nahrung;

/*
 * Zu vervollstaendigen!
 * Das abstrakte Tamagotchi
 */
public abstract class Tamagotchi {

	String name;
	public static Hunger hunger;
	public static Durst durst;
	
	/*
	 * Tamagotchi wird erstellt und benannt.
	 * Hunger und Durst werden auf ein Default von 100Prozent gesetzt.
	 */
	public Tamagotchi(String name){
		this.name = name;
		Tamagotchi.hunger = new Hunger(0);
		Tamagotchi.durst = new Durst(0);
	}
	
	/*
	 * Hier wird von der Nahrung aus auf Hunger und Durst zugegriffen und
	 * erhoeht.
	 */
	public static void naehren(Nahrung n){
		n.geben();
	}
	
	
	public String toString(){
		
		return "Essen: " + Tamagotchi.hunger.getWert() + "\n Trinken: " + Tamagotchi.durst.getWert();
	}
}
