package listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import game.Game;

public class Windowflauscher implements WindowListener {
   

	public Windowflauscher(){
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		this.windowClosing(arg0);

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		Game.getGame().saveTamagotchiInstance();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
