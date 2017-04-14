/**
 * ActionDialouge ist ein ActionListener der für bestimmte Textausgaben in Fenstern benutzt wird.
 */

package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import game.Game;

public class ActionDialouge implements ActionListener {

	public enum DialougeType{
		STATISTICS, ABOUT, ACHIEVEMENTS; 
	}
	
	DialougeType dialougeType;
	
	/**
	 * Konstruktor.
	 * Setzt den dialougeType fest.
	 * @param dialougeType		der DialougeType, der benutzt werden soll.
	 */
	public ActionDialouge(DialougeType dialougeType){
		this.dialougeType = dialougeType;
	}
	
	
	/**
	 * Für jeden DialougeType wird ein Unterfenster mit passendem, davor generiertem Inhalt erstellt.
	 */
	public void actionPerformed(ActionEvent arg0) {
		
		if(this.dialougeType == DialougeType.STATISTICS){
			String statistic = "Lebenszeit:   " + Game.getGame().getTamagotchi().getLivingtime().getTimeSeconds() + " Sekunden";
			JOptionPane.showMessageDialog(Game.getGame().getSpielfenster(), statistic); //Öffnet ein Unterfenster, das den String ausgibt
		}
		
		
		if(this.dialougeType == DialougeType.ABOUT){
			String about = "Developer: Joshua Braun, Marius Schmitt und Marleen Suhm\n\n"
						+ "Dieses Spiel wurde für die 'Elektronikschule Tettnang' als Projektarbeit entwickelt.\n"
						+ "All Rights Reserved by Maehrmann GmbH & Co. KG";
			
			JOptionPane.showMessageDialog(Game.getGame().getSpielfenster(), about); //Öffnet ein Unterfenster, das den String ausgibt

		}
		
		//Wenn der jeweilige Erfolg freigeschalten ist, wird der Text angezeigt, ansonsten nur der Lückenfüller.
		if(this.dialougeType == DialougeType.ACHIEVEMENTS){
			String achievements = "";
			
			achievements += "Erfolg 1:\n";
			if(Game.getGame().getAchievements().isErfolg1()){
				achievements += Game.getGame().getAchievements().getErfolg1TXT();
			}
			else{
				achievements += Game.getGame().getAchievements().getLueckenfuellerTXT();
			}
			
			achievements += "Erfolg 2:\n";
			if(Game.getGame().getAchievements().isErfolg2()){
				achievements += Game.getGame().getAchievements().getErfolg2TXT();
			}
			else{
				achievements += Game.getGame().getAchievements().getLueckenfuellerTXT();
			}
			
			achievements += "Erfolg 3:\n";
			if(Game.getGame().getAchievements().isErfolg3()){
				achievements += Game.getGame().getAchievements().getErfolg3TXT();
			}
			else{
				achievements += Game.getGame().getAchievements().getLueckenfuellerTXT();
			}
			
			achievements += "Erfolg 4:\n";
			if(Game.getGame().getAchievements().isErfolg4()){
				achievements += Game.getGame().getAchievements().getErfolg4TXT();
			}
			else{
				achievements += Game.getGame().getAchievements().getLueckenfuellerTXT();
			}
			
			achievements += "Erfolg 5:\n";
			if(Game.getGame().getAchievements().isErfolg5()){
				achievements += Game.getGame().getAchievements().getErfolg5TXT();
			}
			else{
				achievements += Game.getGame().getAchievements().getLueckenfuellerTXT();
			}
			
			JOptionPane.showMessageDialog(Game.getGame().getSpielfenster(), achievements); //Öffnet ein Unterfenster, das den String ausgibt
		}

	}

}
