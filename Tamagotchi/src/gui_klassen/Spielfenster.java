package gui_klassen;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Listener.ActionBeenden;
import tamagotchi_klassen.Viech;

public class Spielfenster extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String FENSTERNAME = "Tamagotchi";
	private Viech tamagotchi;
	
	
	public Spielfenster(Dimension size, String name){
		
		initGame(name);
		initWindow(size);
		setVisible(true);
		
	}
	
	
	private void initGame(String name) {
		tamagotchi = new Viech(name);
	}

	
	private void initWindow(Dimension size){
		this.setTitle(FENSTERNAME);
		this.setSize(size);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		initMenuBar();
		initJPanels(size);
		
		
	}


	private void initMenuBar() {
		JMenuBar menuLeiste = new JMenuBar();
		addMenu(menuLeiste);
		this.setJMenuBar(menuLeiste);
	}


	private void addMenu(JMenuBar menuLeiste) {
		JMenu spiel = new JMenu("Spiel");
		addSpielMenuItems(spiel);
		
		JMenu optionen = new JMenu("Optionen");
		addOptionMenuItems(optionen);
		
		menuLeiste.add(spiel);
		menuLeiste.add(optionen);
	}

	
	private void addOptionMenuItems(JMenu optionen) {
		
	}


	private void addSpielMenuItems(JMenu spiel) {
		JMenuItem beenden = new JMenuItem("Beenden");
		beenden.addActionListener(new ActionBeenden());
		spiel.add(beenden);
	}


	private void initJPanels(Dimension size) {
		
		int buttonPanelWidth = (int)(size.getWidth()/7);
		int buttonPanelHeight = (int) (size.getHeight() / 1.5) ;
		Dimension buttonpanelSize = new Dimension(buttonPanelWidth, buttonPanelHeight);
		
		this.add(new ButtonPanel( buttonpanelSize ));
		
		
		int gamePanelWidth = (int)(size.getWidth() / 5 * 4);
		int gamePanelHeight = (int) (size.getHeight() / 5 * 4) ;
		Dimension gamePanelSize = new Dimension(gamePanelWidth, gamePanelHeight);
		
		this.add(new GamePanel(tamagotchi, gamePanelSize));
	}

	
}
