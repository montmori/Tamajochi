/**
 * Leitet die Spielzurücksetzung auf Knopfdruck ein.
 */

package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;

public class ActionNewGame implements ActionListener {

	/**
	 * Wenn der Button gedrückt wird, wird die Spielzurücksetzung eingeleitet.
	 */
	public void actionPerformed(ActionEvent arg0) {
		Game.getGame().newGame();

	}

}
