package gui_klassen.mainWindow;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import listener.ActionBeenden;
import listener.ActionNewGame;
import listener.Windowflauscher;
import runnable_klassen.FensterAktualisierung;

public class Spielfenster extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String FENSTERNAME = "Tamagotchi";
	private ButtonPanel buttonpanel;
	private GamePanel gamepanel;
	private ScheduledThreadPoolExecutor t1;
	
	public Spielfenster(Dimension size){
		
		initWindow(size);
		initFensterAktualisierung();
		setVisible(true);
		
	}
	
	public ButtonPanel getButtonPanel(){
		return this.buttonpanel;
	}
	
	public GamePanel getGamePanel(){
		return this.gamepanel;
	}
	
	
	private void initFensterAktualisierung() {
		t1 = new ScheduledThreadPoolExecutor(0);
		t1.scheduleAtFixedRate(new FensterAktualisierung(this), 200, 16, TimeUnit.MILLISECONDS);
		
	}

	private void initWindow(Dimension size){
		this.setTitle(FENSTERNAME);
		this.setResizable(false);
		this.setSize(size);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addWindowListener(new Windowflauscher());
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 30));
		
		
		initMenuBar();
		initJPanels(size);	
	}
	
	private void initJPanels(Dimension size) {
		
		Background backgroundP = new Background(size);
		
		JLabel contentPane = new JLabel();
		contentPane.setIcon(backgroundP.getBackground());
		contentPane.setLayout(new FlowLayout());
		this.setContentPane(contentPane);
		
		int buttonPanelWidth = (int)(size.getWidth()/7);
		int buttonPanelHeight = (int) (size.getHeight() / 1.5) ;
		
		Dimension buttonpanelSize = new Dimension(buttonPanelWidth, buttonPanelHeight);
		this.buttonpanel = new ButtonPanel( buttonpanelSize);
		this.add( buttonpanel);
		
		
		int gamePanelWidth = (int)(size.getWidth() / 5 * 4);
		int gamePanelHeight = (int) (size.getHeight() / 5 * 4) ;
		Dimension gamePanelSize = new Dimension(gamePanelWidth, gamePanelHeight);
		
		this.gamepanel = new GamePanel(gamePanelSize);
		this.add(this .gamepanel);
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
		beenden.addActionListener(new ActionBeenden());
		
		
		JMenuItem newGame = new JMenuItem("Neues Spiel starten");
		newGame.addActionListener(new ActionNewGame());
		
		
		spiel.add(newGame);
		spiel.add(beenden);
	}



}
