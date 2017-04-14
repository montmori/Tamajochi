/**
 * Interface für die SchlafensWerte
 * _M 	= Auswirkung auf die Müdigkeit
 * _L	= Auswirkung auf die Langeweile
 * _TTU = Zeit, bis zur Freischaltung
 */

package schlafen_klassen;

public interface SchlafensWerte {

	public static final int BODEN_M = 30; 
	public static final int BODEN_L = -18;
	public static final int BODEN_TTU = 0;
	
	public static final int BODENSCHLAFDAUER = 5;  //Sekunden 
	
		
	public static final int BETT_M = 60;
	public static final int BETT_L = -16;
	public static final int BETT_TTU = 0;
	
	public static final int BETTSCHLAFDAUER = 6;  //Sekundend
}
