package gui_klassen;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import listener.ActionMenu;
import listener.ActionNaehren;
import nahrungs_klassen.Nahrung;;

public class ButtonPanel extends JPanel{

	private static final long serialVersionUID = 6267475086902074455L;
	private Nahrung[] essenArray;
	private Nahrung[] trinkenArray;
	
	private JButton[] essenButtonArray;
	private JButton[] trinkenButtonArray;

	
	public ButtonPanel(Dimension d, Nahrung[][] nahrungen){
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
		this.setPreferredSize(d);
		
		essenArray = nahrungen[0];
		trinkenArray = nahrungen[1];
		
		addButtons();
	}
	
	private void addButtons() {
		
		addEssen();
		addTrinken();
		
		
	}
	
	
	private void addTrinken(){
		
		JPopupMenu trinkenMenu = new JPopupMenu();
		
		JButton trinkenButton = new JButton("Trinken geben");
        trinkenButton.addActionListener( new ActionMenu(trinkenMenu));
        trinkenButtonArray = new JButton[trinkenArray.length];
        
        for(int x = 0; x < trinkenArray.length; x++){
        	trinkenButtonArray[x] = new JButton(trinkenArray[x].toString());
        	trinkenButtonArray[x].addActionListener(new ActionNaehren(trinkenArray[x]));
        	trinkenMenu.add(trinkenButtonArray[x]);
        }
        
		this.add(trinkenButton);
	}
	
	
	private void addEssen(){
				
		JPopupMenu essenMenu = new JPopupMenu();
		
		JButton essenButton = new JButton("Essen geben");
        essenButton.addActionListener( new ActionMenu(essenMenu));
        essenButtonArray = new JButton[essenArray.length];
        
        for(int x = 0; x < essenArray.length; x++){
        	essenButtonArray[x] = new JButton(essenArray[x].toString());
        	essenButtonArray[x].addActionListener(new ActionNaehren(essenArray[x]));
        	essenMenu.add(essenButtonArray[x]);
        }
        
		this.add(essenButton);
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
