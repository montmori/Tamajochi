package tamagotchi_klassen;

import java.io.Serializable;

import beduerfnis_klassen.Beduerfnis;
import beduerfnis_klassen.Durst;
import beduerfnis_klassen.Hunger;
import beduerfnis_klassen.Langeweile;
import beduerfnis_klassen.Muedigkeit;
import nahrungs_klassen.Apfel;
import nahrungs_klassen.Banane;
import nahrungs_klassen.Cola;
import nahrungs_klassen.Fleisch;
import nahrungs_klassen.Keks;
import nahrungs_klassen.Milch;
import nahrungs_klassen.Nahrung;
import nahrungs_klassen.Salzwasser;
import nahrungs_klassen.Wasser;
import schlafen_klassen.Bett;
import schlafen_klassen.Boden;
import schlafen_klassen.SchlafensOrt;
import spielen_klassen.Ball;
import spielen_klassen.Faden;
import spielen_klassen.Spielmoeglichkeit;

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
	private SchlafensOrt[] schlafenArray;
	private Spielmoeglichkeit [] spielenarray;
	private boolean lebendig;
	
	/*
	 * Tamagotchi wird erstellt und benannt.
	 * Hunger und Durst werden auf ein Default von 100Prozent gesetzt.
	 */
	public Tamagotchi(){
		this.lebendig = true;

		
		this.name = Tamagotchi.promptUserForName();
		
		this.beduerfnisse = new Beduerfnis[]{new Hunger(50), new Durst(50), new Muedigkeit(50), new Langeweile(50)};
		this.essenArray = new Nahrung[]{new Apfel(this), new Banane(this), new Fleisch(this), new Keks(this)};
		this.trinkenArray = new Nahrung[]{new Wasser(this), new Cola(this), new Milch(this), new Salzwasser(this)};
		this.nahrungsArray = new Nahrung[][]{ essenArray, trinkenArray };
		this.schlafenArray = new SchlafensOrt[]{new Boden(this), new Bett(this)};
		this.spielenarray = new Spielmoeglichkeit[]{new Ball(this), new Faden(this)};
		
	}
	
	/*
	 * Hier wird von der Nahrung aus auf Hunger und Durst zugegriffen und
	 * erhoeht.
	 */
	public static void naehren(Nahrung n){
		n.geben();
	}
	
	public static void schlafen(SchlafensOrt s){
		s.schlafen();
	
	}
	
	public static void spielen(Spielmoeglichkeit s){
		s.spielen();
	}
	
	public String toString(){
		
		return "Essen: " + this.beduerfnisse[0].getWert() + "\n Trinken: " + this.beduerfnisse[1].getWert() + "\n Schlafen: " + this.beduerfnisse[2].getWert() + "\n Spielen: " + this.beduerfnisse[3].getWert();
	}

	
	
	public String getName() {
		return this.name;
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
	
	public Muedigkeit getMuedigkeit(){
		return (Muedigkeit)this.beduerfnisse[2];
	}
	
	public Langeweile getLangeweile(){
		return (Langeweile)this.beduerfnisse[3];
	}

	public Nahrung[][] getNahrungsArray() {
		return this.nahrungsArray;
	}
	
	public SchlafensOrt[] getSchlafenArray(){
		return this.schlafenArray;
	}
	
	public Spielmoeglichkeit[] getSpielenArray(){
		return this.spielenarray;
	}
	
	public void gameOver(){
		zeroBeduerfnisse();
	}

	private void zeroBeduerfnisse() {
		for(Beduerfnis x : this.beduerfnisse){
			x.killed();
		}
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
		this.name = Tamagotchi.promptUserForName();
		this.beduerfnisse[0] = new Hunger(50);
		this.beduerfnisse[1] = new Durst(50);
		this.beduerfnisse[2] = new Muedigkeit(50);
		this.beduerfnisse[3] = new Langeweile(50);
		this.lebendig = true;
	}

	public static String promptUserForName() {
		
		
		return "Friedrich";
	}
}
