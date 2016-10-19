package gui_klassen;

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
		
		String beduerfnisse = "" + this.tamagotchi;
		g.drawString(beduerfnisse, 50, 50);
		
	}
}
