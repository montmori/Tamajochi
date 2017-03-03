package runnable_klassen;

import tamagotchi_klassen.Tamagotchi;

public class CheckLifeState implements Runnable {

	private Tamagotchi t;
	
	public CheckLifeState(Tamagotchi t){
		this.t = t;
	}
	@Override
	public void run() {

		if(!t.isLebendig()){
			t.gameOver();
		}

	}

}
