/**
 * Sorgt dafür, dass ein Bedürfnis regelmäßig verringert wird.
 */

package runnable_klassen;

import beduerfnis_klassen.Beduerfnis;
import beduerfnis_klassen.VerringerungsWerte;

public class BeduerfnissVerringerungsTask implements VerringerungsWerte, Runnable{

	private Beduerfnis beduerfnis;
	private int subtraktionswert;
	
	
	/**
	 * Konstruktor.
	 * @param beduerfnis		Welches Bedürfnis verringert werden soll.
	 * @param subtraktionswert	Um wieviel es jedes mal verringert werden soll.
	 */
	public BeduerfnissVerringerungsTask(Beduerfnis beduerfnis, int subtraktionswert) {
		this.beduerfnis = beduerfnis;
		this.subtraktionswert = subtraktionswert;
	}

	/**
	 * Der Bedürfniswert wird um den subtraktionswert verringert.
	 */
	public void run() {
		this.beduerfnis.veraendereBeduerfnisWert(this.subtraktionswert);

	}

}
