/****************************************
 * INFO:                                *
 *--------------------------------------*
 * Die Kommentare "Erfolg" sind nur     *
 * dazu da damit ich die Aenderungen    *
 * leichter wiederfinden kann die       *
 * ich in diesem Kontext gemacht        *
 * habe.                                *
 * ~ Yoshi                              *
 ****************************************/

package achievement;

import game.Game;

public class CheckTimeAchievements implements Runnable{
	
	public void run() {

		if((!Game.getGame().getAchievements().isErfolg4()) && (Game.getGame().getTamagotchi().getLivingtime().getTimeSeconds() >= 1*10)){
			Game.getGame().getAchievements().setErfolg4();
		}
		
		if((!Game.getGame().getAchievements().isErfolg5()) && (Game.getGame().getTamagotchi().getLivingtime().getTimeSeconds() >= 1*30)){
			Game.getGame().getAchievements().setErfolg5();
		}
		
	}

}
