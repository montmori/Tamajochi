package gui_klassen;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import Listener.ActionMenu;
import Listener.ActionNaehren;
import Listener.ActionSchlafen;
import Listener.ActionSpielen;
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
	
	private JPopupMenu trinkenMenu;
	private JPopupMenu essenMenu;
	private JPopupMenu schlafenMenu;
	private JPopupMenu spielenMenu;
	
	public ButtonPanel(Dimension d, Nahrung[][] nahrungen, SchlafensOrt[] schlafenArray, Spielmoeglichkeit[] spielenArray){
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
		this.setPreferredSize(d);
		
		this.essenArray = nahrungen[0];
		this.trinkenArray = nahrungen[1];
		this.schlafenArray = schlafenArray;
		this.spielenArray = spielenArray;
		
		addButtons();
	}
	
	private void addButtons() {
		
		addEssen();
		addTrinken();
		addSchlafen();
		addSpielen();
		
		
	}
	
	private void addTrinken(){
		
		this.trinkenMenu = new JPopupMenu();
		
		JButton trinkenButton = new JButton("Trinken geben");
        trinkenButton.addActionListener( new ActionMenu(trinkenMenu));
        this.trinkenButtonArray = new JButton[this.trinkenArray.length];
        
        for(int x = 0; x < this.trinkenArray.length; x++){
        	this.trinkenButtonArray[x] = new JButton(this.trinkenArray[x].toString());
        	this.trinkenButtonArray[x].addActionListener(new ActionNaehren(this.trinkenArray[x]));
        	this.trinkenMenu.add(this.trinkenButtonArray[x]);
        }
        
		this.add(trinkenButton);
	}
	
	
	private void addEssen(){
				
		this.essenMenu = new JPopupMenu();
		
		JButton essenButton = new JButton("Essen geben");
        essenButton.addActionListener( new ActionMenu(this.essenMenu));
        this.essenButtonArray = new JButton[this.essenArray.length];
        
        for(int x = 0; x < this.essenArray.length; x++){
        	this.essenButtonArray[x] = new JButton(this.essenArray[x].toString());
        	this.essenButtonArray[x].addActionListener(new ActionNaehren(this.essenArray[x]));
        	this.essenMenu.add(this.essenButtonArray[x]);
        }
        
		this.add(essenButton);
	}
	
	private void addSchlafen(){
		
		this.schlafenMenu = new JPopupMenu();
		
		JButton schlafenButton = new JButton("Schlafen legen");
		schlafenButton.addActionListener( new ActionMenu(this.schlafenMenu));
		this.schlafenButtonArray = new JButton[this.schlafenArray.length];
		
		for(int x = 0; x < this.schlafenArray.length; x++){
			this.schlafenButtonArray[x] = new JButton(this.schlafenArray[x].toString());
			this.schlafenButtonArray[x].addActionListener(new ActionSchlafen(this.schlafenArray[x]));
			this.schlafenMenu.add(this.schlafenButtonArray[x]);
		}
		
		this.add(schlafenButton);
	}
	
	private void addSpielen(){
		
		this.spielenMenu = new JPopupMenu();
		
		JButton spielenButton = new JButton("Spielen");
		spielenButton.addActionListener( new ActionMenu(this.spielenMenu));
		this.spielenButtonArray = new JButton[this.spielenArray.length];
		
		for(int x = 0; x < this.spielenArray.length; x++){
			this.spielenButtonArray[x] = new JButton(this.spielenArray[x].toString());
			this.spielenButtonArray[x].addActionListener(new ActionSpielen(this.spielenArray[x]));
			this.spielenMenu.add(this.spielenButtonArray[x]);
		}
		
		this.add(spielenButton);
	}

	public void gameOver() {
		this.essenMenu.setEnabled(false);
		this.trinkenMenu.setEnabled(false);
		this.schlafenMenu.setEnabled(false);
		this.spielenMenu.setEnabled(false);
		
	}

	public void newGame() {
		this.essenMenu.setEnabled(true);
		this.trinkenMenu.setEnabled(true);
		this.schlafenMenu.setEnabled(true);
		this.schlafenMenu.setEnabled(true);
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
