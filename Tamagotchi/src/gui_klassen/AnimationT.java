package gui_klassen;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import debugInterface.Debugable;

public class AnimationT implements Runnable{

	private ImageIcon[] bildArray; //benutze ImageIcon weil man da den Loadstatus abfragen kann!
	private final int BILDANZAHL = 3;

	private boolean rechtsrum = true;
	private int zaehler;
	
	private ImageIcon currentBild;
	
	private ScheduledThreadPoolExecutor timer;

	
	public AnimationT(){
		
		this.bildArray = new ImageIcon[this.BILDANZAHL];
		this.zaehler = this.BILDANZAHL/2;
		
		try {
			for(int i = 0; i < this.BILDANZAHL; i++){
				Image temp = ImageIO.read(new File("Images/tamagotchiNormal" + i + ".png"));
				temp = temp.getScaledInstance(1920/2, 1080/2, 32);
				this.bildArray[i] = new ImageIcon(temp);
			}
			
			this.currentBild = this.bildArray[this.BILDANZAHL/2];
			
		} catch (IOException e) {
			if(Debugable.DEBUG_GUI){
				System.out.println("Keine Bilder fuer Animation gefunden! Fehler in Klasse AnimationT");
			}
		}
		
		this.timer = new ScheduledThreadPoolExecutor(0);
		this.timer.scheduleAtFixedRate(this, 1, 1, TimeUnit.SECONDS);
		
	}
	
	
	public ImageIcon getCurrentBild(){
		return this.currentBild;
	}
	
	
	public void changeImage(){
		
		if(rechtsrum){
			this.zaehler++;
			//System.out.println("positiv " + this.zaehler);
			this.currentBild = this.bildArray[zaehler-1];
		}
		else{
			this.zaehler--;
			//System.out.println("negativ " + this.zaehler);
			this.currentBild = this.bildArray[zaehler-1];
		}
		
		if(this.zaehler == this.BILDANZAHL || this.zaehler == 1){
			this.rechtsrum = !rechtsrum;
		}

	}

	@Override
	public void run() {
		this.changeImage();
	}
	
	
}