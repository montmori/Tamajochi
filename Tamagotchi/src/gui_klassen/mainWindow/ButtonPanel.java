package gui_klassen.mainWindow;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import game.Game;
import listener.ActionMenu;
import listener.ActionNaehren;
import listener.ActionSchlafen;
import listener.ActionSpielen;
import nahrungs_klassen.Nahrung;
import schlafen_klassen.SchlafensOrt;
import spielen_klassen.Spielmoeglichkeit;;

public class ButtonPanel extends JPanel{

	private static final long serialVersionUID = 6267475086902074455L;
	private Nahrung[] essenArray;
	private Nahrung[] trinkenArray;
	private SchlafensOrt[] schlafenArray;
	private Spielmoeglichkeit[] spielenArray;
	
	private JButton[] essenButtonArray;
	private JButton[] trinkenButtonArray;
	private JButton[] schlafenButtonArray;
	private JButton[] spielenButtonArray;
	
	private static JPopupMenu trinkenMenu;
	private static JPopupMenu essenMenu;
	private static JPopupMenu schlafenMenu;
	private static JPopupMenu spielenMenu;
	
	private int outerButtonFontSize;
	private int innerButtonFontSize;
	
	private Dimension size;
	
	public ButtonPanel(Dimension d){
		size = d;
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
		this.setPreferredSize(this.size);
		
		this.essenArray = Game.getGame().getTamagotchi().getNahrungsArray()[0];
		this.trinkenArray = Game.getGame().getTamagotchi().getNahrungsArray()[1];
		this.schlafenArray = Game.getGame().getTamagotchi().getSchlafenArray();
		this.spielenArray = Game.getGame().getTamagotchi().getSpielenArray();
		this.setOpaque(false);
		
		
		addButtons();
	}
	
	private void addButtons() {
		
		getFontSize();
		addEssen();
		addTrinken();
		addSchlafen();
		addSpielen();
		
		
	}
	
	private void getFontSize() {
		if(Game.getGame().getUserSize().getWidth() == 1600){
			this.outerButtonFontSize = 16; 
			this.innerButtonFontSize = 14;
		}
		
		if(Game.getGame().getUserSize().getWidth() == 1376){
			this.outerButtonFontSize = 15; 
			this.innerButtonFontSize = 13;
		}
		
		if(Game.getGame().getUserSize().getWidth() == 1280){
			this.outerButtonFontSize = 14; //1280x720
			this.innerButtonFontSize = 12; //1280x720
		}
		
		if(Game.getGame().getUserSize().getWidth() == 1024){
			this.outerButtonFontSize = 13; 
			this.innerButtonFontSize = 11;
		}
		
		if(Game.getGame().getUserSize().getWidth() == 960){
			this.outerButtonFontSize = 12; 
			this.innerButtonFontSize = 10;
		}
		
		if(Game.getGame().getUserSize().getWidth() == 600){
			this.outerButtonFontSize = 10; 
			this.innerButtonFontSize = 8;
		}
 
		
	}

	private void addTrinken(){
		
		ButtonPanel.trinkenMenu = new JPopupMenu();
		trinkenMenu.setLayout(new FlowLayout(FlowLayout.CENTER,0,1));
		trinkenMenu.setPreferredSize(new Dimension((int)this.size.getWidth(), (int)((this.size.getHeight()/20+1)*trinkenArray.length+5)));
		
		
		JButton trinkenButton = new JButton("Trinken geben");
		trinkenButton.setFont(new Font("Dialog.Bold",Font.PLAIN,this.outerButtonFontSize));
        trinkenButton.addActionListener( new ActionMenu(trinkenMenu));
        trinkenButton.setPreferredSize(new Dimension((int)this.size.getWidth(), (int)this.size.getHeight()/15));
        
        
        this.trinkenButtonArray = new JButton[this.trinkenArray.length];
        
        for(int x = 0; x < this.trinkenArray.length; x++){
        	this.trinkenButtonArray[x] = new JButton(this.trinkenArray[x].toString());
        	this.trinkenButtonArray[x].addActionListener(new ActionNaehren(this.trinkenArray[x]));
        	this.trinkenButtonArray[x].setPreferredSize(new Dimension((int)(this.size.getWidth()),(int)(this.size.getHeight()/20)));
        	this.trinkenButtonArray[x].setFont(new Font("Dialog.Bold", Font.PLAIN, this.innerButtonFontSize));
        	ButtonPanel.trinkenMenu.add(this.trinkenButtonArray[x]);
        }
        
		this.add(trinkenButton);
	}
	
	
	private void addEssen(){
				
		ButtonPanel.essenMenu = new JPopupMenu();
		ButtonPanel.essenMenu.setLayout(new FlowLayout(FlowLayout.CENTER,0,1));
		ButtonPanel.essenMenu.setPreferredSize(new Dimension((int)this.size.getWidth(), (int)(this.size.getHeight()/20+1)*essenArray.length+5));
		
		
		JButton essenButton = new JButton("Essen geben");
		essenButton.setFont(new Font("Dialog.Bold",Font.PLAIN,this.outerButtonFontSize));
        essenButton.addActionListener( new ActionMenu(ButtonPanel.essenMenu));
        essenButton.setPreferredSize(new Dimension((int)this.size.getWidth(), (int)this.size.getHeight()/15));
        
        
        this.essenButtonArray = new JButton[this.essenArray.length];
        
        for(int x = 0; x < this.essenArray.length; x++){
        	this.essenButtonArray[x] = new JButton(this.essenArray[x].toString());
        	this.essenButtonArray[x].addActionListener(new ActionNaehren(this.essenArray[x]));
        	this.essenButtonArray[x].setPreferredSize(new Dimension((int)(this.size.getWidth()),(int)(this.size.getHeight()/20)));
        	this.essenButtonArray[x].setFont(new Font("Dialog.Bold", Font.PLAIN, this.innerButtonFontSize));
        	ButtonPanel.essenMenu.add(this.essenButtonArray[x]);
        }
        
		this.add(essenButton);
	}
	
