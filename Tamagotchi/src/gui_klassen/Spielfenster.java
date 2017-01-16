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
import listener.ActionNewGame;
import listener.Windowflauscher;
import tamagotchi_klassen.Tamagotchi;
import tamagotchi_klassen.Viech;
import timerTask_klassen.CheckLifeState;
import timerTask_klassen.FensterAktualisierung;
import timerTask_klassen.OwnTimer;

public class Spielfenster extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String FENSTERNAME = "Tamagotchi";
	private static ButtonPanel buttonpanel;
	private static GamePanel gamepanel;
	private static Tamagotchi tamagotchi;
	private static String tamagotchiName;
	private ScheduledThreadPoolExecutor t1;
	
	public Spielfenster(Dimension size, String name){
		
		Spielfenster.tamagotchiName = name;
		initGame();
		initWindow(size);
		initFensterAktualisierung();
		setVisible(true);
		
	}
	
	
	private void initFensterAktualisierung() {
		t1 = new ScheduledThreadPoolExecutor(0);
		t1.scheduleAtFixedRate(new FensterAktualisierung(this), 200, 16, TimeUnit.MILLISECONDS);
		
	}


	private void initGame() {
		
		FileInputStream fin;
		ObjectInputStream oin;
		
		try {
			
			fin = new FileInputStream("Save.ser");
			oin = new ObjectInputStream(fin);
			Spielfenster.tamagotchi = (Tamagotchi) oin.readObject();
			globalTaskStart();
			
		} catch (FileNotFoundException e) {
			System.err.println("Neues Spiel wird erstellt!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(Spielfenster.tamagotchi == null){
			Spielfenster.tamagotchi = new Viech(tamagotchiName);
		}
	}

	
	private void globalTaskStart() {
		Spielfenster.tamagotchi.getDurst().startTask(Spielfenster.tamagotchi.getDurst());
		Spielfenster.tamagotchi.getHunger().startTask(Spielfenster.tamagotchi.getHunger());
		Spielfenster.tamagotchi.getMuedigkeit().startTask(Spielfenster.tamagotchi.getMuedigkeit());
		Spielfenster.tamagotchi.getLangeweile().startTask(Spielfenster.tamagotchi.getLangeweile());
		OwnTimer.queueTask(new CheckLifeState(Spielfenster.tamagotchi), 100, 100, TimeUnit.MILLISECONDS);
		
	}


	private void initWindow(Dimension size){
		this.setTitle(FENSTERNAME);
		this.setResizable(false);
		this.setSize(size);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addWindowListener(new Windowflauscher(Spielfenster.tamagotchi));
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 30));
		
		initMenuBar();
		initJPanels(size);	
	}
	
	private void initJPanels(Dimension size) {
		
		int buttonPanelWidth = (int)(size.getWidth()/7);
		int buttonPanelHeight = (int) (size.getHeight() / 1.5) ;
		
		Dimension buttonpanelSize = new Dimension(buttonPanelWidth, buttonPanelHeight);
		Spielfenster.buttonpanel = new ButtonPanel( buttonpanelSize, tamagotchi.getNahrungsArray(), tamagotchi.getSchlafenArray(), tamagotchi.getSpielenArray());
		this.add( buttonpanel);
		
		
		int gamePanelWidth = (int)(size.getWidth() / 5 * 4);
		int gamePanelHeight = (int) (size.getHeight() / 5 * 4) ;
		Dimension gamePanelSize = new Dimension(gamePanelWidth, gamePanelHeight);
		
		Spielfenster.gamepanel = new GamePanel(tamagotchi, gamePanelSize);
		this.add(Spielfenster.gamepanel);
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
		JMenuItem beenden = new JMenuItem("Speichern & Beenden");
		beenden.addActionListener(new ActionBeenden(Spielfenster.tamagotchi));
		
		
		JMenuItem newGame = new JMenuItem("Neues Spiel starten");
		newGame.addActionListener(new ActionNewGame());
		
		
		spiel.add(newGame);
		spiel.add(beenden);
	}


	public static void gameOver(){
		OwnTimer.stopTimer();
		Spielfenster.gamepanel.gameOver();
		Spielfenster.buttonpanel.gameOver();
		
	}

	public static void newGame(){
		OwnTimer.stopTimer();
		Spielfenster.gamepanel.newGame();
		Spielfenster.buttonpanel.newGame();
		Spielfenster.tamagotchi.newGame();

		
	}
}
