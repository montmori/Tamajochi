package listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import tamagotchi_klassen.Tamagotchi;

public class Windowflauscher implements WindowListener {
   
	private Tamagotchi t;

	public Windowflauscher(Tamagotchi t){
		this.t = t;
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
		FileOutputStream f;
		ObjectOutputStream o;
		try {
			
			f = new FileOutputStream("Save.ser");
			o = new ObjectOutputStream(f);
			o.writeObject(t);
			o.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

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
