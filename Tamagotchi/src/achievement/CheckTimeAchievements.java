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
import game.Timestamp;
import tamagotchi_klassen.Tamagotchi;

public class CheckTimeAchievements implements Runnable{
	
	public void run() {

		if((!Game.getGame().getAchievements().isErfolg4()) && (Game.getGame().getTamagotchi().getLivingtime().getTime() >= 1*10)){
			Game.getGame().getAchievements().setErfolg4();
		}
		
		if((!Game.getGame().getAchievements().isErfolg5()) && (Game.getGame().getTamagotchi().getLivingtime().getTime() >= 1*30)){
			Game.getGame().getAchievements().setErfolg5();
		}
		
		//zum test ub das klappt
		System.out.println("Erfolge:");
		System.out.println("gestorben    : " + Game.getGame().getAchievements().isErfolg1());
		System.out.println("oreo         : " + Game.getGame().getAchievements().isErfolg2());
		System.out.println("war ich nicht: " + Game.getGame().getAchievements().isErfolg3());
		System.out.println("10 sek       : " + Game.getGame().getAchievements().isErfolg4());
		System.out.println("30 sek       : " + Game.getGame().getAchievements().isErfolg5());
		
	}

}
