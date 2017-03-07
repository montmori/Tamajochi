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
import listener.ActionUse;
import tamagotchi_klassen.TamagotchiUsable;;

public class ButtonPanel extends JPanel{

	private static final long serialVersionUID = 6267475086902074455L;

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

		this.setOpaque(false);
		
		addButtons();
	}
	
	private void addButtons() {
		
		getFontSize();
		createPopupMenuWithContent(essenMenu, Game.getGame().getTamagotchi().getNahrungsArray()[0]);
		createPopupMenuWithContent(trinkenMenu, Game.getGame().getTamagotchi().getNahrungsArray()[1]);
		createPopupMenuWithContent(schlafenMenu, Game.getGame().getTamagotchi().getSchlafenArray());
		createPopupMenuWithContent(spielenMenu, Game.getGame().getTamagotchi().getSpielenArray());
		 
		
	}
	
	private void getFontSize() {
		switch(Game.getGame().getUserSize().width){
		case 1600:
			this.outerButtonFontSize = 16; 
			this.innerButtonFontSize = 14;
			break;
			
		case 1376:
			this.outerButtonFontSize = 15; 
			this.innerButtonFontSize = 13;
			break;
			
		case 1280:
			this.outerButtonFontSize = 14; 
			this.innerButtonFontSize = 12; 
			break;
		
		case 1024:
			this.outerButtonFontSize = 13; 
			this.innerButtonFontSize = 11;
			break;
		
		case 960:
			this.outerButtonFontSize = 12; 
			this.innerButtonFontSize = 10;
			break;
		
		case 600:
			this.outerButtonFontSize = 10; 
			this.innerButtonFontSize = 8;
			break;
		}
	}
	
	private void createPopupMenuWithContent(JPopupMenu popupMenu, TamagotchiUsable[] usableArray){
		
		popupMenu = new JPopupMenu();
		popupMenu.setLayout(new FlowLayout(FlowLayout.CENTER,0,1));
		popupMenu.setPreferredSize(new Dimension((int)this.size.getWidth(), (int)((this.size.getHeight()/20 + 1) * usableArray.length + 5)));
		 
		
		JButton popupButton = new JButton("Trinken geben");
		popupButton.setFont(new Font("Dialog.Bold",Font.PLAIN,this.outerButtonFontSize));
        popupButton.addActionListener( new ActionMenu(popupMenu));
        popupButton.setPreferredSize(new Dimension((int)this.size.getWidth(), (int)this.size.getHeight()/15));
        
        
        JButton[] buttonArray = new JButton[usableArray.length];
        
        for(int x = 0; x < usableArray.length; x++){
        	buttonArray[x] = new JButton(usableArray[x].toString());
        	buttonArray[x].addActionListener(new ActionUse(usableArray[x]));
        	buttonArray[x].setPreferredSize(new Dimension((int)(this.size.getWidth()),(int)(this.size.getHeight()/20)));
        	buttonArray[x].setFont(new Font("Dialog.Bold", Font.PLAIN, this.innerButtonFontSize));
        	ButtonPanel.trinkenMenu.add(buttonArray[x]);
        }
        
		this.add(popupButton);
	}
	

	public void gameOver() {
		ButtonPanel.setButtonsEnabled(false);
		
	}

	public void newGame() {
		ButtonPanel.setButtonsEnabled(true);
	}
	
	public static void setButtonsEnabled(boolean state){
		for(Component x : ButtonPanel.essenMenu.getComponents()){
			x.setEnabled(state);
		}
		for(Component x : ButtonPanel.trinkenMenu.getComponents()){
			x.setEnabled(state);
		}
		for(Component x : ButtonPanel.schlafenMenu.getComponents()){
			x.setEnabled(state);
		}
		for(Component x : ButtonPanel.spielenMenu.getComponents()){
			x.setEnabled(state);
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
