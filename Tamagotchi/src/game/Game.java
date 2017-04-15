/**
 * Game ist die Klasse, die fuer das Starten und Verwalten des ganzen Spiels verantwortlich ist.
 */

package game;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import achievement.Achievement;
import achievement.CheckTimeAchievements;
import gui_klassen.abfragefenster.ResolutionAbfragefenster;
import gui_klassen.mainWindow.Spielfenster;
import runnable_klassen.CheckLifeState;
import runnable_klassen.CheckUnlockedUsables;
import runnable_klassen.OwnTimer;
import tamagotchi_klassen.Tamagotchi;
import tamagotchi_klassen.Viech;

public class Game { 
	
	private static Game game = null;
	private Spielfenster fenster;
	private Tamagotchi tamagotchi;
	private Dimension userResolution;
	private Timestamp gameTime;
	private String savePath = System.getProperty("user.home") + File.separator + "Tamagotchi" + File.separator + "Save.ser";
	
	
	/**
	 * Erstellt einen neuen Timestamp und startet diesen um die Spielzeit festzuhalten.
	 */
	public Game(){
		this.gameTime = new Timestamp();
		this.gameTime.start();
	}
	
	/**
	 * Wird von der Main aufgerufen.
	 * Startet die Spielinstanz
	 */
	public void start(){
		Dimension size = this.getWindowSize(); 
		this.loadTamagotchiInstance();
		this.fenster = new Spielfenster(size);
		this.scheduleRunnableTasks();
	}
	
	
	/**
	 * Hier können die Runnables in den Executor übernommen werden, wird beim ersten Starten
	 * und bei jedem weiteren Neustart aufgerufen.
	 */
	private void scheduleRunnableTasks(){
		OwnTimer.scheduleAtFixedRate(new CheckLifeState(), 100, 100, TimeUnit.MILLISECONDS);
		OwnTimer.scheduleAtFixedRate(new CheckTimeAchievements(), 1, 1, TimeUnit.SECONDS);
		OwnTimer.scheduleAtFixedRate(new CheckUnlockedUsables(), 100, 100, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * Wenn kein Game vorhanden ist, wird ein neues erstellt.
	 * @return Das aktuelle Game.
	 */
	public static Game getGame(){
		if(Game.game == null){
			Game.game = new Game();
		}
		return Game.game;
	}
	
	
	/**
	 * Wird häufig von anderen Klassen benötigt.
	 * @return Referenz auf das aktuelle Tamagotchi.
	 */
	public Tamagotchi getTamagotchi(){
		return this.tamagotchi;
	}

	
	/**
	 * @return Achievements des aktuellen Tamagotchis.
	 */
	public Achievement getAchievements(){
		return this.getTamagotchi().getAchievements();
	}
	
	
	/**
	 * @return Referenz auf das Spielfenster.
	 */
	public Spielfenster getSpielfenster(){
		return this.fenster;
	}	
	
	
	/**
	 * @return Die Auflösung die vom User ausgewählt wurde.
	 */
	public Dimension getUserSize(){
		return this.userResolution;
	}
	
	
	/**
	 * Erstellt ein Abfragefenster, in dem der User seine gewünschte Auflösung angibt. 
	 * @return Die vom User ausgewählte Auflösung.
	 */
	private Dimension getWindowSize() {

		ResolutionAbfragefenster resolution = new ResolutionAbfragefenster();
		this.userResolution = resolution.getUserPreferredSize();
		
		return this.userResolution;
	}
	
	
	
	/**
	 * Startet die Tasks, die die Bedürfnisse in bestimmten Abständen veringern.
	 */
	private void beduerfnisTaskStart() {
		this.tamagotchi.getDurst().startTask();
		this.tamagotchi.getHunger().startTask();
		this.tamagotchi.getMuedigkeit().startTask();
		this.tamagotchi.getLangeweile().startTask();
	}
	

	
	
	public void gameOver(){
		OwnTimer.clearTimer();
		this.tamagotchi.gameOver();
		this.fenster.getButtonPanel().gameOver();
	}
	
	
	
	/**
	 * Setzt alles auf die Anfangswerte zurück, dabei wird allerdings weder ein neues Game noch ein neues Tamagotchi erstellt.
	 */
	public void newGame(){
		OwnTimer.clearTimer();
		fenster.getButtonPanel().newGame();
		this.tamagotchi.newGame(Game.getUserStringInput("Wie soll dein neues Tamagotchi heißen?"));	
		scheduleRunnableTasks();
	}	
	
	
	/**
	 * @return Gibt die Zeit zurück, die das Tamagotchi schon lebt.
	 */
	public Timestamp getGameTime() {
		return gameTime;
	}
	
	
	
	/**
	 * Öffnet eine Abfragefenster 
	 * @param abfrage	Der String der im Fenster angezeigt wird.
	 * @return Der String der vom User eingegeben wird. Wenn nichts eingegeben wird, wird der String automatisch auf den Namen des ausführenden Benutzersgesetzt.
	 */
	public static String getUserStringInput(String abfrage) {
		
		JPanel panel = new JPanel();
		JTextField txt = new JTextField(10);
		panel.add(new JLabel(abfrage + "  "));
		panel.add(txt);
		
		int inputButton = JOptionPane.showOptionDialog(null, panel, "Eingabefenster", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"OK"}, null);
		
		String input;
		if(inputButton == 0){
			input = txt.getText();
			if(input.isEmpty()){
				input = System.getProperty("user.name");
			}
		}
		else{
			input = System.getProperty("user.name");
		}
		
		return input;
	}

	
	/**
	 * Tamagtochiinstanz wird in der Save.ser gespeichert
	 */
	public void saveTamagotchiInstance() {
		
		FileOutputStream f;
		ObjectOutputStream o;
		try {
			File saveFile = new File(this.savePath);
			if(!saveFile.exists()){
				saveFile.getParentFile().mkdir();
				saveFile.createNewFile();
			}
			f = new FileOutputStream(saveFile);
			o = new ObjectOutputStream(f);
			o.writeObject(this.tamagotchi);
			o.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Versucht aus der Save.ser ein gespeichertes Tamagotchi zu laden.
	 * Wenn keines vorhanden ist, wird ein neues erstellt.
	 */
	public void loadTamagotchiInstance(){
		
		FileInputStream fin;
		ObjectInputStream oin;
		
		try {
			
			fin = new FileInputStream(this.savePath);
			oin = new ObjectInputStream(fin);
			this.tamagotchi = (Tamagotchi) oin.readObject();
			this.beduerfnisTaskStart(); //Startet die Bedürfnisse (damit die sich verringern....)
			this.tamagotchi.getLivingtime().resumeAfterShutdown(); //Zeit wird weitergezählt
			
		} catch (FileNotFoundException e) {
			System.err.println("Neues Spiel wird erstellt!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(this.tamagotchi == null){
			this.tamagotchi = new Viech(Game.getUserStringInput("Wie soll dein Tamagotchi heißen?"));
		}
	}

}
