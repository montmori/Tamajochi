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

package erfolge;

import game.Timestamp;
import tamagotchi_klassen.Tamagotchi;

public class CheckTimeErfolge implements Runnable{

	private Timestamp ti;
	private Tamagotchi t;
	
	public CheckTimeErfolge( Tamagotchi t){
		this.ti = t.getLivingtime();
		this.t = t;
	}
	
	public void run() {

		if(!(t.getErfolge().isErfolg1())){
			if(ti.getTime() >= (10 * 1)){
				t.getErfolge().setErfolg1(true);
			}
		}
		//zum test ub das klappt
		System.out.println("Erfolge:");
		System.out.println("10sek spielen: " + t.getErfolge().isErfolg1());
		System.out.println("1.mal ein Apfel gegessen: " + t.getErfolge().isErfolg2());
		System.out.println("1.mal Gestorben: " + t.getErfolge().isErfolg3());
	}

}
