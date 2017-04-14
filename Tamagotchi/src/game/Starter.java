/**
 * Die Main, die ein neues Game erstellt.
 */
package game;

public class Starter {
	
	public static void main(String[] args){
		startGame();
	}
	
	private static void startGame(){
		Game.getGame().start();
	}
}