	private void addSchlafen(){
		
		ButtonPanel.schlafenMenu = new JPopupMenu();
		ButtonPanel.schlafenMenu.setLayout(new FlowLayout(FlowLayout.CENTER,0,1));
		ButtonPanel.schlafenMenu.setPreferredSize(new Dimension((int)this.size.getWidth(), (int)(this.size.getHeight()/20+1)*schlafenArray.length+5));
		
		
		JButton schlafenButton = new JButton("Schlafen legen");
		schlafenButton.setFont(new Font("Dialog.Bold",Font.PLAIN,this.outerButtonFontSize));
		schlafenButton.addActionListener( new ActionMenu(ButtonPanel.schlafenMenu));
		schlafenButton.setPreferredSize(new Dimension((int)this.size.getWidth(), (int)this.size.getHeight()/15));
		
		
		this.schlafenButtonArray = new JButton[this.schlafenArray.length];
		
		for(int x = 0; x < this.schlafenArray.length; x++){
			this.schlafenButtonArray[x] = new JButton(this.schlafenArray[x].toString());
			this.schlafenButtonArray[x].addActionListener(new ActionSchlafen(this.schlafenArray[x]));
			this.schlafenButtonArray[x].setPreferredSize(new Dimension((int)(this.size.getWidth()),(int)(this.size.getHeight()/20)));
			this.schlafenButtonArray[x].setFont(new Font("Dialog.Bold", Font.PLAIN, this.innerButtonFontSize));
			ButtonPanel.schlafenMenu.add(this.schlafenButtonArray[x]);
		}
		
		this.add(schlafenButton);
	}
	
	private void addSpielen(){
		
		ButtonPanel.spielenMenu = new JPopupMenu();		
		ButtonPanel.spielenMenu.setLayout(new FlowLayout(FlowLayout.CENTER,0,1));
		ButtonPanel.spielenMenu.setPreferredSize(new Dimension((int)this.size.getWidth(), (int)(this.size.getHeight()/20+1)*spielenArray.length+5));
		
		
		JButton spielenButton = new JButton("Spielen");
		spielenButton.setFont(new Font("Dialog.Bold",Font.PLAIN,this.outerButtonFontSize));
		spielenButton.addActionListener( new ActionMenu(ButtonPanel.spielenMenu));
		spielenButton.setPreferredSize(new Dimension((int)this.size.getWidth(), (int)(this.size.getHeight()/15)));
		
		
		this.spielenButtonArray = new JButton[this.spielenArray.length];
		
		for(int x = 0; x < this.spielenArray.length; x++){
			this.spielenButtonArray[x] = new JButton(this.spielenArray[x].toString());
			this.spielenButtonArray[x].addActionListener(new ActionSpielen(this.spielenArray[x]));
			this.spielenButtonArray[x].setPreferredSize(new Dimension((int)(this.size.getWidth()),(int)(this.size.getHeight()/20)));
			this.spielenButtonArray[x].setFont(new Font("Dialog.Bold", Font.PLAIN, this.innerButtonFontSize));
			ButtonPanel.spielenMenu.add(this.spielenButtonArray[x]);
		}
		
		this.add(spielenButton);
	}

	public void gameOver() {
		ButtonPanel.disableButtons();
		
	}

	public void newGame() {
		ButtonPanel.enableButtons();
	}
	
	public static void disableButtons(){
		for(Component x : ButtonPanel.essenMenu.getComponents()){
			x.setEnabled(false);
		}
		for(Component x : ButtonPanel.trinkenMenu.getComponents()){
			x.setEnabled(false);
		}
		for(Component x : ButtonPanel.schlafenMenu.getComponents()){
			x.setEnabled(false);
		}
		for(Component x : ButtonPanel.spielenMenu.getComponents()){
			x.setEnabled(false);
		}
	}
	
	public static void enableButtons(){
		for(Component x : ButtonPanel.essenMenu.getComponents()){
			x.setEnabled(true);
		}
		for(Component x : ButtonPanel.trinkenMenu.getComponents()){
			x.setEnabled(true);
		}
		for(Component x : ButtonPanel.schlafenMenu.getComponents()){
			x.setEnabled(true);
		}
		for(Component x : ButtonPanel.spielenMenu.getComponents()){
			x.setEnabled(true);
		}
		
	}

//	public void paint(Graphics g){
//		int b = this.getWidth() - 1;
//		int h = this.getHeight() - 1;
//		g.drawLine(1, 1, b, 1);
//		g.drawLine(1, 1, 1, h);
//		g.drawLine(b, 1, b, h);
//		g.drawLine(1, h, b, h);
//		
//	}
}
