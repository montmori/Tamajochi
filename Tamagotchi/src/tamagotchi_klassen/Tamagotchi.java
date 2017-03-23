package tamagotchi_klassen;

import java.io.Serializable;

import beduerfnis_klassen.Beduerfnis;
import beduerfnis_klassen.Durst;
import beduerfnis_klassen.Hunger;
import beduerfnis_klassen.Langeweile;
import beduerfnis_klassen.Muedigkeit;
import game.Timestamp;
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
	private Nahrung[][] nahrungsArray;
	private SchlafensOrt[] schlafenArray;
	private Spielmoeglichkeit [] spielenarray;
	private Timestamp livingtime;
	private boolean lebendig;
	
	/*
	 * Tamagotchi wird erstellt und benannt.
	 * Hunger und Durst werden auf ein Default von 50Prozent gesetzt.
	 */
	public Tamagotchi(String name){
		this.lebendig = true;

		
		this.setName(name);
		
		this.beduerfnisse = new Beduerfnis[]{new Hunger(50), new Durst(50), new Muedigkeit(50), new Langeweile(50)};
		
		Nahrung[] essenArray = new Nahrung[]{new Apfel(), new Banane(), new Fleisch(), new Keks()};
		Nahrung[] trinkenArray = new Nahrung[]{new Wasser(), new Cola(), new Milch(), new Salzwasser()};
		this.nahrungsArray = new Nahrung[][]{ essenArray, trinkenArray };
		
		this.schlafenArray = new SchlafensOrt[]{new Boden(), new Bett()};
		this.spielenarray = new Spielmoeglichkeit[]{new Ball(), new Faden()};
		
		this.livingtime = new Timestamp();
		
	}
	
	/*
	 * Hier wird von der Nahrung aus auf Hunger und Durst zugegriffen und
	 * erhoeht.
	 */
	
	public Timestamp getLivingtime() {
		return livingtime;
	}

	public void use(TamagotchiUsable tu){
		tu.use();
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
	
	public void newGame(String name){
		this.name = name;
		this.beduerfnisse[0] = new Hunger(50);
		this.beduerfnisse[1] = new Durst(50);
		this.beduerfnisse[2] = new Muedigkeit(50);
		this.beduerfnisse[3] = new Langeweile(50);
		this.lebendig = true;
		this.livingtime = new Timestamp();
	}


}
