package gui_klassen.abfragefenster;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game.Game;

public class UserStringInputAbfragefenster extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	private String shownString;
	private String UserInputValue;
	
	public UserStringInputAbfragefenster(String shownString){
		this.UserInputValue = "";
		this.shownString = shownString;
		
		this.setTitle("");
		this.setResizable(false);
		this.setSize(new Dimension(400,100));
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(Game.getGame().getSpielfenster());
		
		initPanel();
		
		this.setVisible(true);
	}

	private void initPanel() {
		JPanel p = new JPanel();
		
		p.setLayout(new FlowLayout(FlowLayout.LEFT,0,10));
		
		JTextField prompt = new JTextField();
		prompt.setText(shownString);
		prompt.setEditable(false);
		prompt.setBorder(null);
		
		JTextField input = new JTextField();
		input.setPreferredSize(new Dimension(this.getSize().width - 10, this.getSize().height/4));
		input.addKeyListener(this);
		
		
		p.add(prompt);
		p.add(input);
		this.add(p);
		
	}

	public String getUserInput(){
		return this.UserInputValue;
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			JTextField input = (JTextField)e.getSource();
			input.setEnabled(false);
			this.UserInputValue = input.getText();
			this.setVisible(false);
		}
		
	}
	
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
