package runnable_klassen;

import game.Game;

public class CheckLifeState implements Runnable {
	
	public CheckLifeState(){
		
	}
	@Override
	public void run() {

		if(!Game.getGame().getTamagotchi().isLebendig()){
			Game.getGame().gameOver();
		}

	}

}
