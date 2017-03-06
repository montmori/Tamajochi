package gui_klassen.abfragefenster;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ResolutionAbfragefenster extends JFrame implements ActionListener{

	private final Dimension[] aufloesungen = new Dimension[]{new Dimension(1600,900), new Dimension(1376,768), new Dimension(1280,720)
																, new Dimension(1024,600), new Dimension(960,540), new Dimension(600,480)};
	
	private final String[] aufloesungenAsString = new String[]{"1600x900","1376x768","1280x720","1024x600","960x540", "600x480"};
	
	
	
	
	private static final long serialVersionUID = 1L;
	private final Dimension THISRESOLUTION = new Dimension(300,300);
	private ButtonGroup resolutionButtons;
	boolean selected;
	
	
	public ResolutionAbfragefenster(){
	
		selected = false;
		this.setTitle("Resolution");
		this.setResizable(false);
		this.setSize(this.THISRESOLUTION);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 30));

		initPanel();

		this.setVisible(true);
		
	}
	
	private void initPanel(){
		JPanel buttons = new JPanel();
		buttons.setPreferredSize(new Dimension(250, this.THISRESOLUTION.height));
		buttons.setLayout(new FlowLayout(FlowLayout.LEFT,70,0));
		
		resolutionButtons = new ButtonGroup();
		
		JButton select = new JButton("Diese Auflösung wählen");
		select.addActionListener(this);
		
		JRadioButton w1600h900 = new JRadioButton(aufloesungenAsString[0]);
		JRadioButton w1376h768 = new JRadioButton(aufloesungenAsString[1]);
		JRadioButton w1280h720 = new JRadioButton(aufloesungenAsString[2]);
		JRadioButton w1024h600 = new JRadioButton(aufloesungenAsString[3]);
		JRadioButton w960h540 = new JRadioButton(aufloesungenAsString[4]);
		JRadioButton w600h480 = new JRadioButton(aufloesungenAsString[5]);
		
		w1280h720.setSelected(true);
		
		JTextField text = new JTextField("Bitte Auflösung auswählen!");
		text.setEditable(false);
		text.setBorder(null);
		
		

		buttons.add(text);
		
		resolutionButtons.add(w1600h900);
		resolutionButtons.add(w1376h768);
		resolutionButtons.add(w1280h720);
		resolutionButtons.add(w1024h600);
		resolutionButtons.add(w960h540);
		resolutionButtons.add(w600h480);
		
		buttons.add(w1600h900);
		buttons.add(w1376h768);
		buttons.add(w1280h720);
		buttons.add(w1024h600);
		buttons.add(w960h540);
		buttons.add(w600h480);
		
		
		buttons.add(select);
		this.add(buttons);
		
	}

	public Dimension getUserPreferredSize() {
		
		do{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}while(!selected);
		
		JRadioButton temp = null;
		
		Enumeration<AbstractButton> buttonList = resolutionButtons.getElements();
		
		
		while(buttonList.hasMoreElements()){
			temp = (JRadioButton)buttonList.nextElement();

			if(temp.isSelected()){
				break;
			}
		}
		


		this.setVisible(false);
		return getSizeForButton(temp);
	}

	private Dimension getSizeForButton(JRadioButton temp) {
		if(temp.getText().equals(aufloesungenAsString[0])){
			return aufloesungen[0];
		}
		if(temp.getText().equals(aufloesungenAsString[1])){
			return aufloesungen[1];
		}
		if(temp.getText().equals(aufloesungenAsString[2])){
			return aufloesungen[2];
		}
		if(temp.getText().equals(aufloesungenAsString[3])){
			return aufloesungen[3];
		}
		if(temp.getText().equals(aufloesungenAsString[4])){
			return aufloesungen[4];
		}
		if(temp.getText().equals(aufloesungenAsString[5])){
			return aufloesungen[5];
		}
		if(temp.getText().equals(aufloesungenAsString[6])){
			return aufloesungen[6];
		}
		
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.selected = true;
		
	}
}
