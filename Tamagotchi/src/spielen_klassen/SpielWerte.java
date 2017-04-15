/**
 * Interface für die SpielWerte
 * _L	= Auswirkung auf die Langeweile
 * _M 	= Auswirkung auf die Müdigkeit
 * _H	= Auswirkung auf den Hunger
 * _T	= Auswirkungen auf den Durst
 * _TTU = Zeit, bis zur Freischaltung
 */

package spielen_klassen;

public interface SpielWerte {

	public static final int BALL_L = 10;
	public static final int BALL_H = -2;
 	public static final int BALL_T = -2;
	public static final int BALL_M = -4;
	public static final int BALL_TTU = 1200;
	public static final int BALLSPIELDAUER = 4;
 	
	
	
	
	public static final int FADEN_L = 5;
	public static final int FADEN_H = -1;
	public static final int FADEN_T = -1;
	public static final int FADEN_M = -2;
	public static final int FADEN_TTU = 0;
	public static final int FADENSPIELDAUER = 5;
	
	
}
