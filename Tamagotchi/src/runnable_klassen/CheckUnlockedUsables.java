/**
 * Überwacht den Status der Tamagotchiusables.
 */

package runnable_klassen;

import java.awt.Component;

import javax.swing.JButton;

import game.Game;
import tamagotchi_klassen.TamagotchiUsable;

public class CheckUnlockedUsables implements Runnable {

	TamagotchiUsable[] usables;
	Component[] buttons;
	
	
	/**
	 * Konstruktor
	 * Holt sich alle Usables und Buttons in exakt gleicher Reihenfolge.
	 */
	public CheckUnlockedUsables(){
		//Die Reiehenfolge beider Arrays ist gleich, somit ist an jedem Index 
		//das zugehörige Paar zwischen Button und Usable
		this.usables = Game.getGame().getTamagotchi().getUsables(); 
		this.buttons = Game.getGame().getSpielfenster().getButtonPanel().getButtons();
	}
	
	
	
	/**
	 * Versieht die Buttons mit zugrhöriger Aufschrift.
	 * Enabled bzw. disabled die Buttons.
	 */
	public void run() {
		
		for(int x = 0; x < this.usables.length; x++){
			if(Game.getGame().getTamagotchi().getLivingtime().getTimeSeconds() >= usables[x].getTimeTillUnlock()){
				usables[x].setUnlocked(true);
				((JButton)buttons[x]).setText(usables[x].toString());
			}
			else{
				usables[x].setUnlocked(false);
				((JButton)buttons[x]).setText("???");
			}
		}
		if(!Game.getGame().getSpielfenster().getButtonPanel().isButtonBlockEnabled()){
			for(int x = 0; x < this.usables.length; x++){
				buttons[x].setEnabled(usables[x].isUnlocked());
			}
		}
	}

}
