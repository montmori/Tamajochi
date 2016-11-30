package gui_klassen;

import java.awt.Color;
import java.awt.Dimension;
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
	
	private Tamagotchi tamagotchi;
	
	private int widthMultiplier;
	private int heightMultiplier;
	
	
	public GamePanel(Tamagotchi t, Dimension d){
		this.tamagotchi = t;
		
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
		
		
		if(!(hunger == null) & !(durst == null)){
			
			int hungerImageXStartValue = this.getWidth()/hungerXpara - hunger.getWidth(this) - 5;
			int durstImageXStartValue = this.getWidth()/durstXpara - durst.getWidth(this) - 5;
			
			
			g.drawImage(hunger, hungerImageXStartValue, this.getHeight()/hungerYpara, this);
			g.drawImage(durst, durstImageXStartValue, this.getHeight()/durstYpara, this);
		
		}
		

		printBeduerfnis(g, hungerXpara, hungerYpara, tamagotchi.getHunger().getWert());
		printBeduerfnis(g, durstXpara, durstYpara, tamagotchi.getDurst().getWert());
		
		
//		String beduerfnisse = "" + this.tamagotchi;
//		g.drawString(beduerfnisse, 50, 50);
		
	}
	
	public void printBeduerfnis(Graphics g, int xpara, int ypara, int beduerfnisWert){
		
		int bgesamt = this.getWidth();
		int hgesamt = this.getHeight();
		int startX = bgesamt/xpara;
		int startY = hgesamt/ypara;
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
		
		double breite = ((double)b/100) * (double)beduerfnisWert;
		g.fillRect(startX, startY, (int) breite, h);
		
		g.setColor(Color.BLACK);
		g.drawRect(startX, startY, b, h);		
	}
	
	 

}
