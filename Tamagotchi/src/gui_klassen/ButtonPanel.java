package gui_klassen;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import Listener.ActionNaehren;
import nahrungs_klassen.Essen;
import nahrungs_klassen.Trinken;

public class ButtonPanel extends JPanel{

	private static final long serialVersionUID = 6267475086902074455L;

	public ButtonPanel(Dimension d){
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
		this.setPreferredSize(d);
		addButtons();
	}
	
	private void addButtons() {
		
		JButton essen = new JButton("Essen geben");
		JButton trinken = new JButton("Trinken geben");
		
		essen.addActionListener(new ActionNaehren(new Essen()));
		trinken.addActionListener(new ActionNaehren(new Trinken()));
		
		this.add(essen);
		this.add(trinken);
		
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
