package tamagotchi_klassen;

import beduerfniss_klassen.Durst;
import beduerfniss_klassen.Hunger;
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
		Tamagotchi.hunger = new Hunger(100, 100, 0);
		Tamagotchi.durst = new Durst(100, 100, 0);
	}
	
	/*
	 * Hier wird von der Nahrung aus auf Hunger und Durst zugegriffen und
	 * erhoeht.
	 */
	public void naehren(Nahrung n){
		n.geben();
	}
	
	
	public String toString(){
		
		return "Hunger: " + Tamagotchi.hunger.getWert() + "\nDurst: " + Tamagotchi.durst.getWert();
	}
}
