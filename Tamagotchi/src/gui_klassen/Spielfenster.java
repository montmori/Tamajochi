package gui_klassen;

import java.awt.Dimension;
import javax.swing.JFrame;
import tamagotchi_klassen.Viech;

public class Spielfenster extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String FENSTERNAME = "Tamagotchi";
	private Viech tamagotchi;
	
	public Spielfenster(Dimension size, String name){
		
		initWindow(size);
		initGame(name);
		setVisible(true);
	}
	
	private void initGame(String name) {
		tamagotchi = new Viech(name);
	}

	private void initWindow(Dimension size){
		this.setTitle(FENSTERNAME);
		this.setSize(size);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(new OwnPanel(tamagotchi));
	}

	
}
