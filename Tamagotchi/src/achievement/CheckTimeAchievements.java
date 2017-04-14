/**
 *	Zur �berpr�fung von Zeitabh�ngigen Achievments.
 */

package achievement;

import game.Game;

public class CheckTimeAchievements implements Runnable{
	
	/**
	 * �berpr�ft ob zeitabh�ngige Achievements erreicht wurden.
	 */
	public void run() {

		if((!Game.getGame().getAchievements().isErfolg4()) && (Game.getGame().getTamagotchi().getLivingtime().getTimeSeconds() >= 1*10)){
			Game.getGame().getAchievements().setErfolg4();
		}
		
		if((!Game.getGame().getAchievements().isErfolg5()) && (Game.getGame().getTamagotchi().getLivingtime().getTimeSeconds() >= 1*30)){
			Game.getGame().getAchievements().setErfolg5();
		}
		
	}

}
