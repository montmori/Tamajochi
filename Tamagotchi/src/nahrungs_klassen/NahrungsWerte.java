/**
 * Interface für die Nahrungswerte.
 * _H 	= Auswirkung auf Hunger
 * _T 	= Auswirkung auf Trinken
 * _M	= Auswirkung auf Müdigkeit
 * _TTU	= Zeit bis zur Freischaltung. 		
 */

package nahrungs_klassen;

public interface NahrungsWerte {

	//Essen
	public static final int ESSDAUER = 3;
	
	public static final int BANANE_H = 5;
	public static final int BANANE_TTU = 0;
	
	
	public static final int APFEL_H = 3;
	public static final int APFEL_T = 1;
	public static final int APFEL_TTU = 500;
	
	
	public static final int FLEISCH_H = 10;
	public static final int FLEISCH_T = -2;
	public static final int FLEISCH_M = -4;
	public static final int FLEISCH_TTU = 900;
	
	public static final int KEKS_H = 7;
	public static final int KEKS_T = -3;
	public static final int KEKS_TTU = 1500;

	
	//Trinken 
	public static final int COLA_T = 8;
	public static final int COLA_H = -3;
	public static final int COLA_M = 3;
	public static final int COLA_TTU = 300;
	
	public static final int WASSER_T = 4;
	public static final int WASSER_TTU = 0;
	
	
	public static final int MILCH_T = 7;
	public static final int MILCH_H = 2;
	public static final int MILCH_TTU = 460;
	
	public static final int SALZWASSER_T = -20;
	public static final int SALZWASSER_H = -5;
	public static final int SALZWASSER_TTU = 100;
	
}
