package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import game.Game;

public class ActionDialouge implements ActionListener {

	public enum DialougeType{
		STATISTICS, ABOUT;
	}
	
	DialougeType dialougeType;
	
	public ActionDialouge(DialougeType dialougeType){
		this.dialougeType = dialougeType;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		if(this.dialougeType == DialougeType.STATISTICS){
			String statistic = "Lebenszeit:   " + Game.getGame().getTamagotchi().getLivingtime().getTimeSeconds() + " Sekunden";
			JOptionPane.showMessageDialog(Game.getGame().getSpielfenster(), statistic);
		}
		
		
		if(this.dialougeType == DialougeType.ABOUT){
			String about = "Developer: Joshua Braun, Marius Schmitt und Marleen Suhm\n\n"
						+ "Dieses Spiel wurde für die Elektronikschule als Projektarbeit entwickelt.\n"
						+ "All Rights Reserved by Maehrmann GmbH&Co.KG";
			
			JOptionPane.showMessageDialog(Game.getGame().getSpielfenster(), about);

		}

	}

}
