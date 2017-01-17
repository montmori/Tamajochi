package timerTask_klassen;

import java.util.TimerTask;

import tamagotchi_klassen.Tamagotchi;

public class CheckLifeState extends TimerTask {

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
