/**
 * Leitet die Spielzur�cksetzung auf Knopfdruck ein.
 */

package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;

public class ActionNewGame implements ActionListener {

	/**
	 * Wenn der Button gedr�ckt wird, wird die Spielzur�cksetzung eingeleitet.
	 */
	public void actionPerformed(ActionEvent arg0) {
		Game.getGame().newGame();

	}

}
