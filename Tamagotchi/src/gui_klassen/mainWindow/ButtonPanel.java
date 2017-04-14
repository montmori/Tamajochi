/**
 * Verwaltet und erstellt die Buttons auf einem Panel.
 */

package gui_klassen.mainWindow;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

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
	
	private static boolean buttonBlock;
	
	private int outerButtonFontSize;
	private int innerButtonFontSize;
	
	private Dimension size;
	
	
	/**
	 * Konstruktor.
	 * Setzt die Standartwerte für das Panel.
	 * @param d		Die Dimension die das ButttonPanel haben soll.
	 */
	public ButtonPanel(Dimension d){
		this.size = d;
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
		this.setPreferredSize(this.size);
		this.setOpaque(false); //Macht den PanelHintergrund durchsichtig.
		
		ButtonPanel.buttonBlock = false; 
		addButtons();
	}
	
	
	/**
	 * Buttons und dazugehörige Menüs werden erstellt.
	 */
	private void addButtons() {
		
		this.getFontSize();
		
		ButtonPanel.essenMenu = new JPopupMenu();
		ButtonPanel.trinkenMenu = new JPopupMenu();
		ButtonPanel.schlafenMenu = new JPopupMenu();
		ButtonPanel.spielenMenu = new JPopupMenu();
		
		
		createPopupMenuWithContent(ButtonPanel.essenMenu, Game.getGame().getTamagotchi().getNahrungsArray()[0], "Essen geben");
		createPopupMenuWithContent(ButtonPanel.trinkenMenu, Game.getGame().getTamagotchi().getNahrungsArray()[1], "Trinken geben");
		createPopupMenuWithContent(ButtonPanel.schlafenMenu, Game.getGame().getTamagotchi().getSchlafenArray(), "Schlafen legen");
		createPopupMenuWithContent(ButtonPanel.spielenMenu, Game.getGame().getTamagotchi().getSpielenArray(), "Spielen");
		 
		
	}
	
	
	/**
	 * Schriftgöße wird an die Größe des ButtonPanels bzw. des gesamten Fensters angepasst.
	 */
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
	
	
	
	/**
	 * Erstellt einen Button (zB. Essen geben) und ein dazugehöriges befülltest Popupmenü.
	 * @param popupMenu		Zu welchem Menü das Popupmenü hinzugefügt werden soll.
	 * @param usableArray	Array mit Inhalten die in das Popupmenü rein sollen.
	 * @param buttonText	Wie der Button heißen soll (zB. Essen geben).
	 */
	private void createPopupMenuWithContent(JPopupMenu popupMenu, TamagotchiUsable[] usableArray, String buttonText){
		
		popupMenu.setLayout(new FlowLayout(FlowLayout.CENTER,0,1));
		popupMenu.setPreferredSize(new Dimension((int)this.size.getWidth(), (int)((this.size.getHeight()/20 + 1) * usableArray.length + 5)));
		 
		
		JButton popupButton = new JButton(buttonText);
		popupButton.setFont(new Font("Dialog.Bold",Font.PLAIN,this.outerButtonFontSize));
        popupButton.addActionListener( new ActionMenu(popupMenu));
        popupButton.setPreferredSize(new Dimension((int)this.size.getWidth(), (int)this.size.getHeight()/15));
        
        
        JButton[] buttonArray = new JButton[usableArray.length];
        
        for(int x = 0; x < usableArray.length; x++){
        	buttonArray[x] = new JButton("???");
        	buttonArray[x].addActionListener(new ActionUse(usableArray[x]));
        	buttonArray[x].setPreferredSize(new Dimension((int)(this.size.getWidth()),(int)(this.size.getHeight()/20)));
        	buttonArray[x].setFont(new Font("Dialog.Bold", Font.PLAIN, this.innerButtonFontSize));
        	popupMenu.add(buttonArray[x]);
        }
        
		this.add(popupButton);
	}
	

	/**
	 * Alle Buttons werden disabled.
	 */
	public void gameOver() {
		ButtonPanel.setButtonsEnabled(false);
		
	}

	
	/**
	 * Freigeschaltete Buttons werden enabled.
	 */
	public void newGame() {
		ButtonPanel.setButtonsEnabled(true);
	}
	
	
	/**
	 * Enabled bzw Disabled die Buttons.
	 * @param state		Der Zustand den die Buttons haben sollen, wenn sie freigeschaltet sind.
	 */
	public static void setButtonsEnabled(boolean state){
		ButtonPanel.buttonBlock = !state;
		
		TamagotchiUsable[] essen = Game.getGame().getTamagotchi().getNahrungsArray()[0];
		TamagotchiUsable[] trinken = Game.getGame().getTamagotchi().getNahrungsArray()[1];
		TamagotchiUsable[] schlafen = Game.getGame().getTamagotchi().getSchlafenArray();
		TamagotchiUsable[] spielen = Game.getGame().getTamagotchi().getSpielenArray();
		
		//Um beim wieder aktivieren der Buttons nicht ausversehen Buttons zu aktivieren, welche 
		//noch gar nicht freigeschalten sind, wird hier der state mit dem Unlocked zustand Verundet.
		// ===> state false = alle buttons disabled
		for(int x = 0; x < ButtonPanel.essenMenu.getComponentCount(); x++){
			ButtonPanel.essenMenu.getComponents()[x].setEnabled(state & essen[x].isUnlocked());
		}
		
		for(int x = 0; x < ButtonPanel.trinkenMenu.getComponentCount(); x++){
			ButtonPanel.trinkenMenu.getComponents()[x].setEnabled(state & trinken[x].isUnlocked());
		}
		
		for(int x = 0; x < ButtonPanel.schlafenMenu.getComponentCount(); x++){
			ButtonPanel.schlafenMenu.getComponents()[x].setEnabled(state & schlafen[x].isUnlocked());
		}
		
		for(int x = 0; x < ButtonPanel.spielenMenu.getComponentCount(); x++){
			ButtonPanel.spielenMenu.getComponents()[x].setEnabled(state & spielen[x].isUnlocked());
		}
	}

 
	/**
	 * Befüllt eine ArrayList in der Reihenfolge: Essen, Trinken, Schlafen, Spielen.
	 * @return	Component Array gefüllt mit den Komponenten der verschiedenen Menüs.
	 */
	public Component[] getButtons(){
		ArrayList<Component> temp = new ArrayList<Component>();
		
		for(Component x : ButtonPanel.essenMenu.getComponents()){
			temp.add(x);
		}
		for(Component x : ButtonPanel.trinkenMenu.getComponents()){
			temp.add(x);
		}
		for(Component x : ButtonPanel.schlafenMenu.getComponents()){
			temp.add(x);
		}
		for(Component x : ButtonPanel.spielenMenu.getComponents()){
			temp.add(x);
		}
		
		return (Component[]) temp.toArray(new Component[temp.size()]);
	}

	
	/**
	 * @return	Ob die Buttons blockiert sind oder nicht.
	 */
	public boolean isButtonBlockEnabled(){
		return ButtonPanel.buttonBlock;
	}
}
