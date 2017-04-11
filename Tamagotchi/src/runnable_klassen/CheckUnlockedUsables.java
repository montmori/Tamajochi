package runnable_klassen;

import java.awt.Component;

import javax.swing.JButton;

import game.Game;
import tamagotchi_klassen.TamagotchiUsable;

public class CheckUnlockedUsables implements Runnable {

	TamagotchiUsable[] usables;
	Component[] buttons;
	
	public CheckUnlockedUsables(){
		//Die Reiehenfolge beider Arrays ist gleich, somit ist an jedem Index 
		//das zugehörige Paar zwischen Button und usable
		this.usables = Game.getGame().getTamagotchi().getUsables(); 
		this.buttons = Game.getGame().getSpielfenster().getButtonPanel().getButtons();
	}
	
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
