package beduerfnis_klassen;

import java.io.Serializable;

public abstract class Beduerfnis implements BeduerfnisWerte, Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7666343660063488766L;
	protected int wert;
	protected int maxWert;
	protected int minWert;
	
	/*
	 * wert = der aktuelle Wert des Beduerfnis
	 * maxWert = der groeste Wert fuer "wert"
	 * minWert = der niedrigste Wert fuer "wert"
	 * ------------------------------------------
	 * maxWert & minWert werden später für der "sterben/game over" - Funktion
	 * des Tamagotchis verwendet
	 */
	public Beduerfnis (int wert, int maxWert, int minWert){
		this.wert = wert;
		this.maxWert = maxWert;
		this.minWert = minWert;
	}
	
	/*
	 * soll den aktuellen "wert" um den mitgegebenen Wert verringern
	 */
	public abstract void verringern(int subtraktionsWert);
	
	/*
	 * soll den aktuellen "wert" um den mitgegebenen Wert erhöhen
	 */
	public abstract void erhoehen(int additionsWert);
	
	public abstract int getWert();
	
}
