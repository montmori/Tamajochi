package tamagotchi_klassen;

import java.io.Serializable;

import beduerfnis_klassen.*;
import gui_klassen.Spielfenster;
import nahrungs_klassen.*;

/*
 * Zu vervollstaendigen!
 * Das abstrakte Tamagotchi
 */
public abstract class Tamagotchi implements Serializable{

	private static final long serialVersionUID = 7102825756447706790L;
	private String name;
	private Beduerfnis[] beduerfnisse;
	private Nahrung[] essenArray;
	private Nahrung[] trinkenArray;
	private Nahrung[][] nahrungsArray;
	private boolean lebendig;
	
	/*
	 * Tamagotchi wird erstellt und benannt.
	 * Hunger und Durst werden auf ein Default von 100Prozent gesetzt.
	 */
	public Tamagotchi(String name){
		this.lebendig = true;
		this.name = name;
		
		this.beduerfnisse = new Beduerfnis[]{new Hunger(50), new Durst(50)};
		essenArray = new Nahrung[]{new Apfel(this), new Banane(this), new Fleisch(this), new Keks(this)};
		trinkenArray = new Nahrung[]{new Wasser(this), new Cola(this), new Milch(this)};
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
		
		return "Essen: " + this.beduerfnisse[0].getWert() + "\n Trinken: " + this.beduerfnisse[1].getWert();
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hunger getHunger() {
		return (Hunger)this.beduerfnisse[0];
	}

	public Durst getDurst() {
		return (Durst)this.beduerfnisse[1];
	}

	public Nahrung[][] getNahrungsArray() {
		return nahrungsArray;
	}
	
	public void gameOver(){
		Spielfenster.gameOver();
		zeroBeduerfnisse();
		
	}

	private void zeroBeduerfnisse() {
		this.beduerfnisse[0].killed();
		this.beduerfnisse[1].killed();
	}

	public boolean isLebendig(){
		for(Beduerfnis x : beduerfnisse) {
			if(x.isDead()){
				lebendig = false;
			}
		}
		
		return lebendig;
	}
	
	public void newGame(){
		this.beduerfnisse[0] = new Hunger(50);
		this.beduerfnisse[1] = new Durst(50);
		this.lebendig = true;
	}
}
