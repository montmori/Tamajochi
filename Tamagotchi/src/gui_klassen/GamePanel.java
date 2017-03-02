package gui_klassen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import tamagotchi_klassen.Tamagotchi;

public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Image hunger;
	private Image durst;
	private boolean gameOver;
	private Tamagotchi tamagotchi;
	private String tamaName;
	
	private AnimationT animation;
	
	private int widthMultiplier;
	private int heightMultiplier;
	
	
	public GamePanel(Tamagotchi t, Dimension d){
		this.tamagotchi = t;
		this.tamaName = this.tamagotchi.getName();
		gameOver = !this.tamagotchi.isLebendig();
		this.setPreferredSize(d);
		
		this.widthMultiplier = 10;
		this.heightMultiplier = 25;
		
		this.hunger = null;
		this.durst = null;
		
		this.animation = new AnimationT();
		
		try{
			hunger = ImageIO.read(new File("Images/Hunger.png"));
			durst = ImageIO.read(new File("Images/Durst.png"));
			
			
			
			int bildgroesse = (int)(d.getHeight()/this.heightMultiplier) + 1;

						
			hunger = hunger.getScaledInstance(bildgroesse, bildgroesse, Image.SCALE_SMOOTH);
			durst = durst.getScaledInstance(bildgroesse, bildgroesse, Image.SCALE_SMOOTH);
			
		}catch(NullPointerException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void paint(Graphics g){
		
		int b = this.getWidth() - 1;
		int h = this.getHeight() - 1;

		int beduerfnissbalkenXpara = 8;
		int hungerYpara = 20;
		
		int durstYpara = 10;
		
		double schlafenYpara = 6.5;
		
		double spielenYpara = 4.9;
		
		printAnimation(g);
		
		
		if(!(hunger == null) & !(durst == null)){
			
			int hungerImageXStartValue = this.getWidth()/beduerfnissbalkenXpara - hunger.getWidth(this) - 5;
			int durstImageXStartValue = this.getWidth()/beduerfnissbalkenXpara - durst.getWidth(this) - 5;
			
			
			g.drawImage(hunger, hungerImageXStartValue, this.getHeight()/hungerYpara, this);
			g.drawImage(durst, durstImageXStartValue, this.getHeight()/durstYpara, this);
		
		}
		
		if(gameOver){
			g.setColor(Color.RED);
			g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40 ));
			g.drawString("Game Over!", (int) (b/2.5), h/2);
		}
		else{
			g.drawString(this.tamaName, this.getWidth() - this.tamaName.length()*5 - 40, 20);
		}
		
		printBeduerfnis(g, beduerfnissbalkenXpara, hungerYpara, tamagotchi.getHunger().getWert());
		printBeduerfnis(g, beduerfnissbalkenXpara, durstYpara, tamagotchi.getDurst().getWert());
		printBeduerfnis(g, beduerfnissbalkenXpara, schlafenYpara, tamagotchi.getMuedigkeit().getWert());
		printBeduerfnis(g, beduerfnissbalkenXpara, spielenYpara, tamagotchi.getLangeweile().getWert());
		
		
//		String beduerfnisse = "" + this.tamagotchi;
//		g.drawString(beduerfnisse, 50, 50);
		
	}
	
	public void printAnimation(Graphics g){
		
		ImageIcon printImage = this.animation.getCurrentBild();
		if(printImage.getImageLoadStatus() == MediaTracker.COMPLETE){
			printImage.paintIcon(this, g, 100, 50);
		}
	}
	
	public void printBeduerfnis(Graphics g, int xpara, double ypara, int beduerfnisWert){
		
		
		int bgesamt = this.getWidth();
		int hgesamt = this.getHeight();
		int startX = bgesamt/xpara;
		double startY = hgesamt/ypara;
		int b = bgesamt/this.widthMultiplier;
		int h = hgesamt/this.heightMultiplier;
		
		if(beduerfnisWert < 50){
			g.setColor(new Color(255, 150, 0));
			if(beduerfnisWert < 20){
				g.setColor(Color.RED);
			}
		}
		else{
			g.setColor(Color.GREEN.darker());
		}
	
		if(beduerfnisWert > 0){
			double breite = ((double)b/100) * (double)beduerfnisWert;
			g.fillRect(startX, (int)startY, (int) breite, h);
		}
		
		g.setColor(Color.BLACK);
		g.drawRect(startX, (int)startY, b, h);		
	
	}

	public void gameOver() {
		this.gameOver = true;
	}

	public void newGame() {
		this.gameOver = false;
		
	}
	
	 

}
