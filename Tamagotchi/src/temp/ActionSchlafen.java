package temp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import schlafen_klassen.SchlafensOrt;
import tamagotchi_klassen.Tamagotchi;

public class ActionSchlafen implements ActionListener{

	private SchlafensOrt s1;
	
	public ActionSchlafen(SchlafensOrt s1){
		this.s1 = s1;
	}
	
	public void actionPerformed(ActionEvent e) {
		Tamagotchi.schlafen(this.s1);
	}

}
