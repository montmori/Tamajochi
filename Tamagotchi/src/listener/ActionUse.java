/**
 * Benutzt ein TamagotchiUsable.
 */

package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;
import tamagotchi_klassen.TamagotchiUsable;

public class ActionUse implements ActionListener{

	private TamagotchiUsable e1;
	
	/**
	 * Konstruktor.
	 * @param e1	Das zu verwendende TamagotchiUsable.
	 */
	public ActionUse(TamagotchiUsable e1){
		this.e1 = e1;
	}
	
	/**
	 * Benutzt das TamagotchiUsable, wenn der dazugehörige Button gedrückt wurde.
	 */
	public void actionPerformed(ActionEvent e) {
		Game.getGame().getTamagotchi().use(e1);
	}
}
