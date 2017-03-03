
package game;

import java.awt.Dimension;
import java.awt.Toolkit;

import gui_klassen.mainWindow.Spielfenster;

public class Starter {
	
	public static void main(String[] args){
		
		startGame();
		
	}
	
	private static void startGame(){
			
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		
		int startHoehe = (int)(size.getHeight()/1.5);
		int startBreite = (int)(size.getWidth()/1.5);
		
		size = new Dimension(startBreite, startHoehe);
		
		String Tamagotchiname = "Berndewiglangernameblablabla";
		
		new Spielfenster(size, Tamagotchiname);	
	}
}