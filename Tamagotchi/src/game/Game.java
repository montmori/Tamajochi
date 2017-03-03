package game;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;

import gui_klassen.mainWindow.Spielfenster;
import gui_klassen.resolutionAbfrage.Abfragefenster;
import runnable_klassen.CheckLifeState;
import runnable_klassen.OwnTimer;
import tamagotchi_klassen.Tamagotchi;
import tamagotchi_klassen.Viech;

public class Game {

	private static Game game = null;
	private Spielfenster fenster;
	private Tamagotchi tamagotchi;
	private Dimension userSize;
	
	
	
	public Game(){
		

	}
	
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

	private String getTamagotchiName() {		
		return "Bernd";
	}

	public Dimension getUserSize(){
		
		return this.userSize;
	}
	
	private Dimension getWindowSize() {

		Abfragefenster resolution = new Abfragefenster();
		this.userSize = resolution.getUserPreferredSize();
		
		return this.userSize;
	}
	
	
	
	private void initTamagotchiInstance() {
		
		loadTamagotchiInstance();
		
		if(this.tamagotchi == null){
			this.tamagotchi = new Viech(this.getTamagotchiName());
		}
		
		OwnTimer.queueTask(new CheckLifeState(this.tamagotchi), 100, 100, TimeUnit.MILLISECONDS);
	}
	
	
	private void BeduerfnisTaskStart() {
		this.tamagotchi.getDurst().startTask(this.tamagotchi.getDurst());
		this.tamagotchi.getHunger().startTask(this.tamagotchi.getHunger());
		this.tamagotchi.getMuedigkeit().startTask(this.tamagotchi.getMuedigkeit());
		this.tamagotchi.getLangeweile().startTask(this.tamagotchi.getLangeweile());
		
	}
	
	

	public void gameOver(){
		OwnTimer.stopTimer();
		fenster.getGamePanel().gameOver();
		fenster.getButtonPanel().gameOver();
		
	}

	public void newGame(){
		OwnTimer.stopTimer();
		fenster.getGamePanel().newGame();
		fenster.getButtonPanel().newGame();
		this.tamagotchi.newGame();		
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
