/**
 * Aktualisiert das Fenster in einem bestimmtem Abstand.
 */

package runnable_klassen;

import gui_klassen.mainWindow.Spielfenster;

public class FensterAktualisierung implements Runnable {

	private Spielfenster f;
	
	/**
	 * Konstruktor.
	 * @param f		Welches Fenster aktualisiert werden soll.
	 */
	public FensterAktualisierung(Spielfenster f) {
		this.f = f;
	}

	
	/**
	 * Das Fenster wird aktualisiert.
	 * Die paint-Methode des angegebenen Fensters wird aufgerufen.
	 */
	public void run() {
		f.repaint();
	}

}
