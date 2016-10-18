package game;

import java.awt.Dimension;
import gui_klassen.Spielfenster;

public class Starter {
	public static void main(String[] args){
		
		startGame();
		
	}
	
	private static void startGame(){
		
		Dimension size = new Dimension(1200, 900);
		String Tamagotchiname = "Bernd";
		new Spielfenster(size, Tamagotchiname);
	}
}
