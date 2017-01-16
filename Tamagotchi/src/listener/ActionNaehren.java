package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nahrungs_klassen.Nahrung;
import tamagotchi_klassen.Tamagotchi;

public class ActionNaehren implements ActionListener {

	private Nahrung e1;
	
	public ActionNaehren(Nahrung e1){
		this.e1 = e1;
	}
	
	public void actionPerformed(ActionEvent e) {
		Tamagotchi.naehren(this.e1);
	}

}
