package runnable_klassen;

import java.util.TimerTask;

import gui_klassen.mainWindow.Spielfenster;

public class FensterAktualisierung extends TimerTask {

	private Spielfenster f;
	
	public FensterAktualisierung(Spielfenster f) {
		this.f = f;
	}

	@Override
	public void run() {
		f.repaint();
	}

}
