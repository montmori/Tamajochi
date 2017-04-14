/**
 * Legt fest wo das PopupMenü auftauchen soll, wenn der Button gedrückt wurde.
 */

package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPopupMenu;

public class ActionMenu implements ActionListener {

	JPopupMenu menu;
	
	/**
	 * Konstruktor.
	 * @param menu	Das Menü, das angezeigt werden soll, falls der Button gedrückt wird.
	 */
	public ActionMenu(JPopupMenu menu){
		this.menu = menu;
	}
	
	/**
	 * Öffnet ein Popupmenü an dem gedrückten Button.
	 */
	public void actionPerformed(ActionEvent arg0) {
		 
		JButton button = (JButton)arg0.getSource();
		
		//An welchem Komponent soll ich erscheinen?, von da ausgehend die X-Werte und Y-Werte.
		this.menu.show(button, button.getWidth()/2, button.getHeight()/2);

	}

}
