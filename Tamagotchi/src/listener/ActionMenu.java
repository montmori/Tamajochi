package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPopupMenu;

public class ActionMenu implements ActionListener {

	JPopupMenu menu;
	
	public ActionMenu(JPopupMenu menu){
		this.menu = menu;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		 
		JButton button = (JButton)arg0.getSource();
		
		menu.show(button, button.getWidth()/2, button.getHeight()/2);

	}

}
