package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;

public class ActionNewGame implements ActionListener {

	
	public void actionPerformed(ActionEvent arg0) {
		Game.getGame().newGame();

	}

}
