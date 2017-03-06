package game;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;

import gui_klassen.abfragefenster.ResolutionAbfragefenster;
import gui_klassen.abfragefenster.UserStringInputAbfragefenster;
import gui_klassen.mainWindow.Spielfenster;
import runnable_klassen.CheckLifeState;
import runnable_klassen.OwnTimer;
import tamagotchi_klassen.Tamagotchi;
import tamagotchi_klassen.Viech;

public class Game {

	private static Game game = null;
	private Spielfenster fenster;
	private Tamagotchi tamagotchi;
	private Dimension userResolution;
	
	
	
	public Game(){}
	
	public void start(){
		Dimension size = getWindowSize();
		initTamagotchiInstance();
		this.fenster = new Spielfenster(size);	
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
	
	
	private void initTamagotchiInstance() {
		
		loadTamagotchiInstance();
		
		if(this.tamagotchi == null){
			this.tamagotchi = new Viech(Game.getUserStringInput());
		}
		
		OwnTimer.queueTask(new CheckLifeState(), 100, 100, TimeUnit.MILLISECONDS);
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

	public static String getUserStringInput() {
		UserStringInputAbfragefenster usi = new UserStringInputAbfragefenster("Teststring welcher als Test dient!");
		
		
		return usi.getUserInput();
	}
	
	public void newGame(){
		OwnTimer.clearTimer();
		fenster.getButtonPanel().newGame();
		this.tamagotchi.newGame(getUserStringInput());		
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
			
		} catch (FileNotFoundException e) {
			System.err.println("Neues Spiel wird erstellt!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
