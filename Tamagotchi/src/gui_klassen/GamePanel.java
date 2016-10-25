package gui_klassen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import tamagotchi_klassen.Viech;

public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Viech tamagotchi;
	
	public GamePanel(Viech tamagotchi, Dimension d){
		this.tamagotchi = tamagotchi;
		this.setPreferredSize(d);
		
	}
	
	public void paint(Graphics g){
		
		int b = this.getWidth() - 1;
		int h = this.getHeight() - 1;
		g.drawLine(1, 1, b, 1);
		g.drawLine(1, 1, 1, h);
		g.drawLine(b, 1, b, h);
		g.drawLine(1, h, b, h);
		
			
		printBeduerfnis(g, 20, 20, Viech.hunger.getWert());
		printBeduerfnis(g, 20, 10, Viech.durst.getWert());
		
		
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
