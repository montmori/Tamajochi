package gui_klassen;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import debugInterface.Debugable;

public class AnimationT implements Runnable{

	private Image[] bildArray;

	private int zaehler;
	
	private Image currentBild;
	
	private ScheduledThreadPoolExecutor timer;

	
	public AnimationT(){

		Image bild1;
		Image bild2;
		
		try {
			bild1 = ImageIO.read(new File("tamagotchiNormal.png"));
			bild2 = ImageIO.read(new File("tamagotchiNormal2.png"));
			
			
			bild1 = bild1.getScaledInstance(1920/2, 1080/2, 32);
			bild2 = bild2.getScaledInstance(1920/2, 1080/2, 32);
			
			this.bildArray = new Image[]{bild1, bild2};		
			this.currentBild = this.bildArray[0];
			
		} catch (IOException e) {
			if(Debugable.DEBUG_GUI){
				System.out.println("Keine Bilder fuer Animation gefunden! Fehler in Klasse AnimationT");
			}
		}
		
		this.timer = new ScheduledThreadPoolExecutor(0);
		this.timer.scheduleAtFixedRate(this, 1, 1, TimeUnit.SECONDS);
		
	}
	
	
	public Image getCurrentBild(){
		return this.currentBild;
	}
	
	
	public void changeImage(){
		
		this.zaehler++;
		
		this.currentBild = this.bildArray[zaehler-1];
		
		if(this.zaehler == this.bildArray.length){
			this.zaehler = 0;
		}

	}

	@Override
	public void run() {
		this.changeImage();
	}
	
	
}