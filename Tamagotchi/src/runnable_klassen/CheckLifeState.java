/**
 * �berpr�ft in bestimmten Abst�nden, ob das Tamagotchi am Leben ist.
 */

package runnable_klassen;

import game.Game;

public class CheckLifeState implements Runnable {
	
	/**
	 * Konstruktor.
	 */
	public CheckLifeState(){
		
	}

	/**
	 * �berpr�ft ob das Tamagotchi lebt.
	 * Wenn das Tamagotchi tot sein sollte, wird die gameOver-Methode im Game aufgerufen.
	 */
	public void run() {
		if(!Game.getGame().getTamagotchi().isLebendig()){
			Game.getGame().gameOver();
		}

	}

}
