package gui_klassen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import tamagotchi_klassen.Tamagotchi;

public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Image hunger;
	private Image durst;
	private boolean gameOver;
	private Tamagotchi tamagotchi;
	
	private int widthMultiplier;
	private int heightMultiplier;
	
	
	public GamePanel(Tamagotchi t, Dimension d){
		this.tamagotchi = t;
		gameOver = !this.tamagotchi.isLebendig();
		this.setPreferredSize(d);
		
		this.widthMultiplier = 10;
		this.heightMultiplier = 25;
		
		this.hunger = null;
		this.durst = null;
		
		try{
			hunger = ImageIO.read(new File("Hunger.png"));
			durst = ImageIO.read(new File("Durst.png"));
			
			
			
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
		g.drawLine(1, 1, b, 1);
		g.drawLine(1, 1, 1, h);
		g.drawLine(b, 1, b, h);
		g.drawLine(1, h, b, h);
		
		int hungerXpara = 20;
		int hungerYpara = 20;
		
		int durstXpara = 20;
		int durstYpara = 10;
		
		int schlafenXpara = 20;
		double schlafenYpara = 6.5;
		
		int spielenXpara = 20;
		double spielenYpara = 4.9;
		
		if(!(hunger == null) & !(durst == null)){
			
			int hungerImageXStartValue = this.getWidth()/hungerXpara - hunger.getWidth(this) - 5;
			int durstImageXStartValue = this.getWidth()/durstXpara - durst.getWidth(this) - 5;
			
			
			g.drawImage(hunger, hungerImageXStartValue, this.getHeight()/hungerYpara, this);
			g.drawImage(durst, durstImageXStartValue, this.getHeight()/durstYpara, this);
		
		}
		
		if(gameOver){
			printBeduerfnis(g, hungerXpara, hungerYpara, 0);
			printBeduerfnis(g, durstXpara, durstYpara, 0);
			printBeduerfnis(g, schlafenXpara, schlafenYpara, 0);
			printBeduerfnis(g, spielenXpara, spielenYpara, 0);
			g.setColor(Color.RED);
			g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40 ));
			g.drawString("Game Over!", (int) (b/2.5), h/2);
		}
		else{
			printBeduerfnis(g, hungerXpara, hungerYpara, tamagotchi.getHunger().getWert());
			printBeduerfnis(g, durstXpara, durstYpara, tamagotchi.getDurst().getWert());
			printBeduerfnis(g, schlafenXpara, schlafenYpara, tamagotchi.getMuedigkeit().getWert());
			printBeduerfnis(g, spielenXpara, spielenYpara, tamagotchi.getLangeweile().getWert());
		}
		
//		String beduerfnisse = "" + this.tamagotchi;
//		g.drawString(beduerfnisse, 50, 50);
		
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
