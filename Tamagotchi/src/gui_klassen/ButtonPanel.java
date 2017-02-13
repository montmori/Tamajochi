package gui_klassen;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

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
	
	public ButtonPanel(Dimension d, Nahrung[][] nahrungen, SchlafensOrt[] schlafenArray, Spielmoeglichkeit[] spielenArray){
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
		this.setPreferredSize(d);
		
		this.essenArray = nahrungen[0];
		this.trinkenArray = nahrungen[1];
		this.schlafenArray = schlafenArray;
		this.spielenArray = spielenArray;
		this.setOpaque(false);
		
		addButtons();
	}
	
	private void addButtons() {
		
		addEssen();
		addTrinken();
		addSchlafen();
		addSpielen();
		
		
	}
	
	private void addTrinken(){
		
		ButtonPanel.trinkenMenu = new JPopupMenu();
		
		JButton trinkenButton = new JButton("Trinken geben");
        trinkenButton.addActionListener( new ActionMenu(trinkenMenu));
        this.trinkenButtonArray = new JButton[this.trinkenArray.length];
        
        for(int x = 0; x < this.trinkenArray.length; x++){
        	this.trinkenButtonArray[x] = new JButton(this.trinkenArray[x].toString());
        	this.trinkenButtonArray[x].addActionListener(new ActionNaehren(this.trinkenArray[x]));
        	ButtonPanel.trinkenMenu.add(this.trinkenButtonArray[x]);
        }
        
		this.add(trinkenButton);
	}
	
	
	private void addEssen(){
				
		ButtonPanel.essenMenu = new JPopupMenu();
		
		JButton essenButton = new JButton("Essen geben");
        essenButton.addActionListener( new ActionMenu(ButtonPanel.essenMenu));
        this.essenButtonArray = new JButton[this.essenArray.length];
        
        for(int x = 0; x < this.essenArray.length; x++){
        	this.essenButtonArray[x] = new JButton(this.essenArray[x].toString());
        	this.essenButtonArray[x].addActionListener(new ActionNaehren(this.essenArray[x]));
        	ButtonPanel.essenMenu.add(this.essenButtonArray[x]);
        }
        
		this.add(essenButton);
	}
	
	private void addSchlafen(){
		
		ButtonPanel.schlafenMenu = new JPopupMenu();
		
		JButton schlafenButton = new JButton("Schlafen legen");
		schlafenButton.addActionListener( new ActionMenu(ButtonPanel.schlafenMenu));
		this.schlafenButtonArray = new JButton[this.schlafenArray.length];
		
		for(int x = 0; x < this.schlafenArray.length; x++){
			this.schlafenButtonArray[x] = new JButton(this.schlafenArray[x].toString());
			this.schlafenButtonArray[x].addActionListener(new ActionSchlafen(this.schlafenArray[x]));
			ButtonPanel.schlafenMenu.add(this.schlafenButtonArray[x]);
		}
		
		this.add(schlafenButton);
	}
	
	private void addSpielen(){
		
		ButtonPanel.spielenMenu = new JPopupMenu();
		
		JButton spielenButton = new JButton("Spielen");
		spielenButton.addActionListener( new ActionMenu(ButtonPanel.spielenMenu));
		this.spielenButtonArray = new JButton[this.spielenArray.length];
		
		for(int x = 0; x < this.spielenArray.length; x++){
			this.spielenButtonArray[x] = new JButton(this.spielenArray[x].toString());
			this.spielenButtonArray[x].addActionListener(new ActionSpielen(this.spielenArray[x]));
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
		/*ButtonPanel.essenMenu.setEnabled(false);
		ButtonPanel.trinkenMenu.setEnabled(false);
		ButtonPanel.schlafenMenu.setEnabled(false);
		ButtonPanel.spielenMenu.setEnabled(false);*/
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
		/*ButtonPanel.essenMenu.setEnabled(true);
		ButtonPanel.trinkenMenu.setEnabled(true);
		ButtonPanel.schlafenMenu.setEnabled(true);
		ButtonPanel.spielenMenu.setEnabled(true);*/
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
