/**
 * JPanel auf dem dem alle Spielinhalte, bis auf die Buttons, abgebildet werden.
 * Wird in der FensterAktualisierung gerepainted.
 */

package gui_klassen.mainWindow;

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

import game.Game;
import tamagotchi_klassen.Tamagotchi;

public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Image hunger;
	private Image durst;
	private Image langeweile;
	private Image muedigkeit;
	private Tamagotchi tamagotchi;
	private int tamaXstart;
	private int tamaYstart;
	
	private AnimationT animation;
	
	private int widthMultiplier;
	private int heightMultiplier;
	
	
	/**
	 * Konstruktor.
	 * Erstellt das Panel, legt die wichtigen Werte fest, läd die Bilder für die Bedürfnisanzeige.
	 * @param d		Dimension, die das GamePanel haben soll.
	 */
	public GamePanel(Dimension d){
		this.tamagotchi = Game.getGame().getTamagotchi();

		this.setPreferredSize(d);
		
		this.widthMultiplier = 10;
		this.heightMultiplier = 25;
		
		this.hunger = null;
		this.durst = null;
		this.langeweile = null;
		this.muedigkeit = null;
		
		defineXYValue(d);
		
		this.animation = new AnimationT();
		
		try{
			this.hunger = ImageIO.read(new File("Images/Hunger.png"));
			this.durst = ImageIO.read(new File("Images/Durst.png"));
			this.langeweile = ImageIO.read(new File("Images/Langeweile.png"));
			this.muedigkeit = ImageIO.read(new File("Images/Muedigkeit.png"));
			
			
			int bildgroesse = (int)(d.getHeight()/this.heightMultiplier) + 1;

						
			this.hunger = this.hunger.getScaledInstance(bildgroesse, bildgroesse, Image.SCALE_SMOOTH);
			this.durst = this.durst.getScaledInstance(bildgroesse, bildgroesse, Image.SCALE_SMOOTH);
			this.langeweile = this.langeweile.getScaledInstance(bildgroesse, bildgroesse, Image.SCALE_SMOOTH);
			this.muedigkeit = this.muedigkeit.getScaledInstance(bildgroesse, bildgroesse, Image.SCALE_SMOOTH);
			
		}catch(NullPointerException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Ermittelt die Startwerte für das Tamagotchi anhand der GamePanelDimension.
	 * @param d	Dimension des GamePanels.
	 */
	private void defineXYValue(Dimension d) {
		switch((int)d.getWidth()){	
		case 1024:
			this.tamaXstart = 85;
			this.tamaYstart = 50;
			break;
		case 1280:
			this.tamaXstart = 70;
			this.tamaYstart = 20;
			break;
		case 1100:
			this.tamaXstart = 80;
			this.tamaYstart = 40;
			break;
		case 819:
			this.tamaXstart = 100;
			this.tamaYstart = 70;
			break;
		case 768:
			this.tamaXstart = 100;
			this.tamaYstart = 75;
			break;
		case 480:
			this.tamaXstart = 65;
			this.tamaYstart = 80;
			break;
		}
	}

	
	/**
	 * Zeichnet das Tamagotchi, die Bedürfnisbalken, die BedürfnisIcons und den Namen.
	 * Wenn das Tamagotchi tot ist, wird ein GameOver-Screen gezeichnet.
	 */
	public void paint(Graphics g){
		
		int b = this.getWidth() - 1;
		int h = this.getHeight() - 1;

		int beduerfnissbalkenXpara = 8;
		
		int hungerYpara = 20;
		int durstYpara = 10;
		double schlafenYpara = 6.5;
		double spielenYpara = 4.9;
		
		printAnimation(g);
		
		if(!(this.hunger == null) && !(this.durst == null) && !(this.muedigkeit == null) && !(this.langeweile == null)){
			
			int hungerImageXStartValue = this.getWidth()/beduerfnissbalkenXpara - this.hunger.getWidth(this) - 5;
			int durstImageXStartValue = this.getWidth()/beduerfnissbalkenXpara - this.durst.getWidth(this) - 5;
			int muedigkeitImageXStartValue = this.getWidth()/beduerfnissbalkenXpara - this.muedigkeit.getWidth(this) - 5;
			int langeweileImageXStartValue = this.getWidth()/beduerfnissbalkenXpara - this.langeweile.getWidth(this) - 5;
			
			g.drawImage(this.hunger, hungerImageXStartValue, this.getHeight()/hungerYpara, this);
			g.drawImage(this.durst, durstImageXStartValue, this.getHeight()/durstYpara, this);
			g.drawImage(this.muedigkeit, muedigkeitImageXStartValue, (int)(this.getHeight()/schlafenYpara), this);
			g.drawImage(this.langeweile, langeweileImageXStartValue, (int)(this.getHeight()/spielenYpara), this);
		
		}
		
		if(!Game.getGame().getTamagotchi().isLebendig()){
			g.setColor(Color.RED);
			g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40 ));
			g.drawString(this.tamagotchi.getName() + " ist gestorben!", (int) (b/2.5), h/2);
		}
		else{
			g.drawString(this.tamagotchi.getName(), this.getWidth() - this.tamagotchi.getName().length()*5 - 40, 20);
		}
		
		printBeduerfnis(g, beduerfnissbalkenXpara, hungerYpara, tamagotchi.getHunger().getWert());
		printBeduerfnis(g, beduerfnissbalkenXpara, durstYpara, tamagotchi.getDurst().getWert());
		printBeduerfnis(g, beduerfnissbalkenXpara, schlafenYpara, tamagotchi.getMuedigkeit().getWert());
		printBeduerfnis(g, beduerfnissbalkenXpara, spielenYpara, tamagotchi.getLangeweile().getWert());
		
		
//		String beduerfnisse = "" + this.tamagotchi;
//		g.drawString(beduerfnisse, 50, 50);
		
	}
	
	
	/**
	 * Holt sich das momentan zu zeichnende ImageIcon aus der AnimationT und zeichnet dieses.
	 * @param g		Das graphische Element, das zeichnen soll.
	 */
	public void printAnimation(Graphics g){
		
		ImageIcon printImage = this.animation.getCurrentBild();
		if(printImage.getImageLoadStatus() == MediaTracker.COMPLETE){
			printImage.paintIcon(this, g, this.tamaXstart, this.tamaYstart);
		}
	}
	
	
	/**
	 * Erstellt einen Balken der je nach BedürfnisWert entsprechend gefüllt wird.
	 * Je nachdem wie voll der Balken ist, wird die Farbe angepasst.
	 * 
	 * @param g					Das graphische Element, das zeichnen soll.
	 * @param xpara				X-Startwert für die obere, linke Ecke.
	 * @param ypara				Y-Startwert für die obere, linke Ecke.
	 * @param beduerfnisWert	Wert, den das zu zeichnende Bedürfnis momentan hat.
	 */
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
}
