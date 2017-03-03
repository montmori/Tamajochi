package runnable_klassen;

import gui_klassen.mainWindow.Spielfenster;

public class FensterAktualisierung implements Runnable {

	private Spielfenster f;
	
	public FensterAktualisierung(Spielfenster f) {
		this.f = f;
	}

	@Override
	public void run() {
		f.repaint();
	}

}
