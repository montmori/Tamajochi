/**
 * Sorgt dafür, dass das Spiel gespeichert wird, wenn das Fenster per "X" geschlossen wird.
 */

package listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import game.Game;

public class Windowflauscher implements WindowListener {
   

	/**
	 * Konstruktor.
	 */
	public Windowflauscher(){
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	/**
	 * Wenn das Fenster geschlossen wird, rufe die windowClosing-Methode auf.
	 */
	public void windowClosed(WindowEvent arg0) {
		this.windowClosing(arg0);
	}

	/**
	 * Spiel wird gespeichert, falls das Fenster geschlossen wird.
	 */
	public void windowClosing(WindowEvent arg0) {
		Game.getGame().saveTamagotchiInstance();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}

}
