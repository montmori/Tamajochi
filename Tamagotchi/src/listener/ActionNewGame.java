package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui_klassen.mainWindow.Spielfenster;

public class ActionNewGame implements ActionListener {

	
	public void actionPerformed(ActionEvent arg0) {
		Spielfenster.newGame();

	}

}
