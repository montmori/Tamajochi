package gui_klassen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import tamagotchi_klassen.Viech;

public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Image hunger;
	private Image durst;
	
	public GamePanel(Viech tamagotchi, Dimension d){
		this.setPreferredSize(d);
		hunger = null;
		durst = null;
		try{
			hunger = ImageIO.read(new File("Hunger.png"));
			durst = ImageIO.read(new File("Durst.png"));
			
			
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
			g.drawImage(hunger, this.getWidth()/hungerXpara - 25, this.getHeight()/hungerYpara, this);
			g.drawImage(durst, this.getWidth()/durstXpara - 25, this.getHeight()/durstYpara, this);
		}
		

		printBeduerfnis(g, hungerXpara, hungerYpara, Viech.hunger.getWert());
		printBeduerfnis(g, durstXpara, durstYpara, Viech.durst.getWert());
		
		
//		String beduerfnisse = "" + this.tamagotchi;
//		g.drawString(beduerfnisse, 50, 50);
		
	}
	
	public void printBeduerfnis(Graphics g, int xpara, int ypara, int beduerfnisWert){
		
		int bgesamt = this.getWidth();
		int hgesamt = this.getHeight();
		int startX = bgesamt/xpara;
		int startY = hgesamt/ypara;
		int b = bgesamt/10;
		int h = hgesamt/25;
		
		if(beduerfnisWert < 50){
			g.setColor(Color.ORANGE);
			if(beduerfnisWert < 20){
				g.setColor(Color.RED);
			}
		}
		else{
			g.setColor(Color.GREEN);
		}
		
		double breite = ((double)b/100) * (double)beduerfnisWert;
		g.fillRect(startX, startY, (int) breite, h);
		
		g.setColor(Color.BLACK);
		g.drawRect(startX, startY, b, h);		
	}
	
	 

}
