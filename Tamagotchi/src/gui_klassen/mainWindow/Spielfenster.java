/**
 * Stellt die komplette Grafik auf dem Bildschirm dar.
 */

package gui_klassen.mainWindow;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import listener.ActionBeenden;
import listener.ActionDialouge;
import listener.ActionDialouge.DialougeType;
import listener.ActionNewGame;
import listener.Windowflauscher;
import runnable_klassen.FensterAktualisierung;
import runnable_klassen.OwnTimer;

public class Spielfenster extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String FENSTERNAME = "Tamagotchi";
	private ButtonPanel buttonpanel;
	private GamePanel gamepanel;
	private ScheduledThreadPoolExecutor t1;
	
	
	/**
	 * Konstruktor.
	 * @param size 	Größe, die das Fenster haben soll.
	 */
	public Spielfenster(Dimension size){
		
		initWindow(size);
		initFensterAktualisierung();
		setVisible(true);
		
	}
	
	
	/**
	 * @return	Das Panel, auf dem sich die Buttons und ihre Popupmenüs befinden.
	 */
	public ButtonPanel getButtonPanel(){
		return this.buttonpanel;
	}
	
	
	/**
	 * @return Das Panel, auf dem das Tamagotchi und die dazugehörigen Werte abgebildet werden.
	 */
	public GamePanel getGamePanel(){
		return this.gamepanel;
	}
	
	
	/**
	 * ScheduledThreadPoolExecutor damit das Fenster IMMER aktualisiert wird.
	 * Wird nicht mit den anderen Tasks beim Tod des Tamagotchis beendet.
	 */
	private void initFensterAktualisierung() {
		t1 = new ScheduledThreadPoolExecutor(OwnTimer.EXECUTOR_CORE_POOL_SIZE);
		t1.scheduleAtFixedRate(new FensterAktualisierung(this), 200, 33, TimeUnit.MILLISECONDS);
		
	}

	
	/**
	 * Legt alle wichtigen Werte für das Fenster fest und setzt es mittig.
	 * @param size 	Größe, die das Fenster haben soll.
	 */
	private void initWindow(Dimension size){
		this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - size.width/2
				,Toolkit.getDefaultToolkit().getScreenSize().height/2 - size.height/2); //Setzt das Fenster mittig
		this.setTitle(FENSTERNAME);
		this.setResizable(false);
		this.setSize(size);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addWindowListener(new Windowflauscher());
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 30));
		
		initMenuBar();
		initJPanels(size);	
	}
	
	
	/**
	 * Erstellt das ButtonPanel und das GamePanel und addet sie in das Fenster.
	 * Erstellt den Hintergrund.
	 * @param size	Größe des Fensters.
	 */
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
		this.add(this.gamepanel);
	}


	/**
	 * Erstellt eine Menüleiste
	 */
	private void initMenuBar() {
		JMenuBar menuLeiste = new JMenuBar();
		this.addMenu(menuLeiste);
		this.setJMenuBar(menuLeiste);
	}


	/**
	 * Füllt die Menüleiste mit Menüs
	 * @param menuLeiste	Menüleiste auf die die Menüs angebracht werden sollen.
	 */
	private void addMenu(JMenuBar menuLeiste) {
		JMenu spiel = new JMenu("Spiel");
		this.addSpielMenuItems(spiel);
		
		JMenu optionen = new JMenu("Optionen");
		this.addOptionMenuItems(optionen);
		
		JMenu ueber = new JMenu("Über");
		this.addAboutMenuItems(ueber);
		
		
		menuLeiste.add(spiel);
		menuLeiste.add(optionen);
		menuLeiste.add(ueber);
	}

	
	
	/**
	 * Die Menüs werden mit Unterpunkten gefüllt
	 * (nächsten drei Methoden)
	 * @param ueber	Menü in das die Unterpunkte hinzugefügt werden sollen.
	 */
	private void addAboutMenuItems(JMenu ueber) {
		JMenuItem infos = new JMenuItem("Infos");
		infos.addActionListener(new ActionDialouge(DialougeType.ABOUT));
		
		ueber.add(infos);
	}

	
	/**
	 * @param optionen	Menü in das die Unterpunkte hinzugefügt werden sollen.
	 */
	private void addOptionMenuItems(JMenu optionen) {
		JMenuItem statistiken = new JMenuItem("Statistiken");
		statistiken.addActionListener(new ActionDialouge(DialougeType.STATISTICS));
		
		JMenuItem erfolge = new JMenuItem("Achievements");
		erfolge.addActionListener(new ActionDialouge(DialougeType.ACHIEVEMENTS));
		
		optionen.add(statistiken);
		optionen.add(erfolge);
	}

	
	
	/**
	 * @param spiel	Menü in das die Unterpunkte hinzugefügt werden sollen.
	 */
	private void addSpielMenuItems(JMenu spiel) {
		JMenuItem beenden = new JMenuItem("Speichern & Beenden");
		beenden.addActionListener(new ActionBeenden());
		
		JMenuItem newGame = new JMenuItem("Neues Spiel starten");
		newGame.addActionListener(new ActionNewGame());
		
		spiel.add(newGame);
		spiel.add(beenden);
	}

}
