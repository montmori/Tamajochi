package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import spielen_klassen.Spielmoeglichkeit;
import tamagotchi_klassen.Tamagotchi;

public class ActionSpielen implements ActionListener {

	private Spielmoeglichkeit s1;
	
	public ActionSpielen(Spielmoeglichkeit s1){
		this.s1 = s1;
	}

	public void actionPerformed(ActionEvent e) {
		Tamagotchi.spielen(this.s1);
	}


}
