package gui_klassen;

import javax.swing.JPanel;
import tamagotchi_klassen.Viech;

public class OwnPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Viech tamagotchi;
	
	public OwnPanel(Viech tamagotchi){
		this.tamagotchi = tamagotchi;
		
	}
}
