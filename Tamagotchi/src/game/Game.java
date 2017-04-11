package game;

import java.awt.Dimension;
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
	
	
	
	public Game(){
		this.gameTime = new Timestamp();
		this.gameTime.start();
	}
	
	public void start(){
		Dimension size = getWindowSize();
		loadTamagotchiInstance();
		this.fenster = new Spielfenster(size);
		scheduleRunnableTasks();
	}
	
	
	//Hier können die Runnables in den Executor übernommen werden, wird beim ersten starten
	//und bei jedem weiteren neustart aufgerufen.
	private void scheduleRunnableTasks(){
		OwnTimer.scheduleAtFixedRate(new CheckLifeState(), 100, 100, TimeUnit.MILLISECONDS);
		OwnTimer.scheduleAtFixedRate(new CheckTimeAchievements(), 1, 1, TimeUnit.SECONDS);
		OwnTimer.scheduleAtFixedRate(new CheckUnlockedUsables(), 100, 100, TimeUnit.MILLISECONDS);
	}
	
	public static Game getGame(){
		if(Game.game == null){
			Game.game = new Game();
		}
		return Game.game;
	}
	
	public Tamagotchi getTamagotchi(){
		return this.tamagotchi;
	}
	
	public Achievement getAchievements(){
		return this.getTamagotchi().getAchievements();
	}
	
	public Spielfenster getSpielfenster(){
		return this.fenster;
	}

	public Dimension getUserSize(){
		return this.userResolution;
	}
	
	private Dimension getWindowSize() {

		ResolutionAbfragefenster resolution = new ResolutionAbfragefenster();
		this.userResolution = resolution.getUserPreferredSize();
		
		return this.userResolution;
	}
	
	
	private void BeduerfnisTaskStart() {
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
	
	public void newGame(){
		OwnTimer.clearTimer();
		fenster.getButtonPanel().newGame();
		this.tamagotchi.newGame(Game.getUserStringInput("Wie soll dein neues Tamagotchi heißen?"));	
		scheduleRunnableTasks();
	}
	
	
	public Timestamp getGameTime() {
		return gameTime;
	}
	
	
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
				input = "NoName";
			}
		}
		else{
			input = "NoName";
		}
		
		return input;
	}

	public void saveTamagotchiInstance() {
		
		FileOutputStream f;
		ObjectOutputStream o;
		try {
			
			f = new FileOutputStream("Save.ser");
			o = new ObjectOutputStream(f);
			o.writeObject(this.tamagotchi);
			o.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadTamagotchiInstance(){
		
		FileInputStream fin;
		ObjectInputStream oin;
		
		try {
			
			fin = new FileInputStream("Save.ser");
			oin = new ObjectInputStream(fin);
			this.tamagotchi = (Tamagotchi) oin.readObject();
			BeduerfnisTaskStart();
			this.tamagotchi.getLivingtime().resumeAfterShutdown();
			
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
