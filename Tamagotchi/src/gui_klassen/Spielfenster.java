package gui_klassen;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import listener.ActionBeenden;
import listener.Windowflauscher;
import tamagotchi_klassen.Tamagotchi;
import tamagotchi_klassen.Viech;
import timerTask_klassen.FensterAktualisierung;

public class Spielfenster extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String FENSTERNAME = "Tamagotchi";
	private Tamagotchi tamagotchi;
	private ScheduledThreadPoolExecutor t1;
	
	
	public Spielfenster(Dimension size, String name){
		
		initGame(name);
		initWindow(size);
		initFensterAktualisierung();
		setVisible(true);
		
	}
	
	
	private void initFensterAktualisierung() {
		t1 = new ScheduledThreadPoolExecutor(0);
		t1.scheduleAtFixedRate(new FensterAktualisierung(this), 200, 16, TimeUnit.MILLISECONDS);
		
	}


	private void initGame(String name) {
		
		FileInputStream fin;
		ObjectInputStream oin;
		
		try {
			
			fin = new FileInputStream("Save.ser");
			oin = new ObjectInputStream(fin);
			this.tamagotchi = (Tamagotchi) oin.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(this.tamagotchi == null){
			tamagotchi = new Viech(name);
		}
	}

	
	private void initWindow(Dimension size){
		this.setTitle(FENSTERNAME);
		this.setResizable(false);
		this.setSize(size);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addWindowListener(new Windowflauscher(this.tamagotchi));
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 30));
		
		initMenuBar();
		initJPanels(size);	
	}
	
	private void initJPanels(Dimension size) {
		
		int buttonPanelWidth = (int)(size.getWidth()/7);
		int buttonPanelHeight = (int) (size.getHeight() / 1.5) ;
		
		Dimension buttonpanelSize = new Dimension(buttonPanelWidth, buttonPanelHeight);
		
		this.add(new ButtonPanel( buttonpanelSize, tamagotchi.getNahrungsArray() ));
		
		
		int gamePanelWidth = (int)(size.getWidth() / 5 * 4);
		int gamePanelHeight = (int) (size.getHeight() / 5 * 4) ;
		Dimension gamePanelSize = new Dimension(gamePanelWidth, gamePanelHeight);
		
		this.add(new GamePanel(tamagotchi, gamePanelSize));
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
		beenden.addActionListener(new ActionBeenden(this.tamagotchi));
		spiel.add(beenden);
	}




	
}
