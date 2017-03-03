package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;

public class ActionBeenden implements ActionListener {
	
	
	public ActionBeenden(){
	}
	
	public void actionPerformed(ActionEvent e) {
		saveAndExit();		
	}

	private void saveAndExit(){
		
		Game.getGame().saveTamagotchiInstance();
		
		System.exit(0);
	}

}
