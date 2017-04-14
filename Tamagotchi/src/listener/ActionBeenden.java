/**
 * Wenn der zugewiesene Button gedrückt wird, wird das Spiel gespeichert und daraufhin beendet. 
 */

package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;

public class ActionBeenden implements ActionListener {
	
	/**
	 * Konstruktor.
	 */
	public ActionBeenden(){
	}
	
	/**
	 * Wenn der Button gedrückt wird, wird die saveAndExit-Methode aufgerufen.
	 */
	public void actionPerformed(ActionEvent e) {
		saveAndExit();		
	}

	/**
	 * Das Spiel wird gespeichert und daraufhin beendet.
	 */
	private void saveAndExit(){
		
		Game.getGame().saveTamagotchiInstance();
		
		System.exit(0);
	}

}
